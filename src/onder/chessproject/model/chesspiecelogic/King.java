package onder.chessproject.model.chesspiecelogic;

import onder.chessproject.model.ISquare;
import onder.chessproject.model.Movement;
import onder.chessproject.model.Player;

public class King extends ChessPiece
{

	public King(Player player)
	{
		super(player);
		this.pieceValue = 200;
		this.letter = 'k';
	}
	
	@Override
	public boolean validatePieceSpecific(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		int absoluteVerticalMove = Math.abs(movement.getTo().getY() - movement.getFrom().getY());
		int absoluteHorizontalMove = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
		if(absoluteVerticalMove > 1 || absoluteHorizontalMove > 1)
		{
			return false;
		}
		
		return true;
	}

}
