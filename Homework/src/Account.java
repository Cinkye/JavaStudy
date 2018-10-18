import java.util.*;
import java.math.*;

public class Account
{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	public Account()
	{
		id = 0;
		balance = 0;
		annualInterestRate =0;
	}
	
	public (int id, double balance)
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

	public void withDraw(double withdraw)
	{
		balance -= withdraw;
	}
	
	public void deposit(double deposit) 
	{
		balance += deposit;
	}
}
