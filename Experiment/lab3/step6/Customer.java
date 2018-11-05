import java.util.*;

import javax.security.auth.login.AccountException;

public class Customer inplements Comparable
{
	private ArrayList list;
	private String lastName;
	private String firstName;

	public Customer(String f, String l) 
	{
		lastName = l;
		firstName = f;
        list = new ArrayList();
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}

	public void addAccount(Account ac)
	{
		list.add(ac);
	}

	public Account getAccount(int i)
	{
		return (Account)list.get(i);
	}

	public int getNumOfAccounts()
	{
		return list.size();
	}
	
	public int compareTo(Customer cus)
	{
		return firstName.compareTo(cus.getFirstName());
	}
}