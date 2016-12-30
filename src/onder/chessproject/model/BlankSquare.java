package onder.chessproject.model;

public class BlankSquare implements ISquare
{
  private char letter;
  public BlankSquare(String color)
  {
  	this.letter = ' ';
  	if(color == "black")
  	{
  		this.letter = '.';
  	}
  }
  
	@Override
	public char getLetter()
	{
		return this.letter;
	}

	@Override
	public Boolean validateMove(Movement movement, ISquare[][] table, Player currentPlayer)
	{
		return false;
	}

	@Override
	public Boolean isChessPiece()
	{
		return false;
	}

}
