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
@Table(name = "line_invoices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LineInvoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(foreignKey = @ForeignKey(name = "invoice_id"), name="invoice_id", referencedColumnName = "invoice_id", columnDefinition = "int", nullable = false)
	private Integer invoice_id;

	@Column(name = "shoe_id")
	private Integer shoeId;
	
	@Column(name = "size_id")
	private Integer sizeId;
	
	@Column(name = "amount")
	private Integer amount;

	@Column(name = "base_imponible")
	private Float base_imponible;

	@Column(name = "iva")
	private Float iva;

	@Column(name = "importe")
	private Float importe;

	

	public static LineInvoice builder(LineInvoice linea) {
	
		return new LineInvoice();
	}
}
*/