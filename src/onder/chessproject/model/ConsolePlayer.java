package onder.chessproject.model;

public class ConsolePlayer extends Player
{
	
	public ConsolePlayer(int playerIndex)
	{
		super(playerIndex);
	}

	@Override
	public Movement getMove()
	{
		Movement movement;
		System.out.println(this.getPlayerColor() + ".player's next move: ");
		String movementInput = this.inputScanner.nextLine();
		if(movementInput.equals("q"))
		{
			System.out.println("bye!");
			System.exit(0); 
		}
		
		try{
			movement = new Movement(movementInput);
		}catch(Exception exception){
			movement = new Movement("FF FF");
		}
		
		return movement;
	}
}
