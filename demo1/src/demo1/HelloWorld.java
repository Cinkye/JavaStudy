package demo1;
import java.util.Scanner;
class Test
{
	public static void test(String[] args)
	{
		int i;
		Scanner test = new Scanner(System.in);
		i = test.nextInt();
		System.out.println(i);
	}
}

public class HelloWorld 
{
	public static void main(String[] args)
	{
		System.out.println("Hello world!");
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		System.out.println(test);
		long time = System.currentTimeMillis();
		System.out.println("Current time is "+time);
		Test demo = new Test();
		demo.test(null);
	}
}


