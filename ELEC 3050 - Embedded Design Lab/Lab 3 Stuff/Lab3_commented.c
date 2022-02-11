/*====================================================*/
/* Jacob Howard */
/* Toggle LED1 while button pressed, with short delay inserted */
/*====================================================*/

#include "stm32l4xx.h" /* Microcontroller information */

/* Define global variables */
//int toggles; /* number of times LED state toggled */
static int counter1, counter2;
unsigned char run, up, blueLED, greenLED;

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
	
	/* The line below enables clock for both GPIOA and GPIOB,
	if you're trying to enable clocks only for GPIOB, then it's wrong. 
    Here, it works since we need both GPIOA and GPIOB. */
	RCC->AHB2ENR |= 0x03; //enable GPIOB AND GPIOA clock (2bit)
	
	GPIOB->MODER &= ~(0x03C0); //setting pins 3 and 4 PB //as what??
	/* the OR mask for GPIOB is wrong, it should be 0x0140 */
	GPIOB->MODER |= 0x0180; //setting pins 3 and 4 as output pins
}

/*----------------------------------------------------------*/
/* Interrupt settup
/*----------------------------------------------------------*/
void InterruptSetup(){
	//we are setting PA1 and PA2 as interrupts, not PA0!
	//replace all setup for PA0 with PA2, setup logic is the same 
	
	SYSCFG->EXTICR[0] &= ~(0x000F); //Clear EXTI0 (set for PA0)
	SYSCFG->EXTICR[0] &= ~(0x00F0); //Clear EXTI1 (set for PA1)
	
	EXTI->RTSR1 |= 0x0001; //Set rising trigger for PA0 //change for PA2
	EXTI->RTSR1 |= 0x0002; //Set rising trigger for PA1
	
	EXTI->IMR1 |= 0x0001; //Enable interrupt PA0 //change for PA2
	EXTI->IMR1 |= 0x0002; //Enable interrupt PA1
	
	EXTI->PR1 |= 0x001; //Clear pending bit for PA0 //change for PA2
	EXTI->PR1 |= 0x002; //Clear pending bit for PA1 
	
	//EXTI0 -> Px0 where x = A, B, C etc.
	//EXTI1 -> Px1
	//EXTI2 -> Px2 and so on
	NVIC_EnableIRQ(EXTI1_IRQn); //Enable interrupt for PA1, not PA0!
	NVIC_EnableIRQ(EXTI2_IRQn); //Enable interrupt for PA2, not PA1!
	
	NVIC_ClearPendingIRQ(EXTI1_IRQn); //Clear NVIC pending for PA1, not PA0!
	NVIC_ClearPendingIRQ(EXTI2_IRQn); //Clear NVIC pending for PA2, not PA1!
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
	/* No need to complicate the code for switching ON LED PB3,
	just switch ON LED by writing a 1 using an OR mask to the bit for LED PB3
	just like we did in Lab 2 */
	/* I also moved the LED operation outside of the handler and it worked */
    GPIOB->ODR = (GPIOB->ODR & ~(0x08)) | (run << 3);//Set to value of run
    
	NVIC_ClearPendingIRQ(EXTI1_IRQn);
    EXTI->PR1 |= 0x0002;
	
	/* at the end of the handler, you need to enable interrupts again 
	as the interrupt handler switches it off, see code below */
	__enable_irq();
}

void EXTI2_IRQHandler(){
	if (up == 1) {
			up = 0;
	}
	else {
		up = 1;
	}
	/* Once again, no need to complicate the code for switching ON LED PB4,
	just switch ON LED by writing a 1 using an OR mask to the bit for LED PB4
	just like we did in Lab 2 */
	/* I also moved the LED operation outside of the handler and it worked */
	GPIOB->ODR = (GPIOB->ODR & ~(0x04)) | (up << 2);//Set to value of run
   
	NVIC_ClearPendingIRQ(EXTI2_IRQn);
    EXTI->PR1 |= 0x0001;
	
	/* at the end of the handler, you need to enable interrupts again 
	as the interrupt handler switches it off, see code below */
	__enable_irq();
}


/*----------------------------------------------------------*/
/* Function to Count up to 9 and then back to zero
/*----------------------------------------------------------*/

void countUpandDown () {
  //looks good
  if (up == 1) {
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
/* Function to Count up to 9 indefinately
/*----------------------------------------------------------*/

void count () {
	if (counter2 < 9) {
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
	//Delay worked when I declared the delay() variables as non-static global
	int a,b; //declare these outside delay()
	for (a=0; a<100; a++) { //outer loop
		for (b=0; b<12000; b++); //inner loop
	}
}

/*------------------------------------------------*/
/* Main program */
/*------------------------------------------------*/
int main(void) {
	counter1 = 0; //initializing counter values
	counter2 = 0;
	run = 0; //setting initial run to 0
	up = 1; //setting direction as counting up

	PinSetup(); //Configure GPIO pins
	InterruptSetup(); //Configure Interrupts
	__enable_irq(); //Enable CPU interrupts

	while (1) {
		
		/* Below 2 lines are not needed! As you have setup PA1 and PA2 as interrupts,
		there is no need to read PA1 and PA2 from IDR. Run and Up values will change as
		at the press of their buttons as PA1 and PA2 will call the handler only when the
		particular button is pressed as you set run and up to toggle inside the handlers */
		//run = (GPIOA->IDR & PWR_PUCRA_PA1) >> 1; //sets switch 1 to PA1 and shifts right 1 bit
		//up = (GPIOA->IDR & PWR_PUCRA_PA2) >> 2; //sets switch 2 to PA2 and shifts right 2 bits
		
		if (run == 1) {
			countUpandDown();
			count();
			delay(); //delay
			// Writes counter1 and counter2 to the output pins
			/* As long as you're sure that the line below is correct and performs the bit by bit
			operations correctly, then it should be fine. I do not understand the line below very well. */
			/* If not, you can break the line below into two seperate lines to make them readable,
			one for displaying counter1 and the other for counter2 */
			GPIOA->ODR = (GPIOA->ODR & ~(0x1FE0)) | (((counter2 << 4) + counter1) << 5);
		}
	}
}
