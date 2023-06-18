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
public class CreateInvoiceRequest {
	@JsonProperty("num_fac")
	public String num_fac;
	@JsonProperty("date")
	public String date;
	@JsonProperty("baseImponible")
	public Float baseImponible;
	@JsonProperty("iva")
	public Float iva;
	@JsonProperty("importe")
	public Float importe;
	@JsonProperty("order_id")
	public Integer order_id;
	@JsonProperty("elastic_order_id")
	public String orderIdElastic;

}