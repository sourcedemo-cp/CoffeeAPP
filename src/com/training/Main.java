package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.gui.Login;


public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		Login login = (Login) context.getBean("login");
		login.setVisible(true);
		login.setLocationRelativeTo(null);
		

	}

}
