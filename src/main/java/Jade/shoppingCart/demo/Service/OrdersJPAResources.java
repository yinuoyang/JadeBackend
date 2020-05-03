package Jade.shoppingCart.demo.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.TimerTask;

import Jade.shoppingCart.demo.Entity.Orders;
import com.google.gson.*;

@RestController
public class OrdersJPAResources {
	
	public Gson g = new Gson();
	@Autowired
	private OrdersRepository ordersRepository;
	private Timer timer = new Timer();
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping("/orders/{userid}")
	public List <Orders> retrieveUserOrders (@PathVariable String userid) {
		System.out.println(userid);
		List <Orders> orders = ordersRepository.findByUserId('"'+ userid + '"');
		System.out.println(orders);
		return orders;
		
	}
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/orders/addOrder")
	public String addOrders(@Valid @RequestBody String orders) {
		
		JsonObject order = new JsonParser().parse(orders).getAsJsonObject();
		JsonObject orderItem = (JsonObject) order.get("order");
		String userid = "";
		System.out.println(orderItem);
		if(orderItem.get("userId") != null) {
			userid = orderItem.get("userId").toString();
		}
		Orders newOrder = new Orders(orderItem.get("productName").toString(),orderItem.get("price").toString(),orderItem.get("usage").toString(),orderItem.get("amount").toString(),"未处理",userid, orderItem.get("orderId").toString());
		
		ordersRepository.save(newOrder);
		
		TimerTask task = new TimerTask(){
			public void run() {
				Orders oldItem = ordersRepository.findByOrdId(orderItem.get("orderId").toString());
				oldItem.setStatus("已完成");
				ordersRepository.save(oldItem);
			}
		};
		timer.schedule (task, 90000L);
		return "Success";
	}
	
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/orders/updateOrder")
	public String updateOrders(@Valid @RequestBody String orders) {
		
		JsonObject order = new JsonParser().parse(orders).getAsJsonObject();
		JsonObject orderItem = (JsonObject) order.get("order");
		System.out.println("Order is: " + orderItem.isJsonObject());
		Orders oldItem = ordersRepository.findByOrdId(orderItem.get("orderId").toString());
		System.out.println("Order is: " + oldItem);
		oldItem.setUserId(orderItem.get("userId").toString());
		ordersRepository.save(oldItem);
		
		//Orders newOrder = new Orders(orderItem.get("productName").toString(),orderItem.get("price").toString(),orderItem.get("usage").toString(),orderItem.get("amount").toString(),"noProvision",orderItem.get("userId").toString(),orderItem.get("orderId").toString());
		
		//ordersRepository.save(newOrder);
		
		return "Success";
	}
}
