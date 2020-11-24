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
public class ShippingOptionController {
	ArrayList<ShippingOptionModel> shippingOptions = new ArrayList<ShippingOptionModel>();
	ShippingOptionController(){}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@RequestBody ShippingOptionModel shipping) throws InterruptedException, ExecutionException {
		return ShippingOptionService.createShippingOption(shipping);
	}

	@RequestMapping(value = "/all",method=RequestMethod.GET)
	public List<ShippingOptionModel> getAll() throws InterruptedException, ExecutionException {
		return ShippingOptionService.getAllShippingOption();
	}
	
	@RequestMapping(value = "/get/{id}",method=RequestMethod.GET)
	public ShippingOptionModel get(@PathVariable("id") final String id) throws InterruptedException, ExecutionException {
		return ShippingOptionService.getShippingOption(id);
	}
	
	@RequestMapping(value = "/shop/{shop_id}",method=RequestMethod.GET)
	public List<ShippingOptionModel> getShopShippings(@PathVariable("shop_id") final String shop_id) throws InterruptedException, ExecutionException {
		return ShippingOptionService.getShippingOptionByField(shop_id, "shop_id");
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(@RequestBody ShippingOptionModel s) throws InterruptedException, ExecutionException {
		return ShippingOptionService.saveShippingOption(s);
	}
	
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") final String id) throws InterruptedException, ExecutionException {
		return ShippingOptionService.deleteShippingOption(id);
	}
	
}