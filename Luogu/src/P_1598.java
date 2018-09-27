import java.util.*;
public class P_1598
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String line;
		char[][] star = new char[101][26];
		for(int i = 0;i<100;++i)
			for(int j = 0;j<26;++j)
				star[i][j] = ' ';
		for(int i = 0;i<26;++i)
			star[100][i] = 0;
		for(int i = 0;i<4;++i)
		{
			line = input.nextLine();
			int lineLength = line.length();
			for(int j = 0;j<lineLength;++j)
			{
				char letter = line.charAt(j);
				if((int)letter <= 90 && (int)letter >= 65)
				{
					star[star[100][(int)letter-65]][(int)letter-65] = '*';
					star[100][(int)letter-65]++;
				}
			}
		}
		int large = 0;
		for(int i = 0;i<26;++i)
			if(star[100][i]>large)
				large = star[100][i];
		for(int i = large-1;i>=0;--i)
		{
			for(int j = 0;j<25;++j)
				System.out.print(star[i][j] + " ");
			System.out.println(star[i][25]);
		}
		for(int i = 0;i<25;++i)
			System.out.print((char)(65+i) + " ");
		System.out.print('Z');
		input.close();
	}
}
