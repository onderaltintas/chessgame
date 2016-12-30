/**
 * 
 */
package onder.chessproject.model;

import onder.chessproject.model.chesspiecelogic.Bishop;
import onder.chessproject.model.chesspiecelogic.King;
import onder.chessproject.model.chesspiecelogic.Knight;
import onder.chessproject.model.chesspiecelogic.Pawn;
import onder.chessproject.model.chesspiecelogic.Queen;
import onder.chessproject.model.chesspiecelogic.Rook;

/**
 * @author Önder
 *
 */
public class ChessBoard
{
	private static ChessBoard chessBoardInstance;
	private Player[] players;
	private int currentPlayerIndex;
	private ISquare[][] table;
	private final char HorizontalLetters[] = {'A','B','C','D','E','F','G','H'};
	private final char VerticalNumbers[] = {'1','2','3','4','5','6','7','8'};
	
	public static ChessBoard getInstance()
	{
		if(chessBoardInstance == null)
		{
			chessBoardInstance = new ChessBoard();
		}
		
		return chessBoardInstance;
	}
	
	public ISquare[][] getTable()
	{
		return this.table;
	}
	
	public char[] getLetters()
	{
		return this.HorizontalLetters;
	}
	
	public char[] getNumbers()
	{
		return this.VerticalNumbers;
	}
	
	public void addPlayer(Player player, int index)
	{
		this.players[index] = player;
		if(index+1 == this.players.length) // if all players were added we can initialize the table.
		{
			this.initializeBoard();
		}
	}

	public String doNextPlayerMove()
	{
		String result = "";
		this.currentPlayerIndex = (this.currentPlayerIndex + 1) % 2;
		Player currentPlayer = players[currentPlayerIndex];
    Movement movement = currentPlayer.getMove();
    ISquare chessPiece = this.table[movement.getFrom().getY()][movement.getFrom().getX()];
    Boolean isValid = chessPiece.validateMove(movement, this.table, currentPlayer);
    if(isValid)
    {
    	if(this.checkIfQueenThere(movement.getTo()))
    	{
    		return "win";
    	}
    	
      this.moveChessPiece(movement);
  		result = currentPlayer.getPlayerColor() + "'s move accepted.";
    }
    else
    {
    	this.currentPlayerIndex = (this.currentPlayerIndex - 1) % 2;
    	result = "Invalid Move";
    }
    
    return result;
	}
	
	private ChessBoard()
	{
		this.currentPlayerIndex = 0; 
		this.players = new Player[2];
	}

	private void initializeBoard()
	{
		table = new ISquare[8][8];
		table[0][0] = new Rook(this.players[0]);
		table[0][1] = new Knight(this.players[0]);
		table[0][2] = new Bishop(this.players[0]);
		table[0][3] = new Queen(this.players[0]);
		table[0][4] = new King(this.players[0]);
		table[0][5] = new Bishop(this.players[0]);
		table[0][6] = new Knight(this.players[0]);
		table[0][7] = new Rook(this.players[0]);
		
		for(int x = 0; x < table.length; x++)
		{
			for(int y = 2; y < table[x].length -2; y++)
			{
					table[y][x] = this.createBlankSquare(x,y);
			}
		}
		
		for(int x = 0; x < table.length; x++)
		{
			table[1][x] = new Pawn(this.players[0]);
			table[6][x] = new Pawn(this.players[1]);
		}
		
		table[7][0] = new Rook(players[1]);
		table[7][1] = new Knight(players[1]);
		table[7][2] = new Bishop(players[1]);
		table[7][3] = new Queen(players[1]);
		table[7][4] = new King(players[1]);
		table[7][5] = new Bishop(players[1]);
		table[7][6] = new Knight(players[1]);
		table[7][7] = new Rook(players[1]);
	}

	private boolean checkIfQueenThere(Location targetLocation)
	{
		ISquare targetSquare = this.table[targetLocation.getY()][targetLocation.getX()];
		if(targetSquare.isChessPiece())
		{
			if(Character.toLowerCase(targetSquare.getLetter()) == 'q')
			{
				return true;
			}
		}
		
		return false;
	}

	private void moveChessPiece(Movement movement)
	{
		this.table[movement.getTo().getY()][movement.getTo().getX()] = this.table[movement.getFrom().getY()][movement.getFrom().getX()];
		this.table[movement.getFrom().getY()][movement.getFrom().getX()] = createBlankSquare(movement.getFrom().getX(),movement.getFrom().getY());
	}
	
	private BlankSquare createBlankSquare(int x, int y)
	{
		if((x+y)%2 == 1)
		{
			return new BlankSquare("black");
		}
		
		return new BlankSquare("white");
	}
}
