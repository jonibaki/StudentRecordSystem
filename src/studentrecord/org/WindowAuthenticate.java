package studentrecord.org;

import studentrecord.org.Runner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WindowAuthenticate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPassword;


	/**
	 * Create the dialog.
	 */
	public WindowAuthenticate() {
		setModal(true);
		setBounds(100, 100, 398, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(159, 83, 161, 20);
		contentPanel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(61, 84, 110, 14);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtPassword.getText().toLowerCase().equals("conel2016")){
							Runner.frameDataEntry.setVisible(true);
							setVisible(false);
							txtPassword.setText(null);
							Runner.frameRunnerScreen.setVisible(false);
							
						}
						else {
							JOptionPane.showMessageDialog(Runner.frameAuthenticate, "You have entered WRONG password");
						}
					}
				});
				okButton.setBackground(new Color(51, 255, 102));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(255, 0, 51));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						Runner.frameRunnerScreen.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
