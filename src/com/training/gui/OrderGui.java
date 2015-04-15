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
	
	private JPanel contentPane_order;
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
		contentPane_order = new JPanel();
		contentPane_order.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_order);
		contentPane_order.setLayout(new BorderLayout(0, 0));

		JPanel panel_order = new JPanel();
		contentPane_order.add(panel_order, BorderLayout.CENTER);
		panel_order.setLayout(new BorderLayout(0, 0));

		JPanel panel_button = new JPanel();
		panel_button.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_order.add(panel_button, BorderLayout.SOUTH);
		panel_button.setLayout(new BorderLayout(0, 0));

		JPanel panel_Update = new JPanel();
		panel_button.add(panel_Update, BorderLayout.WEST);

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
		panel_Update.add(btnAdd);

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
		panel_Update.add(btnDelete);

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
		panel_Update.add(btnCreateOrder);

		JPanel panel_out = new JPanel();
		panel_button.add(panel_out, BorderLayout.EAST);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payment.setVisible(true);
				payment.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel_out.add(btnBack);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_out.add(btnCancel);

		JPanel panel_ = new JPanel();
		panel_.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_order.add(panel_, BorderLayout.CENTER);
		panel_.setLayout(new BorderLayout(0, 0));

		JPanel panel_infomation = new JPanel();
		panel_infomation.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_.add(panel_infomation, BorderLayout.NORTH);
		GridBagLayout gbl_panel_infomation = new GridBagLayout();
		gbl_panel_infomation.columnWidths = new int[] { 1, 179, 298, 153, 0 };
		gbl_panel_infomation.rowHeights = new int[] { 20, 0, 0 };
		gbl_panel_infomation.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_infomation.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_infomation.setLayout(gbl_panel_infomation);

		lblBan = new JLabel();
		GridBagConstraints gbc_lblBan = new GridBagConstraints();
		gbc_lblBan.insets = new Insets(0, 0, 5, 5);
		gbc_lblBan.gridx = 1;
		gbc_lblBan.gridy = 0;
		panel_infomation.add(lblBan, gbc_lblBan);

		JPanel panel_showDetail = new JPanel();
		panel_showDetail.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_.add(panel_showDetail, BorderLayout.CENTER);
		panel_showDetail.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		panel_showDetail.add(scrollPane, BorderLayout.CENTER);
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
