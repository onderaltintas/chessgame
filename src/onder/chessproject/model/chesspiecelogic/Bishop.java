package onder.chessproject.model.chesspiecelogic;

import onder.chessproject.model.ChessBoard;
import onder.chessproject.model.ISquare;
import onder.chessproject.model.Movement;
import onder.chessproject.model.Player;

public class Bishop extends ChessPiece
{

	public Bishop(Player player)
	{
		super(player);
		this.pieceValue = 3;
		this.letter = 'b';
	}
	
	@Override
	public boolean validatePieceSpecific(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		int absoluteVerticalMove = Math.abs(movement.getTo().getY() - movement.getFrom().getY());
		int absoluteHorizontalMove = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
		if(absoluteVerticalMove != absoluteHorizontalMove)  
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
		int horizontalDirection = (movement.getTo().getX() > movement.getFrom().getX())? 1 : -1;
		int verticalDirection = (movement.getTo().getY() > movement.getFrom().getY())? 1 : -1;
		int step = 0;
		ISquare[][] table = ChessBoard.getInstance().getTable();
		for(int x = movement.getFrom().getX() + horizontalDirection;x!=movement.getTo().getX();x+=horizontalDirection)
		{
			step++;
			int y = movement.getFrom().getY() + step*verticalDirection;
			if(y>7 || y<0)
			{
				return false;
			}
			
			if(table[y][x].isChessPiece())
			{
				return true;
			}
		}
		
		return false;
	}

}
