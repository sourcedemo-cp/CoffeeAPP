package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.CoffeeTable;
import com.training.service.CoffeeTableService;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@Component("coffeeTableUpdate")
public class CoffeeTableUpdate extends JFrame {

	private JPanel contentPane;
	static JTextField txfID;
	static JTextField txfName;

	@Autowired
	private CoffeeTableService coffeeTableService;
	
	@Autowired
	private CoffeeTableManagement coffeeTableManagement;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeTableUpdate frame = new CoffeeTableUpdate();
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
	public CoffeeTableUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_tableUpdate = new JPanel();
		contentPane.add(panel_tableUpdate, BorderLayout.CENTER);
		panel_tableUpdate.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(34, 11, 46, 14);
		panel_tableUpdate.add(lblId);
		
		txfID = new JTextField();
		txfID.setEditable(false);
		txfID.setBounds(110, 8, 230, 20);
		panel_tableUpdate.add(txfID);
		txfID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 51, 46, 14);
		panel_tableUpdate.add(lblName);
		
		txfName = new JTextField();
		txfName.setBounds(110, 48, 230, 20);
		panel_tableUpdate.add(txfName);
		txfName.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txfName.setText("");
			}
		});
		btnClear.setBounds(10, 150, 89, 23);
		panel_tableUpdate.add(btnClear);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txfID.getText());
				CoffeeTable coffeeTable = coffeeTableService.findCoffeeTableById(id);
				coffeeTable.setTableName(txfName.getText());
				if(coffeeTableService.updateCoffeeTable(coffeeTable)==1){
					JOptionPane.showMessageDialog(null, "Edit Success!");
				}else {
					JOptionPane.showMessageDialog(null, "Edit fail!");
				}
				coffeeTableManagement.AllData();
				
				dispose();
			}
		});
		btnOk.setBounds(110, 150, 89, 23);
		panel_tableUpdate.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(325, 150, 89, 23);
		panel_tableUpdate.add(btnCancel);
	}

}
