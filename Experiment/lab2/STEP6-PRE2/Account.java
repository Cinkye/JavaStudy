import java.util.*;
import java.math.*;

public class Account
{
	private int id;
	protected double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	public Account()
	{
		id = 0;
		balance = 0;
		annualInterestRate =0;
	}
	
	public Account (int id, double balance)
	{
		this.id = id;
		this.balance = balance;
		annualInterestRate = 0;
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
		return Math.pow(getAnnualInterestRate(), 1/12);
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
