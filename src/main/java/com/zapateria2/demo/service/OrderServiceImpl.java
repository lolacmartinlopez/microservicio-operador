package com.zapateria2.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapateria2.demo.data.OrderRepository;
import com.zapateria2.demo.model.pojo.Order;
import com.zapateria2.demo.model.request.CreateOrderRequest;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@CommonsLog
@Service("Servicio operador")

public class OrderServiceImpl {
	
    public final static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);


	
	@Autowired
	OrderRepository repository;
	
	public Order createOrder(CreateOrderRequest request) {
		
        LOGGER.debug("objeto request '{}'",request);
        
        Order order = new Order();
        order.setBaseImponible(request.getBaseImponible());
        order.setCreatedAt(request.getCreatedAt());
        order.setImporte(request.getImporte());
        order.setIva(request.getIva());
        order.setRef(request.getRef());
        order.setUpdatedAt(request.getUpdatedAt());
		
        
		return repository.save(order);
	}



	

}
