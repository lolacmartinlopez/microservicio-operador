package com.zapateria2.demo.service;

import java.util.List;

import com.zapateria2.demo.model.pojo.ElasticInvoice;
import com.zapateria2.demo.model.request.CreateInvoiceRequest;

public interface ElasticInvoiceService {

	List<ElasticInvoice> getInvoices(String num_fac, String date, Float baseImponible, Float iva, Float importe,
			String order);

	ElasticInvoice getInvoice(String invoiceId);

	Boolean removeInvoice(String invoiceId);

	ElasticInvoice createInvoice(CreateInvoiceRequest request);

}
