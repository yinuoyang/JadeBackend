package Jade.shoppingCart.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Table-Order

@Entity
public class Orders {
	
	@Id
	@GeneratedValue
	
	private long id;
	
	private String productName;
	private String price;
	private String number;
	private String amount;
	private String status;
	private String userId;
	private String ordId;
	
	
	public Orders () {
		
	}
	public Orders(String productName, String price, String number, String amount, String status, String userId,
			String orderId) {
		super();
		this.productName = productName;
		this.price = price;
		this.number = number;
		this.amount = amount;
		this.status = status;
		this.userId = userId;
		this.ordId = orderId;
	}

	@Override
	public String toString() {
		return "Order [productName=" + productName + ", price=" + price + ", number=" + number + ", amount=" + amount
				+ ", status=" + status + ", userId=" + userId + ", orderId=" + ordId + "]";
	}
	
	public long getId() {
		return id;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderId() {
		return ordId;
	}

	public void setOrderId(String orderId) {
		this.ordId = orderId;
	}
	
	
	
}
