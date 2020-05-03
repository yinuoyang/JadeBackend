package Jade.shoppingCart.demo.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Jade.shoppingCart.demo.Entity.Orders;


public interface OrdersRepository extends JpaRepository<Orders, Long>{
	List <Orders> findByUserId(String userId);
	Orders  findByOrdId(String orderId);

}
