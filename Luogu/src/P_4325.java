import java.util.Scanner;
public class P_4325
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int[] nums = new int[10];
		for(int i = 0;i < 10;++i)
			nums[i] = input.nextInt();
		int[] mods = new int[42];
		for(int i = 0;i < 10;++i)
			mods[nums[i] % 42]=1;
		int count = 0;
		for(int i = 0;i < 42;++i)
			if(mods[i]==1)	count++;
		System.out.println(count);
		input.close();
	}
}
