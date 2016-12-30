package onder.chessproject.model;
import java.util.Random;

public class RandomStrategy implements IStrategy
{

	@Override
	public Movement createMovement(Player player)
	{
		String randomMovementInput = this.createRandomMovementInput();
		System.out.println(randomMovementInput);
		Movement randomMovement = new Movement(randomMovementInput);
		return randomMovement;
	}

	private String createRandomMovementInput()
	{
		char letter1 = this.getLetter();
		char number1 = this.getNumber();
		char letter2 = this.getLetter();
		char number2 = this.getNumber();
		String input = letter1+""+number1+" "+letter2+""+number2;
		return input;
	}

	private char getNumber()
	{
		int randomNumber = this.createRandomNumber(0,8);
		char number = ChessBoard.getInstance().getNumbers()[randomNumber];
		return number;
	}
	
	private char getLetter()
	{
		int randomNumber = this.createRandomNumber(0,8);
		char letter = ChessBoard.getInstance().getLetters()[randomNumber];
		return letter;
	}

	private int createRandomNumber(int limitLow, int limitHigh)
	{
		Random random = new Random();
		return random.nextInt(limitHigh-limitLow) + limitLow;
	}
}
