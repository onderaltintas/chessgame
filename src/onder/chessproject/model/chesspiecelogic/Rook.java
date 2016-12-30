package onder.chessproject.model.chesspiecelogic;

import onder.chessproject.model.ChessBoard;
import onder.chessproject.model.ISquare;
import onder.chessproject.model.Movement;
import onder.chessproject.model.Player;

public class Rook extends ChessPiece
{

	public Rook(Player player)
	{
		super(player);
		this.pieceValue = 5;
		this.letter = 'r';
	}
	
	@Override
	public boolean validatePieceSpecific(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		int absoluteVerticalMove = Math.abs(movement.getTo().getY() - movement.getFrom().getY());
		int absoluteHorizontalMove = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
		if(absoluteHorizontalMove != 0 && absoluteVerticalMove != 0)  
		{
			return false;
		}
		
		if(this.isPathBlocked(movement))
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	protected Boolean isPathBlocked(Movement movement)
	{
		String direction = (movement.getTo().getX() == movement.getFrom().getX())? "vertical" : "horizontal";
		ISquare[][] table = ChessBoard.getInstance().getTable();
		if(direction == "vertical")
		{
			int incrementConstant = (movement.getTo().getY() > movement.getFrom().getY())? 1 : -1;
			for(int y = movement.getFrom().getY() + incrementConstant;y != movement.getTo().getY();y+=incrementConstant)
			{
				if(table[y][movement.getFrom().getX()].isChessPiece())
				{
					return true;
				}
			}
		}
		else{
			int incrementConstant = (movement.getTo().getX() > movement.getFrom().getX())? 1 : -1;
			for(int x = movement.getFrom().getX() + incrementConstant;x != movement.getTo().getX();x+=incrementConstant)
			{
				if(table[movement.getFrom().getY()][x].isChessPiece())
				{
					return true;
				}
			}
		}
		
		return false;
	}

}
