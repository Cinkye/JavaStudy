import java.io.*;

public class Exercise17_12
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream target = new FileOutputStream(args[args.length - 1], true);
		DataOutputStream out = new DataOutputStream(target);
//		System.out.println(args.length);
		for (int i = 0; i < args.length - 1; ++i)
		{
			FileInputStream source = new FileInputStream(args[i]);
			DataInputStream in = new DataInputStream(source);
			int filebytes = in.available();
			for (int j = 0; j < filebytes; ++j)
				out.write(in.read());
			source.close();
			in.close();
		}
		target.close();
	}
}
