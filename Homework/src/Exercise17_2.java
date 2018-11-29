import java.io.*;
public class Exercise17_2
{
	public static void main(String[] args)
	{
		try
		{
			FileOutputStream file = new FileOutputStream("Exercise17_02.dat",true);
			DataOutputStream in = new DataOutputStream(file);
			for(int i = 0;i < 100;++i)
			{
				in.writeInt((int)(Math.random()*100));
			}
			in.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
