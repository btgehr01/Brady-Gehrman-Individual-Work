#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>
/*
Author Infomation: Brady Gehrman CECS 130

Program Description: Add additional functionality to your phonebook program
from lab# 6. Make it possible for users to:
1) Alphabetically sort the list of entries by name (first or last).
2) Find a phone number for a given name.
3) Randomly select a friend from the phonebook for you to call.
4) Delete everyone from the phonebook at the same time

Lab #7 Language: C

Date: 10/6/2019

Lab section: 02

*/

//define structure

typedef struct phoneBookEntry{
	char firstName[20]; //20 bytes
	char lastName[20];
	char phoneNumber[12];
} entry;
//function prototypes
entry* addEntry(int, entry*);
entry* deleteEntry(int*, entry* );
void showEntries(int, entry*);
entry makeEntry();
void alphabetize(int, entry*);
void findEntry(int, entry*);
void randomlySelect(int, entry*);

int main(void){
	//initialize variables
	entry *entries;
	int userSelection = 0;
	int numberOfEntries = 0;
	entry *pEntries = malloc(sizeof(entry));
	do {
	//print out the menu
	printf("\n\n^*Phone Book*^");
	printf("\n1. Add friend");
	printf("\n2. Delete friend");
	printf("\n3. Show phone book");
	printf("\n4. Alphabetically sort the list of entries by name (first or last)");
	printf("\n5. Find a phone number for a given name");
	printf("\n6. Randomly select a friend from the phonebook for you to call");
	printf("\n7. Delete everyone from the phonebook at the same time");
	printf("\n8. Quit program\n");
	printf("\nPlease select an operation above: ");
	scanf("%d", &userSelection);
	
	switch(userSelection){
		case 1:
			entries = addEntry(numberOfEntries, pEntries);
			if(entries != NULL){
				pEntries = entries;
				numberOfEntries++;
			}else{
				return 1; //indicate program cannot go on any longer
			}
			break;
		case 2:
			if(numberOfEntries == 0){
				printf("\n No contacts in the phone book, so we cannot delete any");
			}else{
			entries = deleteEntry(&numberOfEntries, pEntries);
			if(entries != NULL){
				pEntries = entries;
			}
			else{
				return 1; //end program
			}
			}
			break;
		case 3:
			showEntries(numberOfEntries, pEntries);
			break;
		case 4:
			if(numberOfEntries == 0){
				printf("No entries in phonebook.");
			}else{
				alphabetize(numberOfEntries, pEntries);
			}
			break;
		case 5:
			if(numberOfEntries == 0){
				printf("No entries in phonebook.");
			}else{
				findEntry(numberOfEntries, pEntries);
			}
			break;
		case 6:
			if(numberOfEntries == 0){
				printf("No entries in phonebook.");
			}else{
				randomlySelect(numberOfEntries, pEntries);
			}
			break;
		case 7:
			free(pEntries);
			numberOfEntries = 0;
			pEntries = malloc(sizeof(entry));
			printf("Phonebook is now empty ):");
			//Delete everyone from the phonebook at the same time
			break;	
		case 8:
			//free allocated memory
			free(pEntries);
			printf("Thank you for using the phone book program");
			break;
	}
	
}while (userSelection != 8);

	return 0;

}

