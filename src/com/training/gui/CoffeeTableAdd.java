package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.CoffeeTable;
import com.training.service.CoffeeTableService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@Component("coffeeTableAdd")
public class CoffeeTableAdd extends JFrame {
	
	@Autowired
	private CoffeeTableService coffeeTableService;
	
	@Autowired
	private CoffeeTableManagement coffeeTableManagement;

	private JPanel contentPane;
	private JTextField txfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeTableAdd frame = new CoffeeTableAdd();
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
	public CoffeeTableAdd() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 379, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(24, 14, 46, 14);
		panel.add(lblName);
		
		txfName = new JTextField();
		txfName.setBounds(80, 11, 263, 20);
		panel.add(txfName);
		txfName.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txfName.setText("");
			}
		});
		btnClear.setBounds(11, 80, 89, 23);
		panel.add(btnClear);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoffeeTable coffeeTable = new CoffeeTable();
				coffeeTable.setTableName(txfName.getText());
				if(coffeeTableService.addCoffeeTable(coffeeTable)==1){
					JOptionPane.showMessageDialog(null, "Saved Successful!!");
				}else{
					JOptionPane.showMessageDialog(null, "Saved Failure!!");
				}
				coffeeTableManagement.AllData();
				dispose();
			}
		});
		btnOk.setBounds(110, 80, 89, 23);
		panel.add(btnOk);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(254, 80, 89, 23);
		panel.add(btnNewButton);
	}
}
