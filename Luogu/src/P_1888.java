import java.util.Scanner;
public class P_1888
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int max = Math.max(Math.max(a, b), c);
		int min = Math.min(Math.min(a, b), c);
		int gc = gcd(max,min);
		System.out.println(min/gc + "/" + max/gc);

	}
	public static int gcd(int a,int b)
	{
		if(b==0)
            return a;
        else
            return gcd(b,a%b);
	}
}
