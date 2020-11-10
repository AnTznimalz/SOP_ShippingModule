package SOP_Project.ShippingModule;

public class ShippingOptionModel {
	private String name;
	private int period;
	private float price_cal;
	private int time_estimate;
	private int item_id;
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
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public float getPrice_cal() {
		return price_cal;
	}
	public void setPrice_cal(float price_cal) {
		this.price_cal = price_cal;
	}
	public int getTime_estimate() {
		return time_estimate;
	}
	public void setTime_estimate(int time_estimate) {
		this.time_estimate = time_estimate;
	}
}
