package ShippingDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
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

	@RequestMapping(value = "/test",method=RequestMethod.GET)
	public String  test() {
		return "hello world";
//		return new ResponseEntity<ShippingOrder>(shippings.get(0), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order",method=RequestMethod.POST)
	public String  create(@RequestBody ShippingOrder s) throws InterruptedException, ExecutionException {
		return FirebaseServices.createShippingOrder(s);
//		return new ResponseEntity<ShippingOrder>(shippings.get(0), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get/{id}",method=RequestMethod.GET)
	public ShippingOrder get(@PathVariable("id") final String id) throws InterruptedException, ExecutionException {
		return FirebaseServices.getShippingOrder(id);
	}
	
	@RequestMapping(value = "/all",method=RequestMethod.GET)
	public List<ShippingOrder> getAll() throws InterruptedException, ExecutionException {
		return FirebaseServices.getAllShippingOrder();
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(@RequestBody ShippingOrder s) throws InterruptedException, ExecutionException {
		return FirebaseServices.saveShippingOrder(s);
	}
	
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") final String id) throws InterruptedException, ExecutionException {
		return FirebaseServices.deleteShippingOrder(id);
	}
	
	
	@RequestMapping(value = "/shop/{shop_id}",method=RequestMethod.GET)
	public List<ShippingOrder> getShopShippings(@PathVariable("shop_id") final String shop_id) throws InterruptedException, ExecutionException {
		return FirebaseServices.getShippingOrderByField(shop_id, "shop_id");
	}
	
	@RequestMapping(value = "/user/{user_id}",method=RequestMethod.GET)
	public List<ShippingOrder> getUserShippings(@PathVariable("user_id") final String user_id) throws InterruptedException, ExecutionException {
		return FirebaseServices.getShippingOrderByField(user_id, "user_id");
	}

}