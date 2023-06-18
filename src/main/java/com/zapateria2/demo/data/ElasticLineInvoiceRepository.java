package com.zapateria2.demo.data;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zapateria2.demo.model.pojo.ElasticLineInvoice;

public interface ElasticLineInvoiceRepository extends ElasticsearchRepository<ElasticLineInvoice, String>{

	ElasticLineInvoice save(ElasticLineInvoice lineInvoice);

	Boolean delete(ElasticLineInvoice lineInvoice);

	Optional<ElasticLineInvoice> findById(String lineInvoiceId);

}
