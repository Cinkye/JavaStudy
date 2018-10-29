import java.util.*;

public class Account
{
	private double balance;
	
	Account(double init_balance)
	{
		balance = init_balance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public boolean deposit(double amt)
	{
		balance += amt;
		return true;
	}
	
	public boolean withdraw(double amt)
	{
		if(balance >= amt)
		{
			balance -= amt;
			return true;
		}
		return false;
	}
}