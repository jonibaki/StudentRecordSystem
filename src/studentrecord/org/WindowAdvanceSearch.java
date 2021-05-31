package studentrecord.org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowAdvanceSearch {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the application.
	 */
	public WindowAdvanceSearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(359, 381, 76, 28);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 224, 425, 146);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student's Name", "Gender", "Address", "Exam Mark"
			}
		));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 187, 108, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblExamMark = new JLabel("Exam Mark (0 to 100):");
		lblExamMark.setBounds(10, 190, 124, 14);
		frame.getContentPane().add(lblExamMark);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(144, 100, 166, 78);
		frame.getContentPane().add(textPane);
		
		JLabel label_1 = new JLabel("Address :");
		label_1.setBounds(10, 104, 72, 19);
		frame.getContentPane().add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Not Specified ", "Male", "Female"}));
		comboBox.setToolTipText("Student's gender");
		comboBox.setBounds(144, 54, 108, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("Gender :");
		label_2.setBounds(10, 58, 72, 19);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Student's name:");
		label_3.setBounds(10, 15, 100, 19);
		frame.getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 11, 166, 23);
		frame.getContentPane().add(textField_1);
	}
}
