package banking.domain;
import java.util.*;

public class Bank
{
	private Customer[] customer;
	private int numberOfCustomers;
	public static Bank bankInstance = new Bank();

	private Bank()
	{
		numberOfCustomers = 0;
		customer = new Customer[5];
	}

	public static Bank getBank()
	{
		return bankInstance;
	}

	public void addCustomer(String f,String l)
	{
		customer[numberOfCustomers] = new Customer(f,l);
		numberOfCustomers++;
	}
	
	public int getNumOfCustomers()
	{
		return numberOfCustomers;
	}
	
	public Customer getCustomer(int index)
	{
		return customer[index];
	}
}