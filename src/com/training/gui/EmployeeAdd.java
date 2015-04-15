package com.training.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
@Component("employeeAdd")
public class EmployeeAdd extends JDialog {

	private static final long serialVersionUID = -8009824742286634014L;

	@Autowired
	private EmployeeManagement employeeManagement;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Menu menu;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textTel;
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
		setBounds(100, 100, 462, 301);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_employeeAdd = new JPanel();
		panel_employeeAdd.setBorder(new TitledBorder(null, "Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel_employeeAdd, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{86, 249, 89, 0};
		gbl_panel.rowHeights = new int[]{20, 26, 25, 24, 20, 20, 20, 20, 25, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_employeeAdd.setLayout(gbl_panel);
		
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
		
		JLabel label_1 = new JLabel("Name: ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_employeeAdd.add(label_1, gbc_label_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.anchor = GridBagConstraints.NORTH;
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.gridx = 1;
		gbc_textName.gridy = 1;
		panel_employeeAdd.add(textName, gbc_textName);
		
		JLabel label_3 = new JLabel("Address: ");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 2;
		panel_employeeAdd.add(label_3, gbc_label_3);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.anchor = GridBagConstraints.SOUTH;
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.insets = new Insets(0, 0, 5, 5);
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 2;
		panel_employeeAdd.add(textAddress, gbc_textAddress);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.EAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 3;
		panel_employeeAdd.add(lblTelephone, gbc_lblTelephone);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		GridBagConstraints gbc_textTel = new GridBagConstraints();
		gbc_textTel.anchor = GridBagConstraints.SOUTH;
		gbc_textTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTel.insets = new Insets(0, 0, 5, 5);
		gbc_textTel.gridx = 1;
		gbc_textTel.gridy = 3;
		panel_employeeAdd.add(textTel, gbc_textTel);
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTH;
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.gridx = 2;
		gbc_btnClear.gridy = 3;
		panel_employeeAdd.add(btnClear, gbc_btnClear);
		
		JButton button_2 = new JButton("Save");
		button_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Employee employee = new Employee();
				employee.setEmployeeName(textName.getText());
				employee.setEmployeeAddress(textAddress.getText());
				employee.setEmployeeTelephone(textTel.getText());
				employee.setEmployeeSex(textSex.getText());
				employee.setUserName(textUser.getText());
				employee.setPassword(textPass.getText());
				if(employeeService.addEmployee(employee) == 1 ){
					JOptionPane.showMessageDialog(null, "Saved Successful!!");
				}else{
					JOptionPane.showMessageDialog(null, "Saved Failure!!");
				}
				employeeManagement.fillAllData();
				dispose();
			}
		});
		
		JLabel label_7 = new JLabel("Sex: ");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 4;
		panel_employeeAdd.add(label_7, gbc_label_7);
		
		textSex = new JTextField();
		textSex.setColumns(10);
		GridBagConstraints gbc_textSex = new GridBagConstraints();
		gbc_textSex.anchor = GridBagConstraints.NORTH;
		gbc_textSex.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSex.insets = new Insets(0, 0, 5, 5);
		gbc_textSex.gridx = 1;
		gbc_textSex.gridy = 4;
		panel_employeeAdd.add(textSex, gbc_textSex);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.NORTH;
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 4;
		panel_employeeAdd.add(button_2, gbc_button_2);
		
		JButton button_5 = new JButton("Exit");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JLabel label_8 = new JLabel("User name: ");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 5;
		panel_employeeAdd.add(label_8, gbc_label_8);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		GridBagConstraints gbc_textUser = new GridBagConstraints();
		gbc_textUser.anchor = GridBagConstraints.NORTH;
		gbc_textUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUser.insets = new Insets(0, 0, 5, 5);
		gbc_textUser.gridx = 1;
		gbc_textUser.gridy = 5;
		panel_employeeAdd.add(textUser, gbc_textUser);
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 0);
		gbc_button_5.anchor = GridBagConstraints.SOUTH;
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 5;
		panel_employeeAdd.add(button_5, gbc_button_5);
		
		JLabel label_9 = new JLabel("Password: ");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 6;
		panel_employeeAdd.add(label_9, gbc_label_9);
		
		textPass = new JPasswordField();
		GridBagConstraints gbc_textPass = new GridBagConstraints();
		gbc_textPass.anchor = GridBagConstraints.NORTH;
		gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPass.insets = new Insets(0, 0, 5, 5);
		gbc_textPass.gridx = 1;
		gbc_textPass.gridy = 6;
		panel_employeeAdd.add(textPass, gbc_textPass);
	}
}
