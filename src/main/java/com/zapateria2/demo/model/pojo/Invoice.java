/*package com.zapateria2.demo.model.pojo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "invoices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name = "num_fac")
	private String num_fac;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "base_imponible")
	private Float baseImponible;
	
	@Column(name = "iva")
	private Float iva;
	
	@Column(name = "importe")
	private Float importe;
	
	@JoinColumn(foreignKey = @ForeignKey(name = "order_id"), name="order_id", referencedColumnName = "order_id", columnDefinition = "int", nullable = false)
	private Integer order_id;
	
	public static Invoice builder(Invoice factura) {
	
		return new Invoice();
	}
}
*/