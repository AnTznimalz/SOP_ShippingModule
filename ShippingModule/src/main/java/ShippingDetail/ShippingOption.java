package ShippingDetail;

public class ShippingOption {
	private int id, price, time_estimate, item_id;
	private String name;
	public ShippingOption() {
		
	}
	public ShippingOption(int id, int price, int time_estimate, int item_id, String name) {
		super();
		this.id = id;
		this.price = price;
		this.time_estimate = time_estimate;
		this.item_id = item_id;
		this.name = name;
	}
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}