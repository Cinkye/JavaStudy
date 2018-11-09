package banking.domain;
import java.util.*;

public class SavingsAccount extends Account

{
	private double interestRate;
	
	public SavingsAccount(double balance, double interest_rate)
	{
		super(1,balance);
		interestRate = interest_rate;
	}
	
	public void withdraw(double amt) throws OverdraftException
	{
		if(balance >= amt)
		{
			balance -= amt;
		}
		else
			throw new OverdraftException("No overdraft protection",amt);
	}
}