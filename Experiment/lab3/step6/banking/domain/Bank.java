package banking.domain;
import java.util.*;

public class Bank
{
	private Customer[] customer;
	private int numberOfCustomers;
	public static Bank bankInstance = new Bank();

	public Bank()
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
	
	public void sortCustomers()
	{
		for(int i = 0;i < numberOfCustomers;++i)
			for(int j = i;j > 0;--j)
				if(customer[j].compareTo(customer[j-1]) < 0)
				{
					Customer tmp = customer[j];
					customer[j] = customer[j-1];
					customer[j-1] = tmp;
				}
	}
}