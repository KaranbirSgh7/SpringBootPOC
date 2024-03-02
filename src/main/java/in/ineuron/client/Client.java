package in.ineuron.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="StockService")
public interface Client {
	
	@GetMapping("/price/getPrice/{name}")
	public ResponseEntity<Double> getStockPrice(@PathVariable String name);
	
	
}
