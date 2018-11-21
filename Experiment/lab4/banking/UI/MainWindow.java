package banking.UI;

import java.awt.*;
import banking.DAO.*;
import banking.domain.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.*;

public class MainWindow extends JFrame
{
	// Specify the size of five string fields in the record
	final static int FIRST_NAME_SIZE = 20;
	final static int LAST_NAME_SIZE = 20;
	final static int RECORD_SIZE = (FIRST_NAME_SIZE + LAST_NAME_SIZE);

	// Access address.dat using RandomAccessFile
	private RandomAccessFile raf;

	// ------------------------------- Window components
	// -------------------------------
	// Text fields
	private JTextField jtfFirstName = new JTextField(FIRST_NAME_SIZE);
	private JTextField jtfLastName = new JTextField(LAST_NAME_SIZE);

	// Buttons
	private JButton jbtAdd = new JButton("ADD");
	private JButton jbtDelete = new JButton("DEL");
	private JButton jbtSearch = new JButton("SEARCH");
	private JButton jbtSort = new JButton("SORT");

	// Customer Lists and the list model
	private DefaultListModel model = new DefaultListModel();
	private JList jlCustomer = new JList(model);

	// ------------------------------- End of window components
	// -------------------------------

	// The bank that links with the database
	Bank bank = Bank.getBank();

	public MainWindow()
	{
		// Open or create a random access file
		try
		{
			raf = new RandomAccessFile("bank.dat", "rw");
		} catch (IOException ex)
		{
			System.out.print("Error: " + ex);
			System.exit(0);
		}

		// ------------------------------- Puts the components together -------------------------------
		// Panel p1 for holding labels customers List
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JLabel("Customers List"), BorderLayout.CENTER);

		// Panel list for holding the customers List
		JPanel list = new JPanel();
		list.setLayout(new BorderLayout());
		list.add(jlCustomer, BorderLayout.CENTER);

		// Panel combiled for holding the label and the list
		JPanel combined = new JPanel();
		combined.setLayout(new BorderLayout());
		combined.add(p1, BorderLayout.NORTH);
		combined.add(list, BorderLayout.CENTER);

		// Panel jpFirstName for holding firstName
		JPanel jpFirstName = new JPanel();
		jpFirstName.setLayout(new BorderLayout());
		jpFirstName.add(new JLabel("FirstName"), BorderLayout.WEST);
		jpFirstName.add(jtfFirstName, BorderLayout.CENTER);

		// Panel jpLastname for holding lastName
		JPanel jpLastName = new JPanel();
		jpLastName.setLayout(new BorderLayout());
		jpLastName.add(new JLabel("LastName"), BorderLayout.WEST);
		jpLastName.add(jtfLastName, BorderLayout.CENTER);

