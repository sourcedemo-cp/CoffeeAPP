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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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
		setBounds(100, 100, 462, 301);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{86, 249, 89, 0};
		gbl_panel.rowHeights = new int[]{20, 26, 25, 24, 20, 20, 20, 20, 25, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label_1 = new JLabel("Name: ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.anchor = GridBagConstraints.NORTH;
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.gridx = 1;
		gbc_textName.gridy = 0;
		panel.add(textName, gbc_textName);
		
		JLabel label_2 = new JLabel("City: ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		GridBagConstraints gbc_textCity = new GridBagConstraints();
		gbc_textCity.anchor = GridBagConstraints.SOUTH;
		gbc_textCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCity.insets = new Insets(0, 0, 5, 5);
		gbc_textCity.gridx = 1;
		gbc_textCity.gridy = 1;
		panel.add(textCity, gbc_textCity);
		
		JLabel label_3 = new JLabel("Address: ");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 2;
		panel.add(label_3, gbc_label_3);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.anchor = GridBagConstraints.SOUTH;
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.insets = new Insets(0, 0, 5, 5);
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 2;
		panel.add(textAddress, gbc_textAddress);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 3;
		panel.add(lblTelephone, gbc_lblTelephone);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		GridBagConstraints gbc_textTel = new GridBagConstraints();
		gbc_textTel.anchor = GridBagConstraints.SOUTH;
		gbc_textTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTel.insets = new Insets(0, 0, 5, 5);
		gbc_textTel.gridx = 1;
		gbc_textTel.gridy = 3;
		panel.add(textTel, gbc_textTel);
		
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
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTH;
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.gridx = 2;
		gbc_btnClear.gridy = 3;
		panel.add(btnClear, gbc_btnClear);
		
		JLabel lblShift = new JLabel("Shift:");
		GridBagConstraints gbc_lblShift = new GridBagConstraints();
		gbc_lblShift.anchor = GridBagConstraints.EAST;
		gbc_lblShift.insets = new Insets(0, 0, 5, 5);
		gbc_lblShift.gridx = 0;
		gbc_lblShift.gridy = 4;
		panel.add(lblShift, gbc_lblShift);
		
		textShift = new JTextField();
		textShift.setColumns(10);
		GridBagConstraints gbc_textShift = new GridBagConstraints();
		gbc_textShift.anchor = GridBagConstraints.NORTH;
		gbc_textShift.fill = GridBagConstraints.HORIZONTAL;
		gbc_textShift.insets = new Insets(0, 0, 5, 5);
		gbc_textShift.gridx = 1;
		gbc_textShift.gridy = 4;
		panel.add(textShift, gbc_textShift);
		
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
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.NORTH;
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 4;
		panel.add(button_2, gbc_button_2);
		
		JLabel lblWorkDate = new JLabel("Work date:");
		GridBagConstraints gbc_lblWorkDate = new GridBagConstraints();
		gbc_lblWorkDate.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblWorkDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblWorkDate.gridx = 0;
		gbc_lblWorkDate.gridy = 5;
		panel.add(lblWorkDate, gbc_lblWorkDate);
		
		textWorkDate = new JTextField();
		textWorkDate.setColumns(10);
		GridBagConstraints gbc_textWorkDate = new GridBagConstraints();
		gbc_textWorkDate.anchor = GridBagConstraints.NORTH;
		gbc_textWorkDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWorkDate.insets = new Insets(0, 0, 5, 5);
		gbc_textWorkDate.gridx = 1;
		gbc_textWorkDate.gridy = 5;
		panel.add(textWorkDate, gbc_textWorkDate);
		
		JButton button_5 = new JButton("Exit");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 0);
		gbc_button_5.anchor = GridBagConstraints.SOUTH;
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 5;
		panel.add(button_5, gbc_button_5);
		
		JLabel label_7 = new JLabel("Sex: ");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 6;
		panel.add(label_7, gbc_label_7);
		
		textSex = new JTextField();
		textSex.setColumns(10);
		GridBagConstraints gbc_textSex = new GridBagConstraints();
		gbc_textSex.anchor = GridBagConstraints.NORTH;
		gbc_textSex.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSex.insets = new Insets(0, 0, 5, 5);
		gbc_textSex.gridx = 1;
		gbc_textSex.gridy = 6;
		panel.add(textSex, gbc_textSex);
		
		JLabel label_8 = new JLabel("User name: ");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.SOUTHEAST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 7;
		panel.add(label_8, gbc_label_8);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		GridBagConstraints gbc_textUser = new GridBagConstraints();
		gbc_textUser.anchor = GridBagConstraints.NORTH;
		gbc_textUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUser.insets = new Insets(0, 0, 5, 5);
		gbc_textUser.gridx = 1;
		gbc_textUser.gridy = 7;
		panel.add(textUser, gbc_textUser);
		
		JLabel label_9 = new JLabel("Password: ");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 8;
		panel.add(label_9, gbc_label_9);
		
		textPass = new JPasswordField();
		GridBagConstraints gbc_textPass = new GridBagConstraints();
		gbc_textPass.anchor = GridBagConstraints.NORTH;
		gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPass.insets = new Insets(0, 0, 0, 5);
		gbc_textPass.gridx = 1;
		gbc_textPass.gridy = 8;
		panel.add(textPass, gbc_textPass);
	}
}
