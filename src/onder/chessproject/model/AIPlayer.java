package onder.chessproject.model;

public class AIPlayer extends Player
{
	IStrategy strategy;
	public AIPlayer(int playerIndex, IStrategy aiStrategy)
	{
		super(playerIndex);
		this.strategy = aiStrategy;
	}

	@Override
	public Movement getMove()
	{
		return this.strategy.createMovement(this);
	}
}
