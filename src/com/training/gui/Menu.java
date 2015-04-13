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
	private Service service;
	
	@Autowired
	private CoffeeTableManagement coffeeTableManagement;
	
	private JPanel contentPane;
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
		
		JMenu mnNewMenu = new JMenu("Management");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Employee");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employeeManagement.setVisible(true);
				employeeManagement.AllData();
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Table");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coffeeTableManagement.setVisible(true);
				coffeeTableManagement.setLocationRelativeTo(null);
				
				coffeeTableManagement.AllData();
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmSystem = new JMenuItem("System");
		mntmSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				service.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmSystem);
		
		JMenuItem menuProduct = new JMenuItem("Product");
		menuProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productManagement.setVisible(true);
				productManagement.getProduct();
				dispose();
			}
		});
		mnNewMenu.add(menuProduct);
		
		JMenu mnNewMenu_1 = new JMenu("Statistic");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Revenue");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("S\u1EA3n ph\u1EA9m");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 414, 219);
		contentPane.add(table);
	}
}
