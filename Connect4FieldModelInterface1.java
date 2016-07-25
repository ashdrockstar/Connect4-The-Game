package hw6_2;
/**
 * A Program to Create a Connect4Field class & implement the Connect4FieldInterface.
 	Implement the given test cases

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
// A public interface with some methods to be implemented
public interface Connect4FieldModelInterface1 {
	public boolean checkIfPiecedCanBeDroppedIn(int column);
	public void dropPieces(int column, char gamePiece);
	boolean didLastMoveWin();
	public boolean isItaDraw();
	public void init( Connect4FieldViewInterface1 playerA, Connect4FieldViewInterface1 playerB );
	public String toString();
	public void playTheGame();
}