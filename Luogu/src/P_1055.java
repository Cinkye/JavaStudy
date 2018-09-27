import java.util.*;

public class P_1055
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String isbn = input.nextLine();
		int[] tmp = new int[10];
		tmp[0] = (int) isbn.charAt(0) - 48;
		for (int i = 1; i < 4; ++i)
			tmp[i] = (int) isbn.charAt(i + 1) - 48;
		for (int i = 4; i < 9; ++i)
			tmp[i] = (int) isbn.charAt(i + 2) - 48;
		if (isbn.charAt(12) != 'X')
			tmp[9] = (int) isbn.charAt(12) - 48;
		else
			tmp[9] = 10;
		int sum = 0;
		for (int i = 9; i >= 1; --i)
		{
			sum += tmp[i - 1] * i;
		}
		if (sum % 11 == tmp[9])
			System.out.println("Right");
		else
		{
			System.out.print(isbn.substring(0, 12));
			if (sum % 11 == 10)
				System.out.println('X');
			else
				System.out.println(sum % 11);
		}
		input.close();
	}
}
