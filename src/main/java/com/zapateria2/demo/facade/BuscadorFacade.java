package com.zapateria2.demo.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscadorFacade {
	
	@Value("${decreaseStock.url}")
	private String decreaseStockUrl;
	
	@Value("${elasticDecreaseStock.url}")
	private String elasticDecreaseStockUrl;
	
	private final RestTemplate restTemplate;
	
	public Boolean decreaseStock(Integer shoeId, Integer sizeId, Integer amount) {
		try {
			return restTemplate.exchange(String.format(decreaseStockUrl, shoeId, sizeId, amount), HttpMethod.PUT, null, Boolean.class).getBody();
		} catch (HttpClientErrorException e) {
			return null;
		}
	}
	
	public Boolean elasticDecreaseStock(String shoeSizeId, Integer amount) {
		try {
			return restTemplate.exchange(String.format(elasticDecreaseStockUrl, shoeSizeId, amount), HttpMethod.PUT, null, Boolean.class).getBody();
		} catch (HttpClientErrorException e) {
			return null;
		}
	}

}