entry* addEntry(int numOfEntries, entry *currentPhoneBook){
	entry madeEntry;
	entry *temp;
	temp = (entry *)realloc(currentPhoneBook, (numOfEntries + 1) * sizeof(entry));
	if(temp == NULL){
		printf("not enough memory to add new entry");
		return temp;
		//return false to show error and later end the program
	}else{
	currentPhoneBook = temp;
	madeEntry = makeEntry();
	strcpy(currentPhoneBook[numOfEntries].firstName, madeEntry.firstName);
	strcpy(currentPhoneBook[numOfEntries].lastName, madeEntry.lastName);
	strcpy(currentPhoneBook[numOfEntries].phoneNumber, madeEntry.phoneNumber);
	currentPhoneBook[numOfEntries].firstName[0] = toupper(currentPhoneBook[numOfEntries].firstName[0]);
	currentPhoneBook[numOfEntries].lastName[0] = toupper(currentPhoneBook[numOfEntries].lastName[0]);
	printf("Record added to the phone book");
	}
return currentPhoneBook; 
}
entry* deleteEntry(int *numOfEntries, entry *currentPhoneBook){
	entry *temp;
	int arraySlotToDelete;
	int i;
	char firstName[20];
	char lastName[20];
	char phoneNumber[13];
	int foundEntry = 0;
	printf("\n^*Delete Phonebook Entry*^");
	printf("\nEnter capitalized first name: ");
	scanf("%s", firstName);
	printf("\nEnter capitalized last name: ");
	scanf("%s", lastName);
	for(i = 0; i < *numOfEntries; i++){
		int comparisonFirst = strcmp(currentPhoneBook[i].firstName, firstName);
		int comparisonSecond = strcmp(currentPhoneBook[i].lastName, lastName);
		if(comparisonFirst == 0 && comparisonSecond == 0){
			foundEntry = 1; //we found an entry to delete
			//now remove that slot from the array
			arraySlotToDelete = i;
			for(arraySlotToDelete; arraySlotToDelete < *numOfEntries - 1; arraySlotToDelete++){
			currentPhoneBook[arraySlotToDelete] = currentPhoneBook[arraySlotToDelete + 1]; //set array slots above the arraySlotToDelete to the one below it
			}
			break;	
		}
	}
		if(foundEntry == 0){
			printf("No such entry found.");
			return currentPhoneBook; //return currentPhoneBook(nothing was found to be deleted)
		}else{
			if(*numOfEntries == 1){
				printf("%s %s was deleted from the phonebook", firstName, lastName);
				printf("\nPhonebook is now empty :(");
				(*numOfEntries)--; //update numOfEntries
				return currentPhoneBook;
				//will rewrite over existing data later in execution
			}else{
			temp = (entry *)realloc(currentPhoneBook, (*numOfEntries - 1) * sizeof(entry));
			if(temp == NULL){
				printf("reallocation wasn't sucessful");
				return temp;
			}else{
			currentPhoneBook = temp;
			printf("%s %s was deleted from the phonebook", firstName, lastName);
			(*numOfEntries)--; //update numOfEntries
			return currentPhoneBook;
	}
}
}
}

void showEntries(int numberOfEntries, entry *currentPhoneBook){
	printf("\nPhone Book Entries:\n");
	if(numberOfEntries == 0){
		printf("Phonebook is empty"); //phonebook is empty do not proceed
	} else{
	int i; //iterate through the for loop and print out each slot in the array 
	for(i = 0; i < numberOfEntries; i++){
		printf("\n%s %s %s", currentPhoneBook[i].firstName, currentPhoneBook[i].lastName, currentPhoneBook[i].phoneNumber);
	}
  }	
}
entry makeEntry(){
	entry newphoneBookEntry;
	char firstName[20];
	char lastName[20];
	char phoneNumber[13];
	printf("\n^*Add Phonebook Entry*^");
	printf("\nEnter capitalized first name: ");
	scanf("%s", firstName);
	strcpy(newphoneBookEntry.firstName, firstName);
	printf("\nEnter capitalized last name: ");
	scanf("%s", lastName);
	strcpy(newphoneBookEntry.lastName, lastName);
	printf("\nEnter phone number (***-***-****): ");
	scanf("%s", phoneNumber);
	strcpy(newphoneBookEntry.phoneNumber, phoneNumber);
	return newphoneBookEntry;
}

