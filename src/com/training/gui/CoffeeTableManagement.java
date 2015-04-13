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

import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@Component("coffeeTableManagement")
public class CoffeeTableManagement extends JFrame {
	
	private int id;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Autowired
	private CoffeeTableService coffeeTableService;
	
	@Autowired
	private Menu menu;
	
	@Autowired
	private CoffeeTableAdd coffeeTableAdd;
	
	@Autowired
	private CoffeeTableUpdate coffeeTableUpdate;
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeTableManagement frame = new CoffeeTableManagement();
					frame.setVisible(true);
					frame.table.repaint();
					frame.table.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeTableManagement() {
		setTitle("Table Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coffeeTableAdd.setVisible(true);
				coffeeTableAdd.setLocationRelativeTo(null);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffeeTableUpdate.setVisible(true);
				coffeeTableUpdate.setLocationRelativeTo(null);
			}
		});
		panel_1.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) table.getValueAt(table.getSelectedRow(), 0);
				if(coffeeTableService.deleteCoffeeTableById(id)== true){
					JOptionPane.showMessageDialog(null, "Deleted successful!!!");
				}else {
					JOptionPane.showMessageDialog(null, "Fail!!!");
				}
				
				AllData();
			}
		});
		panel_1.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	
	protected int AllData(){
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Name");

		List<CoffeeTable> coffeeTables = coffeeTableService.getAllCoffeeTable();
		for (CoffeeTable coffeeTable : coffeeTables) {
			dtm.addRow(new Object[]{coffeeTable.getTableId(),coffeeTable.getTableName()});
		}
		
		table.setModel(dtm);
		table.repaint();
		table.revalidate();
		return 1;
	}

}
