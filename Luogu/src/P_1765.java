import java.util.*;
public class P_1765
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		line = line.toLowerCase();
		int sum = 0;
		for(int i = 0;i<line.length();++i)
		{
			char ch = line.charAt(i);
			if(ch == 'a'||ch == 'd'||ch == 'g'||ch == 'j'||ch == 'm'||ch == 'p'||ch == 't'||ch == 'w'||ch == ' ')
				sum += 1;
			else if(ch == 'b'||ch == 'e'||ch == 'h'||ch == 'k'||ch == 'n'||ch == 'q'||ch == 'u'||ch == 'x')
				sum += 2;
			else if(ch == 'c'||ch == 'f'||ch == 'i'||ch == 'l'||ch == 'o'||ch == 'r'||ch == 'v'||ch == 'y')
				sum += 3;
			else
				sum += 4;		
		}
		System.out.println(sum);
	}
	
}
