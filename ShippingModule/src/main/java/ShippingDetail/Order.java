package ShippingDetail;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int user_id;
	private Address address;
	private ArrayList<Product> product;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<Product> getProduct() {
		return product;
	}
	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}
	
	public List<ShippingOrder> toShippingOrder() {
		ArrayList<ShippingOrder> lists = new ArrayList<ShippingOrder>();
		List<String> arr = new ArrayList<String>();
		for (Product p : this.product) { 	
			System.out.println(p.getShop_id());
			System.out.println(arr.indexOf(p.getShop_id()));
	           if(arr.indexOf(p.getShop_id()) == -1) {
	        	 arr.add(p.getShop_id());
	        	 
	        	ShippingOrder s = new ShippingOrder();
	        	
	       		s.setAddress(this.address.toString());
	       		
	       		s.setUser_id(this.user_id+"");
	       		
	       		
	       		ArrayList<Item> its = new ArrayList<Item>();
	       		Item it = new Item();
	       		it.setId(p.getProduct_id());
	       		it.setCount(p.getAmount());
	       		its.add(it);
	       		s.setItems(its);
	       		
	       		
	       		s.setShop_id(p.getShop_id());
	       		
	       		s.setShippingOption(p.getShipping_option_id());
	       		
	       		s.setStatus(ShippingOrder.ShippingStatus.waitForShipping);
	       		lists.add(s);
	           }else {
	        	   ShippingOrder s = lists.get(arr.indexOf(p.getShop_id()));
	        	   Item it = new Item();
		       		it.setId(p.getProduct_id());
		       		it.setCount(p.getAmount());
		       		s.getItems().add(it);
	           }
	      }
		
		return lists;
	}
}

