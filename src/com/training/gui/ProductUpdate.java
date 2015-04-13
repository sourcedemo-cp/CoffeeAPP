package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Product;
import com.training.service.ProductService;
import com.training.service.ProductServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class ProductUpdate extends JFrame {

	@Autowired
	private ProductManagement productManagement;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtQuantity;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductUpdate frame = new ProductUpdate();
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
	public ProductUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(36, 29, 359, 180);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Product name:");
		label.setBounds(29, 34, 89, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Quantity:");
		label_1.setBounds(53, 59, 65, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Price:");
		label_2.setBounds(72, 84, 46, 14);
		panel.add(label_2);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(118, 31, 181, 20);
		panel.add(txtName);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(118, 56, 181, 20);
		panel.add(txtQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(118, 81, 181, 20);
		panel.add(txtPrice);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtQuantity.setText("");
				txtPrice.setText("");
			}
		});
		btnNew.setBounds(29, 141, 89, 23);
		panel.add(btnNew);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Product product = productServiceImpl.updateProduct(product);
//				txtName.setText(product.getProductName());
//				txtQuantity.setText(product.getProductPrice() + "");
//				txtPrice.setText(product.getProductPrice() + "");
				
//				Product product = new Product();
//				product.setProductName(txtName.getText());
//				product.setProductQuantity(Integer.parseInt(txtQuantity.getText()));
//				product.setProductPrice(Integer.parseInt(txtPrice.getText()));
//				if(productService.updateProduct(product) == 1) {
//					JOptionPane.showMessageDialog(null, "Added Successful!!!");
//				}else{
//					JOptionPane.showMessageDialog(null, "Fail!!!");
//				}
			}
		});
		btnOK.setBounds(140, 141, 89, 23);
		panel.add(btnOK);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productManagement.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(253, 141, 89, 23);
		panel.add(btnBack);
	}
}
