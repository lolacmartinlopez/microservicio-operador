package com.zapateria2.demo.model.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idOrders;
	
	@Column(name="ref",unique=true)
	private String ref;
	
	@Column(name="base_imponible")
	private Float baseImponible;
	
	@Column(name="iva")
	private Float iva;
	
	@Column(name="importe")
	private Float importe;
	
	@Column(name="created_at")
	private String createdAt;
	
	@Column(name="updated_at")
	private String updatedAt;

	public static Order builder() {
		return new Order();
	}
	
	public  Float getImporte()
	{
		return importe; 
	}


}



