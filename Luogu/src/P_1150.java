import java.util.*;
public class P_1150
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double n,k;
		n = input.nextDouble();
		k = input.nextDouble();
		System.out.println((int)(n/(k-1)*k));
	}
}
