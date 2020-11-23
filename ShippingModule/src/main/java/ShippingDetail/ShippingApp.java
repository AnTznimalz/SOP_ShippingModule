package ShippingDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shipping_option")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShippingApp {
	ArrayList<ShippingOption> shippingOptions = new ArrayList<ShippingOption>();
	ShippingApp(){}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@RequestBody ShippingOption shipping) throws InterruptedException, ExecutionException {
		return FirebaseShippingOption.createShippingOption(shipping);
	}

	@RequestMapping(value = "/all",method=RequestMethod.GET)
	public List<ShippingOption> getAll() throws InterruptedException, ExecutionException {
		return FirebaseShippingOption.getAllShippingOption();
	}
	
	@RequestMapping(value = "/get/{id}",method=RequestMethod.GET)
	public ShippingOption get(@PathVariable("id") final String id) throws InterruptedException, ExecutionException {
		return FirebaseShippingOption.getShippingOption(id);
	}
	
	@RequestMapping(value = "/shop/{shop_id}",method=RequestMethod.GET)
	public List<ShippingOption> getShopShippings(@PathVariable("shop_id") final String shop_id) throws InterruptedException, ExecutionException {
		return FirebaseShippingOption.getShippingOptionByField(shop_id, "shop_id");
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(@RequestBody ShippingOption s) throws InterruptedException, ExecutionException {
		return FirebaseShippingOption.saveShippingOption(s);
	}
	
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") final String id) throws InterruptedException, ExecutionException {
		return FirebaseShippingOption.deleteShippingOption(id);
	}
	
}