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
	//RCC->AHB2ENR |= 0x01; /* Enable GPIOA clock (bit 0) */
	GPIOA->MODER &= (0xFD5557C3); /* General purpose input mode */	//THIS may be wrong. Might be ~0x0000003C.
	//RCC->AHB2ENR |= 0x02; /* Enable GPIOB clock (bit 1) */
	GPIOB->MODER &= ~(0x003FFFC0); /* Clear PB3-PB10 mode bits */ //tried GPIOB ports as well to see if that would help
	GPIOB->MODER |=  (0x00155540); /* General purpose output mode*/
}

/*----------------------------------------------------------*/
/* Function to Count up to 9 and then back to zero
/*----------------------------------------------------------*/

void countUp9 () {
	if (i<=9) {
	i++;
		counter1++;
	}
	else {
	 i = 0;
	}
}
/////////////////////////////////////////
void countDown9 () {
	if (i>=0) {
	i--;
	counter1--;
	}
	else {
		i = 9;
	}
}

/*----------------------------------------------------------*/
/* Function to Count up indefinately
/*----------------------------------------------------------*/

	void count () {
		if (j<=0) {
			j++;
			counter2++;
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

	counter1 = 0x0000; //hex counter for first counter
	counter2 = 0x0000; //hex counter for second counter

	PinSetup(); //Configure GPIO pins

	while (1) {
		delay(); //delay

	sw1 = GPIOA->IDR & 0x0002;
	while (sw1 == 0) {
					//Edit: using PA not PB. Maybe could try this instead of all 8 code lines. (GPIOA->ODR &= ~0x1FE0; // Clear PA[12:5])
	GPIOB->ODR = 0xFFF7; //reset PB3=0
	GPIOB->ODR = 0xFFEF; //reset PB4=0
	GPIOB->ODR = 0xFFDF; //reset PB5=0
	GPIOB->ODR = 0xFFBF; //reset PB6=0
	GPIOB->ODR = 0xFF7F; //reset PB7=0
	GPIOB->ODR = 0xFEFF; //reset PB8=0
	GPIOB->ODR = 0xFDFF; //reset PB9=0
	GPIOB->ODR = 0xFBFF; //reset PB10=0

	sw1 = GPIOA->IDR & 0x0002; //checks to see if PA_0 is on. If not, continues while loop.
	}
		sw2 = GPIOA->IDR & 0x0004;
	if (sw2 == 0) { //checks to see if switch 2 is on or off
	countUp9();
		out1 = counter1;
		GPIOB->ODR = out1 << 5;		//try 5 and the other 9. (was 3 and 7 at first)

		count();
		out2 = counter2;
		GPIOB->ODR = out2 << 9;

		sw1 = GPIOA->IDR & 0x0002;
	} //if sw2 is on this will continue count but will start cound down 9
	else {
		countDown9();
		out1 = counter1;
		GPIOB->ODR = out1 << 3;

	count();
	out2 = counter2;
	GPIOB->ODR = out2 << 7;
	}
}

}
