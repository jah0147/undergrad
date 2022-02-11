/*====================================================*/

/* ELEC 3040 - Lab 5


/*====================================================*/



#include "stm32l4xx.h" /* microcontroller information */



/* Define global variables */

static unsigned int counter;        //value of count (0-9)

static unsigned int button;            //value of button press

unsigned int col;                //what column has been pressed

unsigned int row;                //what row has been pressed

static unsigned int colNum;            //what column # has been pressed

static unsigned int rowNum;            //what row # has been pressed

unsigned int ccrNum;            //value for duty cycle

static unsigned int go;                    //handler variable

unsigned int i,j,n,k;                     //delay variables

static unsigned int keypad_map [4][4] = {        //keypad matrix, no press = 0xFF

    {0x01,0x02,0x03,0x0A},    //0,0;1st row

    {0x04,0x05,0x06,0x0B},    //1,0;2nd row

    {0x07,0x08,0x09,0x0C},    //2,0;3rd row

    {0x0E,0x00,0x0F,0x0D}     //3,0;4th row

};//0,0; 0,1; 0,2; 0,3;

static unsigned int ccr_value [11] = {        //CCRy values according to button press

    0, 399, 799, 1199, 1599, 1999,

    2399, 2799, 3199, 3599, 3999

};



/*---------------------------------------------------*/

/* initialize clocks used in the program */

/* initialize GPIOB pins used in the program */

/* PB[0] = interrupt trigger, output of AND gate (row signals) */

/* PB[6:3] = displayed value, counter or button */

/*---------------------------------------------------*/

static void Setup() {



    /* enable clocks */

    RCC->AHB2ENR |= 0x03;        //enable GPIOA clock (bit 0) and GPIOB clock (bit 1)



    /* configure GPIO pins */

    GPIOA->MODER &= (0xFFFFFFF0);                        //PA0 = 00 and PA1 = 00

    GPIOA->MODER |=    (0x00000006);                        //PA0 = 10 and PA1 = 01



  GPIOB->MODER &= (0xFFFFC03C);                        //inputs// display and AND, PB[6:3,0] = 00

    GPIOB->MODER |= (0x00001540);                        //outputs// display, PB[6:3] = 01



}



/*---------------------------------------------------*/

/* initialize GPIO pins used in the program */

/*---------------------------------------------------*/

static void PinSetup1() {



    Setup();

    /* configure GPIOA pins */

    GPIOA->MODER &= (0xFF00F00F);        //inputs// column and row, PA[11:8,5:2] = 00

    GPIOA->MODER |= (0x00550000);        //outputs// column, PA[11:8] = 01



    /* configure push-pull pins */

    GPIOA->PUPDR &= (0xFFFFF00F);        //pull-reset// row, PA[5:2] = 00

    GPIOA->PUPDR |= (0x00000550);        //pull-up// row, PA[5:2] = 01





}



/*---------------------------------------------------*/

/* initialize GPIO pins used in the program */

/*---------------------------------------------------*/

static void PinSetup2() {



    Setup();

    /* configure GPIOA pins */

    GPIOA->MODER &= (0xFF00F00F);        //inputs// column and row, PA[11:8,5:2] = 00

    GPIOA->MODER |= (0x0550);                //outputs// row, PA[5:2] = 01



    /* configure push-pull pins */

    GPIOA->PUPDR &= (0xFF00FFFF);        //pull-reset// row, PA[11:8] = 00

    GPIOA->PUPDR |= (0x00550000);        //pull-up// row, PA[11:8] = 01



}



/*---------------------------------------------------*/

/* enable PWM used in the program*/

/*---------------------------------------------------*/

static void PulseSetup() {



    /* enable clock */

    RCC->AHB2ENR |= 0x01;             // Enable GPIOA clock (bit 0)



    /* configure pins */

    GPIOA->MODER &= 0xFFFFFFFC; // PA0 = 00, clear

    GPIOA->MODER |= 0x0002;         // PA0 = 01, alternative function mode



    /* select desired AF (timer) */

    GPIOA->AFR[0] &= (0xFFFFFFF0);                //mask bit[3:0]=00

    GPIOA->AFR[0] |= (0x00000001);                //(0x0002);//configure bit[3:0]=0010, AF1 selected



    /* configure timer */

    RCC->APB1ENR1 |= RCC_APB1ENR1_TIM2EN;            //(0x01);//enable timer module

    TIM2->CR1 |= 0x01;                             //enable timer counter

    TIM2->CCMR1 &= (0xFFFFFF8C);        //mask channel one (bit[6:4]=00), output mode

    TIM2->CCMR1 |= (0x00000060);                 //configure output mode for PWM mode 1

    TIM2->CCER &= (0xFFFC);                    //bit[1:0]=00, clear timer channel 1 output

    TIM2->CCER |= (0x0001);                    //bit[1:0]=01, enable timer channel 1 output (active high)



    /* configure pulse */

    TIM2->PSC = 0;

    TIM2->ARR = 4000;

    TIM2->CCR1 = 0;

    NVIC_EnableIRQ(EXTI0_IRQn);    /* Enable IRQ */

}



