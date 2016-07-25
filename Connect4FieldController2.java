package hw6_2;

/**
 * A Program to Create a Player class & implement the PlayerInterface.
 	Implement a Human vs Human Game

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
//A public class to Test the working of Connect4Field Game
public class Connect4FieldController2 {

	// A public instantiated a Connect4Field class object using constructor	
	public Connect4FieldModel2 aConnect4Field = new Connect4FieldModel2();
	// Created Player objects and assigning the respective values to them
	public Connect4FieldView2 aPlayer = new Connect4FieldView2(aConnect4Field
			, "A", '+');
	public Connect4FieldView2 bPlayer = new Connect4FieldView2(aConnect4Field
			, "B", '*');

	// A public method to check whether a piece can be dropped in a 
	// particular column or not
	public void dropTest( int column ) {
		System.out.println("Can it be dropped in " +
				column + ": " 	   +
				aConnect4Field.checkIfPiecedCanBeDroppedIn(column));
	}

	// A public method to start the game
	public void start_game() {
		System.out.println("This is a Human vs Human Game!\n");
		aConnect4Field = new Connect4FieldModel2();
		aConnect4Field.init(aPlayer, bPlayer);
	}

	// Main method, programs starts here
	public static void main( String[] args ) {
		new Connect4FieldController2().start_game();
	}

}