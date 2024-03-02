package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import in.ineuron.client.Client;


@Service
public class StockServiceCalImpl implements StockServiceCal {

	@Autowired
	Client client;
	
	@Override
	public ResponseEntity<Double> getStockPrice(String stockName) {
		return client.getStockPrice(stockName);
	}

	

}
