package Jade.shoppingCart.demo.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import Jade.shoppingCart.demo.Entity.User;


public class UserDAOService {
		@PersistenceContext
		private EntityManager entityManager;
		
		public long insert (User user) {
			entityManager.persist(user);
			return user.getDdId();
		}
}
