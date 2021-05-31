package studentrecord.org;

import studentrecord.org.Runner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowMainScreen {

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public WindowMainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 534, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentsDatabase = new JLabel("STUDENT'S DATABASE");
		lblStudentsDatabase.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblStudentsDatabase.setForeground(Color.GRAY);
		lblStudentsDatabase.setBounds(68, 60, 402, 63);
		frame.getContentPane().add(lblStudentsDatabase);
		
		JButton btnNewButton = new JButton("Manage Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(true);
				Runner.frameAuthenticate.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 127));
		btnNewButton.setBounds(325, 171, 145, 68);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSearchForRecord = new JButton("Search for Record");
		btnSearchForRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				
				Runner.frameSearchRecord.setVisible(true);
			}
		});
		btnSearchForRecord.setForeground(Color.BLUE);
		btnSearchForRecord.setBounds(68, 171, 145, 68);
		frame.getContentPane().add(btnSearchForRecord);
		
		JLabel lblTheCollegeOf = new JLabel("The College of Haringey, Enfield and North London");
		lblTheCollegeOf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTheCollegeOf.setBounds(57, 42, 434, 22);
		frame.getContentPane().add(lblTheCollegeOf);
		
		JButton btnNewButton_1 = new JButton("Save & Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);}
		});
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1.setBounds(409, 444, 99, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("Min. Grade");
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(68, 273, 140, 47);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Max. Grade");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_1.setBounds(68, 359, 145, 47);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Average Mark");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_2.setBounds(330, 273, 140, 47);
		frame.getContentPane().add(button_2);
		
		JButton btnNewButton_2 = new JButton("Grade Categories");
		btnNewButton_2.setBounds(331, 359, 139, 47);
		frame.getContentPane().add(btnNewButton_2);
	}
}
