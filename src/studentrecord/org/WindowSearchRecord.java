package studentrecord.org;

import studentrecord.org.Runner;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class WindowSearchRecord {

	public JFrame frame;
	private JTextField textField;
	private DefaultListModel model = new DefaultListModel();
	private JTable table;
	public DefaultTableModel tablemodel = new DefaultTableModel(null, 	new String[] {
			"Student's Name", "Gender", "Address", "Exam Mark"
		});
	/**
	 * Create the application.
	 */
	public WindowSearchRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 480, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPrintRecord = new JButton("Display All");
		btnPrintRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Runner.currentStudent);
				for(int i = 0; i< Runner.currentStudent; i++){
					Student record;
					record= Runner.students[i];
					Object[] rowData = {record.name, record.gender, record.address, record.mark};
					tablemodel.addRow(rowData);
				
				}
					
			}
		});
		btnPrintRecord.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPrintRecord.setBounds(50, 417, 89, 39);
		frame.getContentPane().add(btnPrintRecord);
		
		JLabel lblNewLabel = new JLabel("Search by Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 36, 132, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Runner.currentStudent);
				for(int i = 0; i< Runner.currentStudent; i++){
					Student record;
					record= Runner.students[i];
					if (record.name.contains(textField.getText())){
					Object[] rowData = {record.name, record.gender, record.address, record.mark};
					tablemodel.addRow(rowData);
					}
					else{
						System.out.println("No data found");
					}
				}
			}
		});
		btnSearch.setBounds(371, 60, 65, 26);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("STUDENT RECORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(106, 0, 205, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				model.clear();
				Runner.frameRunnerScreen.setVisible(true);
			}
		});
		
		btnNewButton_1.setBounds(347, 416, 89, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  tableRow = tablemodel.getRowCount();
				tablemodel.setNumRows(0);
				
				
				
			}
		});
		btnClear.setBounds(223, 419, 74, 41);
		frame.getContentPane().add(btnClear);
		
		textField = new JTextField();
		textField.setBounds(146, 41, 290, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 426, 251);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tablemodel);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Advance Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(10, 113, 111, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
