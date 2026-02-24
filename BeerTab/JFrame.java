
//	Just a package to include our GUI:
package windowBuilder.views;

//	Packages that includes methods for building the GUI:
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Image;
import java.io.*;
import java.lang.reflect.Method;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JFrame extends javax.swing.JFrame 
{
	//	Instance variables:
	private JPanel ctpMain;
	private JTextField txtWelcomeToBeernet;
	private JTextField txtWhatsOnTap;
	private JTextField txtFirstName;
	private JLabel lblFirstname;
	private JLabel lblLastname;
	private JTextField txtLastName;
	private JButton btnNewcastle;
	private JButton btnCarlsberg;
	private JButton btnRegister;

	/**
	 * Launch the application via the main method:
	 */
	public static void main(String[] args) throws NullPointerException
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					JFrame frame = new JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Jframe.
	 * @throws IOException 
	 */
	public JFrame() throws IOException, NullPointerException
	{
		//	Initialize and create components and create events:
		initComponents();
		createEvents();
	}
	
	/**
	This method is used for creating and initializing components:
	 * @throws IOException 
	*/
	private void initComponents() throws IOException, NullPointerException
	{	
		setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		setTitle("BeerNet");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 410);
		ctpMain = new JPanel();
		ctpMain.setBackground(new Color(107, 142, 35));
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		
		//	Textfield for title:
		txtWelcomeToBeernet = new JTextField();
		txtWelcomeToBeernet.setBounds(67, 13, 440, 34);
		txtWelcomeToBeernet.setEditable(false);
		txtWelcomeToBeernet.setBackground(new Color(205, 133, 63));
		txtWelcomeToBeernet.setFont(new Font("Kefa", Font.PLAIN, 20));
		txtWelcomeToBeernet.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeToBeernet.setText("Welcome to BeerNet!🍺");
		txtWelcomeToBeernet.setColumns(10);
		
		btnNewcastle = new JButton("Newcastle");
		btnNewcastle.setBounds(67, 94, 440, 44);
		btnNewcastle.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewcastle.setIcon(new ImageIcon(JFrame.class.getResource("/windowBuilder/resources/Newcastle_United_32x32.svg.png")));
		btnNewcastle.setForeground(new Color(0, 0, 128));
		
		//	Welcome message for client:
		txtWhatsOnTap = new JTextField();
		txtWhatsOnTap.setBounds(67, 59, 440, 29);
		txtWhatsOnTap.setEditable(false);
		txtWhatsOnTap.setBackground(new Color(205, 133, 63));
		txtWhatsOnTap.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtWhatsOnTap.setHorizontalAlignment(SwingConstants.CENTER);
		txtWhatsOnTap.setText("What's on tap?");
		txtWhatsOnTap.setColumns(10);
		btnNewcastle.setSelectedIcon(new ImageIcon(JFrame.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		btnNewcastle.setBackground(new Color(0, 0, 255));
		
		btnCarlsberg = new JButton("Carlsberg");
		btnCarlsberg.setBounds(67, 143, 440, 44);
		
		btnCarlsberg.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCarlsberg.setIcon(new ImageIcon(JFrame.class.getResource("/windowBuilder/resources/carlsberg_32x32.png")));
		btnCarlsberg.setForeground(new Color(0, 0, 128));
		
		lblFirstname = new JLabel("Firstname:");
		lblFirstname.setBackground(new Color(255, 255, 255));
		lblFirstname.setBounds(81, 217, 66, 16);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(159, 212, 130, 26);
		txtFirstName.setColumns(10);
		
		lblLastname = new JLabel("Lastname:");
		lblLastname.setBounds(83, 245, 64, 16);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(159, 244, 130, 26);
		txtLastName.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(194, 280, 95, 29);
		ctpMain.setLayout(null);
		ctpMain.add(txtWelcomeToBeernet);
		ctpMain.add(txtWhatsOnTap);
		ctpMain.add(btnNewcastle);
		ctpMain.add(btnCarlsberg);
		ctpMain.add(btnRegister);
		ctpMain.add(lblFirstname);
		ctpMain.add(txtFirstName);
		ctpMain.add(txtLastName);
		ctpMain.add(lblLastname);
	}
	 
	/**
	This method is used for creating events:
	*/
	private void createEvents()
	{
		//	Event for carlsberg button:
		btnCarlsberg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Carlsberg selected!");
			}
		});
		
		//	Event for newcastle button:
		btnNewcastle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Newcastle selected!");
			}
		});
		
		//	Event for Register button:
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, 
						"You've been registered: " + txtFirstName.getText() + " " + txtLastName.getText());
			}
		});
	}
}
