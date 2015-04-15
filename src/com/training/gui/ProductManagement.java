package com.training.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Product;
import com.training.service.ProductService;

@SuppressWarnings("serial")
@Component("productManagement")
public class ProductManagement extends JFrame {

	@Autowired
	private Menu menu;

	@Autowired
	private ProductAdd productAdd;

	@Autowired
	private ProductUpdate productUpdate;

	@Autowired
	private ProductService productService;

	private JPanel contentPaneProduct;
	private JTable table1;
	@SuppressWarnings("unused")
	private final JScrollBar scrollBar_1 = new JScrollBar();

	/**
	 * Launch the application.
	 */
	public int getProduct() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Price");
		dtm.addColumn("Quantity");
		List<Product> products = productService.getAllProduct();
		for (Product pr : products) {
			dtm.addRow(new Object[] { pr.getProductId(), pr.getProductName(),
					pr.getProductPrice(), pr.getProductQuantity() });
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

	/**
	 * Create the frame.
	 */
	public ProductManagement() {
		setTitle("Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 293);
		contentPaneProduct = new JPanel();
		contentPaneProduct.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneProduct);
		contentPaneProduct.setLayout(new BorderLayout(0, 0));

		JPanel panelShow = new JPanel();
		contentPaneProduct.add(panelShow, BorderLayout.CENTER);
		panelShow.setLayout(new BorderLayout(0, 0));

		table1 = new JTable();
		// panel_1.add(table1);

		JScrollPane scrollPane = new JScrollPane(table1);
		panelShow.add(scrollPane, BorderLayout.CENTER);

		JPanel panelbutton = new JPanel();
		panelbutton.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPaneProduct.add(panelbutton, BorderLayout.SOUTH);
		panelbutton.setLayout(new BorderLayout(0, 0));

		JPanel panelUpdate = new JPanel();
		panelbutton.add(panelUpdate, BorderLayout.WEST);
		panelUpdate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAdd = new JButton("Add");
		panelUpdate.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		panelUpdate.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		panelUpdate.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
					if (productService.deleteProductById((productService
							.findProductById(id)))) {
						JOptionPane.showMessageDialog(null,
								"Deleted successful!!!");
					} else {
						JOptionPane.showMessageDialog(null, "Fail!!!");
					}
					getProduct();
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Please select a row to delete!");
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
					Product product = productService.findProductById(id);
					productUpdate.textProductID.setText(product.getProductId()+ "");
					productUpdate.txtName.setText(product.getProductName());
					productUpdate.txtPrice.setText(product.getProductPrice()+ "");
					productUpdate.txtQuantity.setText(product.getProductQuantity() + "");
					productUpdate.setVisible(true);
					productUpdate.setLocationRelativeTo(null);
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null,
							"Please select a row to Update!");
				}
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productAdd.setVisible(true);
				productAdd.setLocationRelativeTo(null);
			}
		});

		JPanel panelOut = new JPanel();
		panelbutton.add(panelOut, BorderLayout.EAST);
		panelOut.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnBack = new JButton("Back");
		panelOut.add(btnBack);

		JButton btnExit = new JButton("Exit");
		panelOut.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});

	}
}
