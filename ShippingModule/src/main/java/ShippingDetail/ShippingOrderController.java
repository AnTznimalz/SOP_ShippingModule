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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@RequestMapping("/shipping")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShippingOrderController 
{
	ArrayList<ShippingOrderModel> shippings = new ArrayList<ShippingOrderModel>();
	
	public ShippingOrderController() {
	}
	public static void main(String[] args) {
		SpringApplication.run(ShippingOrderController.class, args);
	}

	@RequestMapping(value = "/test",method=RequestMethod.GET)
	public String  test() {
		return "hello world";
//		return new ResponseEntity<ShippingOrder>(shippings.get(0), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order",method=RequestMethod.POST)
	public String  create(@RequestBody OrderModel s) throws InterruptedException, ExecutionException {
		return ShippingOrderService.createShippingOrder(s);
//		return new ResponseEntity<ShippingOrder>(shippings.get(0), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get/{id}",method=RequestMethod.GET)
	public ShippingOrderModel get(@PathVariable("id") final String id) throws InterruptedException, ExecutionException {
		return ShippingOrderService.getShippingOrder(id);
	}
	
	@RequestMapping(value = "/all",method=RequestMethod.GET)
	public List<ShippingOrderModel> getAll() throws InterruptedException, ExecutionException {
		return ShippingOrderService.getAllShippingOrder();
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(@RequestBody ShippingOrderModel s) throws InterruptedException, ExecutionException {
		System.out.println("********************");
		return ShippingOrderService.saveShippingOrder(s);
	}
	
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") final String id) throws InterruptedException, ExecutionException {
		return ShippingOrderService.deleteShippingOrder(id);
	}
	
	
	@RequestMapping(value = "/shop/{shop_id}",method=RequestMethod.GET)
	public List<ShippingOrderModel> getShopShippings(@PathVariable("shop_id") final String shop_id) throws InterruptedException, ExecutionException {
		return ShippingOrderService.getShippingOrderByField(shop_id, "shop_id");
	}
	
	@RequestMapping(value = "/user/{user_id}",method=RequestMethod.GET)
	public List<ShippingOrderModel> getUserShippings(@PathVariable("user_id") final String user_id) throws InterruptedException, ExecutionException {
		return ShippingOrderService.getShippingOrderByField(user_id, "user_id");
	}

}