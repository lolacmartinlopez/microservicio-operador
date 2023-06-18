package com.zapateria2.demo.data;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zapateria2.demo.model.pojo.ElasticInvoice;

public interface ElasticInvoiceRepository extends ElasticsearchRepository<ElasticInvoice, String>{

	ElasticInvoice save(ElasticInvoice invoice);

	Boolean delete(ElasticInvoice invoice);

	Optional<ElasticInvoice> findById(String invoiceId);

}
