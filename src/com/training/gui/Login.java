package com.training.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.service.EmployeeService;

@Component("login")
public class Login extends JFrame {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Menu menu;
	
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLogin.setBounds(189, 11, 57, 23);
		contentPane.add(lblLogin);
		
		JLabel lblId = new JLabel("User name: ");
		lblId.setBounds(101, 60, 78, 14);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(101, 106, 65, 14);
		contentPane.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(189, 57, 126, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = textUsername.getText();
				String password = textPassword.getText();
				if(employeeService.isEmployeeByUsernamePassword(userName, password)){
					JOptionPane.showMessageDialog(null, "Success!!");
					dispose();
					menu.setVisible(true);
					menu.setLocationRelativeTo(null);
				}else{
					JOptionPane.showMessageDialog(null, "Fail!!");
				}
				
			}
		});
		btnOk.setBounds(145, 154, 74, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(255, 154, 74, 23);
		contentPane.add(btnCancel);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(189, 103, 126, 20);
		contentPane.add(textPassword);
	}
}