package com.training.gui;

import java.awt.BorderLayout;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.CoffeeTable;
import com.training.service.CoffeeTableService;
@Component("coffeeTableUpdate")
public class CoffeeTableUpdate extends JFrame {

	private static final long serialVersionUID = -3108484766123465700L;
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
		
		JPanel panelTableUpdate = new JPanel();
		contentPane.add(panelTableUpdate, BorderLayout.CENTER);
		panelTableUpdate.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(34, 11, 46, 14);
		panelTableUpdate.add(lblId);
		
		txfID = new JTextField();
		txfID.setEditable(false);
		txfID.setBounds(110, 8, 230, 20);
		panelTableUpdate.add(txfID);
		txfID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 51, 46, 14);
		panelTableUpdate.add(lblName);
		
		txfName = new JTextField();
		txfName.setBounds(110, 48, 230, 20);
		panelTableUpdate.add(txfName);
		txfName.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txfName.setText("");
			}
		});
		btnClear.setBounds(10, 150, 89, 23);
		panelTableUpdate.add(btnClear);
		
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
				coffeeTableManagement.fillAllData();
				
				dispose();
			}
		});
		btnOk.setBounds(110, 150, 89, 23);
		panelTableUpdate.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(325, 150, 89, 23);
		panelTableUpdate.add(btnCancel);
	}

}
