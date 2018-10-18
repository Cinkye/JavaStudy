//Cinkye Exercise2_6
import java.util.*;
public class Exercise2_6
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000");
		int num = input.nextInt();
		int sum = 0;
		if(num >= 0 && num <= 1000)
		{
			while(num > 0)
			{
				sum += num % 10;
				num /= 10;
			}
			System.out.println("The sum of the digits is " + sum);
		}
		else
			System.out.println("Number is not between 0 and 1000");
		input.close();
	}
}
