/*====================================================*/
/* Jacob Howard */
/* Toggle LED1 while button pressed, with short delay inserted */
/*====================================================*/

#include "stm32l4xx.h" /* Microcontroller information */

/* Define global variables */
//int toggles; /* number of times LED state toggled */

/*---------------------------------------------------*/
/* Initialize GPIO pins used in the program */
/* PA11 = push button */
/* PB4 = LDR, PB5 = green LED */
/*---------------------------------------------------*/
void PinSetup () {
 /* Configure PA0 as input pin to read push button */
	//RCC->AHB2ENR |= 0x01; /* Enable GPIOA clock (bit 0) */
	GPIOA->MODER &= (0xFD5557C3); /* General purpose input mode */
 /* Configure PB4,PB3 as output pins to drive LEDs */
	//RCC->AHB2ENR |= 0x02; /* Enable GPIOB clock (bit 1) */
	//GPIOB->MODER &= ~(0x000003C0); /* Clear PB4-PB3 mode bits */
	//GPIOB->MODER |=  (0x00000140); /* General purpose output mode*/
}

/*----------------------------------------------------------*/
/* Function to Count up to 9 and then back to zero
/*----------------------------------------------------------*/

void countUp9 (int i, int counter1) {
	if (i<=9) {
	i++;
		counter1++;
	}
	else {
	 //do nothing
	}
}
/////////////////////////////////////////
void countDown9 (int i, int counter1) {
	if (i>=0) {
	i--;
	counter1--;		
	}
	else {
		//do nothing
	}
}
	
/*----------------------------------------------------------*/
/* Function to Count up indefinately
/*----------------------------------------------------------*/
	
	void count (int j, int counter2) {
		if (j<=0) {
			j++;
			counter2++;
		}
	}
	
/*------------------------------------------------*/
/* Main program */
/*------------------------------------------------*/
int main(void) {
	int i = 0;
	int j = 0;
	
	int counter1 = 0x00; //hex counter for first counter
	int counter2 = 0x00; //hex counter for second counter
	
	uint16_t sw1; //declare 16-bit variable that matches IDR size (Switch 1 to start and stop counters)
	uint16_t sw2; //Switch 2 to reverse counter 1
	
	PinSetup(); //Configure GPIO pins
	
	unsigned char dirA;
	unsigned char on;
	
	dirA = GPIOA->IDR & PWR_PUCRA_PA2;   //Sets the direction to the state of SW2
	on = GPIOA->IDR & PWR_PUCRA_PA1;    //Sets the state of SW1 to on
	
	
	
	while (1) {
		delay(); //delay
		
	while (sw1 == 0) {
	sw1 = GPIOA->IDR & 0x0001; //checks to see if PA_0 is on. If not, continues while loop.
	}
		sw2 = GPIOA->IDR & 0x0040;
	if (sw2 == 0) { //checks to see if switch 2 is on or off
	countUp9(i, counter1);
	}
	else {
	count(j, counter2);
	}
}
	
}
