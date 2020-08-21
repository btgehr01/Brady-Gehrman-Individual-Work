#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
Author Infomation: Brady Gehrman CECS 130

Program Description: Write a program that uses an array of structures to hold
contact information for your friends. The program should allow the user to enter as many friends
as the user wants. Create functions to add or delete entries in the phone book and to print valid
phone book entries. Do not display phone book entries that are invalid or NULL (0). You can
assume that all people have unique names. Make sure you allocate and free memory as
necessary. 

Lab #6 Language: C

Date: 9/26/2019

Lab section: 02

*/

//array of structures
//phone nmuber string and so are first and last names
//delete, first name and last name need to match and then delete it

//define structure

typedef struct phoneBookEntry{
	char firstName[20]; //20 bytes
	char lastName[20];
	char phoneNumber[13];
} entry;
//function prototypes
entry* addEntry(int, entry*);
entry* deleteEntry(int*, entry* );
void showEntries(int, entry*);
entry makeEntry();

int main(void){
	//initialize variables
	entry *entries;
	int userSelection = 0;
	int numberOfEntries = 0;
	int length = 0;
	entry *pEntries = malloc(sizeof(entry));
	do {
	//print out the menu
	printf("\n\n^*Phone Book*^");
	printf("\n1. Add friend");
	printf("\n2. Delete friend");
	printf("\n3. Show phone book");
	printf("\n4. Quit program\n");
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
			//free allocated memory
			free(pEntries);
			printf("Thank you for using the phone book program");
			break;
	}
	
}while (userSelection != 4);

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
	printf("\nEnter first name: ");
	scanf("%s", firstName);
	printf("\nEnter last name: ");
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
	int i; //no iterate through the for loop and print out each slot in the array 
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
	printf("\nEnter first name: ");
	scanf("%s", firstName);
	strcpy(newphoneBookEntry.firstName, firstName);
	printf("\nEnter last name: ");
	scanf("%s", lastName);
	strcpy(newphoneBookEntry.lastName, lastName);
	printf("\nEnter phone number (***-***-****): ");
	scanf("%s", phoneNumber);
	strcpy(newphoneBookEntry.phoneNumber, phoneNumber);
	return newphoneBookEntry;
}










