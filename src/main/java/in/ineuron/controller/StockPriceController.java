package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.StockServiceCal;

@RestController
@RequestMapping("/calculator")
public class StockPriceController {

	@Autowired
	private StockServiceCal cal;
	
	@GetMapping("/calculate/{companyname}/{quantity}")
	public ResponseEntity<?> calculate(@PathVariable String companyname,@PathVariable Integer quantity){
		
		ResponseEntity<Double> price=null;
		
		try {
			price=cal.getStockPrice(companyname);
			int code=cal.getStockPrice(companyname).getStatusCode().value();
			
			if(code==200) {
				return new ResponseEntity<Double>(price.getBody()*quantity,HttpStatus.OK);
			}
			
		}
		catch (Exception e){
			return new ResponseEntity<String>("Stock not found",HttpStatus.BAD_REQUEST);
		}
		return price;
	}
}
