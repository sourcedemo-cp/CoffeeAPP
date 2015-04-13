package com.training.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Employee;
import com.training.service.EmployeeService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@Component("employeeAdd")
public class EmployeeAdd extends JDialog {
	
	@Autowired
	private EmployeeManagement employeeManagement;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Menu menu;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textName;
	private JTextField textCity;
	private JTextField textAddress;
	private JTextField textTel;
	private JTextField textShift;
	private JTextField textWorkDate;
	private JTextField textSex;
	private JTextField textUser;
	private JPasswordField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmployeeAdd dialog = new EmployeeAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmployeeAdd() {
		setTitle("EmployeeAdd");
		setBounds(100, 100, 436, 443);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 368, 380);
		contentPanel.add(panel);
		
		JLabel label_1 = new JLabel("Name: ");
		label_1.setBounds(22, 23, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("City: ");
		label_2.setBounds(22, 58, 46, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Address: ");
		label_3.setBounds(22, 99, 60, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Telephone");
		label_4.setBounds(22, 136, 60, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Shift");
		label_5.setBounds(22, 182, 46, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Work date");
		label_6.setBounds(22, 226, 60, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Sex: ");
		label_7.setBounds(22, 264, 46, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("User name: ");
		label_8.setBounds(22, 306, 89, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Password: ");
		label_9.setBounds(22, 346, 77, 14);
		panel.add(label_9);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(95, 20, 159, 20);
		panel.add(textName);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(95, 60, 159, 20);
		panel.add(textCity);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(95, 100, 159, 20);
		panel.add(textAddress);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(95, 140, 159, 20);
		panel.add(textTel);
		
		textShift = new JTextField();
		textShift.setColumns(10);
		textShift.setBounds(92, 180, 162, 20);
		panel.add(textShift);
		
		textWorkDate = new JTextField();
		textWorkDate.setColumns(10);
		textWorkDate.setBounds(92, 220, 162, 20);
		panel.add(textWorkDate);
		
		textSex = new JTextField();
		textSex.setColumns(10);
		textSex.setBounds(95, 260, 159, 20);
		panel.add(textSex);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setBounds(95, 300, 159, 20);
		panel.add(textUser);
		
		textPass = new JPasswordField();
		textPass.setBounds(95, 340, 159, 20);
		panel.add(textPass);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textCity.setText("");
				textAddress.setText("");
				textTel.setText("");
				textShift.setText("");
				textWorkDate.setText("");
				textSex.setText("");
				textUser.setText("");
				textPass.setText("");
			}
		});
		btnClear.setBounds(264, 54, 89, 23);
		panel.add(btnClear);
		
		JButton button_2 = new JButton("Save");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee employee = new Employee();
				employee.setEmployeeName(textName.getText());
				employee.setEmpoyeeCity(textCity.getText());
				employee.setEmployeeAddress(textAddress.getText());
				employee.setEmployeeTelephone(textTel.getText());
				employee.setShift(textShift.getText());
//				employee.setWorkDate(textWorkDate.getText());
				employee.setEmployeeSex(textSex.getText());
				employee.setUserName(textUser.getText());
				employee.setPassword(textPass.getText());
				if(employeeService.addEmployee(employee) == 1 ){
					JOptionPane.showMessageDialog(null, "Saved Successful!!");
				}else{
					JOptionPane.showMessageDialog(null, "Saved Failure!!");
				}
				employeeManagement.AllData();
			}
		});
		button_2.setBounds(264, 95, 89, 23);
		panel.add(button_2);
		
		JButton button_5 = new JButton("Exit");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_5.setBounds(264, 342, 89, 23);
		panel.add(button_5);
	}
}
