package com.zapateria2.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateOrderRequest {
	@JsonProperty("ref")
	public String ref;
	@JsonProperty("baseImponible")
	public Float baseImponible;
	@JsonProperty("iva")
	public Float iva;
	@JsonProperty("importe")
	public Float importe;
	@JsonProperty("createdAt")
	public String createdAt;
	@JsonProperty("updatedAt")
	public String updatedAt;
	
}
