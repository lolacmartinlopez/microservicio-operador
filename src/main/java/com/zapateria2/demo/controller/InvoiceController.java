/*package com.zapateria2.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zapateria2.demo.model.pojo.Invoice;
import com.zapateria2.demo.model.request.CreateInvoiceRequest;
import com.zapateria2.demo.service.InvoiceService;


@RestController 
public class InvoiceController {
	

	private InvoiceService service;
	
	@Autowired 
	public void InvoicesController(InvoiceService service) {this.service = service;}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/invoices") 
	public ResponseEntity<List<Invoice>> getInvoices() {
		List<Invoice> invoices = service.getInvoices(); 
	
		if (invoices != null) {
			return ResponseEntity.ok(invoices); 
		} else { 
			return ResponseEntity.ok(Collections.emptyList());
		} 
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/invoices/{invoiceId}") 
	public ResponseEntity<Invoice> getInvoice(@PathVariable int invoiceId) { 
		Invoice invoice = service.getInvoice(invoiceId); 
	
		if (invoice != null) {
			return ResponseEntity.ok(invoice); 
		} else { 
			return ResponseEntity.notFound().build();
		} 
	} 
	
	@DeleteMapping("/invoices/{invoiceId}") 
	public ResponseEntity<Void> deleteInvoice(@PathVariable int invoiceId) { 
		Boolean removed = service.removeInvoice(invoiceId); 
	
		if (Boolean.TRUE.equals(removed)) { 
			return ResponseEntity.ok().build(); 
		} else { 
			return ResponseEntity.notFound().build();
		} 
	}
	
	@PostMapping("/invoices") 
	
	
	public ResponseEntity<Invoice> createInvoice(@RequestBody CreateInvoiceRequest request){
		
		
		Invoice factura = service.createInvoice(request);
		
		if(factura!=null)
		{
			
			return ResponseEntity.status(HttpStatus.CREATED).body(factura); 
		}else {
			return ResponseEntity.badRequest().build();
		}
		
		
	}

}

*/
