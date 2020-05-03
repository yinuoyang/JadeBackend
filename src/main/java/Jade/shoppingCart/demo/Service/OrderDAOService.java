package Jade.shoppingCart.demo.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import Jade.shoppingCart.demo.Entity.Orders;



@Repository
@Transactional
public class OrderDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(Orders order) {
		
		entityManager.persist(order);
		
		return order.getId();
	}
}
