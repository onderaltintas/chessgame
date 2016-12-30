package onder.chessproject.model;

public class Location
{
	private int x;
	private int y;
	
	public int getX()
	{
		return this.x;
		
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public Location(String xy)
	{
		this.x = this.letterToNumber(xy.charAt(0));
		this.y = this.letterToNumber(xy.charAt(1));
	}

	private int letterToNumber(char letter)
	{
		int result;
		switch(letter)
		{
  		case 'A':
  		case 'a':
  		case '8':	
  			result = 0;
  			break;
  		case 'B':
  		case 'b':
  		case '7':
  			result = 1;
  			break;
  		case 'C':
  		case 'c':
  		case '6':
  			result = 2;
  			break;
  		case 'D':
  		case 'd':
  		case '5':
  			result = 3;
  			break;
  		case 'E':
  		case 'e':
  		case '4':
  			result = 4;
  			break;
  		case 'F':
  		case 'f':
  		case '3':
  			result = 5;
  			break;
  		case 'G':
  		case 'g':
  		case '2':
  			result = 6;
  			break;
  		case 'H':
  		case 'h':
  		case '1':
  			result = 7;
  			break;
  		default:
  			result = 9;
		}
		
		return result;
	}
}
