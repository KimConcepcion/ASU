package windowBuilder.ui;

import common.Beer;
import common.Person;
import common.beerType;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Calendar;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.FlowLayout;

//	Since we inherit from JPanel we can refer to the object itself by using the this keyword:
public class My_Widget extends JPanel
{	
	//	Class with user operations:
	Beer beer = new Beer();
	Person person = new Person();
	
	//	Table:
	DefaultTableModel model = new DefaultTableModel();
		
	private JTextField txtTap;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JButton btnNewcastle_add;
	private JButton btnCarlsberg_add;
	private JButton btnRegister;
	private JTextField txtAmountCB2;
	private JTextField txtAmountNC2;
	private JTextField textDate;
	private JPanel infoPane;
	private JTextField txtDetails;
	private JPanel selectPane;
	private JButton btnNewcastle_sub;
	private JButton btnCarlsberg_sub;
	private JTextField txtTime;
	private JButton btnTuborg_add;
	private JButton btnTuborg_sub;
	private JPanel timePanel;
	private JPanel userPane;
	private JTextField txtAmountNC1;
	private JTextField txtAmountCB1;
	private JTextField txtAmountTB1;
	private JTextField txtAmountTB2;
	private JTextField txtPrice;
	private JTextField txtTotalPrice;
	private JTextField txtAmount;
	private JTextField txtAmountInfo;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtPhone;
	private JTextField txtPhoneIn;
	private JTextField txtUsers;
	private JTextField txtUser;
	private JTable userTable;
	private JButton btnSaveList;
	
	public My_Widget() throws IOException, NullPointerException
	{
		//	Build and create events:
		initComponents();
		createEvents();
	}

