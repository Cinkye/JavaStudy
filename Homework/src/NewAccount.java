import java.util.*;

class Transaction
{
	private Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	public Transaction(char t, double a, double b, String d)
	{
		type = t;
		amount = a;
		balance = b;
		description = d;
	}
}

public class NewAccount extends Account
{
	private String name;
	private ArrayList<Transaction> transactions;

	public NewAccount(String n, int i, double b)
	{
		super(i, b);
		name = n;
	}
	
	public void withdraw(double amt)
	{
		if(amt <= super.getBalance())
		{
			setBalance(getBalance() - amt);
			System.out.println("Withdraw: " + amt);
			transactions.add(new Transaction('W',amt,getBalance(),"Withdraw: " + amt));
		}
		else
			System.out.println("Balance not enough.");
	}
	
	public void deposit(double amt)
	{
		System.out.println("Deposit: " + amt);
		setBalance(getBalance() + amt);
		transactions.add(new Transaction('D',amt,getBalance(),"Deposit: " + amt));
	}
}
