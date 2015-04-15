package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.asm.commons.TryCatchBlockSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Order;
import com.training.entity.OrderDetail;
import com.training.entity.Product;
import com.training.service.OrderDetailService;
import com.training.service.OrderService;
import com.training.service.ProductService;

import javax.swing.JButton;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component("createOrder")
public class CreateOrder extends JFrame {

	static int orderId;

	private JPanel contentPane;
	private JTextField txtQuantity;
	private JTable table;
	private JComboBox comboBox;
	private JLabel lblSum;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderGui orderGui;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateOrder frame = new CreateOrder();
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
	public CreateOrder() {
		setTitle("Order Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_infomation = new JPanel();
		contentPane.add(panel_infomation, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 107, 0, 0 };
		gbl_panel.rowHeights = new int[] { 28, 20, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_infomation.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Product:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_infomation.add(lblNewLabel, gbc_lblNewLabel);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel_infomation.add(comboBox, gbc_comboBox);

		JLabel lblQuantity = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity.insets = new Insets(0, 0, 0, 5);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 1;
		panel_infomation.add(lblQuantity, gbc_lblQuantity);

		txtQuantity = new JTextField();
		GridBagConstraints gbc_txtQuantity = new GridBagConstraints();
		gbc_txtQuantity.anchor = GridBagConstraints.WEST;
		gbc_txtQuantity.gridx = 1;
		gbc_txtQuantity.gridy = 1;
		panel_infomation.add(txtQuantity, gbc_txtQuantity);
		txtQuantity.setColumns(10);

		JPanel panel_button = new JPanel();
		panel_button.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_button, BorderLayout.SOUTH);
		panel_button.setLayout(new BorderLayout(0, 0));

		JPanel panel_orderUpdate = new JPanel();
		panel_button.add(panel_orderUpdate, BorderLayout.WEST);

		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product product = (Product) comboBox.getSelectedItem();

					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setQuantity(Integer.valueOf(txtQuantity
							.getText()));
					System.out.println("---------------------------"
							+ CreateOrder.orderId);
					Order order = orderService
							.findOrderByID(CreateOrder.orderId);

					orderDetail.setProduct(product);
					orderDetail.setOrder(order);

					orderDetailService.addOrderDetail(orderDetail);

					fillData();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Please insert integer number in Quantity!");
				}
			}
		});
		panel_orderUpdate.add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					if(orderDetailService.deleteOrderDetailByID(id) == true){
						JOptionPane.showMessageDialog(null,
								"Deleted successful!!!");
					}else {
						JOptionPane.showMessageDialog(null, "Fail!!!");
					}
					fillData();
					
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Please select a row to delete!");
				}
			}
		});
		panel_orderUpdate.add(btnDelete);

		JPanel panel_out = new JPanel();
		panel_button.add(panel_out, BorderLayout.EAST);

		JButton btnNewButton = new JButton("Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long sum = orderDetailService
							.sumOfOrderDetailByOrderId(orderId);
					lblSum.setText(Long.toString(sum));
					Order order = orderService.findOrderByID(orderId);
					order.setPay(true);
					orderService.updateOrder(order);

					// fillData();

				} catch (NullPointerException ex) {
					JOptionPane
							.showMessageDialog(null,
									"You have no order, please insert order then click");
				}
			}
		});
		panel_out.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				orderGui.setVisible(true);
				orderGui.setLocationRelativeTo(null);
				orderGui.fillDataTable();
			}
		});
		panel_out.add(btnBack);
		panel_out.add(btnCancel);

		JPanel panel_show = new JPanel();
		contentPane.add(panel_show, BorderLayout.CENTER);
		panel_show.setLayout(new BorderLayout(0, 0));

		JPanel panel_showDetail = new JPanel();
		panel_show.add(panel_showDetail, BorderLayout.SOUTH);

		JLabel label = new JLabel("Sum:");
		panel_showDetail.add(label);

		lblSum = new JLabel("");
		panel_showDetail.add(lblSum);

		JLabel lblVnd = new JLabel("VND");
		panel_showDetail.add(lblVnd);

		JPanel panel_sum = new JPanel();
		panel_show.add(panel_sum, BorderLayout.CENTER);
		panel_sum.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		panel_sum.add(scrollPane, BorderLayout.CENTER);

	}

	@PostConstruct
	public void fillData() {

		lblSum.setText("");

		// fill data to table
		List<OrderDetail> orderDetails = orderDetailService
				.findOrderDetailByOrderId(orderId);
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Order ID");
		dtm.addColumn("Product");
		dtm.addColumn("Quantity");
		dtm.addColumn("Product Price");

		for (OrderDetail orderDetail : orderDetails) {
			dtm.addRow(new Object[] {orderDetail.getOrderDetailId() ,orderDetail.getOrder().getOrderId(),
					orderDetail.getProduct().getProductName(),
					orderDetail.getQuantity(),
					orderDetail.getProduct().getProductPrice() });
		}

		table.setModel(dtm);

		// fill data to combobox
		List<Product> products = productService.getAllProduct();
		for (Product product : products) {
			comboBox.addItem(product);
		}
	}

}
