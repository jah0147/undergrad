
/*====================================================*/
/* Jacob Howard */
/* ELEC 3040/3050 - Lab 5, Program 1 */
/* Cuount up/down depending on specified direction */
/*====================================================*/


#include "STM32l4xx.h" 						//Microcontroller information

/* Define global variables */
int counter; 			//number currently displayed
int something;
int key;
int reset;

struct {
	unsigned char row;
	unsigned char column;
	unsigned char event;
	const int row1[4];
	const int row2[4];
	const int row3[4];
	const int row4[4];
	const int* keys[];
} typedef matrix_keypad;

void PinSetup (void);
void delay (void);
void smallDelay (void);
void count (void);
void updateLEDs (int value);
int readColumn(void);
int readRow(void);

matrix_keypad keypad = {
	.row = ~0,
	.column = ~0,
	.event = 0,
	.row1 = {1, 2, 3, 10},
	.row2 = {4, 5, 6, 11},
	.row3 = {7, 8, 9, 12},
	.row4 = {14, 0, 15, 13},
	.keys = {keypad.row1, keypad.row2, keypad.row3, keypad.row4},
};

/*------------------------------------------------*/
/* Main program */
/*------------------------------------------------*/

int main(void) {
	PinSetup();					  			//Configure GPIO pins
	counter = 0;
	key = 0;
	reset = 0;
	updateLEDs(counter);
	
	/* Endless loop */
	while (1) {
		delay();
		count();
		if (keypad.event != 0) {
			updateLEDs(key);
		}
		else {
			updateLEDs(counter);
		}
 }	/* repeat forever */
}

/*---------------------------------------------------*/
/* Initialize GPIO pins used in the program */
/* PA1 = start/stop PA2 = direction */
/* PC[0,3] = output */
/*---------------------------------------------------*/

void PinSetup () {
	/* Configure PA1 and PA2 as input pin to read push button */
	RCC->AHB2ENR |= 0x01; 						//Enable GPIOA clock (bit 0)
	//GPIOA->MODER &= ~(0xFF0); 	//clears bits 2-5
	//GPIOA->MODER &= ~(0xFF0000); //clears bits 8-11
	
	//GPIOA->MODER |= (0x550000); //setting 8-11 as output
	
	/*GPIOB*/
	RCC->AHB2ENR |= 0x02;						//Enable clock
	GPIOB->MODER &= ~(0x3);	//clear
	
	GPIOB->MODER &= ~(0x3FC0);
	GPIOB->MODER |= (0x1540);
	
	//GPIOA->PUPDR &= ~(0xFF0);	//clear pu/pd
	//GPIOA->PUPDR |= (0x550);		//pull up/ pull down
	
	RCC->APB2ENR |= 0x01; //
	SYSCFG->EXTICR[0] &= 0xFFF0; //ext0
	SYSCFG->EXTICR[0] |= 0x1;
	EXTI->FTSR1 |= 0x0001;
	EXTI->IMR1 |= 0x0001;
	EXTI->PR1 |= 0x1;
	NVIC_EnableIRQ (EXTI1_IRQn);
	NVIC_ClearPendingIRQ (EXTI1_IRQn);

	__enable_irq();
}

/*----------------------------------------------------------*/
/* interrupt handler*/
/*----------------------------------------------------------*/
void EXTI1_IRQHandler () {
	EXTI->PR1 |= 0x0002;
	
	int row = readRow();
	int column = readColumn();
	keypad.event = 5;
	if (row != -1 & column != -1) {
		key = keypad.keys[row][column];
	}
	else {
		key = -1;
	}		
	if (key != -1) {
		reset = 5;
	}
	else {
		reset = 0;
	}
}
/*----------------------------------------------------------*/
/* Delay function - do nothing for about 1 second */
/*----------------------------------------------------------*/

void delay () {
 int i,j,n;
	i = j = n = 0;
	if (keypad.event > 0) {
		keypad.event--;
	}
 for (i=0; i<20; i++) { 		//outer loop
	for (j=0; j<20000; j++) { //inner loop
		n = j;									//dummy operation for single-step test
	} 												//do nothing
 }
}
/*------------------------------------------------*/
/* Count function - increment or decrement according to direction*/
/*------------------------------------------------*/

void count () {
	counter = (counter + 1) % 10;
}
/*------------------------------------------------*/
/* Count function - increment or decrement according to direction*/
/*------------------------------------------------*/

void updateLEDs (int value) {
	//display count information
	GPIOB->ODR &= ~(0x78); //sets 3-6 = 0
	GPIOB->ODR |= value << 3;
}

int readColumn() {
	//GPIOB->MODER &= ~(0x0000FFFF);
	//GPIOB->MODER |= (0x00000055);
	//GPIOB->PUPDR &= ~(0x0000FF00);
	//GPIOB->PUPDR |= (0x00005500);
	//rows are ouput
	//columns are input
	GPIOA->MODER &= ~(0xFF0); 	//clears bits 2-5
	GPIOA->MODER &= ~(0xFF0000); //clears bits 8-11
	GPIOA->MODER |= (0x550); //setting 5-2 as output
	GPIOA->PUPDR &= ~(0xFF0000);	//clear pu/pd
	GPIOA->PUPDR |= (0x550000);		//pull up/ pull down
	GPIOA->ODR = 0;
	
	
	something = 4;
	
	while (something > 0) {
		something --;
	}
	int input = GPIOA ->IDR & ~(0xF00);
	input = input >> 8;
	switch(input) {
		case 0xE:
			return 1;
		case 0xD:
			return 2;
		case 0xB:
			return 3;
		case 0x7:
			return 4;
		default:
			return -1;
	}
}
int readRow() {
	/**
	GPIOB->MODER &= ~(0x0000FFFF);
	/GPIOB->MODER |= (0x00005500);
	GPIOB->ODR = 0;
	GPIOB->PUPDR &= ~(0x000000FF);
	GPIOB->PUPDR |= (0x00000055);
	**/
	//rows are input
	//columns are output
	GPIOA->MODER &= ~(0xFF0); 	//clears bits 2-5
	GPIOA->MODER &= ~(0xFF0000); //clears bits 8-11
	GPIOA->MODER |= (0x550000); //setting 8-11 as output
	GPIOA->PUPDR &= ~(0xFF0);	//clear pu/pd
	GPIOA->PUPDR |= (0x550);		//pull up/ pull down
	GPIOA->ODR = 0;
	something = 4;
	
	while (something >4){
		something--;
	}
	int input = GPIOA->IDR & ~(0x3C);
	input = input >> 2;
	switch(input) {
		case 0xE:
			return 1;
		case 0xD:
			return 2;
		case 0xB:
			return 3;
		case 0x7:
			return 4;
		default:
			return -1;
	}
}

