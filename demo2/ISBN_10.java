import java.util.Scanner;
public class ISBN_10
	{
		public static void main(String[] args)
		{
			int isbn;
			Scanner input = new Scanner(System.in);
			isbn = input.nextInt();
			int copy = isbn;
			int sum = 0;
			int[] tmp = new int[9];
			for(int i = 9;i >= 1;--i)
				{
					tmp[i-1] = copy%10;
					sum += tmp[i-1] * i;
					copy /= 10;
				}
			if(sum % 11 == 10)
				{
					for(int i = 0;i < 9;++i)
						System.out.print(tmp[i]);
					System.out.println("X");
				}
			else
				{
					for(int i = 0;i < 9;++i)
						System.out.print(tmp[i]);
					System.out.println(sum % 11);
				}
			input.close();
		}
	}
