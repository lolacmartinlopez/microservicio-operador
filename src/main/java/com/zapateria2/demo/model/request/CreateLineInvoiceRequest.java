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
public class CreateLineInvoiceRequest {
	
	@JsonProperty("invoice_id")
	public Integer invoice_id;
	@JsonProperty("shoe_id")
	public Integer shoeId;
	@JsonProperty("size_id")
	public Integer sizeId;
	@JsonProperty("elastic_invoice_id")
	public String ElasticInvoiceId;
	@JsonProperty("elastic_shoesize_id")
	public String ElasticShoeSizeId;
	@JsonProperty("amount")
	public Integer amount;
	@JsonProperty("baseImponible")
	public Float base_imponible;
	@JsonProperty("iva")
	public Float iva;
	@JsonProperty("importe")
	public Float importe;
	
}