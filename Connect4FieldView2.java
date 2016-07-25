package hw6_2;
/**
 * A Program to Create a Player class & implement the PlayerInterface.
 	Implement a Human vs Human Game

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
import java.util.InputMismatchException;
import java.util.Scanner;

//A public class which implements the PlayerInterface
public class Connect4FieldView2 implements Connect4FieldViewInterface2{

	// Local variables to store the properties
	String player_name;
	char piece;
	// A Default constructor to initialize the properties
	Connect4FieldView2(Connect4FieldModel2 theField,String name,char gamePiece){
		
		player_name=name;
		piece=gamePiece;
		
	}

	// An Overridden method to get the game piece
	@Override
	public char getGamePiece() {
		return piece;
	}

	// An Overridden method to get the player name
	@Override
	public String getName() {
		return player_name;
	}

	// An Overridden method to fetch next move
	@Override
	public int nextMove() {
		int move;
		Scanner scanner=new Scanner(System.in);
		try{
		System.out.println("Your move(column no.): ");
		move=scanner.nextInt();
		}
		catch(InputMismatchException e)
		{
			move=-1;
		}
		return move;
	}
}
