package hw6_2;
/**
 * A Program to Create a Player class & implement the PlayerInterface.
 	Implement a Human vs Computer Game

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
import java.util.Random;

//A public class which implements the Connect4FieldInterface
public class Connect4FieldModel3 implements Connect4FieldModelInterface3{
	// Initialization of variables for the board
	static int MAX_ROW=5;
	static int MAX_COLUMN=10;
	static char connect_board[][]=new char[MAX_ROW][MAX_COLUMN];

	// Default constructor to generate the required board
	Connect4FieldModel3()
	{
		int index1,index2;
		for(index1=0;index1<MAX_ROW;index1++)
		{
			for(index2=0;index2<MAX_COLUMN;index2++)
			{
				connect_board[index1][index2]=' ';
			}
			for(index2=index1;index2<MAX_COLUMN-index1;index2++)
			{
				connect_board[index1][index2]='O';
			}
		}
	}

	// An Overridden method to check whether a piece can be dropped or not 
	@Override
	public boolean checkIfPiecedCanBeDroppedIn(int column) {
		int index=0;
		if (column<0 || column>=MAX_COLUMN)
		{ 
			return false;
		}
		while(index<MAX_ROW && connect_board[index][column]=='O'  )
		{
			index++;
		}
		if(index==0)
		{
			return false;
		}
		else
			return true;
	}

	// An Overridden method to display the object in an understandable form
	@Override
	public String toString() {
		int index1,index2;
		System.out.println("-----------------------------------------");
		for(index1=0;index1<MAX_COLUMN;index1++)
			System.out.print(index1);
		System.out.println();
		for(index1=0;index1<MAX_ROW;index1++)
		{
			for(index2=0;index2<MAX_COLUMN;index2++)
			{
				System.out.print(connect_board[index1][index2]);
			}
			System.out.println();
		}
		return "---------------GAME BOARD----------------";
	}

	// An Overridden method to drop a particular piece in a particular column
	@Override
	public void dropPieces(int column, char gamePiece) {
		int index;
		if(checkIfPiecedCanBeDroppedIn(column))
		{
			for(index=0;index<MAX_ROW && connect_board[index][column]=='O';
					index++);
			System.out.println("\nDropped '"+gamePiece+"' into "+column+":\n");
			connect_board[index-1][column]=gamePiece;
		}

	}

	// An Overridden method to check whether the last move win or not
	@Override
	public boolean didLastMoveWin() {
		int index1,index2;
		int count;
		int row_traverse,column_traverse;
		for(index1=0;index1<MAX_ROW;index1++)
		{
			for(index2=0;index2<MAX_COLUMN;index2++)
			{
				if(connect_board[index1][index2]=='+' || 
						connect_board[index1][index2]=='*' )
				{
					//----------------'\'diagonal check---------------------
					count=0;
					row_traverse=index1-1;
					column_traverse=index2-1;
					while(count<3 && row_traverse<MAX_ROW && 
							column_traverse<MAX_COLUMN && 
							row_traverse>=0 && column_traverse>=0)
					{
						if(connect_board[index1][index2]==
								connect_board[row_traverse][column_traverse])
						{
							count++;
							row_traverse--;
							column_traverse--;
						}
						else
							break;
					}

					row_traverse=index1+1;
					column_traverse=index2+1;
					while(count<3 && row_traverse<MAX_ROW && 
							column_traverse<MAX_COLUMN && 
							row_traverse>=0 && column_traverse>=0)
					{
						if(connect_board[index1][index2]==
								connect_board[row_traverse][column_traverse])
						{
							count++;
							row_traverse++;
							column_traverse++;
						}
						else
							break;
					}


					//if Last Move wins
					if(count==3)
					{
						return true;
					}



					//----------------'/'diagonal check---------------------
					count=0;
					row_traverse=index1+1;
					column_traverse=index2-1;
					while(count<3 && row_traverse<MAX_ROW && 
							column_traverse<MAX_COLUMN && 
							row_traverse>=0 && column_traverse>=0)
					{
						if(connect_board[index1][index2]==
								connect_board[row_traverse][column_traverse])
						{
							count++;
							row_traverse++;
							column_traverse--;
						}
						else
							break;
					}

					row_traverse=index1-1;
					column_traverse=index2+1;
					while(count<3 && row_traverse<MAX_ROW && 
							column_traverse<MAX_COLUMN && 
							row_traverse>=0 && column_traverse>=0)
					{
						if(connect_board[index1][index2]==
								connect_board[row_traverse][column_traverse])
						{
							count++;
							row_traverse--;
							column_traverse++;
						}
						else
							break;
					}


					//if Last Move wins
					if(count==3)
					{
						return true;
					}


					//--------------------'|'upward check---------------------
					count=0;
					row_traverse=index1-1;
					column_traverse=index2;
					while(count<3 && row_traverse<MAX_ROW && 
							column_traverse<MAX_COLUMN && 
							row_traverse>=0 && column_traverse>=0)
					{
						if(connect_board[index1][index2]==
								connect_board[row_traverse][column_traverse])
						{
							count++;
							row_traverse--;
						}
						else
							break;
					}

					row_traverse=index1+1;
					column_traverse=index2;
					while(count<3 && row_traverse<MAX_ROW && 
							column_traverse<MAX_COLUMN && 
							row_traverse>=0 && column_traverse>=0)
					{
						if(connect_board[index1][index2]==
								connect_board[row_traverse][column_traverse])
						{
							count++;
							row_traverse++;
						}
						else
							break;
					}


					//if Last Move wins
					if(count==3)
					{
						return true;
					}

					//----------------'<-->' sideways check--------------------
					count=0;
					row_traverse=index1;
					column_traverse=index2-1;
					while(count<3 && row_traverse<MAX_ROW && 
							column_traverse<MAX_COLUMN && 
							row_traverse>=0 && column_traverse>=0)
					{
						if(connect_board[index1][index2]==
								connect_board[row_traverse][column_traverse])
						{
							count++;
							column_traverse--;
						}
						else
							break;
					}

					row_traverse=index1;
					column_traverse=index2+1;
					while(count<3 && row_traverse<MAX_ROW && 
							column_traverse<MAX_COLUMN && 
							row_traverse>=0 && column_traverse>=0)
					{
						if(connect_board[index1][index2]==
								connect_board[row_traverse][column_traverse])
						{
							count++;
							column_traverse++;
						}
						else
							break;
					}

					//if Last Move wins
					if(count==3)
					{
						return true;
					}
				}
			}
		}
		//System.out.println("No one wins yet!");
		return false;
	}

	// An Overridden method to check whether it's a Draw or not
	@Override
	public boolean isItaDraw() {
		int index1,index2;

		if(!didLastMoveWin())
		{
			for(index1=0;index1<MAX_ROW;index1++)
			{
				for(index2=0;index2<MAX_COLUMN;index2++)
				{
					if(connect_board[index1][index2]=='O')
						return false;
				}
			}
		}
		return true;
	}

	// An Overloaded method to initialize player properties
	public void init(Connect4FieldView3 playerA, Connect4FieldView3 playerB) {
		String name_A,name_B;
		char piece_A,piece_B;

		name_A=playerA.getName();
		piece_A=playerA.getGamePiece();


		name_B=playerB.getName();
		piece_B=playerB.getGamePiece();

		System.out.println("Players Initialized!");
		System.out.println("\nPlayer1: "+name_A);
		System.out.println("Piece: "+piece_A);
		System.out.println("\nPlayer2: "+name_B);
		System.out.println("Piece: "+piece_B);
		this.playTheGame();


	}

	int computerMove()
	{
		int index1,index2,traverse;
		int column;
		Random random_no=new Random();

		// Manipulating Computer winning chances
		for(index1=0;index1<MAX_ROW;index1++)
		{
			for(index2=0;index2<MAX_COLUMN;index2++)
			{
				if(checkIfPiecedCanBeDroppedIn(index2))
				{
					traverse=0;
					while(traverse<MAX_ROW && 
							connect_board[traverse][index2]=='O')
						traverse++;
					traverse--;
					connect_board[traverse][index2]='*';
					if(didLastMoveWin())
					{
						connect_board[traverse][index2]='O';
						return index2;
					}
					else
					{
						connect_board[traverse][index2]='O';
					}
				}
			}
		}

		// Canceling Human Player winning chances
		for(index1=0;index1<MAX_ROW;index1++)
		{
			for(index2=0;index2<MAX_COLUMN;index2++)
			{
				if(checkIfPiecedCanBeDroppedIn(index2))
				{
					traverse=0;
					while(traverse<MAX_ROW && 
							connect_board[traverse][index2]=='O')
						traverse++;
					traverse--;
					connect_board[traverse][index2]='+';
					if(didLastMoveWin())
					{
						connect_board[traverse][index2]='O';
						return index2;
					}
					else
					{
						connect_board[traverse][index2]='O';
					}
				}
			}
		}

		column=0;
		while(!checkIfPiecedCanBeDroppedIn(column))		
			column=random_no.nextInt(MAX_COLUMN-1);
		return column;
	}

	// An Overridden method to Play the game
	@Override
	public  void playTheGame()      {
		int column;
		Connect4FieldView3[] thePlayers=new Connect4FieldView3[2];
		thePlayers[0] = new Connect4FieldView3(this, "A", '+');
		thePlayers[1] = new Connect4FieldView3(this, "Computer", '*');

		boolean gameIsOver = false;
		do {
			for ( int index = 0; index < 2; index ++ )      {
				System.out.println(this);
				if (isItaDraw() )      {
					System.out.println("Draw");
					gameIsOver = true;
				} else {
					System.out.println("Player "+thePlayers[index].player_name+
							" ("+thePlayers[index].piece+")");
					if(index==0)
						column = thePlayers[index].nextMove();
					else
						column= computerMove();
					dropPieces(column, thePlayers[index].getGamePiece() );
					if ( didLastMoveWin() ) {
						gameIsOver = true;
						System.out.println("The winner is: " + 
								thePlayers[index].getName());
						System.out.println(this);
						break;
					}
				}
			}

		}  while ( ! gameIsOver  );
	}

	// An Overridden method to initialize player properties
	@Override
	public void init(Connect4FieldViewInterface3 playerA, Connect4FieldViewInterface3 playerB) {

	}

}
