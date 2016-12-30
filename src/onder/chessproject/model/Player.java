package onder.chessproject.model;

import java.util.Scanner;

public abstract class Player
{
	private int playerIndex;
	protected Scanner inputScanner;
	public Player(int index)
	{
		this.playerIndex = index;
		this.inputScanner = new Scanner(System.in); 
	}
	
	public Movement getMove()
	{
		return new Movement("FF FF");
	}
	
	public int getPlayerIndex()
	{
		return this.playerIndex;
	}

	public String getPlayerColor()
	{
		String playerColor = (this.getPlayerIndex()%2 == 0)? "black" : "white";
		return playerColor;
	}
}
