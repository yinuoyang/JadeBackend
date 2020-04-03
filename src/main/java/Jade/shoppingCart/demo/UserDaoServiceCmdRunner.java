package Jade.shoppingCart.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import Jade.shoppingCart.demo.Service.UserDAOService;


public class UserDaoServiceCmdRunner implements CommandLineRunner{
	
	private static final Logger log = 
				LoggerFactory.getLogger(UserDaoServiceCmdRunner.class);
	
	
	@Autowired
	private UserDAOService userService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("New user created");
	}

	
}
