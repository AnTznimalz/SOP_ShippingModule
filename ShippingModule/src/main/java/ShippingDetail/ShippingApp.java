package ShippingDetail;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shipping_option")
public class ShippingApp {
	ArrayList<ShippingOption> shippingOptions = new ArrayList<ShippingOption>();
	ShippingApp(){}
	
	@RequestMapping(value="/creat",method=RequestMethod.POST)
	public ResponseEntity<ShippingOption> addShippingOptions(@RequestBody ShippingOption shipping) {
				return new ResponseEntity<ShippingOption>(shipping, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<ShippingOption>> getShippingOptions() {
		return new ResponseEntity<ArrayList<ShippingOption>>(shippingOptions, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getById/{id}",method=RequestMethod.GET)
	public ResponseEntity<ShippingOption> getShippingOptions(@PathVariable("id") int id) {
		ShippingOption t = shippingOptions.get(id-1);
		return new ResponseEntity<ShippingOption>(t, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByItemId/{item_id}",method=RequestMethod.GET)
	public ResponseEntity<ShippingOption> getShippingOptionsByItemId(@PathVariable("item_id") int item_id) {
		 for (ShippingOption shipping : shippingOptions) {
		        if (shipping.getItem_id() == item_id) {
		            return new ResponseEntity<ShippingOption>(shipping, HttpStatus.OK);
		        }
		    }
		    return null;
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.POST)
	public ResponseEntity<ShippingOption> updateShippingOptions(@PathVariable("id") int id) {
		ShippingOption t = shippingOptions.get(id-1);
		return new ResponseEntity<ShippingOption>(t, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<ShippingOption> deleteShippingOptions(@PathVariable("id") int id) {
		ShippingOption t = shippingOptions.get(id-1);
		return new ResponseEntity<ShippingOption>(t, HttpStatus.OK);
	}
	
}