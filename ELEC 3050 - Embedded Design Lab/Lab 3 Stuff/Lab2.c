/*====================================================*/
/* Jacob Howard */
/* Toggle LED1 while button pressed, with short delay inserted */
/*====================================================*/

#include "stm32l4xx.h" /* Microcontroller information */

/* Define global variables */
//int toggles; /* number of times LED state toggled */
static int counter1, counter2, run, up;
unsigned char direction, blueLED, greenLED;

static uint16_t sw1; //declare 16-bit variable that matches IDR size (Switch 1 to start and stop counters)
static uint16_t sw2; //Switch 2 to reverse counter 1



/*---------------------------------------------------*/
/* Initialize GPIO pins used in the program */
/* PA11 = push button */
/* PB4 = LDR, PB5 = green LED */
/*---------------------------------------------------*/
void PinSetup () {
 /* Configure PA0 as input pin to read push button */
	RCC->AHB2ENR |= 0x01; /* Enable GPIOA clock (bit 0) */
	GPIOA->MODER &= ~(0x03FFFC3C); // General purpose input mode */	//THIS may be wrong. Might be ~0x0000003C.
  GPIOA->MODER |= 0x01555400; // Sets pins 1 and 2 as inputs and pins 5-12 as outputs, and all others as 00.
	
	RCC->AHB2ENR |= 0x03; //enable GPIOB clock (2bit)
	GPIOB->MODER &= ~(0x03C0); //setting pins 3 and 4 PB
	GPIOB->MODER |= 0x0180; //setting pins 3 and 4 as output pins
}

/*----------------------------------------------------------*/
/* Interrupt settup
/*----------------------------------------------------------*/
void InterruptSetup(){
	SYSCFG->EXTICR[0] &= ~(0x000F); //Clear EXTI0 (set for PA0)
	SYSCFG->EXTICR[0] &= ~(0x00F0); //Clear EXTI1 (set for PA1)
	
	EXTI->RTSR1 |= 0x0001; //Set rising trigger for PA0
	EXTI->RTSR1 |= 0x0002; //Set rising trigger for PA1
	
	EXTI->IMR1 |= 0x0001; //Enable interrupt PA0
	EXTI->IMR1 |= 0x0002; //Enable interrupt PA1
	
	EXTI->PR1 |= 0x001; //Clear pending
	EXTI->PR1 |= 0x002; //Clear pending
	
	NVIC_EnableIRQ(EXTI1_IRQn); //Enable interrupt for PA0
	NVIC_EnableIRQ(EXTI2_IRQn); //Enable interrupt for PA1
	
	NVIC_ClearPendingIRQ(EXTI1_IRQn); //Clear NVIC pending for PA0
	NVIC_ClearPendingIRQ(EXTI2_IRQn); //Clear NVIC pending for PA1
}

/*----------------------------------------------------------*/
/* Interrupt Service Routine                                */
/*----------------------------------------------------------*/
void EXTI1_IRQHandler() {
    if (run == 1) {
        run = 0;
    }
    else {
        run = 1;
    }
    GPIOB->ODR = (GPIOB->ODR & ~(0x08)) | (run << 3);//Set to value of run
    NVIC_ClearPendingIRQ(EXTI1_IRQn);
    EXTI->PR1 |= 0x0002;
}

void EXTI2_IRQHandler(){
	direction = 0;
	if(greenLED == 0){
        	GPIOC->BSRR = 0x0008;            //Toggle PB4
        	greenLED = 1;
    	}else{
        	GPIOC->BSRR = 0x0008 << 16;      //Toggle PB4
        	greenLED = 0;
    	}
	EXTI->PR1 |= 0x002; 					//Clear pending
	NVIC_ClearPendingIRQ(EXTI2_IRQn);   //Clear pending
}


/*----------------------------------------------------------*/
/* Function to Count up to 9 and then back to zero
/*----------------------------------------------------------*/

void countUpandDown () {
  if (direction == 0) {
		if (counter1 < 9) {
					counter1++;
			}
		else {
				counter1 = 0;
			}
		}
  else {
		if (counter1 > 0) {
				counter1--;
			}
		else {
			counter1 = 9;
			}
  }

}

/*----------------------------------------------------------*/
/* Function to Count up indefinately
/*----------------------------------------------------------*/

	void count () {
		if (counter2<9) {
			counter2++;
			
		}
    else {
    counter2 = 0;
    }
	}
/*----------------------------------------------------------*/
/* Delay function - 0.5 second delay */
/*----------------------------------------------------------*/
void delay (){
 int a,b;
 for (a=0; a<100; a++) { //outer loop
 for (b=0; b<12000; b++) { //inner loop
 }
 }
}

/*------------------------------------------------*/
/* Main program */
/*------------------------------------------------*/
int main(void) {
	counter1 = 0; //initializing counter values
	counter2 = 0;
	direction = 0; //setting direction as counting up
	
	//setting blue and green leds as off
	blueLED = 0;
  greenLED = 0;

	PinSetup(); //Configure GPIO pins
	InterruptSetup(); //Configure Interrupts
	__enable_irq(); //Enable CPU interrupts

	while (1) {

	sw1 = (GPIOA->IDR & PWR_PUCRA_PA1) >> 1; //sets switch 1 to PA1and shifts right 1 bit
  direction = (GPIOA->IDR & PWR_PUCRA_PA2) >> 2; //sets switch 2 to PA2 and shifts right 2 bits
	if (sw1 == 1) {
	countUpandDown();
  count();
		
	delay(); //delay

  // Writes counter1 and counter2 to the output pins
   GPIOA->ODR = (GPIOA->ODR & ~(0x1FE0)) | (((counter2 << 4) + counter1) << 5);
  }
}

}
