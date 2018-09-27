import java.util.*;
public class P_2956
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int x,y,l;
		x = input.nextInt();
		y = input.nextInt();
		l = input.nextInt();
		int[][] instructions = new int[l][4];
		for(int i = 0;i<l;++i)
			for(int j = 0;j<4;++j)
				instructions[i][j] = input.nextInt()-1;
		int[][] field = new int[y][x];
		for(int i = 0;i<y;++i)
			for(int j = 0;j<x;++j)
				field[i][j] = 0;
		for(int i = 0;i<l;++i)
			for(int j = instructions[i][1];j<=instructions[i][3];++j)
				for(int k = instructions[i][0];k<=instructions[i][2];++k)
					field[j][k] = 1;
		int count = 0;
		for(int i = 0;i<y;++i)
			for(int j = 0;j<x;++j)
				if(field[i][j] == 1)
					count++;
		System.out.println(count);
		input.close();
	}
}
