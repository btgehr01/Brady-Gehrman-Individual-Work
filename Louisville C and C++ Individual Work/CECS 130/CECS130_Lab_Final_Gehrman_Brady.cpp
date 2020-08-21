/*
Final Lab Project CECS 130
Lab Partners: Brady Gehrman, Hannah Bulbul
Lab Section: 2
Lab Objective:
Ability to work in teams is essential for a successful
career in computer science. Begin this Final Project by finding a partner who has completed
lab#10. You can work with anyone registered for CECS130 from either Tuesday or Thursday lab
section. Your assignment is to create (in the C++ programming language using good OOP
principles (namespaces, etc.)) a Competition class which inherits from yours and your partner’s
3D TTT classes. Assuming both 3DTTT classes have a function which asks computer to make a
move it should be possible with very little rewriting to create a competition between two
computer players. Set it up so the two game bots play 10 games in a row against each other and a
winner is determined and announced at the end of this competition. Give your computer players
names which correspond to the names of the two programmers who created them.
In the header comments to you program please clearly identify the names of the two
programmers comprising your team. Obviously you and your partner will only get one (same)
grade for the lab.




*/



#include<iostream>
#include<string>
#include<sstream>  
#include<ctype.h>
#include<time.h> 
#include<stdlib.h>
#include<string.h>

using namespace std;

char board[3][3] = {'1','2','3','4','5','6','7','8','9'};
char board2[3][3] = {'1','2','3','4','5','6','7','8','9'};
char board3[3][3] = {'1','2','3','4','5','6','7','8','9'};
int numberOfWinsPlayer = 0;
int numberOfWinsComputer = 0;
int count = 0;
char player = 'X';
char computer = 'O';
bool winner = false;
bool playerWins = false;
bool computerWins = false;
///////////one dimensional tictactoe class

class Game{
	public:
		Game() {};
		void printBoard();
		void playersTurn();
		void computersTurn();
		void checkForWins();		
};
/////////////3D tictactoe class inherits class game 
class Tictactoe3d: public Game{
	public:
		void print3DBoard();
		void playersTurn3d();
		void computersTurn3d();
		void displayResult();
		int makeComputerOtherMove(){
		srand(time(NULL));
		int random1 = rand() % 3;
		return random1;
		}
		int makeComputerOtherMove2(){
		int random1 = rand() % 9;
		return random1;
		}
				
};

////////function to print out score and announce winner of 3D TTT
void Tictactoe3d::displayResult(){
	//possible wins : 123,456,789,147,258,369,159,753
	//first board	
	//123
	if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X'){
		numberOfWinsPlayer++;
		}	
	if(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O'){
		numberOfWinsComputer++;
	}
	//456
	if(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X'){
		numberOfWinsPlayer++;
	}		
	if(board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O'){
	 numberOfWinsComputer++;
		}
	//789
	if(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X'){
		numberOfWinsPlayer++;
	}
			
	if(board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O'){
		numberOfWinsComputer++;
	}
	//147
	if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X'){
		numberOfWinsPlayer++;	
	}
	if(board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O'){
		numberOfWinsComputer++;		
	}
	//258
	if(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X'){
		numberOfWinsPlayer++;		
	}
	if(board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'){
		numberOfWinsComputer++;
	}
	//369
	if(board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X'){
	numberOfWinsPlayer++;		
	}
	if(board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O'){
		numberOfWinsComputer++;		
	}
	//159
	if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'){
		numberOfWinsPlayer++;		
	}
	if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'){	
		numberOfWinsComputer++;		
	}
	//753
	if(board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X'){	
		numberOfWinsPlayer++;
		
	}
	if(board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O'){
		numberOfWinsComputer++;		
     }	
