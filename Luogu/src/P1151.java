import java.util.Scanner;
public class P1151
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int div = input.nextInt();
		for(int i = 10000;i <= 30000;++i)
		{
			int a = i / 100;
			int b = (i / 10) % 1000;
			int c = i % 1000;
			if(a % div == 0 && b % div == 0 && c % div ==0)
				System.out.println(i);
		}
		input.close();
	}
}
