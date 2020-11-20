package ShippingDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@EnableAutoConfiguration
@RequestMapping("/shipping")
public class ShippingDetailService 
{
	ArrayList<ShippingOrder> shippings = new ArrayList<ShippingOrder>();
	
	public ShippingDetailService() {
	}
	public static void main(String[] args) {
		SpringApplication.run(ShippingDetailService.class, args);

	}

	@RequestMapping(value = "/order}",method=RequestMethod.POST)
	public ResponseEntity<ShippingOrder> PostnewShippingOrder(@RequestBody ShippingOrder shipping) {
		return new ResponseEntity<ShippingOrder>(shippings.get(0), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shop/{shop_id}",method=RequestMethod.GET)
	public ResponseEntity<List<ShippingOrder>> getShopShippings(@PathVariable("shop_id") final int shop_id) {
		List<ShippingOrder> shopOrders = shippings.stream()
				.filter(s -> s.getShop_id() == shop_id && s.getStatus() == ShippingOrder.ShippingStatus.waitForShipping)
				.collect(Collectors.toList());
		return new ResponseEntity<List<ShippingOrder>>(shopOrders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shop/all/{shop_id}",method=RequestMethod.GET)
	public ResponseEntity<List<ShippingOrder>> getShopShippingsAll(@PathVariable("shop_id") final int shop_id) {
		List<ShippingOrder> shopOrders = shippings.stream()
				.filter(s -> s.getShop_id() == shop_id).collect(Collectors.toList());
		return new ResponseEntity<List<ShippingOrder>>(shopOrders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{user_id}",method=RequestMethod.GET)
	public ResponseEntity<List<ShippingOrder>> getUserShippings(@PathVariable("user_id") final int user_id) {
		List<ShippingOrder> shopOrders = shippings.stream()
				.filter(s -> s.getUser_id() == user_id).collect(Collectors.toList());
		return new ResponseEntity<List<ShippingOrder>>(shopOrders, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/sent/}",method=RequestMethod.POST)
	public ResponseEntity<ShippingOrder> setTrackCode(@RequestBody SentForm sentForm) {
		return new ResponseEntity<ShippingOrder>(shippings.get(0), HttpStatus.OK);
	}
}