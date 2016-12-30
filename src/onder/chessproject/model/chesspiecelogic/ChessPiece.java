/**
 * 
 */
package onder.chessproject.model.chesspiecelogic;

import onder.chessproject.model.ISquare;
import onder.chessproject.model.Location;
import onder.chessproject.model.Movement;
import onder.chessproject.model.Player;

/**
 * @author Önder
 *
 */
public abstract class ChessPiece implements ISquare
{
	public Boolean isChestPiece = true;
	protected char letter;
	protected Player player;
	protected int pieceValue;
	
	public int getPieceValue()
	{
		return this.pieceValue;
	}
	
	public char getLetter()
	{
		if(this.player.getPlayerIndex()%2 == 0)
		{
			return this.letter;
		}
		
		return Character.toUpperCase(letter);
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	public ChessPiece(Player player)
	{
		this.letter = 'X';
		this.pieceValue = 0;
		this.player = player;
	}
	
	public Boolean validateMove(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		if(this.checkIfSamePlace(movement))
		{
			return false;
		}
		
		if(!this.checkIfRightPlayer(currentPlayer))
		{
			return false;
		}
		
		if(this.eatingOwnPiece(movement,table,currentPlayer))
		{
			return false;
		}
		
		if(!this.checkInTableBorders(movement))
		{
			return false;
		}
		
		if(!validatePieceSpecific(movement, table, currentPlayer))
		{
			return false;
		}
		
		return true;
	}
	
	private boolean checkIfSamePlace(Movement movement)
	{
		if(movement.getFrom().getX() == movement.getTo().getX() && movement.getFrom().getY() == movement.getTo().getY())
		{
		 return true;
		}
		
		return false;
	}

	private boolean eatingOwnPiece(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		Location targetLocation = movement.getTo();
		ISquare theThingExistAtTargetPosition = table[targetLocation.getY()][targetLocation.getX()];
		if(theThingExistAtTargetPosition.isChessPiece())
		{
			ChessPiece chessPiece = (ChessPiece)theThingExistAtTargetPosition;
			if(chessPiece.getPlayer().getPlayerIndex() == currentPlayer.getPlayerIndex())
			{
				return true;
			}
		}
		
		return false;
	}

	public boolean validatePieceSpecific(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		return false;
	}

	private boolean checkIfRightPlayer(Player currentPlayer)
	{
		return this.player.getPlayerIndex() == currentPlayer.getPlayerIndex();
	}

	private Boolean checkInTableBorders(Movement movement)
	{
		if(movement.getFrom().getX()<0 || 
				movement.getFrom().getX()>7 || 
				movement.getFrom().getY()<0 || 
				movement.getFrom().getY()>7 || 
				movement.getTo().getX()<0 || 
				movement.getTo().getX()>7 || 
				movement.getTo().getY()<0 || 
				movement.getTo().getY()>7)
		{
			return false;
		}
		
		return true;
	}
	
	protected Boolean isPathBlocked(Movement movement)
	{
		return false;
	}
	
	@Override
	public Boolean isChessPiece()
	{
		return true;
	}
}
