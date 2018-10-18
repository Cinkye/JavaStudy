import java.util.Scanner;
import java.math.*;
public class Exercise5_47
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		int sum = 0;
		if(num.length()<12)
			System.out.println(num + " is an invalid input.");
		else
		{
			for(int i = 0 ;i < 12;++i)
				if(i%2==0)
					sum += (int)num.charAt(i)-48;
				else
					sum += ((int)num.charAt(i)-48)*3;
		}
		System.out.println("The ISBN-13 number is " + (num+(10-sum%10)));
	}
}
