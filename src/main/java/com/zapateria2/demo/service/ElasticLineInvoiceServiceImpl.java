package com.zapateria2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zapateria2.demo.data.ElasticsearchRepository;
import com.zapateria2.demo.facade.BuscadorFacade;
import com.zapateria2.demo.model.pojo.ElasticLineInvoice;
import com.zapateria2.demo.model.request.CreateLineInvoiceRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticLineInvoiceServiceImpl implements ElasticLineInvoiceService{
	
	private final ElasticsearchRepository repository;
	
	@Autowired
	private BuscadorFacade buscadorFacade;
	
	@Override
	public List<ElasticLineInvoice> getLineInvoices(String invoice, String shoeSize, Integer amount,
			Float baseImponible, Float iva, Float importe) {
		// TODO Auto-generated method stub
		List<ElasticLineInvoice> lineInvoices = repository.findLineInvoices(invoice, shoeSize, baseImponible, iva, importe);
		return lineInvoices.isEmpty() ? null : lineInvoices;
	}

	@Override
	public ElasticLineInvoice getLineInvoice(String lineInvoiceId) {
		// TODO Auto-generated method stub
		return repository.findLineInvoiceById(lineInvoiceId).orElse(null);
	}

	@Override
	public Boolean removeLineInvoice(String lineInvoiceId) {
		// TODO Auto-generated method stub
		ElasticLineInvoice lineInvoice = repository.findLineInvoiceById(lineInvoiceId).orElse(null);

		if (lineInvoice != null) {
			repository.deleteLineInvoice(lineInvoice);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public ElasticLineInvoice createLineInvoice(CreateLineInvoiceRequest request) {
		// TODO Auto-generated method stub
		if (request != null && StringUtils.hasLength(request.getElasticInvoiceId().trim()) && StringUtils.hasLength(request.getElasticShoeSizeId().trim()) 
				&& request.getAmount() != null  && request.getBase_imponible() != null && request.getIva() != null && request.getImporte() != null) {			
			
			ElasticLineInvoice lineInvoice = new ElasticLineInvoice();
			lineInvoice.setInvoice(request.getElasticInvoiceId());
			lineInvoice.setShoeSize(request.getElasticShoeSizeId());
			lineInvoice.setAmount(request.getAmount());
			lineInvoice.setBase_imponible(request.getBase_imponible());
			lineInvoice.setImporte(request.getImporte());
			lineInvoice.setIva(request.getIva());
			
			/*ElasticLineInvoice newLineInvoice = repository.saveLineInvoice(lineInvoice);
			Boolean decreaseRes = buscadorFacade.elasticDecreaseStock(request.getElasticShoeSizeId(), request.getAmount());
			
			if(decreaseRes == null || !decreaseRes) {
				repository.deleteLineInvoice(newLineInvoice);
				return lineInvoice;
			} else {
				return newLineInvoice;
			}
			
			*/
			return lineInvoice; 
			 
		}
		
		else {
			return null;
		} 
		
		
	}

}
