#include <stdio.h>
/*
Author Infomation: Brady Gehrman CECS 130

Program Description: Rewrite your lab 3 calculator program using functions.
Each mathematical operation in the menu should be represented by a separate function. In
addition to all operations your calculator had to support in lab 3, please add additional
functionality to your calculator. Include the ability to compute the factorial of an integer
(Example: 4! = 1 * 2 * 3 *4 = 24), and an integer power of a number (Example: 53 = 5 * 5 * 5 = 125).
Finally, add an interesting mathematical function of your choosing which computes the first n
numbers of a sequence of numbers and utilizes an array to store the result before displaying it
(Examples of mathematical sequences: Fibonacci, Primes)

Lab #4 Language: C

Date: 9/12/2019

Lab section: 02

*/

//function prototypes
float addTwoNumbers(float,float); //function prototype for adding two numbers
float subtractTwoNumbers(float,float); //function prototype for subtracting two numbers
float multiplyTwoNumbers(float,float); //function prototype for multiplying two numbers
float divideTwoNumbers(float,float); //function prototype for dividing two numbers
int modulusTwoNumbers(int,int); //function prototype for modulus
int testPrimality(int); //function prototype for testing primality
int factorial(int); //function prototype for factorial
float powerF(float,int); //function prototype for the power function
void fibonacci(int); //function prototype for fibonacci



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
		printf("(7) Factorial (integers only)\n");
		printf("(8) Power\n");
		printf("(9) Fibonacci\n");
		printf("(0) Exit\n");
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
		 
		//operation variables for 7
		int factorialNumber = 0;
		int factorialOfFactorialNumber = 0;
		//operation variables for 8
		float baseNumber = 0;
		int power = 0;
		float powerOutput = 0;
		//operation variables for 9
		int numberOfFibNumbersWanted;
		//input 1 number how many to print out
	
		
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
				factor = testPrimality(testPrimalityNumber); //tests for factors in function definition below, returns first factor it finds, or 0 if it doesn't find one
				//if factor = 0 then the function found no factors and just returned zero
				if(factor == 0){
					printf("\n%d Is Prime", testPrimalityNumber);
				}
				//function found a factor!
				else{
					printf("\nNot Prime: %d x %d = %d", testPrimalityNumber / factor, factor, testPrimalityNumber);
				}
				break;
				case 7:
					printf("----Factorial----");
					printf("\nEnter an integer to factorial: ");
					scanf("%d", &factorialNumber);
					factorialOfFactorialNumber = factorial(factorialNumber); //factorials number taken in to the function
					printf("\n factorial of %d is %d", factorialNumber, factorialOfFactorialNumber);
					break;
				case 8:
					printf("----Exponent/Power----");
					printf("\nEnter the base number: ");
					scanf("%f", &baseNumber); //get base number
					printf("\nEnter the power you would like to raise the base number to (integer): ");
					scanf("%d", &power); //get power number
					powerOutput = powerF(baseNumber,power);
					printf("\n %.3f ^ %d is %.3f", baseNumber, power, powerOutput);
					break;
				case 9:
					printf("---- Fibonacci----");
					printf("\nEnter the number of Fibonacci numbers you want me to display: ");
					scanf("%d", &numberOfFibNumbersWanted);
					fibonacci(numberOfFibNumbersWanted); //prints in function itself
					break;
				case 0:
				printf("\nThank You, Goodbye!");
				break;
			default:
				printf("\nselection was out of bounds (0-9) Returning to the Main Menu...\n");
				system("PAUSE"); 
				break;
		}
	
	} while(userSelection != 0); //if user inputs 0 then quit the program
	
	
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
	return 0; //doesn't return a factor, meaning the userInputedNumber is prime
}
int factorial(int userRequestedFactorialNumber){
	int factorial = 1;
	int i; 
	for(i = userRequestedFactorialNumber; i > 0; i--){
		factorial = factorial * i;
	}
	return factorial;
}
float powerF(float baseNumber, int power){
	float answer = 1;
	if(power == 0){
		return 1;
	}
	int i;
	if(power > 0){
	for(i = 1; i <= power; i++){
		answer = answer * baseNumber;
	}
		return answer; //baseNumber^power
	}else{ //power is negative
		power = power * -1; //make power positive to reuse code
	for(i = 1; i <= power; i++){
		answer = answer * baseNumber;
	}
		return 1 / answer; //negative exponenets mean 1/(baseNumber^power)
	}
	
}
void fibonacci(int numberOfNumbersWanted){
	int fibonacciNumbers[numberOfNumbersWanted];
	int number1 = 0;
	int number2 = 1;
	int nextNumber;
	fibonacciNumbers[0] = 0; //declare out first two cases and put them in an array
	fibonacciNumbers[1] = 1;
	int i;
	for(i = 2; i < numberOfNumbersWanted; i++){
		nextNumber = number1 + number2;
		fibonacciNumbers[i] = nextNumber;
		number1 = number2; //x1 = x2
		number2 = nextNumber; //x2 = next number
	}
	printf("\n %d Fibonacci Numbers: \n", numberOfNumbersWanted);
	for(i = 0; i < numberOfNumbersWanted; i++){
		printf("%d ", fibonacciNumbers[i]); //print out each number from the array starting at zero to end of array
	}
	
}












