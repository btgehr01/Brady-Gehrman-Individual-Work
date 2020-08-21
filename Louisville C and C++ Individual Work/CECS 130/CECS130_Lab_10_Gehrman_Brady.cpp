#include<iostream>
#include<string>
#include<sstream>  
#include<ctype.h>
#include<time.h> 
#include<stdlib.h>
#include<string.h>
#include<stdio.h>

using namespace std;

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
		
		cout<<"Player Wins:"<<player1Wins<<endl;
		cout<<"Computer Wins:"<<computerWins<<endl;
		cout<<"Turns:"<<TicTacToe :: getNumOfTurns()<<endl;
	
		}
		
int makeComputerMove(string userSymbol, string computerSymbol){
	int computerMoveOne;
	int computerMoveTwo;
	bool sucessfulComputerMove = false;
	do{
	srand(time(NULL));
	computerMoveOne = rand() % 3;
	srand(time(NULL));
	computerMoveTwo = rand() % 9;
	if(inputs[computerMoveOne][computerMoveTwo].compare(userSymbol) == 0 || inputs[computerMoveOne][computerMoveTwo].compare(computerSymbol) == 0){
		sucessfulComputerMove = false;
	}else{
		sucessfulComputerMove = true;
	}
	} while(sucessfulComputerMove != true);
	//make computer move
	inputs[computerMoveOne][computerMoveTwo] = computerSymbol;
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
if(numOfTurns == 27){
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

};



//function prototypes before main:
//bool makeUserMove(*ThreeDTicTacToe, Player, Player);
//bool makeComputerMove(*ThreeDTicTacToe, Player, Player);
//bool checkEndGame(*ThreeDTicTacToe, Player, Player);

bool makeUserMove(ThreeDTicTacToe &threeDTicTacToe, Player user, Player computer);
bool makeComputerMove(ThreeDTicTacToe &threeDTicTacToe, Player user, Player computer);
bool checkEndGame(ThreeDTicTacToe &threeDTicTacToe, Player user, Player computer);



int main(){
	//setup Players
	bool endGame;
	Player user("O ");
	Player computer("X ");
	//initialize game
	ThreeDTicTacToe threeDTicTacToe;
	//reset game, set arrays
	threeDTicTacToe.resetGame();
	//start game
	srand (time(NULL));
	int firstMove = rand() % 2 + 1;
	//if random grants 1, computer just goes first
	if(firstMove == 1){
		cout<<"Computer has won the coin toss and makes the first move!"<<endl;
		endGame = makeComputerMove(threeDTicTacToe, user, computer);
	}else{
		cout<<"You have won the coin toss!"<<endl;
	}
	do{
		endGame = makeUserMove(threeDTicTacToe, user, computer);
		if(endGame == false){
			endGame = makeComputerMove(threeDTicTacToe,user, computer);
		}
	}while(endGame == false);
	
	
	
	
	return 0;
}

bool makeUserMove(ThreeDTicTacToe &threeDTicTacToe, Player user, Player computer){
	//initialize variable
	int userMove;
	string endOfTurnOption;
	
	threeDTicTacToe.showBoard();
	cout<<"Enter the number corresponding to the move you would like to make"<<endl;
	cin>>userMove;
	bool legal = threeDTicTacToe.checkLegal(userMove, user.getPlayerSymbol(), computer.getPlayerSymbol());
	
	//if first suggested move wasn't legal go into the while loop
	while(legal == false){
	threeDTicTacToe.showBoard();
	cout<<"***ILLEGAL MOVE, cell is already occupied!***"<<endl;
	cout<<"Please enter the number corresponding to the valid move you would like to make"<<endl;
	cin>>userMove;
	legal = threeDTicTacToe.checkLegal(userMove, user.getPlayerSymbol(), computer.getPlayerSymbol());
	}
	threeDTicTacToe.showBoard(); //show user board after their move
	cout<<"Here is what the board looks like now, type c and press enter to continue!"<<endl; 
	string random;
	cin>>random;
	return checkEndGame(threeDTicTacToe, user, computer);
		
}
bool makeComputerMove(ThreeDTicTacToe &threeDTicTacToe, Player user, Player computer){
	int computerMove = threeDTicTacToe.makeComputerMove(user.getPlayerSymbol(), computer.getPlayerSymbol());
	cout<<"The computer chooses to fill in spot "<<computerMove<<endl; 
	return checkEndGame(threeDTicTacToe, user, computer);
}
bool checkEndGame(ThreeDTicTacToe &threeDTicTacToe, Player user, Player computer){
	bool endOfTurnOption = threeDTicTacToe.checkWinnerOrEnd(user.getPlayerSymbol(), computer.getPlayerSymbol());
	if(endOfTurnOption == true){
		string winString = threeDTicTacToe.getWinner(user.getPlayerSymbol(), computer.getPlayerSymbol());
		if(winString.compare(user.getPlayerSymbol()) == 0){
			threeDTicTacToe.showBoard();
			cout<<"You won the game! (:"<<endl;
			return true;
		}else if(winString.compare(computer.getPlayerSymbol()) == 0){
			threeDTicTacToe.showBoard();
			cout<<"The computer won the game!"<<endl;
			return true;
		}else{
			threeDTicTacToe.showBoard();
			cout<<"The game ended in a draw!"<<endl;
			return true;
		}
	}else{
		return false;
	}
}














