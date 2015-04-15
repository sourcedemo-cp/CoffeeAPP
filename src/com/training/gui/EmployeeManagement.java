package com.training.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.training.entity.Employee;
import com.training.service.EmployeeService;
import com.training.service.EmployeeServiceImpl;

@Component("employeeManagement")
public class EmployeeManagement extends JFrame {

	private static final long serialVersionUID = -7604799192448396715L;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private Menu menu;

	@Autowired
	private EmployeeAdd employeeAdd;

	@Autowired
	private EmployeeEdit employeeEdit;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private ProductManagement productManagement;

	private JPanel contentPaneEmpManagement;

	/**
	 * Launch the application.
	 */

	private JTable table1;

	public int fillAllData() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Address");
		dtm.addColumn("Telephone");
		dtm.addColumn("Sex");
		dtm.addColumn("User name");
		dtm.addColumn("Password");
		for (Employee employee : this.employeeService.getAllEmployee()) {
			dtm.addRow(new Object[] { employee.getEmployeeId(),
					employee.getEmployeeName(), employee.getEmployeeAddress(),
					employee.getEmployeeTelephone(), employee.getEmployeeSex(),
					employee.getUserName(), employee.getPassword() });
		}
		this.table1.setModel(dtm);
		this.table1.repaint();
		this.table1.revalidate();
		return 1;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagement frame = new EmployeeManagement();
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
	public EmployeeManagement() {
		setTitle("Employee management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 323);
		contentPaneEmpManagement = new JPanel();
		contentPaneEmpManagement.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneEmpManagement);
		contentPaneEmpManagement.setLayout(new BorderLayout(0, 0));

		JPanel panelButton = new JPanel();
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPaneEmpManagement.add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new BorderLayout(0, 0));

		JPanel panelUpdate = new JPanel();
		panelButton.add(panelUpdate, BorderLayout.WEST);
		panelUpdate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNew = new JButton("Add");
		panelUpdate.add(btnNew);

		JButton btnUpdate = new JButton("Update");
		panelUpdate.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		panelUpdate.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
					if (employeeServiceImpl
							.deleteEmployeeById(employeeServiceImpl
									.findEmployeeById(id))) {
						JOptionPane.showMessageDialog(null,
								"Deleted successful!!!");
					} else {
						JOptionPane.showMessageDialog(null, "Fail!!!");
					}
					fillAllData();
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Please select a row to delete!");
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
					Employee employee = employeeService.findEmployeeById(id);
					EmployeeEdit.textID.setText(employee.getEmployeeId() + "");
					EmployeeEdit.textName.setText(employee.getEmployeeName());
					EmployeeEdit.textAddress.setText(employee
							.getEmployeeAddress());
					EmployeeEdit.textTel.setText(employee
							.getEmployeeTelephone());
					EmployeeEdit.textSex.setText(employee.getEmployeeSex());
					EmployeeEdit.textUser.setText(employee.getUserName());
					EmployeeEdit.textPass.setText(employee.getPassword());
					employeeEdit.setVisible(true);
					employeeEdit.setLocationRelativeTo(null);
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null,
							"Please select a row to update!");
				}
			}
		});
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employeeAdd.setVisible(true);
				employeeAdd.setLocationRelativeTo(null);
			}
		});

		JPanel panelOut = new JPanel();
		panelButton.add(panelOut, BorderLayout.EAST);

		JButton btnNewButton = new JButton("Back");
		panelOut.add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		panelOut.add(btnExit);

		JPanel panelShow = new JPanel();
		contentPaneEmpManagement.add(panelShow, BorderLayout.CENTER);
		panelShow.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelShow.add(scrollPane, BorderLayout.CENTER);

		table1 = new JTable();

		scrollPane.setViewportView(table1);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
				dispose();
			}
		});
	}
}
