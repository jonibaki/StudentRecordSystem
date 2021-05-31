package studentrecord.org;

import studentrecord.org.Runner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowStudentProfile {
	public JFrame frame;
	private JTextField txtExamMark;
	private JTextField txtStudentName;
	private int recordNo;
	/**
	 * Create the application.
	 */
	public WindowStudentProfile(int record) {
		recordNo = record;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 345, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Student record = Runner.getStudent(recordNo);
		
		
		txtExamMark = new JTextField();
		txtExamMark.setText(Integer.toString(record.mark));
		txtExamMark.setColumns(10);
		txtExamMark.setBounds(144, 187, 86, 20);
		frame.getContentPane().add(txtExamMark);
		
		JLabel label = new JLabel("Exam Mark :");
		label.setBounds(10, 190, 89, 14);
		frame.getContentPane().add(label);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(record.address);
		textPane.setBounds(144, 100, 166, 78);
		frame.getContentPane().add(textPane);
		
		JLabel label_1 = new JLabel("Address :");
		label_1.setBounds(10, 104, 72, 19);
		frame.getContentPane().add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		if (record.gender.equals("Male")){
			comboBox.setSelectedIndex(0);	
		}
		else {
			comboBox.setSelectedIndex(1);
			
			}
		
		
		comboBox.setToolTipText("Student's gender");
		comboBox.setBounds(144, 54, 166, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("Gender :");
		label_2.setBounds(10, 58, 72, 19);
		frame.getContentPane().add(label_2);
		
		JLabel lblStudentsName = new JLabel("Student's Name:");
		lblStudentsName.setBounds(10, 15, 100, 19);
		frame.getContentPane().add(lblStudentsName);
		
		txtStudentName = new JTextField();
		txtStudentName.setText(record.name);
		txtStudentName.setColumns(10);
		txtStudentName.setBounds(144, 11, 166, 23);
		frame.getContentPane().add(txtStudentName);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runner.frameDataEntry.setVisible(true);
				Runner.frameDataEntry.setEnabled(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(230, 243, 89, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Student replacement = new Student();
				
				replacement.name = txtStudentName.getText();
			 
				if (comboBox.getSelectedIndex()== 0){
					replacement.gender = "Male";
				}
				else {
					replacement.gender = "Female";
					}
				
				replacement.address = textPane.getText();
				replacement.mark = Integer.parseInt(txtExamMark.getText());
				Runner.students[recordNo] = replacement;
				frame.setVisible(false);
				Runner.frameDataEntry.setEnabled(true);
			}
		});
		btnSave.setBounds(111, 243, 89, 39);
		frame.getContentPane().add(btnSave);
	}

	private Object ParseString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private String ParseInt(int mark) {
		// TODO Auto-generated method stub
		return null;
	}

}
