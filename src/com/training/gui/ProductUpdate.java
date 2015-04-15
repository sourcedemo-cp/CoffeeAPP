package com.training.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Product;
import com.training.service.ProductService;

@Component
public class ProductUpdate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductManagement productManagement;

	@Autowired
	private ProductService productService;

	private JPanel contentPane_productUpdate;
	static JTextField txtName;
	static JTextField txtQuantity;
	static JTextField txtPrice;
	static JTextField textProductID;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane_productUpdate = new JPanel();
		contentPane_productUpdate.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_productUpdate);
		contentPane_productUpdate.setLayout(null);

		JPanel panel_infomation = new JPanel();
		panel_infomation.setLayout(null);
		panel_infomation.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_infomation.setBounds(36, 29, 359, 180);
		contentPane_productUpdate.add(panel_infomation);

		JLabel label = new JLabel("Product name:");
		label.setBounds(29, 34, 89, 14);
		panel_infomation.add(label);

		JLabel label_1 = new JLabel("Quantity:");
		label_1.setBounds(53, 59, 65, 14);
		panel_infomation.add(label_1);

		JLabel label_2 = new JLabel("Price:");
		label_2.setBounds(72, 84, 46, 14);
		panel_infomation.add(label_2);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(118, 31, 181, 20);
		panel_infomation.add(txtName);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(118, 56, 181, 20);
		panel_infomation.add(txtQuantity);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(118, 81, 181, 20);
		panel_infomation.add(txtPrice);

		JButton btnNew = new JButton("Clear");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtQuantity.setText("");
				txtPrice.setText("");
			}
		});
		btnNew.setBounds(29, 141, 89, 23);
		panel_infomation.add(btnNew);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(textProductID.getText());
					Product product = productService.findProductById(id);
					product.setProductName(txtName.getText());
					product.setProductQuantity(Integer.parseInt(txtQuantity
							.getText()));
					product.setProductPrice(Integer.parseInt(txtPrice.getText()));
					if (productService.updateProduct(product) == 1) {
						JOptionPane.showMessageDialog(null,
								"Updated Successful!!!");
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Fail!!!");
					}
					productManagement.getProduct();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please insert number in Price and Quantity field!");
				}
			}
		});
		btnOK.setBounds(140, 141, 89, 23);
		panel_infomation.add(btnOK);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productManagement.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(253, 141, 89, 23);
		panel_infomation.add(btnBack);

		JLabel lblNewLabel = new JLabel("Product ID: ");
		lblNewLabel.setBounds(29, 9, 75, 14);
		panel_infomation.add(lblNewLabel);

		textProductID = new JTextField();
		textProductID.setEnabled(false);
		textProductID.setBounds(118, 3, 181, 20);
		panel_infomation.add(textProductID);
		textProductID.setColumns(10);
	}
}
