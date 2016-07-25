package hw6_2;
/**
 * A Program to Create a Player class & implement the PlayerInterface.
 	Implement a Human vs Computer Game

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
//A public interface with some methods to be implemented
public interface Connect4FieldModelInterface3 {
	public boolean checkIfPiecedCanBeDroppedIn(int column);
	public void dropPieces(int column, char gamePiece);
	boolean didLastMoveWin();
	public boolean isItaDraw();
	public void init( Connect4FieldViewInterface3 playerA, Connect4FieldViewInterface3 playerB );
	public String toString();
	public void playTheGame();
}