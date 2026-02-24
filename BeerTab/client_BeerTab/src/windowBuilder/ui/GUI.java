package windowBuilder.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws NullPointerException 
	 */
	public GUI() throws NullPointerException, IOException 
	{
		setTitle("BeerTab");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 525);	//	<-- Position and size of window
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//	Instance of My_Widget class which contains the GUI elements:
		My_Widget mw1 = new My_Widget();
		mw1.setBounds(0, 0, 1300, 500);
		contentPane.add(mw1);
		mw1.setLayout(null);
	}
	
	//	Setup the frame:
	public void setup()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
