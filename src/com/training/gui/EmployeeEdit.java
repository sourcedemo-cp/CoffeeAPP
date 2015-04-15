package com.training.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Employee;
import com.training.service.EmployeeService;
@Component("EmployeeEdit")
public class EmployeeEdit extends JDialog {
	
	private static final long serialVersionUID = -8449708040996123151L;

	@Autowired
	private EmployeeManagement employeeManagement;
	
	@Autowired
	private EmployeeService employeeService;
	
	private final JPanel contentPanel_employeeEdit = new JPanel();
	static JTextField textID;
	static JTextField textName;
	static JTextField textAddress;
	static JTextField textTel;
	static JTextField textSex;
	static JTextField textUser;
	static JPasswordField textPass;

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
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Employee Edit");
		setBounds(100, 100, 427, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel_employeeEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel_employeeEdit, BorderLayout.CENTER);
		contentPanel_employeeEdit.setLayout(null);
		{
			JPanel panel_employeeEdit = new JPanel();
			panel_employeeEdit.setLayout(null);
			panel_employeeEdit.setBorder(new TitledBorder(null, "Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_employeeEdit.setBounds(10, 11, 367, 296);
			contentPanel_employeeEdit.add(panel_employeeEdit);
			{
				JLabel label = new JLabel("ID: ");
				label.setBounds(22, 24, 46, 14);
				panel_employeeEdit.add(label);
			}
			{
				JLabel label = new JLabel("Name: ");
				label.setBounds(22, 62, 46, 14);
				panel_employeeEdit.add(label);
			}
			{
				JLabel label = new JLabel("Address: ");
				label.setBounds(22, 100, 60, 14);
				panel_employeeEdit.add(label);
			}
			{
				JLabel label = new JLabel("Telephone");
				label.setBounds(22, 138, 60, 14);
				panel_employeeEdit.add(label);
			}
			{
				JLabel label = new JLabel("Sex: ");
				label.setBounds(22, 176, 46, 14);
				panel_employeeEdit.add(label);
			}
			{
				JLabel label = new JLabel("User name: ");
				label.setBounds(22, 214, 89, 14);
				panel_employeeEdit.add(label);
			}
			{
				JLabel label = new JLabel("Password: ");
				label.setBounds(22, 252, 77, 14);
				panel_employeeEdit.add(label);
			}
			{
				textID = new JTextField();
				textID.setEditable(false);
				textID.setColumns(10);
				textID.setBounds(95, 19, 159, 20);
				panel_employeeEdit.add(textID);
			}
			{
				textName = new JTextField();
				textName.setColumns(10);
				textName.setBounds(95, 58, 159, 20);
				panel_employeeEdit.add(textName);
			}
			{
				textAddress = new JTextField();
				textAddress.setColumns(10);
				textAddress.setBounds(95, 97, 159, 20);
				panel_employeeEdit.add(textAddress);
			}
			{
				textTel = new JTextField();
				textTel.setColumns(10);
				textTel.setBounds(95, 136, 159, 20);
				panel_employeeEdit.add(textTel);
			}
			{
				textSex = new JTextField();
				textSex.setColumns(10);
				textSex.setBounds(95, 175, 159, 20);
				panel_employeeEdit.add(textSex);
			}
			{
				textUser = new JTextField();
				textUser.setColumns(10);
				textUser.setBounds(95, 214, 159, 20);
				panel_employeeEdit.add(textUser);
			}
			{
				textPass = new JPasswordField();
				textPass.setBounds(95, 253, 159, 20);
				panel_employeeEdit.add(textPass);
			}
			{
				JButton btnClear = new JButton("Clear");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textName.setText("");
						textAddress.setText("");
						textTel.setText("");
						textSex.setText("");
						textUser.setText("");
						textPass.setText("");
					}
				});
				btnClear.setBounds(264, 54, 89, 23);
				panel_employeeEdit.add(btnClear);
			}
			{
				JButton button = new JButton("Update");
				button.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						int id = Integer.parseInt(textID.getText());
						Employee employee = employeeService.findEmployeeById(id);
						employee.setEmployeeName(textName.getText());
						employee.setEmployeeAddress(textAddress.getText());
						employee.setEmployeeTelephone(textTel.getText());
						
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
						dispose();
					}
				});
				button.setBounds(264, 91, 89, 23);
				panel_employeeEdit.add(button);
			}
			{
				JButton button = new JButton("Exit");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				button.setBounds(264, 248, 89, 23);
				panel_employeeEdit.add(button);
			}
		}
	}

}