//second board
if(board2[0][0] == 'X' && board2[0][1] == 'X' && board2[0][2] == 'X'){
		numberOfWinsPlayer++;			
	}	
	if(board2[0][0] == 'O' && board2[0][1] == 'O' && board2[0][2] == 'O'){
		numberOfWinsComputer++;				
	}
	//456
	if(board2[1][0] == 'X' && board2[1][1] == 'X' && board2[1][2] == 'X'){
		numberOfWinsPlayer++;		
	}	
	if(board2[1][0] == 'O' && board2[1][1] == 'O' && board2[1][2] == 'O'){
	 	numberOfWinsComputer++;	
		}
	//789
	if(board2[2][0] == 'X' && board2[2][1] == 'X' && board2[2][2] == 'X'){
		numberOfWinsPlayer++;		
	}
	
	if(board2[2][0] == 'O' && board2[2][1] == 'O' && board2[2][2] == 'O'){
		numberOfWinsComputer++;		
	}
	//147
	if(board2[0][0] == 'X' && board2[1][0] == 'X' && board2[2][0] == 'X'){
		numberOfWinsPlayer++;
		
	}
	if(board2[0][0] == 'O' && board2[1][0] == 'O' && board2[2][0] == 'O'){
		numberOfWinsComputer++;		
	}
	//258
	if(board2[0][1] == 'X' && board2[1][1] == 'X' && board2[2][1] == 'X'){
		numberOfWinsPlayer++;		
	}
	if(board2[0][1] == 'O' && board2[1][1] == 'O' && board2[2][1] == 'O'){
		numberOfWinsComputer++;
	}
	//369
	if(board2[0][2] == 'X' && board2[1][2] == 'X' && board2[2][2] == 'X'){
		numberOfWinsPlayer++;		
	}
	if(board2[0][2] == 'O' && board2[1][2] == 'O' && board2[2][2] == 'O'){
		numberOfWinsComputer++;		
	}
	//159
	if(board2[0][0] == 'X' && board2[1][1] == 'X' && board2[2][2] == 'X'){
		numberOfWinsPlayer++;		
	}
	if(board2[0][0] == 'O' && board2[1][1] == 'O' && board2[2][2] == 'O'){	
		numberOfWinsComputer++;		
	}
	//753
	if(board2[2][0] == 'X' && board2[1][1] == 'X' && board2[0][2] == 'X'){	
		numberOfWinsPlayer++;		
	}
	if(board2[2][0] == 'O' && board2[1][1] == 'O' && board2[0][2] == 'O'){
		numberOfWinsComputer++;		
}	
//////////////////third board
	if(board3[0][0] == 'X' && board3[0][1] == 'X' && board3[0][2] == 'X'){
		numberOfWinsPlayer++;			
	}	
	if(board3[0][0] == 'O' && board3[0][1] == 'O' && board3[0][2] == 'O'){
		numberOfWinsComputer++;				
	}
	//456
	if(board3[1][0] == 'X' && board3[1][1] == 'X' && board3[1][2] == 'X'){
		numberOfWinsPlayer++;		
	}	
	if(board3[1][0] == 'O' && board3[1][1] == 'O' && board3[1][2] == 'O'){
	 	numberOfWinsComputer++;		
		}
	//789
	if(board3[2][0] == 'X' && board3[2][1] == 'X' && board3[2][2] == 'X'){
		numberOfWinsPlayer++;		
	}
	
	if(board3[2][0] == 'O' && board3[2][1] == 'O' && board3[2][2] == 'O'){
		numberOfWinsComputer++;		
	}
	//147
	if(board3[0][0] == 'X' && board3[1][0] == 'X' && board3[2][0] == 'X'){
		numberOfWinsPlayer++;
		
	}
	if(board3[0][0] == 'O' && board3[1][0] == 'O' && board3[2][0] == 'O'){
		numberOfWinsComputer++;
		
	}
	//258
	if(board3[0][1] == 'X' && board3[1][1] == 'X' && board3[2][1] == 'X'){
		numberOfWinsPlayer++;
		
	}
	if(board3[0][1] == 'O' && board3[1][1] == 'O' && board3[2][1] == 'O'){
		numberOfWinsComputer++;
	}
	//369
	if(board3[0][2] == 'X' && board3[1][2] == 'X' && board3[2][2] == 'X'){
		numberOfWinsPlayer++;
		
	}
	if(board3[0][2] == 'O' && board3[1][2] == 'O' && board3[2][2] == 'O'){
		numberOfWinsComputer++;		
	}
	//159
	if(board3[0][0] == 'X' && board3[1][1] == 'X' && board3[2][2] == 'X'){
		numberOfWinsPlayer++;
		
	}
	if(board3[0][0] == 'O' && board3[1][1] == 'O' && board3[2][2] == 'O'){	
		numberOfWinsComputer++;		
	}
	//753
	if(board3[2][0] == 'X' && board3[1][1] == 'X' && board3[0][2] == 'X'){	
		numberOfWinsPlayer++;		
	}
	if(board3[2][0] == 'O' && board3[1][1] == 'O' && board3[0][2] == 'O'){
		numberOfWinsComputer++;		
}	
		//////checking for wins accross all 3 boards together
		for(int i = 0; i<3;i++)
		{

			for(int j=0; j<3;j++){
			
				if(board[i][j]==board2[i][j] && board2[i][j]==board3[i][j])
				{
				if(board[i][j]=='X')
				numberOfWinsPlayer++;
				
				if(board[i][j]=='O')
				numberOfWinsComputer++;	
				
				}
			}
			}//end for			
