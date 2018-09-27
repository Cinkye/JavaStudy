import java.util.*;

public class P_1308
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String strTBF = input.nextLine();
		String sentence = input.nextLine();
		strTBF = strTBF.toLowerCase();
		sentence = sentence.toLowerCase();
		int num = 0;
		int index1 = 0;
		int index2 = sentence.indexOf(' ');
		while (sentence.indexOf(' ', index1) != -1)
		{
			if (sentence.substring(index1, index2) == strTBF)
				++num;
			index1 = index2;
			index2 = sentence.indexOf(' ', index2);
		}
		if (num == 0)
			System.out.println("-1");
		else
		{
			System.out.println("" + num + " " + sentence.indexOf(strTBF));
		}
		input.close();
	}
}