/*---------------------------------------------------*/

/* initialize interrupts used in the program */

/* EXTI1 = external interrupt one */

/* EXTI2 = external interrupt two */

/*---------------------------------------------------*/

static void InterruptSetup() { //maybe void in ()



    /* enable clocks */

    RCC->APB2ENR |= 0x01;        //enable interrupt clock SYSCFG



    /* configure port PA0 as input source of EXTI0 */

    SYSCFG->EXTICR[0] &= 0xFFF0;            //clear EXTI1 bit in config reg ~(0xF)

  SYSCFG->EXTICR[0] |= 0x0001;          //PB configuration in EXTI0





  /* configure and enable EXTI0 as falling-edge triggered */

    EXTI->FTSR1 |= 0x0001;                                                        //falling edge trigger enabled

    EXTI->IMR1 |= 0x0001;                                                     //enable (unmask) EXTI0

    EXTI->PR1 |= 0x0001;                                                       //clear EXTI0 pending bit for line 1

    NVIC_ClearPendingIRQ(EXTI0_IRQn);                        ////////* Clear NVIC pending bit */

    NVIC_EnableIRQ(EXTI0_IRQn);                                            //enable IRQ with EXTI line 0 interrupt





}

/*----------------------------------------------------------*/

/* debounce delay function - do nothing for about 0.001 second */

/*----------------------------------------------------------*/

static void debounce() {                            //

    for (i=0; i<15; i++) {                 //outer loop

        for (j=0; j<40; j++) {            //inner loop

            n = j;                                          //dummy operation for single-step test

        }                                                     //do nothing

    }

}



/*----------------------------------------------------------*/

/* delay function - do nothing for about 1 second */

/*----------------------------------------------------------*/

static void delay() {                                    //

    for (i=0; i<15; i++) {                 //outer loop

        for (j=0; j<10000; j++) {        //inner loop *4000*

            n = j;                                          //dummy operation for single-step test

        }                                                     //do nothing

    }

}



/*----------------------------------------------------------*/

/* keypad function - find which button has been pressed */

/*----------------------------------------------------------*/

static void keypad() {



    button = 0;

    rowNum = 0;

    colNum = 0;

    ccrNum = 0;

    col = 0;                                //initialize col

    row = 0;                                //initialize row



    /* clear unwanted values */

    GPIOB->ODR &= 0xFF87;                     //mask PB[6:3] to 0

    /* columns output 0 and find which row is 0*/

    //PinSetup1();

    row=0;

    GPIOA->ODR &= (0xF0FF);                //set column to output 0, PA[11:8] = 0

    for(k=0; k<4; k++);                        //delay for values to load

    row = (~GPIOA->IDR & 0x003C);    //get row inputs, PA[5:2] = 0***check~

    row = row >> 2;                                //shift right by 2

    do {

        row = row << 1;                            //shift left by 1 to find row count

        rowNum++;                                        //add to row count

    } while(row < 0x10) ;                    //can only shift four times



    /* rows output 0 and find which column is 0 */

    PinSetup2();

    debounce();

    col=0;

    GPIOA->ODR &= (0xFFC3);                //set row to output 0, PA[5:2] = 0

    for(k=0; k<4; k++);                        //delay for values to load

    col = (~GPIOA->IDR & 0xF00);    //get column inputs, PA[11:8] = 0

    col = col >> 8;                                //shift right by 8

    do {

        col = col << 1;                            //shift left by 1 to find column count

        colNum++;                                        //add to column count

    } while(col < 0x10) ;                    //can only shift four times



    button = keypad_map[--rowNum][--colNum];    //test and see if works****



    ccrNum = ccr_value[button];

    TIM2->CCR1 = ccrNum;



    button = button << 3;

    GPIOB->ODR &= 0xFF87;                     //mask PB[6:3] to 0

    GPIOB->ODR |= button;        //output button value, PB[6:3]





    ccrNum = 0;

    button = 0;

        delay ();                                    //1 sec delay

        delay ();                                    //1 sec delay

}



/*----------------------------------------------------------*/

/* interrupt handler EXTI0 - keypad has been pressed */

/*----------------------------------------------------------*/

void EXTI0_IRQHandler() { //maybe put void in ()





        debounce();

        go=~go;

        keypad();                        //keypad logic

        PinSetup1();

        debounce();



        EXTI->PR1 |= 0x0001;                //clear EXTI0 pending bit*

        NVIC_ClearPendingIRQ(EXTI0_IRQn);        //clear NVIC pending bit with EXTI line 1 interrupt

        __enable_irq();                                         //enable interupts* Maybe this has to go before above line

}



/*------------------------------------------------*/

/* main program */

/*------------------------------------------------*/

int main(void) {



    Setup();                                //configure clocks and GPIOB pins

    PinSetup1();

    InterruptSetup();                //configure interrupts

    PulseSetup();

    go = 1;                                    //initialize go



    /* Endless loop */

    while(1){                            //endless loop

        delay();                             //delay for 1 seconds

        if(go != 0x01){                    //see if button has been pressed

        go=~go;

        }

    } /* repeat forever */

}
