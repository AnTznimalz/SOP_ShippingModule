package ShippingDetail;

import java.util.ArrayList;

public class ShippingOrder {
	private int id, shop_id, user_id;
	private String address;
	private String shippingOption;
	private ArrayList<Item> items;
	private String trackingCode;
	
	enum ShippingStatus {
		  waitForShipping,
		  Shipping,
		  Success
	}
	private ShippingStatus status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTrackingCode() {
		return trackingCode;
	}
	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getShippingOption() {
		return shippingOption;
	}
	public void setShippingOption(String shippingOption) {
		this.shippingOption = shippingOption;
	}
	public ShippingStatus getStatus() {
		return status;
	}
	public void setStatus(ShippingStatus status) {
		this.status = status;
	}
	
}
