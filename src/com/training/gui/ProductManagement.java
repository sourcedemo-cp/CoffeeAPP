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
import javax.swing.border.LineBorder;
import java.awt.Color;
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
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Price");
		dtm.addColumn("Quantity");
		List<Product> products = productServiceImpl.getAllProduct();
		for(Product pr: products){
			dtm.addRow(new Object[]{pr.getProductId(), pr.getProductName(), pr.getProductPrice(), pr.getProductQuantity()});
		}
		table1.setModel(dtm);
		table1.repaint();
		table1.revalidate();
		return 1;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductManagement frame = new ProductManagement();
					frame.setVisible(true);
					frame.table1.repaint();
					frame.table1.revalidate();
					
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
		contentPane.add(panel_1,BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table1 = new JTable();
//		panel_1.add(table1);
		
		
		JScrollPane scrollPane = new JScrollPane(table1);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		panel_2.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		panel_2.add(btnDelete);
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
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productUpdate.setVisible(true);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productAdd.setVisible(true);
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnBack = new JButton("Back");
		panel_3.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		panel_3.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		
	}
}
