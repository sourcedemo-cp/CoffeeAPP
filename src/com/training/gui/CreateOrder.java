package com.training.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Order;
import com.training.entity.OrderDetail;
import com.training.entity.Product;
import com.training.service.OrderDetailService;
import com.training.service.OrderService;
import com.training.service.ProductService;

@Component("createOrder")
public class CreateOrder extends JFrame {

	private static final long serialVersionUID = 6372870975820166134L;

	static int orderId;

	private JPanel contentPane;
	private JTextField txtQuantity;
	private JTable table;
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
	public CreateOrder() {
		setTitle("Order Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelInfomation = new JPanel();
		contentPane.add(panelInfomation, BorderLayout.NORTH);
		GridBagLayout gbl_panelInfomation = new GridBagLayout();
		gbl_panelInfomation.columnWidths = new int[] { 107, 0, 0 };
		gbl_panelInfomation.rowHeights = new int[] { 28, 20, 0 };
		gbl_panelInfomation.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelInfomation.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelInfomation.setLayout(gbl_panelInfomation);

		JLabel lblNewLabel = new JLabel("Product:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelInfomation.add(lblNewLabel, gbc_lblNewLabel);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panelInfomation.add(comboBox, gbc_comboBox);

		JLabel lblQuantity = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity.insets = new Insets(0, 0, 0, 5);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 1;
		panelInfomation.add(lblQuantity, gbc_lblQuantity);

		txtQuantity = new JTextField();
		GridBagConstraints gbc_txtQuantity = new GridBagConstraints();
		gbc_txtQuantity.anchor = GridBagConstraints.WEST;
		gbc_txtQuantity.gridx = 1;
		gbc_txtQuantity.gridy = 1;
		panelInfomation.add(txtQuantity, gbc_txtQuantity);
		txtQuantity.setColumns(10);

		JPanel panelButton = new JPanel();
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new BorderLayout(0, 0));

		JPanel panelOrderUpdate = new JPanel();
		panelButton.add(panelOrderUpdate, BorderLayout.WEST);

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
		panelOrderUpdate.add(btnSave);

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
		panelOrderUpdate.add(btnDelete);

		JPanel panelOut = new JPanel();
		panelButton.add(panelOut, BorderLayout.EAST);

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
		panelOut.add(btnNewButton);

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
		panelOut.add(btnBack);
		panelOut.add(btnCancel);

		JPanel panelShow = new JPanel();
		contentPane.add(panelShow, BorderLayout.CENTER);
		panelShow.setLayout(new BorderLayout(0, 0));

		JPanel panelShowDetail = new JPanel();
		panelShow.add(panelShowDetail, BorderLayout.SOUTH);

		JLabel label = new JLabel("Sum:");
		panelShowDetail.add(label);

		lblSum = new JLabel("");
		panelShowDetail.add(lblSum);

		JLabel lblVnd = new JLabel("VND");
		panelShowDetail.add(lblVnd);

		JPanel panelSum = new JPanel();
		panelShow.add(panelSum, BorderLayout.CENTER);
		panelSum.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		panelSum.add(scrollPane, BorderLayout.CENTER);

	}

	@SuppressWarnings("unchecked")
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
