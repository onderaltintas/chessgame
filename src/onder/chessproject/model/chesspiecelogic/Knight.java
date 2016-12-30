package onder.chessproject.model.chesspiecelogic;

import onder.chessproject.model.ISquare;
import onder.chessproject.model.Movement;
import onder.chessproject.model.Player;

public class Knight extends ChessPiece
{

	public Knight(Player player)
	{
		super(player);
		this.pieceValue = 3;
		this.letter = 'n';
	}
	
	@Override
	public boolean validatePieceSpecific(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		int absoluteVerticalMove = Math.abs(movement.getTo().getY() - movement.getFrom().getY());
		int absoluteHorizontalMove = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
		if((absoluteVerticalMove + absoluteHorizontalMove) != 3 || Math.abs(absoluteHorizontalMove - absoluteVerticalMove) == 3||
				(absoluteVerticalMove == 2 && absoluteHorizontalMove != 1) ||
				(absoluteVerticalMove == 1 && absoluteHorizontalMove != 2) 
				)
		{
			return false;
		}
		
		return true;
	}
	
	
}