//////////announce winner
		cout<<"\n***********GAME OVER**********"<<endl;		
		if(numberOfWinsPlayer>numberOfWinsComputer){

			cout<<"\n**********PLAYER HAS WON**********"<<endl;
		}else 
		if(numberOfWinsComputer>numberOfWinsPlayer)
			cout<<"\n**********COMPUTER HAS WON**********"<<endl;
		else{
			if(numberOfWinsPlayer==numberOfWinsComputer)
			cout<<"\n**********IT'S A TIE!**********"<<endl;
	}

/////////////display scores
cout<<"\n**SCORE**"<<endl;
		cout<<"PLAYER: "<<numberOfWinsPlayer<<endl;
		cout<<"COMPUTER: "<<numberOfWinsComputer<<endl;
	}


////////computers turn in 3D tictactoe
void Tictactoe3d::computersTurn3d(){
	int row,column;
	char boardPosition;
	srand(time(NULL));
	
	int randomNumber;
	bool emptySpot=false;
	//random number will choose which board to play on (1, 2, or 3) if the board the computer chooses is already full loop will reapeat for a different random number
	while(emptySpot==false)
	{
	randomNumber = (rand()%3)+1;
	for(int i=0;i<3;i++)
	{
		for(int j=0; j<3;j++)
		{
			if(randomNumber==1)
			{
				if(!(board[i][j]=='X' || board[i][j]=='O'))
				{
					emptySpot=true;
				}
			}
			else
			if(randomNumber==2)
			{
				if(!(board2[i][j]=='X' || board2[i][j]=='O'))
				{
					emptySpot=true;
				}
			}
			else
			if(randomNumber==3)
			{
				if(!(board3[i][j]=='X' || board3[i][j]=='O'))
				{
					emptySpot=true;
				}
			}
		}
	}
}
	
	if(randomNumber == 1){
		computersTurn();//function from inherited class "Game"
		cout<<" on the 1st board"<<endl;		
	}
		
	if(randomNumber ==2){	
	
	while(true){
			
		int randomNumber2 = (rand() % 9) +1;
			
		row = (randomNumber2 - 1) /3;
		column = (randomNumber2 - 1) %3;
		
		boardPosition = board2[row][column];
		
		if(boardPosition =='X' || boardPosition =='O'){
			continue;
		
		}else{
		
			cout<<"\n\nThe computer has chosen position "<<randomNumber2<<" on the 2nd board"<<endl;
			board2[row][column] = computer;
			count++;
			break;	
			}
		}		
	}	

	if(randomNumber==3){	
	
	while(true){	
		
		int randomNumber3 = (rand() % 9) +1;
		
		row = (randomNumber3 - 1) /3;
		column = (randomNumber3 - 1) %3;
		
		boardPosition = board3[row][column];
		
		if(boardPosition =='X' || boardPosition =='O'){
			continue;
		
		}else{
		
			cout<<"\n\nThe computer has chosen position "<<randomNumber3<<" on the 3rd board"<<endl;
			board3[row][column] = computer;
			count++;
			break;	
	}
}
		
	}
}

