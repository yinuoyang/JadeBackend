package Jade.shoppingCart.demo.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	
	private long dingdingId;//Dingding id
	private String name;
	
	protected User() {
		
	}
	
	public User(String name, long id) {
		
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public long getDdId() {
		return this.dingdingId;
	}
	
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s]", dingdingId, name);
	}
	
}
