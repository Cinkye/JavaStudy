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
import javafx.application.*;

public class MainWindow extends JFrame
{
	// Specify the size of five string fields in the record
	final static int FIRST_NAME_SIZE = 20;
	final static int LAST_NAME_SIZE = 20;
	final static int RECORD_SIZE = (FIRST_NAME_SIZE + LAST_NAME_SIZE);
	
	// Access address.dat using RandomAccessFile
	private RandomAccessFile raf;
	
	// Text fields
	private JTextField jtfFirstName = new JTextField(FIRST_NAME_SIZE);
	private JTextField jtfLastName = new JTextField(LAST_NAME_SIZE);
	
	// Buttons
	private JButton jbtAdd = new JButton("ADD");
	private JButton jbtDelete = new JButton("DEL");
	private JButton jbtSearch = new JButton("PREV");
	private JButton jbtSort = new JButton("SORT");

	// Customer Lists
	private DefaultListModel model = new DefaultListModel();
	private JList jlCustomer = new JList(model);
	
	
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

		// Panel p1 for holding labels customers List
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JLabel("Customers List"),BorderLayout.CENTER);
	
		JPanel list = new JPanel();
		list.setLayout(new BorderLayout());
		list.add(jlCustomer,BorderLayout.CENTER);
		
		// Panel list for holding jtfName, jtfStreet, and p3
		JPanel combined = new JPanel();
		combined.setLayout(new BorderLayout());
		combined.add(p1,BorderLayout.NORTH);
		combined.add(list,BorderLayout.CENTER);
				
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
		
		// Panel p2 for holding jpState and jpZip
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4,1));
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

		// Panel p3 for holding jtfCity and p2
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2,1));
		p3.add(p2);
		p3.add(jpButton);
				
		// Set the panel with line border
		combined.setBorder(new BevelBorder(BevelBorder.RAISED));
		p3.setBorder(new BevelBorder(BevelBorder.RAISED));
				
		// Add jpAddress and jpButton to the frame
		add(combined, BorderLayout.WEST);
		add(p3, BorderLayout.EAST);
		
		// Add customers to jlCustomer
		Bank bank = Bank.getBank();
		for(int i = 0;i < bank.getNumOfCustomers();++i)
		{
			model.addElement(bank.getCustomer(i).getFirstName() + " " + bank.getCustomer(i).getLastName());
		}
		
		
		jbtAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				writeCustomer();
				bank.addCustomer(jtfFirstName.getText(),jtfLastName.getText());
				String fn = jtfFirstName.getText().replaceAll(" ", "");
				String ln = jtfLastName.getText().replaceAll(" ", "");
				model.addElement(fn + " " + ln);
			}
		});
		
		jlCustomer.addListSelectionListener(new ListSelectionListener()
		{
			
			public void valueChanged(ListSelectionEvent e)
			{
				try
				{
					readCustomer(jlCustomer.getSelectedIndex() * RECORD_SIZE * 2);
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		jbtDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				bank.removeCustomer(jlCustomer.getSelectedIndex());
				model.removeAllElements();
				for(int i = 0;i < bank.getNumOfCustomers();++i)
					model.addElement(bank.getCustomer(i).getFirstName() + " " + bank.getCustomer(i).getLastName());
				try
				{
					if (raf.length() > 0)
						readCustomer(0);
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		jbtSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					long currentPosition = raf.getFilePointer();
					if (currentPosition < raf.length())
						readCustomer(currentPosition);
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		jbtSort.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					long currentPosition = raf.getFilePointer();
					if (currentPosition - 2 * RECORD_SIZE > 0)
						// Why 2 * 2 * RECORD_SIZE? See the follow-up remarks
						readCustomer(currentPosition - 2 * 2 * RECORD_SIZE);
					else
						readCustomer(0);
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});

		// Display the first record if exists
		try
		{
			if (raf.length() > 0)
				readCustomer(0);
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

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

	/** Read a record at the specified position */
	public void readCustomer(long position) throws IOException
	{
		raf.seek(position);
		String FirstName = FixedLengthStringIO.readFixedLengthString(FIRST_NAME_SIZE, raf);
		String LastName = FixedLengthStringIO.readFixedLengthString(LAST_NAME_SIZE, raf);

		jtfFirstName.setText(FirstName);
		jtfLastName.setText(LastName);
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

