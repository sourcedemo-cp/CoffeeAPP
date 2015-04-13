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

import com.toedter.calendar.JTextFieldDateEditor;
import com.training.entity.Employee;
import com.training.service.EmployeeService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@Component("EmployeeEdit")
public class EmployeeEdit extends JDialog {
	
	@Autowired
	private EmployeeManagement employeeManagement;
	
	@Autowired
	private EmployeeService employeeService;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textID;
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
			EmployeeEdit dialog = new EmployeeEdit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmployeeEdit() {
		setTitle("Employee Edit");
		setBounds(100, 100, 434, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(22, 11, 368, 380);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("ID: ");
				label.setBounds(22, 22, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Name: ");
				label.setBounds(22, 58, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("City: ");
				label.setBounds(22, 95, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Address: ");
				label.setBounds(22, 131, 60, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Telephone");
				label.setBounds(23, 169, 60, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Shift");
				label.setBounds(22, 206, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Work date");
				label.setBounds(22, 242, 60, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Sex: ");
				label.setBounds(22, 281, 46, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("User name: ");
				label.setBounds(22, 318, 89, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Password: ");
				label.setBounds(22, 346, 77, 14);
				panel.add(label);
			}
			{
				textID = new JTextField();
				textID.setColumns(10);
				textID.setBounds(95, 19, 159, 20);
				panel.add(textID);
			}
			{
				textName = new JTextField();
				textName.setColumns(10);
				textName.setBounds(95, 55, 159, 20);
				panel.add(textName);
			}
			{
				textCity = new JTextField();
				textCity.setColumns(10);
				textCity.setBounds(95, 92, 159, 20);
				panel.add(textCity);
			}
			{
				textAddress = new JTextField();
				textAddress.setColumns(10);
				textAddress.setBounds(95, 128, 159, 20);
				panel.add(textAddress);
			}
			{
				textTel = new JTextField();
				textTel.setColumns(10);
				textTel.setBounds(95, 166, 159, 20);
				panel.add(textTel);
			}
			{
				textShift = new JTextField();
				textShift.setColumns(10);
				textShift.setBounds(95, 203, 159, 20);
				panel.add(textShift);
			}
			{
				textWorkDate = new JTextField();
				textWorkDate.setColumns(10);
				textWorkDate.setBounds(93, 239, 161, 20);
				panel.add(textWorkDate);
			}
			{
				textSex = new JTextField();
				textSex.setColumns(10);
				textSex.setBounds(95, 278, 159, 20);
				panel.add(textSex);
			}
			{
				textUser = new JTextField();
				textUser.setColumns(10);
				textUser.setBounds(95, 315, 159, 20);
				panel.add(textUser);
			}
			{
				textPass = new JPasswordField();
				textPass.setBounds(95, 343, 159, 20);
				panel.add(textPass);
			}
			{
				JButton btnClear = new JButton("Clear");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textID.setText("");
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
			}
			{
				JButton button = new JButton("Update");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int id = Integer.parseInt(textID.getText());
						Employee employee = employeeService.findEmployeeById(id);
						//employee.setEmployeeId(id);
						employee.setEmployeeName(textName.getText());
						employee.setEmpoyeeCity(textCity.getText());
						employee.setEmployeeAddress(textAddress.getText());
						employee.setEmployeeTelephone(textTel.getText());
						employee.setShift(textShift.getText());
						employee.setWorkDate(textWorkDate.getText());
						if(employee.getEmployeeSex().length() != 0){
							employee.setEmployeeSex(textSex.getText());
						}
						employee.setUserName(textUser.getText());
						employee.setPassword(textPass.getText());
						if(employeeService.updateEmployee(employee) == 1 ){
							JOptionPane.showMessageDialog(null, "Updated Successful!!");
						}else{
							JOptionPane.showMessageDialog(null, "Updated Failure!!");
						}
						employeeManagement.AllData();
					}
				});
				button.setBounds(264, 91, 89, 23);
				panel.add(button);
			}
			{
				JButton button = new JButton("Exit");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				button.setBounds(264, 342, 89, 23);
				panel.add(button);
			}
		}
	}

}
