package onder.chessproject.model;

public interface ISquare
{
	public char getLetter();
	public Boolean validateMove(Movement movement, ISquare[][] table, Player currentPlayer);
	public Boolean isChessPiece();
}
