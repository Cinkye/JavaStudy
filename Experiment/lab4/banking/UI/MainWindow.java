package banking.UI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import javafx.application.*;

public class MainWindow extends JFrame
{
	// Specify the size of five string fields in the record
	final static int FIRST_NAME_SIZE = 20;
	final static int LAST_NAME_SIZE = 20;
	
	// Access address.dat using RandomAccessFile
	private RandomAccessFile raf;
	
	// Text fields
	private JTextField jtfFirstName = new JTextField(FIRST_NAME_SIZE);
	private JTextField jtfLastName = new JTextField(LAST_NAME_SIZE);
	
	// Buttons
	private JButton jbtAdd = new JButton("ADD");
	private JButton jbtDelete = new JButton("DEL");
	private JButton jbtSearch = new JButton("SEARCH");
	private JButton jbtSort = new JButton("Sort");

	// Customer Lists
	private JList jlCustomer = new JList();
	
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
		
		/*
		
		
		
		
		
		// Place p1 and p4 into jpAddress
		JPanel jpAddress = new JPanel(new BorderLayout());
		jpAddress.add(p1, BorderLayout.WEST);
		jpAddress.add(p2, BorderLayout.CENTER);
		*/
				
		// Set the panel with line border
		//jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));
		
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
				
		// Add jpAddress and jpButton to the frame
		add(combined, BorderLayout.WEST);
		add(p3, BorderLayout.EAST);
	}
		/*
		jbtAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				writeAddress();
			}
		});
		jbtFirst.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					if (raf.length() > 0)
						readAddress(0);
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		jbtNext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					long currentPosition = raf.getFilePointer();
					if (currentPosition < raf.length())
						readAddress(currentPosition);
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		jbtPrevious.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					long currentPosition = raf.getFilePointer();
					if (currentPosition - 2 * RECORD_SIZE > 0)
						// Why 2 * 2 * RECORD_SIZE? See the follow-up remarks
						readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
					else
						readAddress(0);
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		jbtLast.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					long lastPosition = raf.length();
					if (lastPosition > 0)
						// Why 2 * RECORD_SIZE? See the follow-up remarks
						readAddress(lastPosition - 2 * RECORD_SIZE);
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
				readAddress(0);
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	*//** Write a record at the end of the file *//*
	public void writeAddress()
	{
		try
		{
			raf.seek(raf.length());
			FixedLengthStringIO.writeFixedLengthString(jtfName.getText(), NAME_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(jtfStreet.getText(), STREET_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(jtfCity.getText(), CITY_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(jtfState.getText(), STATE_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(jtfZip.getText(), ZIP_SIZE, raf);
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	*//** Read a record at the specified position *//*
	public void readAddress(long position) throws IOException
	{
		raf.seek(position);
		String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf);
		String street = FixedLengthStringIO.readFixedLengthString(STREET_SIZE, raf);
		String city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE, raf);
		String state = FixedLengthStringIO.readFixedLengthString(STATE_SIZE, raf);
		String zip = FixedLengthStringIO.readFixedLengthString(ZIP_SIZE, raf);

		jtfName.setText(name);
		jtfStreet.setText(street);
		jtfCity.setText(city);
		jtfState.setText(state);
		jtfZip.setText(zip);
	}*/

	public static void main(String[] args)
	{
		MainWindow frame = new MainWindow();
		frame.pack();
		frame.setTitle("Bank");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