////////players turn in 3D tictactoe
void Tictactoe3d::playersTurn3d(){
	
	int a,b;
	bool wrongMove = true;
	int row, column;
	char boardPosition;
	
	do{
	cout<<"\nEnter the board number you want to play on: ";
	cin>>b;	
	if(b<1 || b>3){
		cout<<"\nInvalid choice!"<<endl;
		continue;
	}
	cout<<"Enter the number you want to fill: ";
	cin>>a;
	if(a<1 || a>9){
		cout<<"\nYou must enter a number between 1 and 9!"<<endl;
		continue;
	}
	
	if(b==1){
	
	row = (a-1)/3;
	column = (a-1) %3;
	
	boardPosition = board[row][column];
	if(boardPosition =='X' || boardPosition =='O'){
			cout<<"Invalid move!"<<endl;
	}else{
		
			board[row][column] = player;
			wrongMove = false;
			count++;	
		}
	}
	
	if(b==2){
	row = (a-1)/3;
	column = (a-1) %3;
	
	boardPosition= board2[row][column];
	if(boardPosition =='X' || boardPosition=='O'){
			cout<<"Invalid move!"<<endl;
	}else{
		
			board2[row][column] = player;
			wrongMove = false;
			count++;	
		}		
	  }
	
	if(b==3){
	row = (a-1)/3;
	column = (a-1) %3;
	
	boardPosition = board3[row][column];
	if(boardPosition =='X' || boardPosition =='O'){
			cout<<"Invalid move!"<<endl;
	}else{
		
			board3[row][column] = player;
			wrongMove = false;
			count++;	
		}
	}
	
	
	}while(wrongMove);	
}

//Printing 3d board
void Tictactoe3d::print3DBoard(){
	cout<<"\nBoard 1       Board 2        Board 3"<<endl;
	cout<<""<<endl;
	printBoard();

	int i = 0;
	int j = 0;
	
	for ( i = 0; i < 3; i++ ){
		cout<<"             ";

	for ( j = 0; j < 3; j++ ){

	cout << board2[i][j] << " | ";
}
	cout<<endl;
}
	int k =0;
	int l = 0;
	for ( k = 0; k < 3; k++ ){
		cout<<"                           ";

	for ( l = 0; l < 3; l++ ){

	cout << board3[k][l] << " | ";
}
	cout<<endl;
}
	
}//end
///checking for wins in one dimenesional TTT class game
void Game::checkForWins(){
	//possible wins : 123,456,789,147,258,369,159,753
	
	//123
	if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X'){
		
		playerWins= true;
		winner = true;
		
	}
	
	if(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O'){
		
		computerWins = true;
		winner = true;
		
	}
	//456
	if(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X'){
		
		playerWins= true;
		winner = true;
		
	}	
	if(board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O'){
		
		
		computerWins = true;
		winner = true;
		
		}
	//789
	if(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X'){
		
		playerWins= true;
		winner = true;
		
	}
	
	if(board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O'){
		
		computerWins = true;
		winner = true;
		
	}
	//147
	if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X'){
		
		playerWins= true;
		winner = true;
		
	}
	if(board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O'){
		
		computerWins = true;
		winner = true;
		
	}
	//258
	if(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X'){
		
		playerWins= true;
		winner = true;
		
	}
	if(board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'){
		
		computerWins = true;
		winner = true;
	}
	//369
	if(board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X'){
		
		playerWins= true;
		winner = true;
		
	}
	if(board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O'){
		
		computerWins = true;
		winner = true;
		
	}
	//159
	if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'){
		
		playerWins= true;
		winner = true;
		
	}
	if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'){	
		
		computerWins = true;
		winner = true;
		
	}
	//753
	if(board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X'){	
		
		playerWins= true;
		winner = true;
		
	}
	if(board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O'){
		
		computerWins = true;
		winner = true;
		
}	
if(!playerWins && !computerWins && count == 9){
	winner = true;
cout<<"It's a tie!"<<endl; 
}

if(playerWins && !computerWins)
	cout<<"Player wins! Computer loses!"<<endl;
	
if(computerWins && !playerWins)
 cout<<"Computer wins! Player loses!"<<endl;	

}//end


//printing board for class "Game"(one tictactoe board)
void Game::printBoard(){
	
	int i = 0;
	int j = 0;
	
	for ( i = 0; i < 3; i++ ){

	for ( j = 0; j < 3; j++ ){

	cout << board[i][j] << " | ";
}
	cout<<endl;
}

}//End

// Computer plays(class "Game")

void Game::computersTurn(){
	srand(time(NULL));	
	
	while(true){	
		
		int randomNumber = (rand() % 9) +1;
		
		int row = (randomNumber - 1) /3;
		int column = (randomNumber - 1) %3;
		
		char boardPosition = board[row][column];
		
		if(boardPosition == 'X' || boardPosition =='O'){
			continue;
		
		}else{
		
			cout<<"\nThe computer has chosen position "<< randomNumber;
			board[row][column] = computer;
			count++;
			break;	
	}
}
}//end

