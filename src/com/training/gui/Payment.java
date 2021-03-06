package com.training.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.CoffeeTable;
import com.training.service.CoffeeTableService;

import java.awt.FlowLayout;
@SuppressWarnings("serial")
@Component("payment")
public class Payment extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JButton[] btn_Bans;
	
	@Autowired
	private CoffeeTableService coffeeTableService;
	
	@Autowired
	private OrderGui orderGui;
	
	@Autowired
	private Menu menu;
	
	private List<CoffeeTable> coffeeTables;
	
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	
	public Payment() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Payment");
	}
	
	@PostConstruct
	public void initButtons() {
		coffeeTables = coffeeTableService.getAllCoffeeTable();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTable = new JPanel();
		contentPane.add(panelTable, BorderLayout.CENTER);
		panelTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_Bans = new JButton[coffeeTables.size()];
		for(int i = 0;i < coffeeTables.size();i ++){
			btn_Bans[i] = new JButton(coffeeTables.get(i).getTableName());
			panelTable.add(btn_Bans[i]);
			btn_Bans[i].addActionListener(this);
		}

		JPanel panelButton = new JPanel();
		getContentPane().add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new BorderLayout(0, 0));
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelOut = new JPanel();
		panelButton.add(panelOut, BorderLayout.EAST);
		panelOut.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		panelOut.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelOut.add(btnNewButton_1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		for(int i = 0;i < coffeeTables.size();i++){
			if(e.getSource()==btn_Bans[i]){
				String tableName = coffeeTables.get(i).getTableName();
				OrderGui.banId = coffeeTables.get(i).getTableId();
				OrderGui.lblBan.setText(tableName);
				orderGui.fillDataTable();
				orderGui.setVisible(true);
				orderGui.setLocationRelativeTo(null);
				dispose();
			}
		}
	}

}
