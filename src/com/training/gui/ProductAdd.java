package com.training.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Employee;
import com.training.entity.Product;
import com.training.service.EmployeeService;
import com.training.service.ProductService;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

@Component("productAdd")
public class ProductAdd extends JDialog {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductManagement productManagement;

	private final JPanel contentPanel = new JPanel();
	private JTextField txfProductName;
	private JTextField txfQuantity;
	private JTextField txfPrice;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			ProductAdd dialog = new ProductAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProductAdd() {
		setBounds(100, 100, 375, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblProductName = new JLabel("Product name:");
		lblProductName.setBounds(29, 34, 89, 14);
		contentPanel.add(lblProductName);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(53, 59, 65, 14);
		contentPanel.add(lblQuantity);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(72, 84, 46, 14);
		contentPanel.add(lblPrice);

		txfProductName = new JTextField();
		txfProductName.setBounds(118, 31, 181, 20);
		contentPanel.add(txfProductName);
		txfProductName.setColumns(10);

		txfQuantity = new JTextField();
		txfQuantity.setBounds(118, 56, 181, 20);
		contentPanel.add(txfQuantity);
		txfQuantity.setColumns(10);

		txfPrice = new JTextField();
		txfPrice.setBounds(118, 81, 181, 20);
		contentPanel.add(txfPrice);
		txfPrice.setColumns(10);

		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txfProductName.setText("");
				txfQuantity.setText("");
				txfPrice.setText("");
			}
		});
		btnNewButton.setBounds(29, 141, 89, 23);
		contentPanel.add(btnNewButton);

		JButton btnAdd = new JButton("OK");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product product = new Product();
					product.setProductName(txfProductName.getText());
					product.setProductQuantity(Integer.parseInt(txfQuantity
							.getText()));
					product.setProductPrice(Integer.parseInt(txfPrice.getText()));
					if (productService.addProduct(product) == 1) {
						JOptionPane.showMessageDialog(null,
								"Added Successful!!!");
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Fail!!!");
					}
					productManagement.getProduct();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please insert a number in to Price and Quantity field!");
				}
			}
		});
		btnAdd.setBounds(140, 141, 89, 23);
		contentPanel.add(btnAdd);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productManagement.setVisible(true);
				productManagement.getProduct();
				dispose();
			}
		});
		btnBack.setBounds(253, 141, 89, 23);
		contentPanel.add(btnBack);
	}
}
