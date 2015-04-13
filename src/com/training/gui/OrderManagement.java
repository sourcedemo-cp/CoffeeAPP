package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class OrderManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderManagement frame = new OrderManagement();
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
	public OrderManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrder = new JLabel("Order: ");
		lblOrder.setBounds(116, 29, 46, 14);
		contentPane.add(lblOrder);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(195, 26, 98, 20);
		contentPane.add(comboBox);
		
		table = new JTable();
		table.setBounds(24, 61, 385, 146);
		contentPane.add(table);
	}
}
