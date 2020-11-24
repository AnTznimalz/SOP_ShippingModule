package ShippingDetail;

public class ShippingOptionModel {
	private int price, time_estimate;
	private String id, name, shop_id;
	public ShippingOptionModel() {
		
	}
	public ShippingOptionModel(String id, int price, int time_estimate, String shop_id, String name) {
		super();
		this.id = id;
		this.price = price;
		this.time_estimate = time_estimate;
		this.shop_id = shop_id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTime_estimate() {
		return time_estimate;
	}
	public void setTime_estimate(int time_estimate) {
		this.time_estimate = time_estimate;
	}
	public String getshop_id() {
		return shop_id;
	}
	public void setshop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}