/**
 * 
 */
package onder.chessproject.ui;

import java.util.Scanner;
import onder.chessproject.controller.ChessController;
import onder.chessproject.model.ChessBoard;
import onder.chessproject.model.ISquare;

/**
 * @author Önder
 *
 */
public class ConsoleUserInterface implements IUserInterface
{

	private Scanner inputScanner;
	private ChessController chessController;
	String userInput;
	public final String InitialText = "Welcome to Chess program.\nEnter your moves as:\n <current location of the piece> <new location of the piece>\nFor example enter `a2 a4` to move piece located at a2 to a4\nEnter 'q' to quit.\n\n";
	
	public ConsoleUserInterface(ChessController chessController)
	{
		this.inputScanner = new Scanner(System.in); 
		this.chessController = chessController;
	}

	/**
	 * 
	 */
	public void run()
	{
		System.out.println(this.InitialText);
		System.out.println("Computer's strategy R for random, P for piece values:");
		this.userInput = this.inputScanner.nextLine();
		this.chessController.addPlayer("A", 0, userInput);
		this.chessController.addPlayer("H", 1, "");
		
		do{
			draw();
			String movementResult = this.chessController.doNextPlayerMove();
			System.out.println(movementResult);
		}while(true);
	}
	
	public void draw()
	{
		char[] letters = ChessBoard.getInstance().getLetters();
		char[] numbers = ChessBoard.getInstance().getNumbers();
		ISquare[][] table = ChessBoard.getInstance().getTable();
		System.out.print("\n  ");
		for(int i = 0;i<letters.length;i++)
		{
			System.out.print("  " + letters[i] + " ");
		}
		
		System.out.println("\n  +---+---+---+---+---+---+---+---+");
		for(int i = 0; i < table.length; i++)
		{
			System.out.print(numbers[7-i] + " |");
			for(int j = 0; j < table[i].length; j++)
			{
				System.out.print(" " + table[i][j].getLetter() + " |");
			}
			
			System.out.print(" " + numbers[7-i]);
			System.out.println("\n  +---+---+---+---+---+---+---+---+");
		}
		
		System.out.print("  ");
		for(int i = 0;i<letters.length;i++)
		{
			System.out.print("  " + letters[i] + " ");
		}
		
		System.out.println("");
	}

}
