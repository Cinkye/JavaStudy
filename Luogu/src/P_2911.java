import java.util.*;
public class P_2911
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int s1 = input.nextInt();
		int s2 = input.nextInt();
		int s3 = input.nextInt();
		int[] sum = new int[s1 + s2 + s3 + 1];
		for(int i = 0;i <= s1 + s2 + s3;++i)
			sum[i]=0;
		for(int i = 1;i <= s1;++i)
			for(int j = 1;j <= s2;++j)
				for(int k = 1;k <= s3;++k)
					sum[i+j+k]++;
		int currlarge = 1;
		for(int i = 1;i < s1 + s2 + s3;++i)
		{
			if(sum[i+1]>sum[i])
				currlarge = i+1;
		}
		System.out.println(currlarge);
		input.close();
	}
}
