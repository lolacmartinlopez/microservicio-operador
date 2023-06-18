package com.zapateria2.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zapateria2.demo.model.pojo.ElasticInvoice;
import com.zapateria2.demo.model.request.CreateInvoiceRequest;
import com.zapateria2.demo.service.ElasticInvoiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ElasticInvoiceController {
	
	private final ElasticInvoiceService service;
	
	@GetMapping("/elastic/invoices")
	public ResponseEntity<List<ElasticInvoice>> getInvoices(
			@RequestParam(required = false) String num_fac,
			@RequestParam(required = false) String date,
			@RequestParam(required = false) Float baseImponible, 
			@RequestParam(required = false) Float iva, 
			@RequestParam(required = false) Float importe,
			@RequestParam(required = false) String order) {

		List<ElasticInvoice> invoices = service.getInvoices(num_fac, date, baseImponible, iva, importe, order);

		if (invoices != null) {
			return ResponseEntity.ok(invoices);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@GetMapping("/elastic/invoices/{invoiceId}")
	public ResponseEntity<ElasticInvoice> getInvoice(@PathVariable String invoiceId) {

		ElasticInvoice invoice = service.getInvoice(invoiceId);

		if (invoice != null) {
			return ResponseEntity.ok(invoice);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/elastic/invoices/{invoiceId}")
	public ResponseEntity<Void> removeInvoice(@PathVariable String invoiceId) {

		Boolean removed = service.removeInvoice(invoiceId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping("/elastic/invoices")
	public ResponseEntity<ElasticInvoice> createInvoice(@RequestBody CreateInvoiceRequest request) {
		ElasticInvoice invoice = service.createInvoice(request);
		
		if (invoice != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
