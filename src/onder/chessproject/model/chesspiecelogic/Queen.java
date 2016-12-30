package onder.chessproject.model.chesspiecelogic;

import onder.chessproject.model.ChessBoard;
import onder.chessproject.model.ISquare;
import onder.chessproject.model.Movement;
import onder.chessproject.model.Player;

public class Queen extends ChessPiece
{

	public Queen(Player player)
	{
		super(player);
		this.pieceValue = 9;
		this.letter = 'q';
	}
	
	@Override
	public boolean validatePieceSpecific(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		int absoluteVerticalMove = Math.abs(movement.getTo().getY() - movement.getFrom().getY());
		int absoluteHorizontalMove = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
		if((absoluteVerticalMove != absoluteHorizontalMove) &&
				(absoluteHorizontalMove != 0 && absoluteVerticalMove != 0))  
				
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
		int absoluteVerticalMove = Math.abs(movement.getTo().getY() - movement.getFrom().getY());
		int absoluteHorizontalMove = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
		if(absoluteVerticalMove == absoluteHorizontalMove)
		{
			return this.isPathBlockedCrosswise(movement);
		}
		
		return this.isPathBlockedOneDirection(movement);
	}

	private Boolean isPathBlockedOneDirection(Movement movement)
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

	private Boolean isPathBlockedCrosswise(Movement movement)
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
