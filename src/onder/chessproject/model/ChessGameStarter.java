/**
 * 
 */
package onder.chessproject.model;

import onder.chessproject.controller.ChessController;
import onder.chessproject.ui.ConsoleUserInterface;

/**
 * @author Önder
 *
 */
public class ChessGameStarter
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ChessController chessController = new ChessController();
		ConsoleUserInterface ui = new ConsoleUserInterface(chessController);
		ui.run();
	}

}
