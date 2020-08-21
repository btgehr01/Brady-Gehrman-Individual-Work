#include <stdio.h>
/*
Author Infomation: Brady Gehrman CECS 130

Program Description: Write a computer program in C which will request
the user to enter a number representing the amount of foreign currency he/she would
like to exchange. Your program should output a foreign currency conversion table for at
least 6 different currencies, showing how much of each type of foreign currency can be
obtained for the amount the user enters. 

Lab #2 Language: C

Date: 8/29/2019

Lab section: 02

*/


int main(void){
	
	float amountOfForeignCurrency;
	printf("We support conversions for USD, GBP, CAD, EUR, AUD, and Pesos!");
	printf("\nPlease input the whole number amount of foreign currency you would like to convert : \n");
	scanf("%f", &amountOfForeignCurrency);
	printf("\nThis is the amountOfForeignCurrency reuqested: %.0f", amountOfForeignCurrency); //amountOfForeignCurrency is the requested amount by the user
	
	const float gbpToUsdMultiplier = 1.22; //$1.22 = £1
	const float cadToUsdMultiplier = .75; //$0.75 = C$1
	const float eurToUsdMultiplier = 1.1;  //$1.10 = €1
	const float audToUsdMultiplier = .67; //$0.67 = A$1
	const float pesToUsdMultiplier = .05;  //$0.05 = M$1
	
	
	const float usdToGbpMultiplier = 1/gbpToUsdMultiplier; //$1 = £0.82
	const float usdToCadMultiplier = 1/cadToUsdMultiplier; //$1 = c$1.33
	const float usdToEurMultiplier = 1/eurToUsdMultiplier; //$1 = €0.91
	const float usdToAudMultiplier = 1/audToUsdMultiplier; //$1 = A$1.49
	const float usdToPesMultiplier = 1/pesToUsdMultiplier; //$1 = M$20.00
	
	float requestedGbpToUSD = amountOfForeignCurrency * gbpToUsdMultiplier; //user requested amount of gbp to $
	float requestedCadToUSD = amountOfForeignCurrency * cadToUsdMultiplier; //user requested amount of cad to $ 
	float requestedEurToUSD = amountOfForeignCurrency * eurToUsdMultiplier; //user requested amount of eur to $
	float requestedAudToUSD = amountOfForeignCurrency * audToUsdMultiplier; //user requested amount of aud to $
	float requestedPesToUSD = amountOfForeignCurrency * pesToUsdMultiplier; //user requested amount of pes to $
	//should be the data used for the top row of the table (all dollars)
	
	
	
	
	printf("\n\n\tUSD($)\tGBP(£)\tCAD(C$)\tEUR(€)\tAUD(A$)\tPes(M$)"); //top row headers
	
	printf("\n\nUSD($)\t%.0f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f", 
	amountOfForeignCurrency, requestedGbpToUSD, requestedCadToUSD, requestedEurToUSD, requestedAudToUSD, requestedPesToUSD); 
	//user requested amount of all currencies to USD 
	
	printf("\n\nGBP(£)\t%.2f\t%.0f\t%.2f\t%.2f\t%.2f\t%.2f", 
	amountOfForeignCurrency * usdToGbpMultiplier, amountOfForeignCurrency, requestedCadToUSD * usdToGbpMultiplier, requestedEurToUSD * usdToGbpMultiplier, requestedAudToUSD * usdToGbpMultiplier, requestedPesToUSD * usdToGbpMultiplier); 
	///user requested amount of all currencies to GBP 
	
	printf("\n\nCAD(C$)\t%.2f\t%.2f\t%.0f\t%.2f\t%.2f\t%.2f", 
	amountOfForeignCurrency * usdToCadMultiplier, requestedGbpToUSD * usdToCadMultiplier, amountOfForeignCurrency, requestedEurToUSD * usdToCadMultiplier, requestedAudToUSD * usdToCadMultiplier, requestedPesToUSD * usdToCadMultiplier);
	//user requested amount of all currencies to CAD 
	
	printf("\n\nEUR(€)\t%.2f\t%.2f\t%.2f\t%.0f\t%.2f\t%.2f", 
	amountOfForeignCurrency * usdToEurMultiplier, requestedGbpToUSD * usdToEurMultiplier, requestedCadToUSD * usdToEurMultiplier, amountOfForeignCurrency, requestedAudToUSD * usdToEurMultiplier, requestedPesToUSD * usdToEurMultiplier);
	//user requested amount of all currencies to EUR 
	
	printf("\n\nAUD(A$)\t%.2f\t%.2f\t%.2f\t%.2f\t%.0f\t%.2f",
	amountOfForeignCurrency * usdToAudMultiplier, requestedGbpToUSD * usdToAudMultiplier, requestedCadToUSD * usdToAudMultiplier, requestedEurToUSD * usdToAudMultiplier, amountOfForeignCurrency, requestedPesToUSD * usdToAudMultiplier);
	//user requested amount of all currencies to AUD 
	
	printf("\n\nPes(M$)\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.0f",
	amountOfForeignCurrency * usdToPesMultiplier, requestedGbpToUSD * usdToPesMultiplier, requestedCadToUSD *  usdToPesMultiplier, requestedEurToUSD * usdToPesMultiplier, requestedAudToUSD * usdToPesMultiplier, amountOfForeignCurrency);
	//user requested amount of all currencies to PESOs 
	
	//columns are all diffrent currencies (labeled to the left)
	
	//rows all one currency
	return 0;
}

