package hw6_2;
/**
 * A Program to Create a Player class & implement the PlayerInterface.
 	Implement a Human vs Computer Game

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
//A public class to Test the working of Connect4Field Game
public class Connect4FieldController3 {

	// A public instantiated a Connect4Field class object using constructor
	public Connect4FieldModel3 aConnect4Field = new Connect4FieldModel3();
	// Created Player objects and assigning the respective values to them
	public Connect4FieldView3 aPlayer = new Connect4FieldView3(aConnect4Field,
			"A", '+');
	public Connect4FieldView3 bPlayer = new Connect4FieldView3(aConnect4Field,
			"Computer", '*');

	// A public method to check whether a piece can be dropped in a 
	// particular column or not
	public void dropTest( int column ) {
		System.out.println("Can it be dropped in " +
				column + ": " 	   +
				aConnect4Field.checkIfPiecedCanBeDroppedIn(column));
	}

	// A public method to start the game
	public void start_game() {
		System.out.println("This is a Human vs Computer Game!\n");
		aConnect4Field = new Connect4FieldModel3();
		aConnect4Field.init(aPlayer, bPlayer);
	}

	// Main method, programs starts here
	public static void main( String[] args ) {
		new Connect4FieldController3().start_game();
	}

}