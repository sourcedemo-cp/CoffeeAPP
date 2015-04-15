package com.training.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("menu")
public class Menu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private EmployeeManagement employeeManagement;
	
	@Autowired
	private ProductManagement productManagement;
	
	@Autowired
	private CoffeeTableManagement coffeeTableManagement;
	
	@Autowired
	private Payment payment;
	
	private JPanel contentPaneMenu;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuBarList = new JMenu("Management");
		menuBar.add(menuBarList);
		
		JMenuItem menuEmployee = new JMenuItem("Employee");
		menuEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employeeManagement.setVisible(true);
				employeeManagement.setLocationRelativeTo(null);
				employeeManagement.fillAllData();
				dispose();
			}
		});
		menuBarList.add(menuEmployee);
		
		JMenuItem menuTable = new JMenuItem("Table");
		menuTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coffeeTableManagement.setVisible(true);
				coffeeTableManagement.setLocationRelativeTo(null);
				
				coffeeTableManagement.fillAllData();
				dispose();
			}
		});
		menuBarList.add(menuTable);
		
		JMenuItem menuProduct = new JMenuItem("Product");
		menuProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productManagement.setVisible(true);
				productManagement.setLocationRelativeTo(null);
				productManagement.getProduct();
				dispose();
			}
		});
		menuBarList.add(menuProduct);
		
		JMenuItem menuPayment = new JMenuItem("Payment");
		menuPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment.setVisible(true);
				payment.setLocationRelativeTo(null);
				payment.initButtons();
				dispose();
			}
		});
		menuBarList.add(menuPayment);
		contentPaneMenu = new JPanel();
		contentPaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneMenu);
		contentPaneMenu.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 414, 219);
		contentPaneMenu.add(table);
	}
}
