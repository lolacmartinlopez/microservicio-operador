package com.zapateria2.demo.service;

import java.util.List;

import com.zapateria2.demo.model.pojo.ElasticOrder;
import com.zapateria2.demo.model.request.CreateOrderRequest;

public interface ElasticOrderService {

	public List<ElasticOrder> getOrders(String ref, Float baseImponible, Float iva, Float importe); 

	public ElasticOrder getOrder(String orderId);

	public Boolean removeOrder(String orderId);

	public ElasticOrder createOrder(CreateOrderRequest request);

}
