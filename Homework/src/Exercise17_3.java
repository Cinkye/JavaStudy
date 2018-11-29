import java.io.*;
import java.util.*;
public class Exercise17_3
{
	public static void main(String[] args)
	{
		try
		{
			FileInputStream file = new FileInputStream("Exercise17_02.dat");
			DataInputStream in = new DataInputStream(file);
			int sum = 0;
			while(true)
			{
				try 
				{
					sum += in.readInt();
				}
				catch(Exception ex)
				{
					break;
				}
			}
			System.out.println(sum);
			in.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
