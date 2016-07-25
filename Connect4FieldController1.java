package hw6_2;
/**
 * A Program to Create a Connect4Field class & implement the Connect4FieldInterface.
 	Implement the given test cases

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 1.0
 */
// A public class to Test the working of Connect4Field Game
public class Connect4FieldController1 {

	// A public instantiated a Connect4Field class object using constructor	
	public Connect4FieldModel1 aConnect4Field = new Connect4FieldModel1();
	// Created Player objects and assigning the respective values to them
	public Connect4FieldView1 aPlayer = new Connect4FieldView1(aConnect4Field, "A", '+');
	public Connect4FieldView1 bPlayer = new Connect4FieldView1(aConnect4Field, "B", '*');

	// A public method to check whether a piece can be dropped in a 
	// particular column or not
	public void dropTest( int column ) {
		System.out.println("Can it be dropped in " +
				column + ": " 	   +
				aConnect4Field.checkIfPiecedCanBeDroppedIn(column));
	}

	// A public method to check some of the conditions
	public void testIt() {
		aConnect4Field = new Connect4FieldModel1();
		System.out.println(aConnect4Field);
		dropTest(-1);
		dropTest(0);
		dropTest(1);
		aConnect4Field.dropPieces(1, '+');
		System.out.println(aConnect4Field);
		aConnect4Field.dropPieces(1, '*');
		System.out.println(aConnect4Field);
		aConnect4Field.didLastMoveWin();
		aConnect4Field.isItaDraw();
		aConnect4Field.init(aPlayer, bPlayer);
	}

	// Main method, programs starts here
	public static void main( String[] args ) {
		new Connect4FieldController1().testIt();

	}

}