package com.zapateria2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapateria2.demo.data.LineInvoiceRepository;
import com.zapateria2.demo.facade.BuscadorFacade;
import com.zapateria2.demo.model.pojo.LineInvoice;
import com.zapateria2.demo.model.request.CreateLineInvoiceRequest;
 


@Service
public class LineInvoiceServiceImpl implements LineInvoiceService {
	
	@Autowired
	private BuscadorFacade buscadorFacade;
	
	@Autowired
	private LineInvoiceRepository repository;
	
	@Override
	public List<LineInvoice> getLineInvoices() {
	List<LineInvoice> lineInvoices = repository.findAll();
		return lineInvoices.isEmpty() ? null : lineInvoices;
	}
	@Override
	public LineInvoice getLineInvoice(int lineInvoiceId) {
		return repository.findById(Long.valueOf(lineInvoiceId)).orElse(null);
	}
	@Override
	public Boolean removeLineInvoice(int lineInvoiceId) {
		LineInvoice lineInvoice = repository.findById(Long.valueOf(lineInvoiceId)).orElse(null);
		if (lineInvoice != null) {repository.delete(lineInvoice);
		return Boolean.TRUE;
		} else {return Boolean.FALSE;}
	}
	
	@Override
	public LineInvoice createLineInvoice(CreateLineInvoiceRequest request) {
		
		Boolean decreaseRes = buscadorFacade.decreaseStock(request.getShoeId(), request.getSizeId(), request.getAmount());
		if(decreaseRes == null || !decreaseRes) return null;
		
		LineInvoice lineInvoice = new LineInvoice();
		lineInvoice.setInvoice_id(request.getInvoice_id()); ;
		lineInvoice.setShoeId(request.getShoeId());
		lineInvoice.setSizeId(request.getSizeId());
		lineInvoice.setAmount(request.getAmount());
		lineInvoice.setBase_imponible(request.getBase_imponible());
		lineInvoice.setIva(request.getIva());
		lineInvoice.setImporte(request.getImporte());
			
		return repository.save(lineInvoice);
	}
	
	@Override
	public LineInvoice postLineInvoice(int lineInvoiceId) {
		return null;
	}
}