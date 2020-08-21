#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
/*
Author Infomation: Brady Gehrman CECS 130

Program Description: Write a program which generates interactive stories. You
program should begin by asking the user a number of questions such as: what is your name?
How old are you? What is your favorite color? Etc. After obtaining a sufficient amount of
personal information your program should output a short story (at least one paragraph) which
incorporates user’s personal information you have obtained via questioning. (The topic of the
story is up to you, but please keeps it clean.) The generated story should be somewhat different
every time the program is run (randomly generate alternative endings, randomly select different
descriptions of objects (blue car, green car, red car), etc. Your program should make use of
pointers and arrays to deal with strings.

Lab #5 Language: C

Date: 9/20/2019

Lab section: 02

*/

int main(void){
	
	//get user name
	char name[25] = {'\0'};
	char *pName = name;
	printf("Enter your first name: ");
	scanf("%s", name);
	
	//get user's favorite animal
	char favoriteAnimal[20] = {'\0'};
	char *pFavAnimal = favoriteAnimal;
	printf("\nEnter your favorite animal: ");
	scanf("%s", favoriteAnimal);
	
	//get user's occupation
	char occupation[20] = {0};
	char *pOccupation = occupation;
	printf("\nEnter your occupation: ");
	scanf("%s", pOccupation);
	
	
	//get user age
	int age;
	printf("\nEnter your age: ");
	scanf("%d", &age);
	
	//get user's lucky number, store in int array to show pointer handles
	int luckyNumber[1];
	int *pLuckyNum = luckyNumber;
	printf("\nEnter your lucky number: ");
	scanf("%d", pLuckyNum); 
	// luckyNumber[0]);
	// *pLuckyNum);
	
	
	//get user's fav musical artist out of the listed
	int choice;
	char *artists[] = {"Ariana Grande", "Taylor Swift","Eminem", "Drake", "Adele", "Justin Bieber", "Ed Sheeran", "Elvis Presley"};
	int i;
	for(i = 0; i < 8; i++){
		printf("\n%d. %s ", i+1 , artists[i]); //ex 1. Ariana Grande
	}
	printf("\nPlease enter the number corresponding to your favorite musical artist above: ");
	scanf("%d", &choice);
	choice --; //choice = choice -1 so we can use that number to search through an array
	// (artists[choice]));
	//*(artists + choice));
	
	
	
	//randomization arrays
	
	char *cars[] = {"ferrari", "lamborghini","audi", "bmw", "toyota", "Nissan"};
	char *vacationSpots[] = {"Hawaii", "London","Hong Kong", "Tokyo","Moscow"};
	char *dates[] = {"breakfast", "brunch", "lunch", "dinner", "movie", "bowling"};
	char *colors[] = {"red", "green", "yellow", "black", "grey", "white", "purple"};
	
	//random numbers to be used for randomization in the story (slot numbers for the arrays above)
	
	srand(time(NULL)); //seed random number generator for later
	
	int carRan = rand() % 6;
	
	int vacationSpotRan = rand() % 5;
	
	int typeOfDateRan = rand() % 6;
	
	int colorRan = rand() % 7;
	
	
	//print out story
	printf("\nStory:\n");
	printf("\n\n%s is %d years old and works as an %s in a big city.", name, age, occupation); 
	printf("\n%s likes to listen to some %s songs while he travels to work in his %s %s!", pName, *(artists + choice), colors[colorRan], cars[carRan]);
	printf("\nHe loves animals and owns %d %ss.", *pLuckyNum, pFavAnimal); //pointer to luckynumber and pointer to favorite animal (String)
	printf("\nLast year %s went on his dream vacation to %s and actually met %s, his favorite musical artist of all time!", name, vacationSpots[vacationSpotRan], (artists[choice]));
	printf("\nThey went on a %s date and are still great friends to this day!", *(dates + typeOfDateRan));
	
	
	
return 0;

}

