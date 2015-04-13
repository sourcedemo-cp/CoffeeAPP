package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.config.TxNamespaceHandler;

import com.training.entity.Product;
import com.training.service.ProductService;
import com.training.service.ProductServiceImpl;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
@Component("productManagement")
public class ProductManagement extends JFrame {

	@Autowired
	private Menu menu;
	
	@Autowired
	private ProductAdd productAdd;
	
	@Autowired
	private ProductUpdate productUpdate;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	private JPanel contentPane;
	private JTable table1;
	private final JScrollBar scrollBar_1 = new JScrollBar();

	/**
	 * Launch the application.
	 */
	public int getProduct(){
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("1");
		dtm.addColumn("2");
		dtm.addColumn("3");
		dtm.addColumn("4");
		dtm.addRow(new Object[]{"ID", "Name", "Price", "Quantity"});
		List<Product> products = productServiceImpl.getAllProduct();
		for(Product pr: products){
			dtm.addRow(new Object[]{pr.getProductId(), pr.getProductName(), pr.getProductPrice(), pr.getProductQuantity()});
		}
		table1.setModel(dtm);
		return 1;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductManagement frame = new ProductManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int getProductToUpdate(){
		int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
		return 1;
	}
	/**
	 * Create the frame.
	 */
	public ProductManagement() {
		setTitle("Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setBounds(0, 0, 2, 2);
		panel_1.add(scrollPane);
		
		table1 = new JTable();
		table1.setBounds(10, 11, 541, 186);
		panel_1.add(table1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productAdd.setVisible(true);
			}
		});
		btnAdd.setBounds(21, 204, 89, 23);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productUpdate.setVisible(true);
			}
		});
		btnUpdate.setBounds(120, 204, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
				if(productServiceImpl.deleteProductById((productServiceImpl.findProductById(id)))){
					JOptionPane.showMessageDialog(null, "Deleted successful!!!");
				}else{
					JOptionPane.showMessageDialog(null, "Fail!!!");
				}
			}
		});
		btnDelete.setBounds(219, 204, 89, 23);
		panel_1.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(356, 204, 89, 23);
		panel_1.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(454, 204, 89, 23);
		panel_1.add(btnExit);
		
	}
}
