package com.training.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.dao.EmployeeDAOImpl;
import com.training.dao.OrderDetailDAOImpl;
import com.training.entity.CoffeeTable;
import com.training.entity.OrderDetail;
import com.training.entity.Product;
import com.training.service.EmployeeServiceImpl;
import com.training.service.OrderDetailService;
import com.training.service.OrderDetailServiceImpl;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

@Component("service")
public class Service extends JFrame {

	@Autowired
	private ServiceProduct serviceProduct;

	@Autowired
	private Menu menu;

	@Autowired
	private OrderDetailService orderDetailService;

	// @Autowired
	// private OrderDetailDAOImpl orderDetailDAOImpl;

	private JPanel contentPane;
	private JTable tableDisplay;

	/**
	 * Launch the application.
	 */
	public int getOrderDetail() {
		Product product = new Product();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("1");
		dtm.addColumn("2");
		dtm.addColumn("3");
		dtm.addColumn("4");
		dtm.addColumn("5");
		dtm.addRow(new Object[] { "ID", "Name", "Price", "Quantity", "Payment" });
		//CoffeeTable coffeeTable = new CoffeeTable();
		int id = 1;
		CoffeeTable cf = new CoffeeTable();
		cf.setTableId(id);
		List<OrderDetail> orderDetails = (List<OrderDetail>) orderDetailService.getOrderDetailByID(1);
		for (OrderDetail orderDetail : orderDetails) {
			dtm.addRow(new Object[] { orderDetail.getOrderDetailId(),
					orderDetail.getProduct().getProductName(),
					orderDetail.getProduct().getProductPrice(),
					orderDetail.getQuantity(), orderDetail.getPayment() });
		}
		tableDisplay.setModel(dtm);
		return 1;
	}

	// product.getProductName(), product.getProductPrice(),
	// List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetail();
	// if(orderDetails != null){
	// for (int i =0;i< orderDetails.size();i++) {
	//
	// System.out.println(orderDetails.get(i).getOrderDetailId());
	// }
	// }
	//
	//
	// List<OrderDetail> orders =this.orderDetailService.getAllOrderDetail();
	//
	// for(OrderDetail orderDetail: orders){
	// dtm.addRow(new Object[]{orderDetail.getOrder(), orderDetail.getPayment(),
	// orderDetail.getQuantity(), orderDetail.getOrderDetailId()});
	// }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service frame = new Service();
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
	public Service() {
		setTitle("Service");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "B\u00E0n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 6, 528, 138);
		contentPane.add(panel);
		panel.setLayout(null);

		final JButton table1 = new JButton("B\u00E0n 1");
		table1.setForeground(Color.GRAY);
		table1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (getOrderDetail() == 1) {
					table1.setForeground(Color.BLUE);
				}
			}
		});
		table1.setBounds(20, 24, 89, 23);
		panel.add(table1);

		JButton table2 = new JButton("B\u00E0n 2");
		table2.setForeground(Color.GRAY);
		table2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (getOrderDetail() != 1) {
					table1.setForeground(Color.RED);
				}
			}
		});
		table2.setBounds(119, 24, 89, 23);
		panel.add(table2);

		JButton table3 = new JButton("B\u00E0n 3");
		table3.setForeground(Color.GRAY);
		table3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		table3.setBounds(218, 24, 89, 23);
		panel.add(table3);

		JButton table4 = new JButton("B\u00E0n 4");
		table4.setForeground(Color.GRAY);
		table4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		table4.setBounds(317, 24, 89, 23);
		panel.add(table4);

		JButton table5 = new JButton("B\u00E0n 5");
		table5.setForeground(Color.GRAY);
		table5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		table5.setBounds(416, 24, 89, 23);
		panel.add(table5);

		JButton table6 = new JButton("B\u00E0n 6");
		table6.setForeground(Color.GRAY);
		table6.setBounds(20, 79, 89, 23);
		panel.add(table6);

		JButton table7 = new JButton("B\u00E0n 7");
		table7.setForeground(Color.GRAY);
		table7.setBounds(119, 79, 89, 23);
		panel.add(table7);

		JButton table8 = new JButton("B\u00E0n 8");
		table8.setForeground(Color.GRAY);
		table8.setBounds(218, 79, 89, 23);
		panel.add(table8);

		JButton table9 = new JButton("B\u00E0n 9");
		table9.setForeground(Color.GRAY);
		table9.setBounds(317, 79, 89, 23);
		panel.add(table9);

		JButton table10 = new JButton("B\u00E0n 10");
		table10.setForeground(Color.GRAY);
		table10.setBounds(416, 79, 89, 23);
		panel.add(table10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Chi ti\u1EBFt",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(10, 145, 528, 300);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		tableDisplay = new JTable();
		tableDisplay.setBounds(10, 28, 508, 272);
		panel_2.add(tableDisplay);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(545, 11, 263, 253);
		contentPane.add(panel_4);
		panel_4.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Ho\u1EA1t \u0111\u1ED9ng",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_4.setLayout(null);

		JButton btnThanhTon = new JButton("Thanh to\u00E1n");
		btnThanhTon.setBounds(85, 28, 109, 36);
		panel_4.add(btnThanhTon);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(58, 211, 89, 23);
		panel_4.add(btnBack);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(156, 211, 89, 23);
		panel_4.add(btnExit);

		JButton btnGiMn = new JButton("G\u1ECDi m\u00F3n");
		btnGiMn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serviceProduct.setVisible(true);
			}
		});
		btnGiMn.setBounds(85, 87, 109, 36);
		panel_4.add(btnGiMn);

		JButton btnNewButton = new JButton("In h\u00F3a \u0111\u01A1n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getOrderDetail();
			}
		});
		btnNewButton.setBounds(85, 150, 109, 36);
		panel_4.add(btnNewButton);

		JLabel lblQunCngNhn = new JLabel(
				"Qu\u00E1n C\u01B0\u1EDDng Nh\u00E2n d\u00E2n t\u1EC7 - 69 h\u00E0ng nho");
		lblQunCngNhn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQunCngNhn.setBounds(568, 295, 240, 25);
		contentPane.add(lblQunCngNhn);

		JLabel lblNgonB = new JLabel("Ngon - B\u1ED5 - r\u1EBB ");
		lblNgonB.setBounds(650, 329, 97, 14);
		contentPane.add(lblNgonB);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
	}
}