//Player plays (class "Game")
void Game::playersTurn(){
	int a;
	bool wrongMove = true;
	do{
	
	cout<<"Enter the number you want to fill: ";
	cin>>a;	
	
	int row = (a-1)/3;
	int column = (a-1) %3;
	
	char boardPosition = board[row][column];
	if(boardPosition =='X' || boardPosition =='O'){
			cout<<"Invalid move!"<<endl;
	}else{
		
			board[row][column] = player;
			wrongMove = false;
			count++;	
		}
	}while(wrongMove);
}




//end of namespace 

class Player{
	private:
		string playerSymbol;
	public:
		string getPlayerSymbol();
		string getPlayerSymbolToCompare();
		void setPlayerSymbol(string);
		//constructor
		Player(string requestedSymbol){
			playerSymbol = requestedSymbol;
		}
};

string Player:: getPlayerSymbol(){
	return playerSymbol;
}
string Player:: getPlayerSymbolToCompare(){
	return playerSymbol + " ";
}
void Player:: setPlayerSymbol(string playerSymbol){
	playerSymbol = playerSymbol;
}

class TicTacToe{
	
	private:
		//members
		int numOfTurns;
		string input[9];
		//methods
	public:
		void resetGame();
		void showBoard();
		int makeComputerMove(string, string);
		bool checkLegal(int, string, string);
		string checkWinnerOrEnd();
		int getNumOfTurns(){
			return numOfTurns;
		}
		void incrementNumOfTurns(){
			numOfTurns = numOfTurns + 1;
		}
		//constructor
		TicTacToe(){
			numOfTurns = 0;
		}
		
};

void TicTacToe::resetGame(){
	numOfTurns = 0;
	int i;
	for(i = 0; i < 9; i++){
		input[i] = i + '1';
	}
}

void TicTacToe::showBoard(){
	using std::cout;
	cout<<"-------"<<endl;
	cout<<"|"<<input[0]<<"|"<<input[1]<<"|"<<input[2]<< "|"<<endl;
	cout<<"-------"<<endl;
	cout<<"|"<<input[3]<<"|"<<input[4]<<"|"<<input[5]<<"|"<<endl;
	cout<<"-------"<<endl;
	cout<<"|"<<input[6]<<"|"<<input[7]<<"|"<<input[8]<<"|"<<endl;
	cout<<"-------"<<endl;
	
}
int TicTacToe:: makeComputerMove(string userSymbol, string computerSymbol){
	int computerMove;
	bool sucessfulComputerMove = false;
	do{
	srand(time(NULL));
	computerMove = rand() % 9;
	if(input[computerMove] == userSymbol || input[computerMove] == computerSymbol){
		sucessfulComputerMove = false;
	}else{
		sucessfulComputerMove = true;
	}
	} while(sucessfulComputerMove != true);
	//make computer move
	input[computerMove] = computerSymbol;
	//update game numOfMoves
	numOfTurns++;
	return computerMove;
}

bool TicTacToe::checkLegal(int userWantedMoveSpot, string userSymbol, string computerSymbol){
	if(input[userWantedMoveSpot-1] == userSymbol || input[userWantedMoveSpot-1] == computerSymbol || userWantedMoveSpot > 9){
		return false;
	}else{
	//make move
	input[userWantedMoveSpot - 1] = userSymbol;
	//update game numOfMoves
	numOfTurns++;
	return true;
	}
}

string TicTacToe::checkWinnerOrEnd(){
	int i;
	//check vertical winner
	for(i = 0; i < 3; i++){
	if(input[i] == input[i+3] && input[i] == input[i+6]){
		return input[i]; //return winner's symbol
		}
	}
	//check for horizontal winner
	for(i = 0; i < 9; i = i+3){
		if(input[i] == input[i+1] && input[i] == input[i+2]){
		return input[i]; //return winner's symbol
		}
	}
	//check for diagonal winnder
	if(input[0] == input[4] && input[0] == input[8]){
		return input[0]; //return winner's symbol
	}
	//check for other diagonal winner
	if(input[2] == input[4] && input[2] == input[6]){
		return input[2]; //return winner's symbol
	}
	//check for end of game
	if(numOfTurns == 9){
		return "d";  //return draw
	}
	//return n, we don't have a winner or a draw yet
	return "n";
}

