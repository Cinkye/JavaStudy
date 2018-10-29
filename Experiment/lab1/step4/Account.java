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
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public void withdraw(double amount)
	{
		balance -= amount;
	}
}