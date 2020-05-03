package Jade.shoppingCart.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Jade.shoppingCart.demo.Service.OrderDAOService;
import Jade.shoppingCart.demo.Service.OrdersRepository;
import Jade.shoppingCart.demo.Service.UserDAOService;


public class OrderDaoServiceCmdRunner implements CommandLineRunner{
	
	private static final Logger log = 
				LoggerFactory.getLogger(OrderDaoServiceCmdRunner.class);
	
	
	@Autowired
	private OrdersRepository orderService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("New order created");
	}

	
}
