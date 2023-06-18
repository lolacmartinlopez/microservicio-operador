package com.zapateria2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapateria2.demo.data.InvoiceRepository;
import com.zapateria2.demo.model.pojo.Invoice;
import com.zapateria2.demo.model.request.CreateInvoiceRequest;



@Service
public class InvoiceServiceImpl implements InvoiceService {

@Autowired
private InvoiceRepository repository;

@Override
public List<Invoice> getInvoices() {
List<Invoice> invoices = repository.findAll();
return invoices.isEmpty() ? null : invoices;
}
@Override
public Invoice getInvoice(int invoiceId) {
return repository.findById(Long.valueOf(invoiceId)).orElse(null);
}

@Override
public Boolean removeInvoice(int invoiceId) {
Invoice invoice = repository.findById(Long.valueOf(invoiceId)).orElse(null);
	if (invoice != null) {
		repository.delete(invoice);
		return Boolean.TRUE;
	} else {
		return Boolean.FALSE;
		}
	}

@Override
public Invoice createInvoice (CreateInvoiceRequest request) {

	Invoice invoc = new Invoice();
		
		invoc.setNum_fac(request.getNum_fac());
		invoc.setDate(request.getDate());
		invoc.setBaseImponible(request.getBaseImponible());
		invoc.setIva(request.getIva());
		invoc.setImporte(request.getImporte());
		invoc.setOrder_id(request.getOrder_id());
		
		
		return repository.save(invoc);

	}

	@Override
	public Invoice postInvoice(int invoiceId) {
		// TODO Auto-generated method stub
		return null;
	}

}