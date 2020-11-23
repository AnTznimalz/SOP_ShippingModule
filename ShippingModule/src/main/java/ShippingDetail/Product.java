package ShippingDetail;

public class Product {
	private String shop_id, shipping_option_id;
	private int amount, product_id;
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getShipping_option_id() {
		return shipping_option_id;
	}
	public void setShipping_option_id(String shipping_option_id) {
		this.shipping_option_id = shipping_option_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
