package com.zapateria2.demo.service;

import java.util.List;

import com.zapateria2.demo.model.pojo.ElasticLineInvoice;
import com.zapateria2.demo.model.request.CreateLineInvoiceRequest;

public interface ElasticLineInvoiceService {

	public List<ElasticLineInvoice> getLineInvoices(String invoice, String shoesize, Integer amount,
			Float baseImponible, Float iva, Float importe);

	public ElasticLineInvoice getLineInvoice(String lineInvoiceId);

	public Boolean removeLineInvoice(String lineInvoiceId);

	public ElasticLineInvoice createLineInvoice(CreateLineInvoiceRequest request);
	
}