class ThreeDTicTacToe : public TicTacToe{
	private:
		int player1Wins;
		int computerWins;
		string inputs[3][9];
	public:
		ThreeDTicTacToe(){
			player1Wins = 0;
			computerWins = 0;
		}
		int getPlayerWins(){
			return player1Wins;
		}
		void setPlayerAndComputerWinsToZero(){
			player1Wins = 0;
			computerWins = 0;
		}
		int getComputerWins(){
			return computerWins;
		}
		void resetGame(){
		int i;
		int j;
		for(i = 0; i < 3; i++){
			for(j = 0; j < 9; j++){
				int value = (9*i) + (j+1);
				stringstream ss;
				ss << value;
				string strToInt = ss.str();
				if(i == 0){
					strToInt = strToInt + " ";
				}
				inputs[i][j] = strToInt;
				}
			}
		}
		//redefining how it works for this class seperatle
		//TicTacToe :: resetGame()
	
		void showBoard(){
		using std::cout;
		cout<<"----------"<<endl;
		cout<<"|"<<inputs[0][0]<<"|"<<inputs[0][1]<<"|"<<inputs[0][2]<<"|"<<endl;
		cout<<"----------"<<endl;
		cout<<"|"<<inputs[0][3]<<"|"<<inputs[0][4]<<"|"<<inputs[0][5]<<"|"<<endl;
		cout<<"----------"<<endl;
		cout<<"|"<<inputs[0][6]<<"|"<<inputs[0][7]<<"|"<<inputs[0][8]<<"|"<<endl;
		cout<<"----------"<<endl;
	
		cout<<"\t----------"<<endl;
		cout<<"\t|"<<inputs[1][0]<<"|"<<inputs[1][1]<<"|"<<inputs[1][2]<< "|"<<endl;
		cout<<"\t----------"<<endl;
		cout<<"\t|"<<inputs[1][3]<<"|"<<inputs[1][4]<<"|"<<inputs[1][5]<<"|"<<endl;
		cout<<"\t----------"<<endl;
		cout<<"\t|"<<inputs[1][6]<<"|"<<inputs[1][7]<<"|"<<inputs[1][8]<<"|"<<endl;
		cout<<"\t----------"<<endl;
	
		cout<<"\t\t  ----------"<<endl;
		cout<<"\t\t  |"<<inputs[2][0]<<"|"<<inputs[2][1]<<"|"<<inputs[2][2]<< "|"<<endl;
		cout<<"\t\t  ----------"<<endl;
		cout<<"\t\t  |"<<inputs[2][3]<<"|"<<inputs[2][4]<<"|"<<inputs[2][5]<<"|"<<endl;
		cout<<"\t\t  ----------"<<endl;
		cout<<"\t\t  |"<<inputs[2][6]<<"|"<<inputs[2][7]<<"|"<<inputs[2][8]<<"|"<<endl;
		cout<<"\t\t  ----------"<<endl;
		
		cout<<"Brady Wins:"<<player1Wins<<endl;
		cout<<"Hannah Wins:"<<computerWins<<endl;
		cout<<"Turns:"<<TicTacToe :: getNumOfTurns()<<endl;
	
		}
		
int makeComputerMove(string computerSymbol, string computer2Symbol){
	int computerRandom;
	int computerMoveOne;
	int computerMoveTwo;
	bool sucessfulComputerMove = false;
	do{
	srand(time(NULL));
	computerRandom = (rand() % 27) + 1;
	if(float(computerRandom)/9 <= 1){
		computerMoveOne = 0;
		computerMoveTwo = computerRandom - 1; // should be the same
	}else if(float(computerRandom)/9 > 1 && float(computerRandom)/9 <=2){
		computerMoveOne = 1;
		computerMoveTwo = computerRandom - 10; //subtract by 10 to get the array slot
	}else if(float(computerRandom)/9 > 2 && float(computerRandom)/9 <= 3){
		computerMoveOne = 2;
		computerMoveTwo = computerRandom - 19;
	}else{
		return false; //random number is not in the range
	}
	if(inputs[computerMoveOne][computerMoveTwo].compare(computer2Symbol) == 0 || inputs[computerMoveOne][computerMoveTwo].compare(computerSymbol) == 0){
		sucessfulComputerMove = false;
	}else{
		sucessfulComputerMove = true;
	}
	} while(sucessfulComputerMove != true);
	inputs[computerMoveOne][computerMoveTwo] = " O";
	//update game numOfMoves
	TicTacToe :: incrementNumOfTurns();
	int actualComputerMove = ((computerMoveOne + 1) * 9) - (9 - (computerMoveTwo+ 1));
	return actualComputerMove;
}

bool checkLegal(int userWantedMove, string userSymbol, string computerSymbol){
	int userWantedBoard;
	int userWantedSpot;
	if(float(userWantedMove)/9 <= 1){
		userWantedBoard = 0;
		userWantedSpot = userWantedMove - 1; // should be the same
	}else if(float(userWantedMove)/9 > 1 && float(userWantedMove)/9 <=2){
		userWantedBoard = 1;
		userWantedSpot = userWantedMove - 10; //subtract by 10 to get the array slot
	}else if(float(userWantedMove)/9 > 2 && float(userWantedMove)/9 <= 3){
		userWantedBoard = 2;
		userWantedSpot = userWantedMove - 19;
	}else{
		return false; //number entered is not in the range
	}
	if(inputs[userWantedBoard][userWantedSpot].compare(userSymbol) == 0 || inputs[userWantedBoard][userWantedSpot].compare(computerSymbol) == 0){
		return false;
	}else{
	//make move
	inputs[userWantedBoard][userWantedSpot] = userSymbol;
	//update game numOfMoves
	TicTacToe :: incrementNumOfTurns();
	return true;
	}
}

bool checkWinnerOrEnd(string playerSymbol, string computerSymbol){
int j;
int i;
setPlayerAndComputerWinsToZero();
	//check vertical winner
for(j = 0; j < 3; j++){
	for(i = 0; i < 3; i++){
		if(inputs[j][i] == inputs[j][i+3] && inputs[j][i] == inputs[j][i+6]){
			if(inputs[j][i].compare(playerSymbol) == 0){
				player1Wins = player1Wins + 1;
			}else{
				computerWins = computerWins + 1;
			}
		}
	}
}

	//check for horizontal winner
for(j = 0; j < 3; j++){
	for(i = 0; i < 9; i = i+3){
		if(inputs[j][i].compare(inputs[j][i+1]) == 0 && inputs[j][i].compare(inputs[j][i+2]) == 0){
			if(inputs[j][i].compare(playerSymbol) == 0){
				player1Wins = player1Wins + 1;
			}else{
				computerWins = computerWins + 1;
			}//return winner's symbol
		}
	}
}
	//check for diagonal winnder
for(j = 0; j < 3; j++){
	if(inputs[j][0].compare(inputs[j][4]) == 0 && inputs[j][0].compare(inputs[j][8]) == 0){
			if(inputs[j][0].compare(playerSymbol) == 0){
			player1Wins = player1Wins + 1;
		}else{
			computerWins = computerWins + 1;
		} //return winner's symbol
	}
}
	//check for other diagonal winner
for(j = 0; j < 3; j++){
	if(inputs[j][2].compare(inputs[j][4]) == 0 && inputs[j][2].compare(inputs[j][6]) == 0){
		if(inputs[j][2].compare(playerSymbol) == 0){
			player1Wins = player1Wins + 1;
		}else{
			computerWins = computerWins + 1;
		} //return winner's symbol
	}
}
//check vertical board wins
	j = 0;
	for(i = 0; i < 9; i++){
		if(inputs[j][i].compare(inputs[j+1][i]) == 0 && inputs[j][i].compare(inputs[j+2][i]) == 0){
			if(inputs[j][i].compare(playerSymbol) == 0){
				player1Wins = player1Wins + 1;
			}else{
				computerWins = computerWins + 1;
			}
		}
	}

	//check for end of game
int numOfTurns = TicTacToe :: getNumOfTurns();
if(numOfTurns % 27 == 0){
	return true;  //return true, game is over
}
	//return false, continue game
return false;	

}

		
string getWinner(string playerSymbol, string computerSymbol){
	if(player1Wins > computerWins){
		return playerSymbol;
}else if (computerWins > player1Wins){
	return computerSymbol;
}else{
	return "d";
	}
}
bool makeMoveOnMyBoard(int spot1, int spot2){
	if(inputs[spot1][spot2].compare(" O") == 0 || inputs[spot1][spot2].compare(" X") == 0){
		return false;
	}else{
		inputs[spot1][spot2] = " X";
		TicTacToe :: incrementNumOfTurns();
		return true;
	}
}

};

