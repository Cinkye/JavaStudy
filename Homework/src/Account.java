import java.util.*;
public class Account
{
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;
	
	public Account()
	{
		
	}
	
	public Account(int i,double bal)
	{
		id = i;
		balance = bal;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public double getMonthlyInterestRate()
	{
		return Math.pow(annualInterestRate, 1*12);
	}
	
	public double getMonthlyInterest()
	{
		return getMonthlyInterestRate() * balance;
	}
	
	public void withdraw(double amt)
	{
		if(amt <= balance)
		{
			balance -= amt;
			System.out.println("Withdraw: " + amt);
		}
		else
			System.out.println("Balance not enough.");
	}
	
	public void deposit(double amt)
	{
		System.out.println("Deposit: " + amt);
		balance += amt;
	}
}
