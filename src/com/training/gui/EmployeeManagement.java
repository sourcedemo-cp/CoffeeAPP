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
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("City");
		dtm.addColumn("Address");
		dtm.addColumn("Telephone");
		dtm.addColumn("Shift");
		dtm.addColumn("Work date");
		dtm.addColumn("Sex");
		dtm.addColumn("User name");
		dtm.addColumn("Password");
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		JButton btnNew = new JButton("Add");
		panel_1.add(btnNew);
		
		JButton btnUpdate = new JButton("Update");
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		panel_1.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
				if(employeeServiceImpl.deleteEmployeeById(employeeServiceImpl.findEmployeeById(id))){
					JOptionPane.showMessageDialog(null, "Deleted successful!!!");
				}else{
					JOptionPane.showMessageDialog(null, "Fail!!!");
				}
				AllData();
			}
		});
		//		contentPane.add(table1);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						employeeEdit.setVisible(true);
					}
				});
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employeeAdd.setVisible(true);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("Back");
		panel_2.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		panel_2.add(btnExit);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		table1 = new JTable();
		
		scrollPane.setViewportView(table1);
		
		
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
	}
}
