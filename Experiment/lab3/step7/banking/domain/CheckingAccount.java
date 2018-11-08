package banking.domain;
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
	
	public void withdraw(double amt) throws OverdraftException
	{
		if(balance >= amt)
		{
			super.withdraw(amt);
		}
		else if(balance + overdraftProtection >= amt)
		{
			overdraftProtection = balance + overdraftProtection - amt;
			double tmp = balance;
			balance = 0;
			throw new OverdraftException("Insufficient funds for overdraft protection",amt-tmp);
		}
		else
		{
			double tmp = balance;
			balance = 0;
			throw new OverdraftException("Insufficient funds for overdraft protection",amt-tmp-overdraftProtection);
		}
	}
	public double getOverdraftProtection()
	{
		return overdraftProtection;
	}
}