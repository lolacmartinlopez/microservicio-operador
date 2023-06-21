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

import com.zapateria2.demo.model.pojo.ElasticLineInvoice;
import com.zapateria2.demo.model.request.CreateLineInvoiceRequest;
import com.zapateria2.demo.service.ElasticLineInvoiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ElasticLineInvoiceController {
	
private final ElasticLineInvoiceService service;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/elastic/lineinvoices")
	public ResponseEntity<List<ElasticLineInvoice>> getLineInvoices(
			@RequestParam(required = false) String invoice,
			@RequestParam(required = false) String shoeSize,
			@RequestParam(required = false) Integer amount,
			@RequestParam(required = false) Float baseImponible, 
			@RequestParam(required = false) Float iva, 
			@RequestParam(required = false) Float importe) {

		List<ElasticLineInvoice> lineinvoices = service.getLineInvoices(invoice, shoeSize, amount, baseImponible, iva, importe);

		if (lineinvoices != null) {
			return ResponseEntity.ok(lineinvoices);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/elastic/lineinvoices/{lineInvoiceId}")
	public ResponseEntity<ElasticLineInvoice> getLineInvoice(@PathVariable String lineInvoiceId) {

		ElasticLineInvoice lineInvoice = service.getLineInvoice(lineInvoiceId);

		if (lineInvoice != null) {
			return ResponseEntity.ok(lineInvoice);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/elastic/lineinvoices/{lineInvoiceId}")
	public ResponseEntity<Void> removeLineInvoice(@PathVariable String lineInvoiceId) {

		Boolean removed = service.removeLineInvoice(lineInvoiceId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping("/elastic/lineinvoices")
	public ResponseEntity<ElasticLineInvoice> createLineInvoice(@RequestBody CreateLineInvoiceRequest request) {
		ElasticLineInvoice lineInvoice = service.createLineInvoice(request);
		
		if (lineInvoice != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(lineInvoice);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
