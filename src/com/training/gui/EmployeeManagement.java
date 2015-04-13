package com.training.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.training.entity.Employee;
import com.training.service.EmployeeService;
import com.training.service.EmployeeServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
@Component("employeeManagement")

public class EmployeeManagement extends JFrame {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Menu menu;
	
	@Autowired
	private EmployeeAdd employeeAdd;
	
	@Autowired
	private EmployeeEdit employeeEdit;
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired 
	private ProductManagement productManagement;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	//public DefaultTableModel dtm;
	private JTable table1;
	
	public int AllData(){
		//dtm = (DefaultTableModel) table1.getModel();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("1");
		dtm.addColumn("2");
		dtm.addColumn("3");
		dtm.addColumn("4");
		dtm.addColumn("5");
		dtm.addColumn("6");
		dtm.addColumn("7");
		dtm.addColumn("8");
		dtm.addColumn("9");
		dtm.addColumn("10");
		
		dtm.addRow(new Object[]{"ID", "Name", "City","Address","Telephone","Shift", "Work date", "Sex", "User", "Password"});
		for(Employee employee: this.employeeService.getAllEmployee()){
			dtm.addRow(new Object[]{employee.getEmployeeId(), employee.getEmployeeName(),employee.getEmpoyeeCity(), employee.getEmployeeAddress(), employee.getEmployeeTelephone(), employee.getShift(), employee.getWorkDate(), employee.getEmployeeSex(), employee.getUserName(), employee.getPassword()});
		}
		this.table1.setModel(dtm);
		this.table1.repaint();
		this.table1.revalidate();
		return 1;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					EmployeeManagement frame = new EmployeeManagement();
					frame.setVisible(true);	
					frame.table1.repaint();
					frame.table1.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public EmployeeManagement() {
		setTitle("Employee management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		
		
		JButton btnNew = new JButton("Add");
		btnNew.setBounds(10, 234, 89, 23);
		contentPane.add(btnNew);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(620, 234, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(719, 234, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(243, 234, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(123, 234, 89, 23);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.setBounds(10, 11, 798, 193);
		contentPane.add(table1);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Employee emp = new Employee();
				emp.setEmployeeId(Integer.parseInt(textID.getText()));
				emp.setEmployeeName(textName.getText());
				emp.setEmpoyeeCity(textCity.getText());
				emp.setEmployeeAddress(textAddress.getText());
				emp.setEmployeeTelephone(textTelephone.getText());
				emp.setShift(textShift.getText());
				emp.setWorkDate(textWordDate.getText());
				emp.setEmployeeSex(textSex.getText());
				emp.setUserName(textUser.getText());
				emp.setPassword(textPass.getText());
				if(employeeService.updateEmployee(emp) == 1 ){
					JOptionPane.showMessageDialog(null, "Updated Successful!!");
				}else{
					JOptionPane.showMessageDialog(null, "Updated Failure!!");
				}*/
				employeeEdit.setVisible(true);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Employee emp = new Employee();
				int id = Integer.parseInt(textID.getText());
				if(employeeService.deleteEmployeeById(id) == 1 ){
					JOptionPane.showMessageDialog(null, "Deleted Successful!!");
				}else{
					JOptionPane.showMessageDialog(null, "Deleted Failure!!");
				}*/
				int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
				if(employeeServiceImpl.deleteEmployeeById(employeeServiceImpl.findEmployeeById(id))){
					JOptionPane.showMessageDialog(null, "Deleted successful!!!");
				}else{
					JOptionPane.showMessageDialog(null, "Fail!!!");
				}
				AllData();
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
				dispose();
			}
		});
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*textID.setText("");
				textName.setText("");
				textCity.setText("");
				textAddress.setText("");
				textTelephone.setText("");
				textShift.setText("");
				textWordDate.setText("");
				textSex.setText("");
				textUser.setText("");
				textPass.setText("");*/
				employeeAdd.setVisible(true);
			}
		});
	}
}
