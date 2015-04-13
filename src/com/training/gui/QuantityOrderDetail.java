package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuantityOrderDetail extends JFrame {

	private JPanel contentPane;
	private JTextField textQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuantityOrderDetail frame = new QuantityOrderDetail();
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
	public QuantityOrderDetail() {
		setTitle("Quantity");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quantity: ");
		lblNewLabel.setBounds(24, 32, 72, 14);
		contentPane.add(lblNewLabel);
		
		textQuantity = new JTextField();
		textQuantity.setBounds(101, 29, 86, 20);
		contentPane.add(textQuantity);
		textQuantity.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(51, 61, 72, 23);
		contentPane.add(btnOk);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(133, 60, 86, 23);
		contentPane.add(btnNewButton);
	}
}
