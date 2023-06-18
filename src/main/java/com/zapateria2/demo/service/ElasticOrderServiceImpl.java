package com.zapateria2.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zapateria2.demo.data.ElasticsearchRepository;
import com.zapateria2.demo.model.pojo.ElasticOrder;
import com.zapateria2.demo.model.request.CreateOrderRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticOrderServiceImpl implements ElasticOrderService{

	private final ElasticsearchRepository repository;

	@Override
	public List<ElasticOrder> getOrders(String ref, Float baseImponible, Float iva, Float importe) {
		// TODO Auto-generated method stub
		List<ElasticOrder> orders = repository.findOrders(ref, baseImponible, iva, importe);
		return orders.isEmpty() ? null : orders;
	}

	@Override
	public ElasticOrder getOrder(String orderId) {
		// TODO Auto-generated method stub
		return repository.findOrderById(orderId).orElse(null);
	}

	@Override
	public Boolean removeOrder(String orderId) {
		// TODO Auto-generated method stub
		ElasticOrder order = repository.findOrderById(orderId).orElse(null);

		if (order != null) {
			repository.deleteOrder(order);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public ElasticOrder createOrder(CreateOrderRequest request) {
		// TODO Auto-generated method stub
		if (request != null && StringUtils.hasLength(request.getRef().trim()) && request.getBaseImponible() != null && request.getIva() != null && request.getImporte() != null) {
			
			ElasticOrder order = new ElasticOrder();
			order.setRef(request.getRef());
			order.setBaseImponible(request.getBaseImponible());
			order.setImporte(request.getImporte());
			order.setIva(request.getIva());
			
			return repository.saveOrder(order);
			
		} else {
			return null;
		}
	}

	
	
}
