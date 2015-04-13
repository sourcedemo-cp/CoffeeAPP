package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.dao.OrderDetailDAOImpl;
import com.training.entity.CoffeeTable;
import com.training.entity.OrderDetail;
import com.training.entity.Product;
import com.training.service.CoffeeTableService;
import com.training.service.OrderDetailService;
import com.training.service.OrderDetailServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
@Component("serviceProduct")
public class ServiceProduct extends JFrame {
	
	@Autowired
	private Service service;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private CoffeeTableService coffeeTableService;
	
	private JPanel contentPane;
	private JTextField textQuantity;
	private JTable tableProduct;

	/**
	 * Launch the application.
	 */
//	List<OrderDetail> orderDetails = (List<OrderDetail>) orderDetailService;
//	 Vector<String> vTableID = new Vector<String>();
//	private DefaultComboBoxModel dcm = new DefaultComboBoxModel();
	public int getOrderDetail1() {
		Product product = new Product();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("1");
		dtm.addColumn("2");
		dtm.addColumn("3");
		dtm.addColumn("4");
		dtm.addColumn("5");
		dtm.addRow(new Object[] { "ID", "Name", "Price", "Quantity", "Payment" });
		// CoffeeTable coffeeTable = new CoffeeTable();
		int id = 1;
		CoffeeTable cf = new CoffeeTable();
		cf.setTableId(id);
		List<OrderDetail> orderDetails = (List<OrderDetail>) orderDetailService
				.getOrderDetailByID(1);
		if (orderDetails.size() != 0) {
			for (OrderDetail orderDetail : orderDetails) {
				dtm.addRow(new Object[] { orderDetail.getOrderDetailId(),
						orderDetail.getProduct().getProductName(),
						orderDetail.getProduct().getProductPrice(),
						orderDetail.getQuantity(), orderDetail.getPayment() });
			}
			tableProduct.setModel(dtm);
			return 1;
		}
		return -1;
	}
	
	public void loadDataCB(){
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceProduct frame = new ServiceProduct();
					frame.setVisible(true);
					frame.coffeeTableService.getAllCoffeeTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServiceProduct() {
		
		
		
		setTitle("Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(62, 46, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblTableId = new JLabel("Table ID: ");
		lblTableId.setBounds(62, 110, 65, 14);
		contentPane.add(lblTableId);
		
		JLabel lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setBounds(334, 46, 65, 14);
		contentPane.add(lblQuantity);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Cafe \u0110en", "Cafe S\u1EEFa", "Sting d\u00E2u", "Sting v\u00E0ng", "C2"}));
		comboBox1.setBounds(137, 43, 99, 20);
		contentPane.add(comboBox1);
		
		JComboBox comboBox2 = new JComboBox();
//		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
//		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"B\u00E0n 1", "B\u00E0n 2", "B\u00E0n 3", "B\u00E0n 4", "B\u00E0n 5", "B\u00E0n 6", "B\u00E0n 7", "B\u00E0n 8", "B\u00E0n 9", "B\u00E0n 10"}));
//		for(CoffeeTable coffeeTabless: coffeeTableService.getAllCoffeeTable()) {
//		    dcm.addElement(coffeeTabless.getTableName());
//		}
//		comboBox2.setModel(dcm);
//		comboBox2.addItem(cfs.get(0).getTableName());
		comboBox2.setForeground(Color.BLACK);
		comboBox2.setBounds(137, 107, 99, 20);
		contentPane.add(comboBox2);
//		List<CoffeeTable> coffeeTables = coffeeTableService.getAllCoffeeTable();
//		comboBox2.addItem(coffeeTables.get(0).getTableId());
		
		textQuantity = new JTextField();
		textQuantity.setBounds(409, 43, 122, 20);
		contentPane.add(textQuantity);
		textQuantity.setColumns(10);
		
		tableProduct = new JTable();
		tableProduct.setBounds(10, 155, 600, 254);
		contentPane.add(tableProduct);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(332, 106, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBounds(442, 106, 89, 23);
		contentPane.add(btnExit);
		
		JButton btAdd = new JButton("Add");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btAdd.setBounds(334, 72, 89, 23);
		contentPane.add(btAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(442, 74, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
//				try{
//					getOrderDetail();
//				}catch(java.lang.NullPointerException ex){
//					JOptionPane.showMessageDialog(null, "Null roi!!!");
//				}
			}
		});
		btnView.setBounds(541, 86, 89, 23);
		contentPane.add(btnView);
	}
	private void getDataCB() {
		// TODO Auto-generated method stub
		
	}
}
