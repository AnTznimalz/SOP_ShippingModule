package SOP_Project.ShippingModule;


import java.util.ArrayList;

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

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@EnableSwagger2
public class App 
{
	ArrayList<ShippingOptionModel> shippingOptionArray = new ArrayList<ShippingOptionModel>();
	public App() {
	}
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

	@RequestMapping(value = "/post",method=RequestMethod.POST)

	public ShippingOptionModel create(@RequestBody ShippingOptionModel s) {
		shippingOptionArray.add(s);
		return s;
	}
	
	//read : get by item id
	@RequestMapping(value = "/get/{index}",method=RequestMethod.GET)
	public ShippingOptionModel read(@PathVariable("index") int index) {
		for(int i=0; i < shippingOptionArray.size(); i++) {
			if(shippingOptionArray.get(i).getItem_id() == index) {
				return shippingOptionArray.get(i);
			}
		}
		return null;
		}

	public void update() {
		
	}

	public void delete() {
		
	}
	


}
