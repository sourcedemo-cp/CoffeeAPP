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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.CoffeeTable;
import com.training.service.CoffeeTableService;

@Component("coffeeTableManagement")
public class CoffeeTableManagement extends JFrame {

	private static final long serialVersionUID = 1L;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Autowired
	private CoffeeTableService coffeeTableService;

	@Autowired
	private Menu menu;

	@Autowired
	private CoffeeTableAdd coffeeTableAdd;

	@Autowired
	private CoffeeTableUpdate coffeeTableUpdate;

	private JPanel contentPaneTableManagement;
	private JTable table_management;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeTableManagement frame = new CoffeeTableManagement();
					frame.setVisible(true);
					frame.table_management.repaint();
					frame.table_management.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeTableManagement() {
		setTitle("Table Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 322);
		contentPaneTableManagement = new JPanel();
		contentPaneTableManagement.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneTableManagement);
		contentPaneTableManagement.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPaneTableManagement.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelUpdate = new JPanel();
		panel.add(panelUpdate, BorderLayout.WEST);
		panelUpdate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coffeeTableAdd.setVisible(true);
				coffeeTableAdd.setLocationRelativeTo(null);
			}
		});
		panelUpdate.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table_management.getValueAt(table_management.getSelectedRow(), 0);
					CoffeeTable coffeeTable = coffeeTableService.findCoffeeTableById(id);
					coffeeTableUpdate.txfID.setText(coffeeTable.getTableId()+ "");
					coffeeTableUpdate.txfName.setText(coffeeTable.getTableName() + "");
					coffeeTableUpdate.setVisible(true);
					coffeeTableUpdate.setLocationRelativeTo(null);
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Please select a row to edit");
				}
			}
		});
		panelUpdate.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table_management.getValueAt(table_management.getSelectedRow(), 0);
					if (coffeeTableService.deleteCoffeeTableById(id) == true) {
						JOptionPane.showMessageDialog(null,
								"Deleted successful!!!");
					} else {
						JOptionPane.showMessageDialog(null, "Fail!!!");
					}

					fillAllData();
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null,
							"Please select a row to delete");
				}
			}
		});
		panelUpdate.add(btnDelete);

		JPanel panelOut = new JPanel();
		panel.add(panelOut, BorderLayout.EAST);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		panelOut.add(btnBack);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panelOut.add(btnExit);

		JPanel panelScroll = new JPanel();
		contentPaneTableManagement.add(panelScroll, BorderLayout.CENTER);
		panelScroll.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelScroll.add(scrollPane, BorderLayout.CENTER);

		table_management = new JTable();
		scrollPane.setViewportView(table_management);
	}

	protected int fillAllData() {

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Name");

		List<CoffeeTable> coffeeTables = coffeeTableService.getAllCoffeeTable();
		for (CoffeeTable coffeeTable : coffeeTables) {
			dtm.addRow(new Object[] { coffeeTable.getTableId(),
					coffeeTable.getTableName() });
		}

		table_management.setModel(dtm);
		table_management.repaint();
		table_management.revalidate();
		return 1;
	}

}
