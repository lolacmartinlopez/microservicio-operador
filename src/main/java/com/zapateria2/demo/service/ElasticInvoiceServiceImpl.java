package com.zapateria2.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zapateria2.demo.data.ElasticsearchRepository;
import com.zapateria2.demo.model.pojo.ElasticInvoice;
import com.zapateria2.demo.model.request.CreateInvoiceRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticInvoiceServiceImpl implements ElasticInvoiceService{
	
	private final ElasticsearchRepository repository;

	@Override
	public List<ElasticInvoice> getInvoices(String num_fac, String date, Float baseImponible, Float iva, Float importe,
			String order) {
		// TODO Auto-generated method stub
		List<ElasticInvoice> invoices = repository.findInvoices(num_fac, date, baseImponible, iva, importe, order);
		return invoices.isEmpty() ? null : invoices;
	}

	@Override
	public ElasticInvoice getInvoice(String invoiceId) {
		// TODO Auto-generated method stub
		return repository.findInvoiceById(invoiceId).orElse(null);
	}

	@Override
	public Boolean removeInvoice(String invoiceId) {
		// TODO Auto-generated method stub
		ElasticInvoice invoice = repository.findInvoiceById(invoiceId).orElse(null);

		if (invoice != null) {
			repository.deleteInvoice(invoice);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public ElasticInvoice createInvoice(CreateInvoiceRequest request) {
		// TODO Auto-generated method stub
		if (request != null && StringUtils.hasLength(request.getNum_fac().trim()) && StringUtils.hasLength(request.getDate().trim()) && request.getBaseImponible() != null 
				&& request.getIva() != null && request.getImporte() != null && StringUtils.hasLength(request.getOrderIdElastic().trim())) {
			
			ElasticInvoice invoice = new ElasticInvoice();
			invoice.setNum_fac(request.getNum_fac());
			invoice.setDate(request.getDate());
			invoice.setBaseImponible(request.getBaseImponible());
			invoice.setImporte(request.getImporte());
			invoice.setIva(request.getIva());
			invoice.setOrder(request.getOrderIdElastic());
			
			return repository.saveInvoice(invoice);
			
		} else {
			return null;
		}
	}
	
	

}
