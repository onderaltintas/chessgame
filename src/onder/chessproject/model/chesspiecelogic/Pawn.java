package onder.chessproject.model.chesspiecelogic;

import onder.chessproject.model.ChessBoard;
import onder.chessproject.model.ISquare;
import onder.chessproject.model.Movement;
import onder.chessproject.model.Player;

public class Pawn extends ChessPiece
{

	public Pawn(Player player)
	{
		super(player);
		this.pieceValue = 1;
		this.letter = 'i';
	}
	
	@Override
	public boolean validatePieceSpecific(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		int absoluteVerticalMove = Math.abs(movement.getTo().getY() - movement.getFrom().getY());
		int absoluteHorizontalMove = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
		if(absoluteVerticalMove > 2 || absoluteHorizontalMove > 2 || 
				(absoluteVerticalMove == 2 && absoluteHorizontalMove != 0) ||
				(absoluteVerticalMove == 1 && absoluteHorizontalMove > 1) ||
				(absoluteVerticalMove == 0 && absoluteHorizontalMove > 0))
		{
			return false;
		}
		
		if(absoluteVerticalMove == 2)
		{
			String playerColor = this.getPlayer().getPlayerColor();
			if((playerColor == "white" && movement.getFrom().getY() != 6) || 
					(playerColor == "black" && movement.getFrom().getY() != 2))
			{
				return false;
			}
		}
		
		if(absoluteVerticalMove == 1 && absoluteHorizontalMove == 1)
		{
			ISquare targetChessPiece = ChessBoard.getInstance().getTable()[movement.getTo().getY()][movement.getTo().getX()];
			Boolean isChessPiece = targetChessPiece.isChessPiece();
			if(!isChessPiece)
			{
				return false;
			}
			
			String playerColor = this.getPlayer().getPlayerColor();
			if((playerColor == "white" && (movement.getTo().getY()-movement.getFrom().getY()) > 0) || 
					(playerColor == "black" && (movement.getTo().getY()-movement.getFrom().getY()) < 0))
			{
				return false;
			}
		}
		
		if(absoluteVerticalMove == 1 && absoluteHorizontalMove == 0)
		{
			String playerColor = this.getPlayer().getPlayerColor();
			if((playerColor == "white" && (movement.getTo().getY()-movement.getFrom().getY()) > 0) || 
					(playerColor == "black" && (movement.getTo().getY()-movement.getFrom().getY()) < 0) ||
					ChessBoard.getInstance().getTable()[movement.getTo().getY()][movement.getTo().getX()].isChessPiece()
					)
			{
				return false;
			}
		}
		
		
		return true;
	}
}

