package com.zapateria2.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zapateria2.demo.model.pojo.ElasticOrder;
import com.zapateria2.demo.model.request.CreateOrderRequest;
import com.zapateria2.demo.service.ElasticOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ElasticOrderController {
	
	private final ElasticOrderService service;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/elastic/orders")
	public ResponseEntity<List<ElasticOrder>> getOrders(
			@RequestParam(required = false) String ref,
			@RequestParam(required = false) Float baseImponible, 
			@RequestParam(required = false) Float iva, 
			@RequestParam(required = false) Float importe) {

		List<ElasticOrder> orders = service.getOrders(ref, baseImponible, iva, importe);

		if (orders != null) {
			return ResponseEntity.ok(orders);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/elastic/orders/{orderId}")
	public ResponseEntity<ElasticOrder> getOrder(@PathVariable String orderId) {

		ElasticOrder order = service.getOrder(orderId);

		if (order != null) {
			return ResponseEntity.ok(order);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/elastic/orders/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) {

		Boolean removed = service.removeOrder(orderId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/elastic/orders")
	public ResponseEntity<ElasticOrder> createOrder(@RequestBody CreateOrderRequest request) {
		ElasticOrder order = service.createOrder(request);
		
		if (order != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(order);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