		// Panel p2 for holding jpFirstName and jpLastName
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 1));
		p2.add(new JPanel());
		p2.add(jpFirstName);
		p2.add(new JPanel());
		p2.add(jpLastName);

		// Add buttons to a panel
		JPanel jpButton = new JPanel();
		jpButton.add(jbtAdd);
		jpButton.add(jbtDelete);
		jpButton.add(jbtSearch);
		jpButton.add(jbtSort);

		// Panel p3 for holding the name inputs and the buttons
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 1));
		p3.add(p2);
		p3.add(jpButton);

		// Set the panel with line border
		combined.setBorder(new BevelBorder(BevelBorder.RAISED));
		p3.setBorder(new BevelBorder(BevelBorder.RAISED));

		// Add everything above to the frame
		add(combined, BorderLayout.WEST);
		add(p3, BorderLayout.EAST);
		// ------------------------------- End of putting things together -------------------------------
		
		// ------------------------------- Initializing the program -------------------------------
		// Write the records in the file into the bank
		try
		{
			writeCustomerToBank();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
		// Write the customers in the bank to the list
		for (int i = 0; i < bank.getNumOfCustomers(); ++i)
		{
			model.addElement(bank.getCustomer(i).getLastName() + "," + bank.getCustomer(i).getFirstName());
		}
		// ------------------------------- Initializing finished -------------------------------
		
		// ------------------------------- Functions of the buttons and the list -------------------------------
		// Functions of the button add
		jbtAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				writeCustomer();	// Add the customer to the file
				bank.addCustomer(jtfFirstName.getText(), jtfLastName.getText());	// Add the customer to the bank
				String fn = jtfFirstName.getText().replaceAll(" ", "");
				String ln = jtfLastName.getText().replaceAll(" ", "");
				model.addElement(ln + "," + fn);	// Add the customer to the list
			}
		});

		// Functions when an item of the list is selected
		jlCustomer.addListSelectionListener(new ListSelectionListener()
		{

			public void valueChanged(ListSelectionEvent e)
			{
				if(bank.getNumOfCustomers() == 0)	// If no customer, the fields are empty
				{
					jtfFirstName.setText("");
					jtfLastName.setText("");
				}
				else if(jlCustomer.getSelectedIndex() == -1)	// Else if no customer is selected, the fields shows the last customer
				{
					int numberOfCustomer = bank.getNumOfCustomers();
					jtfFirstName.setText(bank.getCustomer(numberOfCustomer-1).getFirstName());
					jtfLastName.setText(bank.getCustomer(numberOfCustomer-1).getLastName());
				}
				else	// Some customer selected, show his info
				{
					jtfFirstName.setText(bank.getCustomer(jlCustomer.getSelectedIndex()).getFirstName());
					jtfLastName.setText(bank.getCustomer(jlCustomer.getSelectedIndex()).getLastName());
				}
			}
		});

		// Functions of the button delete
		jbtDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				bank.removeCustomer(jlCustomer.getSelectedIndex());	// Remove the customer in the bank
				model.removeAllElements();	// Clear the list
				for (int i = 0; i < bank.getNumOfCustomers(); ++i)	// Refill the list from the bank
					model.addElement(bank.getCustomer(i).getLastName() + "," + bank.getCustomer(i).getFirstName());
				try
				{
					ReorganizeTheFile();	// Clear the file and rewrite the file from the bank
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});

		// Functions of the button search, if some customer in the bank match the inputs, highlight the item in the list
		jbtSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int index = bank.searchCustomers(jtfFirstName.getText(), jtfLastName.getText());
				if(index != -1)
					jlCustomer.setSelectedIndex(index);
			}
		});
		
		// Cinkye 201730684427
		// Functions of the buttom sort
		jbtSort.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				bank.sortCustomers();	// Sort the customers in the bank
				model.removeAllElements();	// Clear the list and re-write it from the bank
				for (int i = 0; i < bank.getNumOfCustomers(); ++i)
					model.addElement(bank.getCustomer(i).getLastName() + "," + bank.getCustomer(i).getFirstName());
				try
				{
					ReorganizeTheFile();	// Clear the file and re-write it from the bank
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});

		// Display the first record if exists
		if(bank.getNumOfCustomers()!=0)
		{
			jtfFirstName.setText(bank.getCustomer(0).getFirstName());
			jtfLastName.setText(bank.getCustomer(0).getLastName());
		}
			
	}

	// ------------------------------- End of functions of the buttons and the list -------------------------------
	// Cinkye 201730684427
	/** Write a record at the end of the file */
	public void writeCustomer()
	{
		try
		{
			raf.seek(raf.length());
			FixedLengthStringIO.writeFixedLengthString(jtfFirstName.getText(), FIRST_NAME_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(jtfLastName.getText(), LAST_NAME_SIZE, raf);
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	/* Read a record at the specified position */
	public void readCustomer(long position) throws IOException
	{
		raf.seek(position);
		String FirstName = FixedLengthStringIO.readFixedLengthString(FIRST_NAME_SIZE, raf);
		String LastName = FixedLengthStringIO.readFixedLengthString(LAST_NAME_SIZE, raf);

		jtfFirstName.setText(FirstName);
		jtfLastName.setText(LastName);
	}

	// Clear the file and re-write it from the bank
	// It is used to delete some specific customer
	public void ReorganizeTheFile() throws IOException
	{
		// Clear it
		File file = new File("bank.dat");
		try
		{
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		// And re-write it
		for (int i = 0; i < bank.getNumOfCustomers(); ++i)
		{
			try
			{
				raf.seek(raf.length());
				FixedLengthStringIO.writeFixedLengthString(bank.getCustomer(i).getFirstName(), FIRST_NAME_SIZE, raf);
				FixedLengthStringIO.writeFixedLengthString(bank.getCustomer(i).getLastName(), LAST_NAME_SIZE, raf);
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	// Write the customers to the bank
	public void writeCustomerToBank() throws IOException
	{
		int length = 0;
		try
		{
			length = (int) raf.length();
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
		for (int i = 0; i < length / 2 / RECORD_SIZE; ++i)
		{
			raf.seek(i * 2 * RECORD_SIZE);
			String FirstName = FixedLengthStringIO.readFixedLengthString(FIRST_NAME_SIZE, raf).replaceAll(" ", "");
			String LastName = FixedLengthStringIO.readFixedLengthString(LAST_NAME_SIZE, raf).replaceAll(" ", "");
			bank.addCustomer(FirstName, LastName);
		}
	}

	public static void main(String[] args)
	{
		MainWindow frame = new MainWindow();
		frame.pack();
		frame.setTitle("Bank");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
