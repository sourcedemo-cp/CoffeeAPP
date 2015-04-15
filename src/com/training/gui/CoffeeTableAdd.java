package com.training.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.CoffeeTable;
import com.training.service.CoffeeTableService;
@Component("coffeeTableAdd")
public class CoffeeTableAdd extends JFrame {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private CoffeeTableService coffeeTableService;
	
	@Autowired
	private CoffeeTableManagement coffeeTableManagement;

	private JPanel contentPaneTableAdd;
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
		contentPaneTableAdd = new JPanel();
		contentPaneTableAdd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTableAdd);
		contentPaneTableAdd.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTableAdd = new JPanel();
		panelTableAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPaneTableAdd.add(panelTableAdd, BorderLayout.CENTER);
		panelTableAdd.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(24, 14, 46, 14);
		panelTableAdd.add(lblName);
		
		txfName = new JTextField();
		txfName.setBounds(80, 11, 263, 20);
		panelTableAdd.add(txfName);
		txfName.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txfName.setText("");
			}
		});
		btnClear.setBounds(11, 80, 89, 23);
		panelTableAdd.add(btnClear);
		
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
				coffeeTableManagement.fillAllData();
				dispose();
			}
		});
		btnOk.setBounds(110, 80, 89, 23);
		panelTableAdd.add(btnOk);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(254, 80, 89, 23);
		panelTableAdd.add(btnNewButton);
	}
}
