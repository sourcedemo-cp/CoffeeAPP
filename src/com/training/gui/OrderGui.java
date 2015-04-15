package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.CoffeeTable;
import com.training.entity.Order;
import com.training.entity.Product;
import com.training.service.CoffeeTableService;
import com.training.service.OrderService;
import com.training.service.ProductService;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component("orderGui")
public class OrderGui extends JFrame {

	static int banId;

	@Autowired
	private Payment payment;

	@Autowired
	private CoffeeTableService coffeeTableService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CreateOrder createOrder;
	
	private JPanel contentPane;
	private JTable table;
	static JLabel lblBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderGui frame = new OrderGui();
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
	public OrderGui() {
		setTitle("Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//<<<<<<< HEAD
				//List<Order> orders = orderService.getOrderByTableID(OrderGui.banId);
				//Order order1 = (Order) orderService.getOrderByTableID(OrderGui.banId);
				//orderGuiAdd.setVisible(true);
//=======
//				orderAdd.setVisible(true);
//				orderAdd.setLocationRelativeTo(null);
//				dispose();
				try{
					
					CoffeeTable coffeeTable = coffeeTableService.findCoffeeTableById(banId);
					Order order = new Order();
					order.setPay(false);
					Date date = new Date();
					order.setDatePayment(new Timestamp(date.getTime()));
					order.setCoffeeTable(coffeeTable);
					if(orderService.addOrder(order)==true){
						JOptionPane.showMessageDialog(null, "Add successful!");
					}else {
						JOptionPane.showMessageDialog(null, "Fail!");
					}
					fillDataTable();					
				}catch(Exception ex){
					
				}
//>>>>>>> branch 'master' of https://github.com/sourcedemo-cp/CoffeeAPP.git
			}
		});
		panel_2.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					if(orderService.deleteOrderById(id)==true){
						JOptionPane.showMessageDialog(null,
								"Deleted successful!!!");
					}else {
						JOptionPane.showMessageDialog(null, "Fail!!!");
					}
					
					fillDataTable();
					
				}catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null, "Please select a row to delete");
				}
			}
		});
		panel_2.add(btnDelete);

		JButton btnCreateOrder = new JButton("Create Order");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					CreateOrder.orderId = id;
					createOrder.setVisible(true);
					createOrder.setLocationRelativeTo(null);
					createOrder.fillData();
					dispose();
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null,
							"Please select a row to create order!");
				}
			}
		});
		panel_2.add(btnCreateOrder);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payment.setVisible(true);
				payment.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel_3.add(btnBack);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_3.add(btnCancel);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_5, BorderLayout.NORTH);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 1, 179, 298, 153, 0 };
		gbl_panel_5.rowHeights = new int[] { 20, 0, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		lblBan = new JLabel();
		GridBagConstraints gbc_lblBan = new GridBagConstraints();
		gbc_lblBan.insets = new Insets(0, 0, 5, 5);
		gbc_lblBan.gridx = 1;
		gbc_lblBan.gridy = 0;
		panel_5.add(lblBan, gbc_lblBan);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		panel_6.add(scrollPane, BorderLayout.CENTER);
	}

	@PostConstruct
	public void fillDataTable() {
		List<Order> orders = orderService.findOrderByCoffeeTableId(banId);
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Date");
		dtm.addColumn("Payment");

		for (Order order : orders) {
			dtm.addRow(new Object[] { order.getOrderId(),
					order.getDatePayment(), order.getPay() == true ? "Paid" : "UnPaid" });
		}
		table.setModel(dtm);

	}

}
