import java.util.*;
public class RandomLetter
{
	public static void main(String[] args)
	{
		int number = (int)(Math.random() * 1000 )% 26 + 65;
		System.out.println((char)number);
	}
}