class Competition : public ThreeDTicTacToe, public Tictactoe3d{
	private:
		int computer1Wins;
		int computer2Wins;
	public:
		void increaseComputer1Wins(){
			computer1Wins = computer1Wins + 1;
		}
		void increaseComputer2Wins(){
			computer2Wins = computer2Wins + 1;
		}
		void showWhoWon(){
			if(computer1Wins > computer2Wins){
				cout<<"----Brady won the whole game----"<<endl;
			}else if(computer2Wins > computer1Wins){
				cout<<"----Hannah won the whole game----"<<endl;
			}else{
				cout<<"----Overall draw----";
			}
			cout<<"Brady: "<<computer1Wins<<" "<<"Hannah: "<<computer2Wins;
		}
	int computersTurn3dOtherCode(){
		bool worked = false;
		do{
		int random1 = Tictactoe3d :: makeComputerOtherMove();
		int random2 = Tictactoe3d :: makeComputerOtherMove2();
		worked = ThreeDTicTacToe :: makeMoveOnMyBoard(random1, random2);
		}while(worked == false);
	}
		
	Competition(){
		computer1Wins = 0;
		computer2Wins = 0;
	}
}; 



//function prototypes before main:
//bool makeUserMove(*ThreeDTicTacToe, Player, Player);
//bool makeComputerMove(*ThreeDTicTacToe, Player, Player);
//bool checkEndGame(*ThreeDTicTacToe, Player, Player);

