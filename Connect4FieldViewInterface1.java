package hw6_2;
/**
 * A Program to Create a Connect4Field class & implement the Connect4FieldInterface.
 	Implement the given test cases

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
//A public interface with some methods to be implemented
public interface Connect4FieldViewInterface1 {

// this is how your constructor has to be
// Player(Connect4FieldInterface theField, String name, char gamePiece)
	
	public char getGamePiece();
	public String getName();
	public int  nextMove();
}