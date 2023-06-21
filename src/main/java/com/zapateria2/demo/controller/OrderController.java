/*package com.zapateria2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zapateria2.demo.model.pojo.Order;
import com.zapateria2.demo.model.request.CreateOrderRequest;
import com.zapateria2.demo.service.OrderServiceImpl;


@RestController
public class OrderController {
	
	
	private OrderServiceImpl service;
	
	@Autowired 
	public void OrderController(OrderServiceImpl service) {this.service = service;}

	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request){
		

		
		Order createdOrder = service.createOrder(request);
	
		
		if(createdOrder != null) {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
		}else {
			return ResponseEntity.badRequest().build();
		}
		

		
	}
	
	
	
}
*/
