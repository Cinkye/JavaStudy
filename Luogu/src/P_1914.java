import java.util.*;

public class P_1914
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.nextLine();
		String code = input.nextLine();
		int codeLength = code.length();
		for (int i = 0; i < codeLength; ++i)
		{
			System.out.print((char) (((int) code.charAt(i) + num - 97) % 26 + 97));
		}
	}
}
