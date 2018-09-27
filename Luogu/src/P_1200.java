import java.util.*;
public class P_1200
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String star = input.nextLine();
	    String team = input.nextLine();
	    int teamSum = 1;
	    int starSum = 1;
	    int teamLength = team.length();
	    int starLength = star.length();
	    for(int i = 0;i<teamLength;++i)
	        teamSum *= ((int)team.charAt(i)-64);
	    for(int i = 0;i<starLength;++i)
	        starSum *= ((int)star.charAt(i)-64);
	    if(teamSum % 47 == starSum % 47)
	    	System.out.println("GO");
	    else
	    	System.out.println("STAY");
	}
}
