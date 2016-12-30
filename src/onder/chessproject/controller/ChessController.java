/**
 * 
 */
package onder.chessproject.controller;
import onder.chessproject.model.AIPlayer;
import onder.chessproject.model.ChessBoard;
import onder.chessproject.model.ConsolePlayer;
import onder.chessproject.model.IStrategy;
import onder.chessproject.model.PieceValueStrategy;
import onder.chessproject.model.Player;
import onder.chessproject.model.RandomStrategy;

/**
 * @author Önder
 *
 */
public class ChessController
{
	private final String PlayerTypeHuman = "H";
	private final String PlayerTypeAI = "A";
	
	public void addPlayer(String playerType, int index, String strategy)
	{
		Player player;
		switch(playerType)
		{
  		case PlayerTypeHuman:
 			 player = new ConsolePlayer(index);
 			 ChessBoard.getInstance().addPlayer(player, index);
 			 break;
  		case PlayerTypeAI:
  			IStrategy aiStrategy; 
  			switch(strategy.toLowerCase())
  			{
  				case "r":
  					aiStrategy = new RandomStrategy();
  					break;
  				case "p":
  					aiStrategy = new PieceValueStrategy();
  					break;
  				default:
  					aiStrategy = new RandomStrategy();
  					break;
  			}
  		 
 			 player = new AIPlayer(index,aiStrategy);
 			 ChessBoard.getInstance().addPlayer(player, index);
 			 break;
  		default:
			 player = new ConsolePlayer(index);
			 ChessBoard.getInstance().addPlayer(player, index);
		}
	}

	public String doNextPlayerMove()
	{
		String result = ChessBoard.getInstance().doNextPlayerMove();
		return result;
	}

}