	/**
	This method is used for creating and initializing components:
	 * @throws IOException 
	*/
	public void initComponents() throws IOException, NullPointerException
	{		
		this.setBounds(0, 0, 1300, 500);
		this.setBackground(Color.LIGHT_GRAY);
		
		JPanel titlePane = new JPanel();
		titlePane.setBounds(0, 0, 600, 30);
		setLayout(null);
		add(titlePane);
		titlePane.setLayout(null);
		
		//	Welcome message for client:
		txtTap = new JTextField();
		txtTap.setBounds(0, 0, 454, 30);
		titlePane.add(txtTap);
		txtTap.setForeground(Color.WHITE);
		txtTap.setEditable(false);
		txtTap.setBackground(Color.DARK_GRAY);
		txtTap.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtTap.setHorizontalAlignment(SwingConstants.LEFT);
		txtTap.setText("What's on tap?");
		txtTap.setColumns(33);
		
		txtDetails = new JTextField();
		txtDetails.setBounds(454, 0, 145, 30);
		txtDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtDetails.setForeground(Color.WHITE);
		txtDetails.setBackground(Color.DARK_GRAY);
		txtDetails.setText("Details:");
		txtDetails.setEditable(false);
		titlePane.add(txtDetails);
		
		infoPane = new JPanel();
		infoPane.setBackground(Color.LIGHT_GRAY);
		infoPane.setBounds(452, 30, 148, 440);
		add(infoPane);
		infoPane.setLayout(null);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPrice.setForeground(Color.WHITE);
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBackground(Color.GRAY);
		txtPrice.setBounds(0, 402, 148, 37);
		infoPane.add(txtPrice);
		
		txtAmountCB2 = new JTextField();
		txtAmountCB2.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAmountCB2.setForeground(Color.WHITE);
		txtAmountCB2.setHorizontalAlignment(SwingConstants.LEFT);
		txtAmountCB2.setBackground(Color.GRAY);
		txtAmountCB2.setBounds(0, 125, 148, 50);
		infoPane.add(txtAmountCB2);
		txtAmountCB2.setEditable(false);
		txtAmountCB2.setColumns(10);
		
		txtAmountNC2 = new JTextField();
		txtAmountNC2.setForeground(Color.WHITE);
		txtAmountNC2.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAmountNC2.setHorizontalAlignment(SwingConstants.LEFT);
		txtAmountNC2.setBackground(Color.GRAY);
		txtAmountNC2.setBounds(0, 38, 148, 50);
		infoPane.add(txtAmountNC2);
		txtAmountNC2.setEditable(false);
		txtAmountNC2.setColumns(10);
		
		txtAmountTB2 = new JTextField();
		txtAmountTB2.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAmountTB2.setForeground(Color.WHITE);
		txtAmountTB2.setHorizontalAlignment(SwingConstants.LEFT);
		txtAmountTB2.setEditable(false);
		txtAmountTB2.setColumns(10);
		txtAmountTB2.setBackground(Color.GRAY);
		txtAmountTB2.setBounds(0, 210, 148, 50);
		infoPane.add(txtAmountTB2);
		
		txtTotalPrice = new JTextField();
		txtTotalPrice.setText("Total Price [DKK]:");
		txtTotalPrice.setForeground(Color.WHITE);
		txtTotalPrice.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setBackground(Color.DARK_GRAY);
		txtTotalPrice.setBounds(0, 363, 148, 40);
		infoPane.add(txtTotalPrice);
		
		txtAmountNC1 = new JTextField();
		txtAmountNC1.setForeground(new Color(255, 255, 255));
		txtAmountNC1.setBackground(Color.DARK_GRAY);
		txtAmountNC1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtAmountNC1.setText("xNewcastle:");
		txtAmountNC1.setHorizontalAlignment(SwingConstants.LEFT);
		txtAmountNC1.setEditable(false);
		txtAmountNC1.setBounds(0, 0, 148, 40);
		infoPane.add(txtAmountNC1);
		txtAmountNC1.setColumns(10);
		
		txtAmountCB1 = new JTextField();
		txtAmountCB1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtAmountCB1.setForeground(Color.WHITE);
		txtAmountCB1.setBackground(Color.DARK_GRAY);
		txtAmountCB1.setText("xCarlsberg:");
		txtAmountCB1.setEditable(false);
		txtAmountCB1.setColumns(10);
		txtAmountCB1.setBounds(0, 85, 148, 40);
		infoPane.add(txtAmountCB1);
		
		txtAmountTB1 = new JTextField();
		txtAmountTB1.setText("xTuborg:");
		txtAmountTB1.setForeground(Color.WHITE);
		txtAmountTB1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtAmountTB1.setEditable(false);
		txtAmountTB1.setColumns(10);
		txtAmountTB1.setBackground(Color.DARK_GRAY);
		txtAmountTB1.setBounds(0, 175, 148, 40);
		infoPane.add(txtAmountTB1);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAmount.setForeground(Color.WHITE);
		txtAmount.setBounds(0, 299, 148, 65);
		infoPane.add(txtAmount);
		txtAmount.setHorizontalAlignment(SwingConstants.LEFT);
		txtAmount.setEditable(false);
		txtAmount.setColumns(10);
		txtAmount.setBackground(Color.GRAY);
		
		txtAmountInfo = new JTextField();
		txtAmountInfo.setText("Total amount:");
		txtAmountInfo.setForeground(Color.WHITE);
		txtAmountInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtAmountInfo.setEditable(false);
		txtAmountInfo.setColumns(10);
		txtAmountInfo.setBackground(Color.DARK_GRAY);
		txtAmountInfo.setBounds(0, 260, 148, 40);
		infoPane.add(txtAmountInfo);
		
		selectPane = new JPanel();
		selectPane.setBounds(0, 30, 452, 120);
		add(selectPane);
		selectPane.setLayout(null);
		
		btnNewcastle_add = new JButton("Newcastle - 10 kr (+)");
		btnNewcastle_add.setBounds(0, 0, 226, 40);
		btnNewcastle_add.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewcastle_add.setAlignmentX(Component.RIGHT_ALIGNMENT);
		selectPane.add(btnNewcastle_add);
		btnNewcastle_add.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewcastle_add.setIcon(new ImageIcon(GUI.class.getResource("/windowBuilder/resources/Newcastle_United_32x32.svg.png")));
		btnNewcastle_add.setForeground(Color.BLACK);
		btnNewcastle_add.setSelectedIcon(new ImageIcon(GUI.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		btnNewcastle_add.setBackground(Color.ORANGE);
		
		btnNewcastle_sub = new JButton("Newcastle - 10 kr (-)");
		btnNewcastle_sub.setIcon(new ImageIcon(My_Widget.class.getResource("/windowBuilder/resources/Newcastle_United_32x32.svg.png")));
		btnNewcastle_sub.setForeground(Color.BLACK);
		btnNewcastle_sub.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewcastle_sub.setBackground(Color.ORANGE);
		btnNewcastle_sub.setAlignmentY(0.0f);
		btnNewcastle_sub.setAlignmentX(1.0f);
		btnNewcastle_sub.setBounds(226, 0, 226, 40);
		selectPane.add(btnNewcastle_sub);
		
		btnCarlsberg_add = new JButton("Carlsberg - 20 kr (+)");
		btnCarlsberg_add.setBackground(Color.ORANGE);
		btnCarlsberg_add.setBounds(0, 40, 226, 40);
		selectPane.add(btnCarlsberg_add);
		
		btnCarlsberg_add.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCarlsberg_add.setIcon(new ImageIcon(GUI.class.getResource("/windowBuilder/resources/carlsberg_32x32.png")));
		btnCarlsberg_add.setForeground(Color.BLACK);
		
		btnCarlsberg_sub = new JButton("Carlsberg - 20 kr (-)");
		btnCarlsberg_sub.setIcon(new ImageIcon(My_Widget.class.getResource("/windowBuilder/resources/carlsberg_32x32.png")));
		btnCarlsberg_sub.setBackground(Color.ORANGE);
		btnCarlsberg_sub.setForeground(Color.BLACK);
		btnCarlsberg_sub.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCarlsberg_sub.setBounds(226, 40, 226, 40);
		selectPane.add(btnCarlsberg_sub);
		
		btnTuborg_add = new JButton("Tuborg - 35 kr (+)");
		btnTuborg_add.setIcon(new ImageIcon(My_Widget.class.getResource("/windowBuilder/resources/rsz_beer_groen_new.png")));
		btnTuborg_add.setForeground(Color.BLACK);
		btnTuborg_add.setFont(new Font("Dialog", Font.BOLD, 15));
		btnTuborg_add.setBackground(Color.ORANGE);
		btnTuborg_add.setAlignmentY(0.0f);
		btnTuborg_add.setAlignmentX(1.0f);
		btnTuborg_add.setBounds(0, 80, 226, 40);
		selectPane.add(btnTuborg_add);
		
		btnTuborg_sub = new JButton("Tuborg - 35 kr (-)");
		btnTuborg_sub.setIcon(new ImageIcon(My_Widget.class.getResource("/windowBuilder/resources/rsz_beer_groen_new.png")));
		btnTuborg_sub.setForeground(Color.BLACK);
		btnTuborg_sub.setFont(new Font("Dialog", Font.BOLD, 15));
		btnTuborg_sub.setBackground(Color.ORANGE);
		btnTuborg_sub.setAlignmentY(0.0f);
		btnTuborg_sub.setAlignmentX(1.0f);
		btnTuborg_sub.setBounds(226, 80, 226, 40);
		selectPane.add(btnTuborg_sub);
		
		timePanel = new JPanel();
		timePanel.setBounds(0, 470, 600, 30);
		add(timePanel);
		timePanel.setLayout(null);
		
		//	Date setup:
		textDate = new JTextField();
		textDate.setBounds(52, 0, 550, 30);
		timePanel.add(textDate);
		textDate.setHorizontalAlignment(SwingConstants.CENTER);
		textDate.setForeground(Color.WHITE);
		textDate.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		textDate.setBackground(Color.DARK_GRAY);
		textDate.setEditable(false);
		textDate.setColumns(10);
		textDate.setText(Calendar.getInstance().getTime().toString());
		
		txtTime = new JTextField();
		txtTime.setBounds(0, 0, 52, 30);
		timePanel.add(txtTime);
		txtTime.setText("Time:");
		txtTime.setForeground(Color.WHITE);
		txtTime.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		txtTime.setEditable(false);
		txtTime.setBackground(Color.DARK_GRAY);
		
		userPane = new JPanel();
		userPane.setBackground(Color.LIGHT_GRAY);
		userPane.setBounds(0, 150, 454, 320);
		add(userPane);
		userPane.setLayout(null);
		
		txtFirst = new JTextField();
		txtFirst.setEditable(false);
		txtFirst.setHorizontalAlignment(SwingConstants.LEFT);
		txtFirst.setForeground(Color.WHITE);
		txtFirst.setText("Firstname:");
		txtFirst.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		txtFirst.setBackground(Color.DARK_GRAY);
		txtFirst.setBounds(0, 0, 454, 30);
		userPane.add(txtFirst);
		txtFirst.setColumns(10);
		
		txtLast = new JTextField();
		txtLast.setEditable(false);
		txtLast.setText("Lastname:");
		txtLast.setHorizontalAlignment(SwingConstants.LEFT);
		txtLast.setForeground(Color.WHITE);
		txtLast.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		txtLast.setColumns(10);
		txtLast.setBackground(Color.DARK_GRAY);
		txtLast.setBounds(0, 60, 454, 30);
		userPane.add(txtLast);
		
		txtPhone = new JTextField();
		txtPhone.setText("Phone (for mobilepay):");
		txtPhone.setHorizontalAlignment(SwingConstants.LEFT);
		txtPhone.setForeground(Color.WHITE);
		txtPhone.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		txtPhone.setEditable(false);
		txtPhone.setColumns(10);
		txtPhone.setBackground(Color.DARK_GRAY);
		txtPhone.setBounds(0, 120, 454, 30);
		userPane.add(txtPhone);
		
		txtPhoneIn = new JTextField();
		txtPhoneIn.setHorizontalAlignment(SwingConstants.LEFT);
		txtPhoneIn.setColumns(10);
		txtPhoneIn.setBounds(0, 150, 454, 30);
		userPane.add(txtPhoneIn);
		
		txtFirstName = new JTextField();
		txtFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		txtFirstName.setBounds(0, 30, 454, 30);
		userPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(0, 90, 454, 30);
		userPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		btnSaveList = new JButton("Save list");
		btnSaveList.setForeground(Color.BLACK);
		btnSaveList.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnSaveList.setBackground(Color.ORANGE);
		btnSaveList.setBounds(0, 250, 454, 70);
		userPane.add(btnSaveList);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setBackground(Color.ORANGE);
		btnRegister.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnRegister.setBounds(0, 180, 454, 70);
		userPane.add(btnRegister);
		
		//	Initialize textfields:
		txtAmountCB2.setText(Integer.toString(person.xCarlsBerg));
		txtAmountNC2.setText(Integer.toString(person.xNewCastle));
		txtAmountTB2.setText(Integer.toString(person.xTuborg));
		txtAmount.setText(Integer.toString(person.quantity));
		txtPrice.setText(Double.toString(person.payment));
		
		JPanel guestPane = new JPanel();
		guestPane.setBackground(Color.GRAY);
		guestPane.setBounds(600, 0, 700, 500);
		add(guestPane);
		guestPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setForeground(Color.WHITE);
		txtUser.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		txtUser.setBackground(Color.DARK_GRAY);
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		txtUser.setText("Guest list:");
		txtUser.setEditable(false);
		txtUser.setBounds(0, 0, 700, 30);
		guestPane.add(txtUser);
		txtUser.setColumns(10);
		
		//	Text field for table layout:
		txtUsers = new JTextField();
		
		//	Table setup:
		userTable = new JTable(model);
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userTable.setBackground(Color.LIGHT_GRAY);
		userTable.setBounds(0, 30, 700, 470);
		guestPane.add(userTable);
			
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Lastname");
		model.addColumn("Phone");
		
		model.addColumn("Amount");
		model.addColumn("Price");
		model.addColumn("Newcastle");
		model.addColumn("Carlsberg");
		model.addColumn("Tuborg");
		
		Object[] rowData = {"ID", "Firstname", "Lastname", "Phone", "Amount", "Price", "Newcastle", "Carlsberg", "Tuborg"};
		model.addRow(rowData);
				
		userTable.setModel(model);
	}
	 
	/**
	This method is used for creating events:
	*/
	
	public void createEvents() throws IOException
	{
		//	################################################################################## Event for carlsberg button ##################################################################################
		btnCarlsberg_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				//	Add beer:
				person.bType = beerType.Carlsberg;
				person.addBeer(person.bType);
				person.setPayment();
				
				//	Update textfields:
				txtAmountCB2.setText(Integer.toString(person.xCarlsBerg));
				txtAmount.setText(Integer.toString(person.quantity));
				txtPrice.setText(Integer.toString(person.payment));
			}
		});
		
