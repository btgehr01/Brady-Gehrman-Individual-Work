#include <stdio.h>
/*
Author Infomation: Brady Gehrman CECS 130

Program Description: Write a computer program in C which will simulate a
calculator. Your calculator needs to support the five basic operations (addition, subtraction,
multiplication, division and modulus) plus primality testing (natural number is prime if it has no
non-trivial divisors) 

Lab #3 Language: C

Date: 9/5/2019

Lab section: 02

*/

//function prototypes
float addTwoNumbers(float,float); //function prototype for adding two numbers
float subtractTwoNumbers(float,float); //function prototype for subtracting two numbers
float multiplyTwoNumbers(float,float); //function prototype for multiplying two numbers
float divideTwoNumbers(float,float); //function prototype for dividing two numbers
int modulusTwoNumbers(int,int); //function prototype for modulus
int testPrimality(int); //function prototype for testing primality


int main(void){
	int userSelection = 0;
	do{
		//print out calculator menu
		printf("\n\nCalculator Menu\n");
		printf("(1) Addition\n");
		printf("(2) Subtraction\n");
		printf("(3) Multiplication\n");
		printf("(4) Division\n");
		printf("(5) Modulus (Integers Only)\n");
		printf("(6) Test Primality (Integers Only)\n");
		printf("(7) Exit\n");
		printf("\nPlease choose an operation:");
		//get user selection
		scanf("%d", &userSelection);
		
		//operation variables for 1-4
		float firstNumber = 0;
		float secondNumber = 0;
		float output = 0;
	
		
		//operation variables for 5
		int firstNumberModulus = 0;
		int secondNumberModulus = 0;
		int modulusOutput = 0;
		
		//operation variables for 6
		int testPrimalityNumber = 0;
		int factor = 0;
	
		
		switch(userSelection){
			case 1:
				printf("----Addition----");
				printf("\nEnter the first number: ");
				scanf("%f", &firstNumber);
				printf("\nEnter the second number: ");
				scanf("%f", &secondNumber);
				output = addTwoNumbers(firstNumber,secondNumber); //firstNumber + secondNumber = output
				printf("\n%.3f + %.3f = %.3f", firstNumber, secondNumber, output);
				break;
			case 2:
				printf("----Subtraction----");
				printf("\nEnter the first number: ");
				scanf("%f", &firstNumber);
				printf("\nEnter the second number: ");
				scanf("%f", &secondNumber);
				output = subtractTwoNumbers(firstNumber,secondNumber); //firstNumber - secondNumber = output
				printf("\n%.3f - %.3f = %.3f", firstNumber, secondNumber, output);
				break;
			case 3:
				printf("----Multiplication----");
				printf("\nEnter the first number: ");
				scanf("%f", &firstNumber);
				printf("\nEnter the second number: ");
				scanf("%f", &secondNumber);
				output = multiplyTwoNumbers(firstNumber,secondNumber); //firstNumber x secondNumber = output
				printf("\n%.3f x %.3f = %.3f", firstNumber, secondNumber, output);
				break;
			case 4:
				printf("----Division----");
				printf("\nEnter the first number: ");
				scanf("%f", &firstNumber);
				printf("\nEnter the second number: ");
				scanf("%f", &secondNumber);
				output = divideTwoNumbers(firstNumber,secondNumber); //firstNumber / secondNumber = output
				printf("\n%.3f / %.3f = %.3f", firstNumber, secondNumber, output);
				break;
			case 5:
				printf("----Modulus----");
				printf("\nEnter the first number(must be an integer): ");
				scanf("%d", &firstNumberModulus);
				printf("\nEnter the second number(must be an integer): ");
				scanf("%d", &secondNumberModulus);
				modulusOutput = modulusTwoNumbers(firstNumberModulus,secondNumberModulus); //firstNumber % secondNumber = output
				printf("\n%d %% %d = %d", firstNumberModulus, secondNumberModulus, modulusOutput);
				break;
			case 6:
				printf("----Primality----");
				printf("\nEnter the number to be tested(must be an integer): ");
				scanf("%d", &testPrimalityNumber);
				factor = testPrimality(testPrimalityNumber); //tests for factors in function definition below, returns first factor it finds, or 1 if it doesn't find one
				//if factor = 1 then the function found no factors and just returned one
				if(factor == 1){
					printf("\n%d Is Prime", testPrimalityNumber);
				}
				//function found a factor!
				else{
					printf("\nNot Prime: %d x %d = %d", testPrimalityNumber / factor, factor, testPrimalityNumber);
				}
				break;
			case 7:
				printf("\nThank You, Goodbye!");
				break;
			default:
				printf("\nselection was out of bounds (1-7) Returning to the Main Menu...\n");
				system("PAUSE"); 
				break;
				
		}
	
	} while(userSelection != 7);
	
	
	return 0;
}

//function definitions


float addTwoNumbers(float addendOne, float addendTwo){
	float sum = addendOne + addendTwo;
	return sum;
}

float subtractTwoNumbers(float minuend, float subtrahend){
	float difference = minuend - subtrahend;
	return difference;
}

float multiplyTwoNumbers(float factorOne, float factorTwo){
	float product = factorOne * factorTwo;
	return product;
}

float divideTwoNumbers(float dividend, float divisor){
	float quotient =  dividend / divisor;
	return quotient;
}

int modulusTwoNumbers(int modulusNumberOne, int modulusNumberTwo){
	int remainder = modulusNumberOne % modulusNumberTwo;
	return remainder;
}

int testPrimality(int primalityTestNumber){
	int i;
	for(i = 2; i < primalityTestNumber; i++){
		int remainder = primalityTestNumber % i;
		if(remainder == 0){
			return i;
		}
	}
	return 1; //doesn't return a factor, meaning the userInputedNumber is prime
}







