package studentrecord.org;

import studentrecord.org.Runner;
import studentrecord.org.WindowStudentProfile;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class WindowDataEntry {

	
	
	public JFrame frame;
	private JTextField txtStudentName;
	private JTextField txtExamMark;
	public JLabel lblRecordCounter;
	private JTable table;
	public DefaultTableModel tablemodel = new DefaultTableModel(null, 	new String[] {
			"Student's Name", "Gender", "Address", "Exam Mark"
		}) {
		
		@Override
		public boolean isCellEditable (int row, int column){
			return false;
			}
		
		
	};

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public WindowDataEntry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JTextPane txtAddress = new JTextPane();
		txtAddress.setBounds(159, 101, 166, 78);
		frame.getContentPane().add(txtAddress);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(25, 59, 72, 19);
		frame.getContentPane().add(lblGender);
		
		JComboBox cmbGender = new JComboBox();
		
		
		lblRecordCounter = new JLabel("");
		lblRecordCounter.setBounds(10, 211, 115, 14);
		frame.getContentPane().add(lblRecordCounter);
		
		
		
		JButton btnAddInfo = new JButton("Add");
		btnAddInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student student = new Student();
				student.name = txtStudentName.getText();
				student.address= txtAddress.getText();
				student.gender = (String) cmbGender.getSelectedItem();
				
				
				try {
					student.mark = Integer.parseInt(txtExamMark.getText());
					student.address = txtAddress.getText();
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(frame, "Enter all the data");
					}		
						
				if (Runner.currentStudent == 29){
					JOptionPane.showMessageDialog(frame, "Data is full!");
				}
				else {
					Runner.currentStudent++;
					int counter = (29-Runner.currentStudent);
					lblRecordCounter.setText(counter+" record remaining");
					Runner.students[Runner.currentStudent] = student;
					Object[] rowData = {student.name, student.gender, student.address, student.mark};
					tablemodel.addRow(rowData);
				
				}
		}
		});
		btnAddInfo.setBounds(355, 12, 89, 34);
		frame.getContentPane().add(btnAddInfo);
		
		JButton btnClearInfo = new JButton("Clear");
		btnClearInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			
				Runner.currentStudent=-1;
				int  tableRow = tablemodel.getRowCount();
				tablemodel.setNumRows(0);
				lblRecordCounter.setText(null);
				
			}
		});
		btnClearInfo.setBounds(355, 145, 89, 34);
		frame.getContentPane().add(btnClearInfo);
		
		JButton btnEnd = new JButton("End");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Runner.frameRunnerScreen.setVisible(true);
				
			}
		});
		btnEnd.setBounds(355, 191, 89, 34);
		frame.getContentPane().add(btnEnd);
		
		txtStudentName = new JTextField();
		txtStudentName.setBounds(159, 12, 166, 23);
		frame.getContentPane().add(txtStudentName);
		txtStudentName.setColumns(10);
		
		JList list = new JList();
		list.setBounds(37, 240, 370, -107);
		frame.getContentPane().add(list);
	
		
		JLabel lblStudentsName = new JLabel("Student's name:");
		lblStudentsName.setBounds(25, 16, 100, 19);
		frame.getContentPane().add(lblStudentsName);
		

		
		
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male ", "Female"}));
		cmbGender.setToolTipText("Student's gender");
		cmbGender.setBounds(159, 55, 166, 22);
		frame.getContentPane().add(cmbGender);
		
		JLabel lblNewLabel = new JLabel("Address :");
		lblNewLabel.setBounds(25, 105, 72, 19);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Exam Mark :");
		lblNewLabel_1.setBounds(25, 191, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtExamMark = new JTextField();
		txtExamMark.setBounds(159, 188, 86, 20);
		frame.getContentPane().add(txtExamMark);
		txtExamMark.setColumns(10);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int data = table.getSelectedRow();
			
			if (data > -1){						
			
			WindowStudentProfile editWindow = new WindowStudentProfile(data);
			frame.setEnabled(false);
			editWindow.frame.setVisible(true);
			
			tablemodel.setRowCount(0);
			
		
			}
			
			}

			private void setEnabled(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(355, 90, 89, 34);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 274, 434, 215);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tablemodel);
		updateTable();
		scrollPane.setViewportView(table);
		table.setShowGrid(false);
		table.setFillsViewportHeight(true);
		}
	
	public void updateTable(){
		tablemodel.setRowCount(0);
		for(int i = 0; i<Runner.currentStudent+1; i++){
			Student data= Runner.getStudent(i);
			Object[] row = {data.name, data.gender, data.address, data.mark};
			tablemodel.addRow(row);
			
		
			}
	}
	
	
	
}
