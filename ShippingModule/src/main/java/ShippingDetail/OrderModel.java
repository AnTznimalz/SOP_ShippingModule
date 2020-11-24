package ShippingDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {
	private int user_id;
	private AddressModel address;
	private ArrayList<ProductModel> product;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public AddressModel getAddress() {
		return address;
	}
	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public ArrayList<ProductModel> getProduct() {
		return product;
	}
	public void setProduct(ArrayList<ProductModel> product) {
		this.product = product;
	}
	
	public List<ShippingOrderModel> toShippingOrder() {
		ArrayList<ShippingOrderModel> lists = new ArrayList<ShippingOrderModel>();
		List<String> arr = new ArrayList<String>();
		for (ProductModel p : this.product) { 	
			System.out.println(p.getShop_id());
			System.out.println(arr.indexOf(p.getShop_id()));
	           if(arr.indexOf(p.getShop_id()) == -1) {
	        	 arr.add(p.getShop_id());
	        	 
	        	ShippingOrderModel s = new ShippingOrderModel();
	        	
	       		s.setAddress(this.address.toString());
	       		
	       		s.setUser_id(this.user_id+"");
	       		
	       		
	       		ArrayList<ItemModel> its = new ArrayList<ItemModel>();
	       		ItemModel it = new ItemModel();
	       		it.setId(p.getProduct_id());
	       		it.setCount(p.getAmount());
	       		it.setName(p.getProductName());
	       		its.add(it);
	       		s.setItems(its);
	       		
	       		
	       		s.setShop_id(p.getShop_id());
	       		
	       		s.setShippingOption(p.getShipping_option_id());
	       		
	       		s.setStatus(ShippingOrderModel.ShippingStatus.waitForShipping);
	       		lists.add(s);
	           }else {
	        	   ShippingOrderModel s = lists.get(arr.indexOf(p.getShop_id()));
	        	   ItemModel it = new ItemModel();
	        	   it.setName(p.getProductName());
		       		it.setId(p.getProduct_id());
		       		it.setCount(p.getAmount());
		       		s.getItems().add(it);
	           }
	      }
		
		return lists;
	}
}