bool makeComputerMove(Competition &competition, Player computer, Player computer2);
bool makeComputer2Move(Competition &competition, Player computer, Player computer2);
bool checkEndGame(Competition &competition, Player user, Player computer);



int main(){
	//setup Players
	bool endGame = false;
	Player computer(" O");
	Player computerTwo(" X");
	//initialize game
	Competition competition;
	int count = 1;
	//reset game, set arrays
	while(count <= 10){
	
	competition.resetGame();
	//start game
	srand (time(NULL));
	int firstMove = rand() % 2 + 1;
	//if random grants 1, Brady goes first
	if(firstMove == 1){
		endGame = makeComputerMove(competition, computer, computerTwo);
	}
	do{
		endGame = makeComputer2Move(competition, computer, computerTwo);
		if(endGame == false){
			endGame = makeComputerMove(competition, computer, computerTwo);
		}
	}while(endGame == false);
	count = count + 1;
}
	competition.showWhoWon();
	
	
	return 0;
}

bool makeComputerMove(Competition &competition, Player computer, Player computer2){
	int computerMove = competition.makeComputerMove(computer.getPlayerSymbol(), computer2.getPlayerSymbol());
	return checkEndGame(competition, computer, computer2);
}
bool makeComputer2Move(Competition &competition, Player computer, Player computer2){
	competition.computersTurn3dOtherCode();
	return checkEndGame(competition, computer, computer2);
}
bool checkEndGame(Competition &competition, Player computer, Player computer2){
	bool endOfTurnOption = competition.checkWinnerOrEnd(computer.getPlayerSymbol(), computer2.getPlayerSymbol());
	if(endOfTurnOption == true){
		string winString = competition.getWinner(computer.getPlayerSymbol(), computer2.getPlayerSymbol());
		if(winString.compare(computer.getPlayerSymbol()) == 0){
			competition.showBoard();
			competition.increaseComputer1Wins();
			cout<<"--Brady won that game!--"<<endl;
			return true;
		}else if(winString.compare(computer2.getPlayerSymbol()) == 0){
			competition.showBoard();
			competition.increaseComputer2Wins();
			cout<<"--Hannah won that game!--"<<endl;
			return true;
		}else{
			competition.showBoard();
			cout<<"--They drew that game!--"<<endl;
			return true;
		}
	}else{
		competition.showBoard();
		return false;
	}
}




