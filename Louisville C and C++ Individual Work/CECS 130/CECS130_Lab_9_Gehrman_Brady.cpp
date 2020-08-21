#include <iostream>
#include<string>
#include <ctype.h>
#include <time.h> 
#include <stdlib.h>

using namespace std;

class Player{
	private:
		char playerSymbol;
	public:
		char getPlayerSymbol();
		void setPlayerSymbol(char);
		//constructor
		Player(char requestedSymbol){
			playerSymbol = requestedSymbol;
		}
};

char Player:: getPlayerSymbol(){
	return playerSymbol;
}
void Player:: setPlayerSymbol(char playerSymbol){
	playerSymbol = playerSymbol;
}

class TicTacToe{
	
	private:
		//members
		int numOfTurns;
		char inputs[9];
		//methods
	public:
		void resetGame();
		void showBoard();
		int makeComputerMove(char, char);
		bool checkLegal(int, char, char);
		char checkWinnerOrEnd();
		
		
};

void TicTacToe::resetGame(){
	numOfTurns = 0;
	int i;
	for(i = 0; i < 9; i++){
		inputs[i] = i + '1';
	}
}

void TicTacToe::showBoard(){
	using std::cout;
	cout<<"-------"<<endl;
	cout<<"|"<<inputs[0]<<"|"<<inputs[1]<<"|"<<inputs[2]<< "|"<<endl;
	cout<<"-------"<<endl;
	cout<<"|"<<inputs[3]<<"|"<<inputs[4]<<"|"<<inputs[5]<<"|"<<endl;
	cout<<"-------"<<endl;
	cout<<"|"<<inputs[6]<<"|"<<inputs[7]<<"|"<<inputs[8]<<"|"<<endl;
	cout<<"-------"<<endl;
	
}
int TicTacToe:: makeComputerMove(char userSymbol, char computerSymbol){
	int computerMove;
	bool sucessfulComputerMove = false;
	do{
	srand(time(NULL));
	computerMove = rand() % 9;
	if(inputs[computerMove] == userSymbol || inputs[computerMove] == computerSymbol){
		sucessfulComputerMove = false;
	}else{
		sucessfulComputerMove = true;
	}
	} while(sucessfulComputerMove != true);
	//make computer move
	inputs[computerMove] = computerSymbol;
	//update game numOfMoves
	numOfTurns++;
	return computerMove;
}

bool TicTacToe::checkLegal(int userWantedMoveSpot, char userSymbol, char computerSymbol){
	if(inputs[userWantedMoveSpot-1] == userSymbol || inputs[userWantedMoveSpot-1] == computerSymbol || userWantedMoveSpot > 9){
		return false;
	}else{
	//make move
	inputs[userWantedMoveSpot - 1] = userSymbol;
	//update game numOfMoves
	numOfTurns++;
	return true;
	}
}

char TicTacToe::checkWinnerOrEnd(){
	int i;
	//check vertical winner
	for(i = 0; i < 3; i++){
	if(inputs[i] == inputs[i+3] && inputs[i] == inputs[i+6]){
		return inputs[i]; //return winner's symbol
		}
	}
	//check for horizontal winner
	for(i = 0; i < 9; i = i+3){
		if(inputs[i] == inputs[i+1] && inputs[i] == inputs[i+2]){
		return inputs[i]; //return winner's symbol
		}
	}
	//check for diagonal winnder
	if(inputs[0] == inputs[4] && inputs[0] == inputs[8]){
		return inputs[0]; //return winner's symbol
	}
	//check for other diagonal winner
	if(inputs[2] == inputs[4] && inputs[2] == inputs[6]){
		return inputs[2]; //return winner's symbol
	}
	//check for end of game
	if(numOfTurns == 9){
		return 'd';  //return draw
	}
	//return n, we don't have a winner or a draw yet
	return 'n';
}

//function prototypes
bool makeUserMove(TicTacToe &ticTacToe, Player user, Player computer);
bool makeComputerMove(TicTacToe &ticTacToe, Player user, Player computer);
bool checkEndGame(TicTacToe &ticTacToe, Player user, Player computer);


int main(){
	bool endGame = false;
	//initialize players
	Player user('O');
	Player computer('X');
	//initialize game
	TicTacToe ticTacToe;
	//reset game
	ticTacToe.resetGame();
	//seed the random
	srand (time(NULL));
	int firstMove = rand() % 2 + 1;
	//if random grants 1, computer just goes first
	if(firstMove == 1){
		cout<<"Computer has won the coin toss and makes the first move!"<<endl;
		makeComputerMove(ticTacToe,user.getPlayerSymbol(), computer.getPlayerSymbol());
	}else{
		cout<<"You have won the coin toss!"<<endl;
	}
	do{
		endGame = makeUserMove(ticTacToe, user.getPlayerSymbol(), computer.getPlayerSymbol());
		if(endGame != true){
			endGame = makeComputerMove(ticTacToe,user.getPlayerSymbol(), computer.getPlayerSymbol());
		}
	}while(endGame == false);
	return 0;
}

bool makeUserMove(TicTacToe &ticTacToe, Player user, Player computer){
	//initialize variable
	int userMove;
	char endOfTurnOption;
	
	ticTacToe.showBoard();
	cout<<"Enter the number corresponding to the move you would like to make"<<endl;
	cin>>userMove;
	bool legal = ticTacToe.checkLegal(userMove, user.getPlayerSymbol(), computer.getPlayerSymbol());
	
	//if first suggested move wasn't legal go into the while loop
	while(legal == false){
	ticTacToe.showBoard();
	cout<<"***ILLEGAL MOVE, cell is already occupied!***"<<endl;
	cout<<"Please enter the number corresponding to the valid move you would like to make"<<endl;
	cin>>userMove;
	legal = ticTacToe.checkLegal(userMove, user.getPlayerSymbol(), computer.getPlayerSymbol());
	}
	
	ticTacToe.showBoard(); //show user board after their move
	cout<<"Here is what the board looks like now, type c and press enter to continue!"<<endl; 
	string random;
	cin>>random;
	return checkEndGame(ticTacToe, user, computer);
		
}
bool makeComputerMove(TicTacToe &ticTacToe, Player user, Player computer){
	int computerMove = ticTacToe.makeComputerMove(user.getPlayerSymbol(), computer.getPlayerSymbol());
	cout<<"The computer chooses to fill in spot "<<computerMove + 1<<endl; 
	return checkEndGame(ticTacToe, user, computer);
}
bool checkEndGame(TicTacToe &ticTacToe, Player user, Player computer){
	char endOfTurnOption = ticTacToe.checkWinnerOrEnd();
	if(endOfTurnOption == user.getPlayerSymbol()){
		ticTacToe.showBoard();
		cout<<"You won the game! (:"<<endl;
		return true;
	}else if(endOfTurnOption == computer.getPlayerSymbol()){
		ticTacToe.showBoard();
		cout<<"The computer won the game"<<endl;
		return true;
	}else if(endOfTurnOption == 'd'){
		ticTacToe.showBoard();
		cout<<"The game ended in a draw!"<<endl;
		return true;
	}else{
		return false;
	}
}














