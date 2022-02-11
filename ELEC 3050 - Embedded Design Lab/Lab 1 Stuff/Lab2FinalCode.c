/*====================================================*/
/* Jacob Howard */
/* Toggle LED1 while button pressed, with short delay inserted */
/*====================================================*/

#include "stm32l4xx.h" /* Microcontroller information */

/* Define global variables */
//int toggles; /* number of times LED state toggled */
static int i;
static int j;
static int counter1; //hex counter for first counter
static int counter2; //hex counter for second counter

static uint16_t sw1; //declare 16-bit variable that matches IDR size (Switch 1 to start and stop counters)
static uint16_t sw2; //Switch 2 to reverse counter 1
static uint16_t out1; //output 1
static uint16_t out2; //output 2


/*---------------------------------------------------*/
/* Initialize GPIO pins used in the program */
/* PA11 = push button */
/* PB4 = LDR, PB5 = green LED */
/*---------------------------------------------------*/
void PinSetup () {
 /* Configure PA0 as input pin to read push button */
	RCC->AHB2ENR |= 0x01; /* Enable GPIOA clock (bit 0) */
	GPIOA->MODER &= ~(0x03FFFC3C); /* General purpose input mode */	//THIS may be wrong. Might be ~0x0000003C.
  GPIOA->MODER |= 0x01555400; /* Sets pins 1 and 2 as inputs and pins 5-12 as outputs, and all others as 00.
}

/*----------------------------------------------------------*/
/* Function to Count up to 9 and then back to zero
/*----------------------------------------------------------*/

void countUpandDown (int sw2) {
  if (sw2 == 0) {
  if (i < 9) {
	i++;
	}
  else {
	 i = 0;
	}
	}
  else {
  if (i > 0) {
  i--;
  }
  else {
  i = 9;
  }
  }

}
/////////////////////////////////////////

/*----------------------------------------------------------*/
/* Function to Count up indefinately
/*----------------------------------------------------------*/

	void count () {
		if (j<9) {
			j++;
			//counter2++;
		}
    else {
    j = 0;
    }
	}
	//delay/////////////////////////////////////////////
	void delay () {
	int a,b,c;
	for (a=0; a<20; a++) { //outer loop
		for (b=0; b<20000; b++) { //inner loop
			c = j; //dummy operation for single-step test
		} //do nothing
	}
}

/*------------------------------------------------*/
/* Main program */
/*------------------------------------------------*/
int main(void) {
	i = 0;
	j = 0;

	//counter1 = 0x0000; //hex counter for first counter
	//counter2 = 0x0000; //hex counter for second counter

	PinSetup(); //Configure GPIO pins

	while (1) {
		delay(); //delay

	sw1 = (GPIOA->IDR & PWR_PUCRA_PA1) >> 1; //sets switch 1 to PA1and shifts right 1 bit
  sw2 = (GPIOA->IDR & PWR_PUCRA_PA2) >> 2; //sets switch 2 to PA2 and shifts right 2 bits

	if (sw1 == 1) {
	countUpandDown(sw2);

  count();

  // Writes i and j to the output pins
   GPIOA->ODR = (GPIOA->ODR & ~(0x1FE0)) | (((j << 4) + i) << 5);
  }
}

}
