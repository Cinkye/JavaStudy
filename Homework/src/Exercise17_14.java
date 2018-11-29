import java.io.*;

public class Exercise17_14
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream target = new FileOutputStream(args[1], true);
		DataOutputStream out = new DataOutputStream(target);
		FileInputStream source = new FileInputStream(args[0]);
		DataInputStream in = new DataInputStream(source);
		int filebytes = in.available();
		for (int j = 0; j < filebytes; ++j)
			out.write(in.read() + 5);
		source.close();
		in.close();
		target.close();
		out.close();
	}
}
