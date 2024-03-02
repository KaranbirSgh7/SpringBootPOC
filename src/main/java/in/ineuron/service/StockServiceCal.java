package in.ineuron.service;

import org.springframework.http.ResponseEntity;

public interface StockServiceCal {
	
	public ResponseEntity<Double> getStockPrice(String stockName);

}
