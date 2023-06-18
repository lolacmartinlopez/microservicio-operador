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

@Document(indexName = "orders", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ElasticOrder {

	@Id
	private String id;
	
	@Field(type = FieldType.Keyword, name = "ref")
	private String ref;
	
	@Field(type = FieldType.Scaled_Float, name = "base_imponible")
	private Float baseImponible;
	
	@Field(type = FieldType.Scaled_Float, name = "iva")
	private Float iva;
	
	@Field(type = FieldType.Scaled_Float, name = "importe")
	private Float importe;
	
}
