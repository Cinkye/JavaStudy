import java.util.*;
import java.math.*;

public class Exercise6_31
{
	public static String getPrefix(String number, int k)
	{
		if (number.charAt(0) == '4' || number.charAt(0) == '5' || number.charAt(0) == '6')
			return number.substring(0, 1);
		if (number.charAt(0) == '3' && number.charAt(1) == '7')
			return number.substring(0, 2);
		return number;
	}

	public static boolean prefixMatched(String number, int d)
	{
		if(getPrefix(number,2)=="4"||getPrefix(number,2)=="5"||getPrefix(number,2)=="6"||getPrefix(number,2)=="37")
			return true;
		return false;
	}
	
	public static int getSize(String number)
	{
		return number.length();
	}

	public static int getDigit(char num)
	{
		return ((int) num - 48) * 2 / 10 + ((int) num - 48) * 2 % 10;
	}

	public static int sumOfDoubleEvenPlace(String number)
	{
		int sum = 0;
		for (int i = getSize(number) - 1; i >= 0; i -= 2)
		{
			sum += getDigit(number.charAt(i));
		}
		return sum;
	}

	public static int sumOfOddPlace(String number)
	{
		int sum = 0;
		for (int i = getSize(number) - 2; i >= 0; i -= 2)
		{
			sum += ((int) number.charAt(i) - 48);
		}
		return sum;
	}

	public static boolean isValid(String number)
	{
		int sum = 0;
		sum += (sumOfDoubleEvenPlace(number));
		sum += sumOfDoubleEvenPlace(number);
		if (sum % 10 == 0)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		String number;
		System.out.println("Enter a credit card number as a long integer:");
		Scanner input = new Scanner(System.in);
		number = input.nextLine();
		if(prefixMatched(number,2) && isValid(number))
			System.out.println(number + " is valid");
		else
			System.out.println(number + " is invalid");
	}
}
