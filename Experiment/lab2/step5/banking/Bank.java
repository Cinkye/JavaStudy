package banking;
import java.util.*;

public class Bank
{
	private Customer[] customer;
	private int numberOfCustomers;
	
	public Bank()
	{
		numberOfCustomers = 0;
		customer = new Customer[5];
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