package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import org.springframework.stereotype.Component;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
@Component("coffeeTableUpdate")
public class CoffeeTableUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField txfID;
	private JTextField txfName;

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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(34, 11, 46, 14);
		panel.add(lblId);
		
		txfID = new JTextField();
		txfID.setEditable(false);
		txfID.setBounds(110, 8, 230, 20);
		panel.add(txfID);
		txfID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 51, 46, 14);
		panel.add(lblName);
		
		txfName = new JTextField();
		txfName.setBounds(110, 48, 230, 20);
		panel.add(txfName);
		txfName.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(10, 150, 89, 23);
		panel.add(btnClear);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(110, 150, 89, 23);
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(325, 150, 89, 23);
		panel.add(btnCancel);
	}

}
