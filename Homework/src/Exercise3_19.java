import java.util.*;

public class Exercise3_19
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
		if (a + b > c && b + c > a && c + a > b)
			System.out.println("The circumference of the triangle is " + (a + b + c));
		else
			System.out.println("The input is invalid.");
	}
}
