package banking;
import java.util.*;

import javax.security.auth.login.AccountException;

public class Customer 
{
	private Account account;
	private String lastName;
	private String firstName;

	public Customer(String f, String l) 
	{
		lastName = l;
		firstName = f;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setAccount(Account acct)
	{
		account = acct;
	}
	
	public Account getAccount()
	{
		return account;
	}
}