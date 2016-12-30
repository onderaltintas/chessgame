package onder.chessproject.model;

public class PieceValueStrategy implements IStrategy
{

	@Override
	public Movement createMovement(Player player)
	{
		// TODO Not implemented yet therefore I will use RandomStrategy; 
		// Normally it will check the board, find opponent's most valuable piece then try to get near to it. 
		RandomStrategy randomStrategy = new RandomStrategy();
		return randomStrategy.createMovement(player);
	}

}
