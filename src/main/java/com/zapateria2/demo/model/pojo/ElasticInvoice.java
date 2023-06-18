package com.zapateria2.demo.model.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "invoices", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ElasticInvoice {
	
	@Id
	private String id;
	
	@Field(type = FieldType.Keyword, name = "num_fac")
	private String num_fac;
	
	@Field(type = FieldType.Date, name = "date")
	private String date;
	
	@Field(type = FieldType.Scaled_Float, name = "baseImponible")
	private Float baseImponible;
	
	@Field(type = FieldType.Scaled_Float, name = "iva")
	private Float iva;
	
	@Field(type = FieldType.Scaled_Float, name = "importe")
	private Float importe;
	
	@Field(type = FieldType.Keyword, name = "order")
	private String order;

}
