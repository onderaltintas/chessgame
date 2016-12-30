package onder.chessproject.model;

public class Movement
{
	private Location from;
	private Location to;
	
	public Location getFrom()
	{
		return this.from;
	}
	
	public Location getTo()
	{
		return this.to;
	}
	
	public Movement(String movement)
	{
		String movementSplitted [] = movement.split("\\s+");
		this.from = new Location(movementSplitted[0]);
		this.to = new Location(movementSplitted[1]);
	}
}
