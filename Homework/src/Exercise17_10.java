import java.io.*;

public class Exercise17_10
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 2)
		{
			System.out.println("Usage: java Exercise17_10 SourceFile NumberOfPieces");
			return;
		}

		FileInputStream source = new FileInputStream(args[0]);
		DataInputStream in = new DataInputStream(source);
		int part = Integer.valueOf(args[1]).intValue();
		int size = (int) Math.ceil(source.available() / part);

		try
		{
			for (int i = 0; i < part; ++i)
			{
				FileOutputStream out = new FileOutputStream(args[0] + "." + (i + 1));
				DataOutputStream o = new DataOutputStream(out);
				for (int j = 0; j <= size; ++j)
				{
					o.write(in.read());
				}
				out.close();
			}
		} catch (Exception ex)
		{

		}
		source.close();
	}
}
