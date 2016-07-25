package hw6_2;
/**
 * A Program to Create a Connect4Field class & implement the Connect4FieldInterface.
 	Implement the given test cases

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
// A public class which implements the Connect4FieldInterface
public class Connect4FieldModel1 implements Connect4FieldModelInterface1{

	// Initialization of variables for the board
	static int MAX_ROW=4;
	static int MAX_COLUMN=10;
	static char connect_board[][]=new char[MAX_ROW][MAX_COLUMN];

	// Default constructor to generate the required board
	Connect4FieldModel1()
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
					//  '/'diagonal check
					count=0;
					row_traverse=index1-1;
					column_traverse=index2-1;
					while(count<4 && row_traverse<MAX_ROW && 
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
					while(count<4 && row_traverse<MAX_ROW && 
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



					//  '\'diagonal check
					count=0;
					row_traverse=index1+1;
					column_traverse=index2-1;
					while(count<4 && row_traverse<MAX_ROW && 
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
					while(count<4 && row_traverse<MAX_ROW && 
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


					//  '|' upward-downward check
					count=0;
					row_traverse=index1-1;
					column_traverse=index2;
					while(count<4 && row_traverse<MAX_ROW && 
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
					while(count<4 && row_traverse<MAX_ROW && 
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

					//  '--'sideways check
					count=0;
					row_traverse=index1;
					column_traverse=index2-1;
					while(count<4 && row_traverse<MAX_ROW && 
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
					while(count<4 && row_traverse<MAX_ROW && 
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
	public void init(Connect4FieldView1 playerA, Connect4FieldView1 playerB) {
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


	// An Overridden method to initialize player properties
	@Override
	public void init(Connect4FieldViewInterface1 playerA, Connect4FieldViewInterface1 playerB) {

	}

	// An Overridden method to Play the game
	@Override
	public void playTheGame() {

		System.out.println("Called Play Game!");
	}

}
