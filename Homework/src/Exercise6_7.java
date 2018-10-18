import java.util.*;
import java.math.*;
public class Exercise6_7
{
	public static double futureInvestmentValue(double invest, double monthlyInterestRate, int years)
	{
		return invest*Math.pow(1+monthlyInterestRate, years*12);
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("The amount invested: ");
		double invest = input.nextDouble();
		System.out.print("Annual interest rate: ");
		int year = input.nextInt();
		System.out.printf("%-5s%20s\n","Year","Future Value");
		for(int i = 1;i<=30;++i)
			System.out.printf("%-5d%20.2f\n",i,futureInvestmentValue(invest,(double)year/100/12,i));
	}
	
	
}