		btnCarlsberg_sub.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//	Remove beer:
				person.bType = beerType.Carlsberg;
				person.removeBeer(person.bType);
				person.setPayment();
				
				//	Update textfields:
				txtAmountCB2.setText(Integer.toString(person.xCarlsBerg));
				txtAmount.setText(Integer.toString(person.quantity));
				txtPrice.setText(Integer.toString(person.payment));
			}
		});
		
		//	################################################################################## Event for newcastle button ##################################################################################
		btnNewcastle_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//	Add beer:
				person.bType = beerType.NewCastle;
				person.addBeer(person.bType);
				person.setPayment();
				
				//	Update textfields:
				txtAmountNC2.setText(Integer.toString(person.xNewCastle));
				txtAmount.setText(Integer.toString(person.quantity));
				txtPrice.setText(Integer.toString(person.payment));
			}
		});
		
		btnNewcastle_sub.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//	Remove beer:
				person.bType = beerType.NewCastle;
				person.removeBeer(person.bType);
				person.setPayment();
				
				//	Update textfields:
				txtAmountNC2.setText(Integer.toString(person.xNewCastle));
				txtAmount.setText(Integer.toString(person.quantity));
				txtPrice.setText(Integer.toString(person.payment));
			}
		});
				
		//	################################################################################## Event for tuborg button ##################################################################################
		btnTuborg_add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//	Add beer:
				person.bType = beerType.Tuborg;
				person.addBeer(person.bType);
				person.setPayment();
				
				//	Update textfields:
				txtAmountTB2.setText(Integer.toString(person.xTuborg));
				txtAmount.setText(Integer.toString(person.quantity));
				txtPrice.setText(Integer.toString(person.payment));
			}
		});
		
		btnTuborg_sub.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//	Remove beer:
				person.bType = beerType.Tuborg;
				person.removeBeer(person.bType);
				person.setPayment();
				
				//	Update textfields:
				txtAmountTB2.setText(Integer.toString(person.xTuborg));
				txtAmount.setText(Integer.toString(person.quantity));
				txtPrice.setText(Integer.toString(person.payment));
			}
		});
		
		//		################################################################################## Event for register button ################################################################################
			btnRegister.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{			
					//Update ID:
					person.id += 1;
					
					//	Update table:
					Object[] userData = {person.id, txtFirstName.getText(), txtLastName.getText(), txtPhoneIn.getText(),  
							person.quantity, person.payment, person.xNewCastle, person.xCarlsBerg, person.xTuborg};
					
					model.addRow(userData);										
					userTable.setModel(model);
					
					//	Reset calculations:
					person.resetCalculations();
					
					//	Update textfields:
					txtAmountNC2.setText(Integer.toString(person.xNewCastle));
					txtAmountCB2.setText(Integer.toString(person.xCarlsBerg));
					txtAmountTB2.setText(Integer.toString(person.xTuborg));
					txtAmount.setText(Integer.toString(person.quantity));
					txtPrice.setText(Integer.toString(person.payment));
					txtFirstName.setText("");
					txtLastName.setText("");
					txtPhoneIn.setText("");
				}
			});	
			
			btnSaveList.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					
				}
					
			});
						
		//		################################################################################## Event for date field ##################################################################################
		ActionListener task = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//	Update time:
				textDate.setText(Calendar.getInstance().getTime().toString());
			}
		};
		
		Timer t = new Timer(1000, task);
		t.setRepeats(true);
		t.start();
	}
}
