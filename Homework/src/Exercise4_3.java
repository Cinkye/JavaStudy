import java.util.Scanner;
import java.math.*;

public class Exercise4_3
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		final double AtlantaX = 33.7489954;
		final double AtlantaY = -84.3879824;
		final double OrlandoX = 28.5383355;
		final double OrlandoY = -81.3792365;
		final double SavannahX = 32.0835407;
		final double SavannahY = -81.0998342;
		final double CharlotteX = 35.2270869;
		final double CharlotteY = -80.8431267;
		double s3 = Math.sqrt(Math.pow(CharlotteX - OrlandoX, 2) + Math.pow(CharlotteY - OrlandoY, 2));
		double s1 = Math.sqrt(Math.pow(CharlotteX - AtlantaX, 2) + Math.pow(CharlotteY - AtlantaY, 2));
		double s2 = Math.sqrt(Math.pow(OrlandoX - AtlantaX, 2) + Math.pow(OrlandoY - AtlantaY, 2));
		double s = (s1+s2+s3)/2;
		double sum = (Math.sqrt(s*(s-s1)*(s-s2)*(s-s3)));
		s1 = Math.sqrt(Math.pow(CharlotteX - SavannahX, 2) + Math.pow(CharlotteY - SavannahY, 2));
		s2 = Math.sqrt(Math.pow(OrlandoX - SavannahX, 2) + Math.pow(OrlandoY - SavannahY, 2));
		s = (s1+s2+s3)/2;
		sum += (Math.sqrt(s*(s-s1)*(s-s2)*(s-s3)));
		System.out.println("The area is " + sum);
	}
}