void alphabetize(int numOfEntries, entry *currentPhoneBook){
	int i;
	int j;
	char temp[20];
	char tempTwo[20];
	char tempThree[20];
	int userSelection = 0;
	printf("\n1. alphabetize by first name");
	printf("\n2. alphabetize by last name\n");
	printf("\n choose from the options above ");
	scanf("%d", &userSelection);
	switch(userSelection){
		case 1:
			for(i = 0; i < numOfEntries - 1; i++){
				for(j = i + 1; j < numOfEntries; j++){
					if(strcmp(currentPhoneBook[i].firstName, currentPhoneBook[j].firstName) > 0){
						strcpy(temp, currentPhoneBook[i].firstName);
						strcpy(tempTwo, currentPhoneBook[i].lastName); //switch last name too
						strcpy(tempThree, currentPhoneBook[i].phoneNumber); //switch phoneNumbers too
						strcpy(currentPhoneBook[i].firstName, currentPhoneBook[j].firstName);
						strcpy(currentPhoneBook[i].lastName, currentPhoneBook[j].lastName);
						strcpy(currentPhoneBook[i].phoneNumber, currentPhoneBook[j].phoneNumber);
						strcpy(currentPhoneBook[j].firstName, temp);
						strcpy(currentPhoneBook[j].lastName, tempTwo);
						strcpy(currentPhoneBook[j].phoneNumber, tempThree);
					}
				}
			}
			printf("Alphabetize list by first name: ");
			for(i = 0; i < numOfEntries; i++){
				printf("%s, ", currentPhoneBook[i].firstName);
			}
			break;
		case 2:
			for(i = 0; i < numOfEntries - 1; i++){
				for(j = i + 1; j < numOfEntries; j++){
					if(strcmp(currentPhoneBook[i].lastName, currentPhoneBook[j].lastName) > 0){
						strcpy(temp, currentPhoneBook[i].lastName);
						strcpy(tempTwo, currentPhoneBook[i].firstName); //switch first name too
						strcpy(tempThree, currentPhoneBook[i].phoneNumber); //switch phone numbers too
						strcpy(currentPhoneBook[i].lastName, currentPhoneBook[j].lastName);
						strcpy(currentPhoneBook[i].firstName, currentPhoneBook[j].firstName);
						strcpy(currentPhoneBook[i].phoneNumber, currentPhoneBook[j].phoneNumber);
						strcpy(currentPhoneBook[j].lastName, temp);
						strcpy(currentPhoneBook[j].firstName, tempTwo);
						strcpy(currentPhoneBook[j].phoneNumber, tempThree);
					}
				}
			}
			printf("Alphabetize list by last name: ");
			for(i = 0; i < numOfEntries; i++){
				printf("%s, ", currentPhoneBook[i].lastName);
			}
			break;
		default:
			printf("User selection invalid, returning to main menu");
			break;
	}
	
	
}

void findEntry(int numOfEntries, entry *currentPhoneBook){
	int foundArraySlot;
	char firstName[20];
	char lastName[20];
	int foundEntry = 0;
	printf("\n^*Find Phonebook Entry*^");
	printf("\nEnter capitalized first name: ");
	scanf("%s", firstName);
	printf("\nEnter capitalized last name: ");
	scanf("%s", lastName);
	int i;
	for(i = 0; i < numOfEntries; i++){
		int comparisonFirst = strcmp(currentPhoneBook[i].firstName, firstName);
		int comparisonSecond = strcmp(currentPhoneBook[i].lastName, lastName);
		if(comparisonFirst == 0 || comparisonSecond == 0){
			foundArraySlot = i;
			foundEntry = 1; //we found an entry that matches
			printf("\n%s %s %s", currentPhoneBook[i].firstName, currentPhoneBook[i].lastName, currentPhoneBook[i].phoneNumber);
			break;
		}
	}
	if(foundEntry == 0){
		printf("%s %s is not included in the phonebook.", firstName, lastName);
	} 
}

void randomlySelect(int numOfEntries, entry *currentPhoneBook){
	srand(time(NULL)); //seed random number generator
	int random = rand() % numOfEntries;
	int answered = rand() % 2;
		printf("\nDialing %s", currentPhoneBook[random].phoneNumber);
		printf(".......");
		if(answered == 1){
			printf("%s %s answered", currentPhoneBook[random].firstName, currentPhoneBook[random].lastName);
		}else{
			printf("%s %s didn't answer", currentPhoneBook[random].firstName, currentPhoneBook[random].lastName);
		}
}













