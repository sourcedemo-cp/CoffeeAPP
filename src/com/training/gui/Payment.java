package com.training.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.CoffeeTable;
import com.training.service.CoffeeTableService;
import java.awt.FlowLayout;
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
		setTitle("Order");
		
		JPanel panel1 = new JPanel();
		getContentPane().add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel2 = new JPanel();
		panel1.add(panel2, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel1.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_1.add(btnNewButton_1);
	
	}
	
	@PostConstruct
	public void initButtons() {
		coffeeTables = coffeeTableService.getAllCoffeeTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		btn_Bans = new JButton[coffeeTables.size()];
		for(int i = 0;i < coffeeTables.size();i ++){
			btn_Bans[i] = new JButton(coffeeTables.get(i).getTableName());
			panel.add(btn_Bans[i]);
			btn_Bans[i].addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		for(int i = 0;i < coffeeTables.size();i++){
			if(e.getSource()==btn_Bans[i]){
				System.out.println("OK");
				orderGui.setVisible(true);
				orderGui.setLocationRelativeTo(null);
			}
		}
	}

}
