package ShippingDetail;

import java.util.ArrayList;

public class ShippingOrderModel {
	private String id, shop_id, user_id;
	private String address;
	private String shippingOption;
	private ArrayList<ItemModel> items;
	private String trackingCode;
	
	enum ShippingStatus {
		  waitForShipping,
		  Shipping,
		  Success
	}
	private ShippingStatus status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public ArrayList<ItemModel> getItems() {
		return items;
	}
	public void setItems(ArrayList<ItemModel> items) {
		this.items = items;
	}
	public String getTrackingCode() {
		return trackingCode;
	}
	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}
	public ShippingStatus getStatus() {
		return status;
	}
	public void setStatus(ShippingStatus status) {
		this.status = status;
	}
	
	
	
}
