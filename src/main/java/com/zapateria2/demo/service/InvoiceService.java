package com.zapateria2.demo.service;

import java.util.List;

import com.zapateria2.demo.model.pojo.Invoice;
import com.zapateria2.demo.model.request.CreateInvoiceRequest;

public interface InvoiceService {

	List<Invoice> getInvoices();
	
	Invoice postInvoice(int invoiceId);

	public Boolean removeInvoice(int invoiceId);

	public Invoice createInvoice(CreateInvoiceRequest factura);

	public Invoice getInvoice(int invoiceId);
}
