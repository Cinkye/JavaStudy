import java.util.*;

public class CheckingAccount extends Account
{
	private double overdraftProtection;
	
	public CheckingAccount(double balance)
	{
		super(1,balance);
	}
	
	public CheckingAccount(double balance, double protect)
	{
		super(1,balance);
		overdraftProtection = protect;
	}
	
	public boolean withdraw(double amt)
	{
		if(balance >= amt)
		{
			super.withdraw(amt);
			return true;
		}
		else if(balance + overdraftProtection >= amt)
		{
			balance = 0;
			overdraftProtection = balance + overdraftProtection - amt;
			return true;
		}
		else
			return false;
	}
	public double getOverdraftProtection()
	{
		return overdraftProtection;
	}
}