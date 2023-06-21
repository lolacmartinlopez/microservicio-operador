/*package com.zapateria2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zapateria2.demo.model.pojo.LineInvoice;
import com.zapateria2.demo.model.request.CreateLineInvoiceRequest;
import com.zapateria2.demo.service.LineInvoiceService;


@RestController
public class LineInvoiceController {
	
	
	private LineInvoiceService service;

	@Autowired 
	public void LineInvoicesController(LineInvoiceService service) {this.service = service;}

	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/linesInvoice") 
	public ResponseEntity<LineInvoice> createLineInvoice(@RequestBody CreateLineInvoiceRequest request){
		
		
		LineInvoice lineInvoice = service.createLineInvoice(request);
		
		if(lineInvoice!=null)
		{
			
			return ResponseEntity.status(HttpStatus.CREATED).body(lineInvoice); 
		}else {
			return ResponseEntity.badRequest().build();
		}
		
		
	}


}
*/