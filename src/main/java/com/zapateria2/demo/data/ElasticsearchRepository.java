package com.zapateria2.demo.data;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import com.zapateria2.demo.model.pojo.ElasticInvoice;
import com.zapateria2.demo.model.pojo.ElasticLineInvoice;
import com.zapateria2.demo.model.pojo.ElasticOrder;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ElasticsearchRepository {
	
	private final ElasticOrderRepository orderRepository;
	private final ElasticInvoiceRepository invoiceRepository;
	private final ElasticLineInvoiceRepository lineInvoiceRepository;
	private final ElasticsearchOperations elasticClient;
	
	//ORDERS
	
	public ElasticOrder saveOrder(ElasticOrder order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}
	
	public Boolean  deleteOrder(ElasticOrder order) {
		// TODO Auto-generated method stub
		return orderRepository.delete(order);
	}
	
	public Optional<ElasticOrder> findOrderById(String orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId);
	}
	
	public List<ElasticOrder> findOrders(String ref, Float baseImponible, Float iva, Float importe) {
		// TODO Auto-generated method stub
		BoolQueryBuilder querySpec = QueryBuilders.boolQuery();

		if (!StringUtils.isEmpty(ref)) {
			querySpec.must(QueryBuilders.matchQuery("ref", ref));
		}
		
		if (baseImponible != null) {
			querySpec.must(QueryBuilders.termQuery("baseImponible", baseImponible));
		}
		
		if (iva != null) {
			querySpec.must(QueryBuilders.termQuery("iva", iva));
		}
		
		if (importe != null) {
			querySpec.must(QueryBuilders.termQuery("importe", importe));
		}

		//Si no he recibido ningun parametro, busco todos los elementos.
		if (!querySpec.hasClauses()) {
			querySpec.must(QueryBuilders.matchAllQuery());
		}

		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

		Query query = nativeSearchQueryBuilder.build();
		SearchHits<ElasticOrder> result = elasticClient.search(query, ElasticOrder.class);
		
		return result.getSearchHits().stream().map(SearchHit::getContent).toList();
	}
	
	//INVOICES
	
	public ElasticInvoice saveInvoice(ElasticInvoice invoice) {
		// TODO Auto-generated method stub
		return invoiceRepository.save(invoice);
	}

	public Boolean deleteInvoice(ElasticInvoice invoice) {
		// TODO Auto-generated method stub
		return invoiceRepository.delete(invoice);
	}

	public Optional<ElasticInvoice> findInvoiceById(String invoiceId) {
		// TODO Auto-generated method stub
		return invoiceRepository.findById(invoiceId);
	}

	public List<ElasticInvoice> findInvoices(String num_fac, String date, Float baseImponible, Float iva, Float importe,
			String order) {
		// TODO Auto-generated method stub
		BoolQueryBuilder querySpec = QueryBuilders.boolQuery();

		if (!StringUtils.isEmpty(num_fac)) {
			querySpec.must(QueryBuilders.termQuery("num_fac", num_fac));
		}
		
		if (!StringUtils.isEmpty(date)) {
			querySpec.must(QueryBuilders.termQuery("date", date));
		}
		
		if (baseImponible != null) {
			querySpec.must(QueryBuilders.termQuery("baseImponible", baseImponible));
		}
		
		if (iva != null) {
			querySpec.must(QueryBuilders.termQuery("iva", iva));
		}
		
		if (importe != null) {
			querySpec.must(QueryBuilders.termQuery("importe", importe));
		}

		//Si no he recibido ningun parametro, busco todos los elementos.
		if (!querySpec.hasClauses()) {
			querySpec.must(QueryBuilders.matchAllQuery());
		}
		
		if (!StringUtils.isEmpty(order)) {
			querySpec.must(QueryBuilders.termQuery("order", order));
		}

		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

		Query query = nativeSearchQueryBuilder.build();
		SearchHits<ElasticInvoice> result = elasticClient.search(query, ElasticInvoice.class);
		
		return result.getSearchHits().stream().map(SearchHit::getContent).toList();
	}

	//LINEINVOICES
	
	public ElasticLineInvoice saveLineInvoice(ElasticLineInvoice lineInvoice) {
		// TODO Auto-generated method stub
		return lineInvoiceRepository.save(lineInvoice);
	}

	public Boolean deleteLineInvoice(ElasticLineInvoice lineInvoice) {
		// TODO Auto-generated method stub
		return lineInvoiceRepository.delete(lineInvoice);
	}

	public Optional<ElasticLineInvoice> findLineInvoiceById(String lineInvoiceId) {
		// TODO Auto-generated method stub
		return lineInvoiceRepository.findById(lineInvoiceId);
	}

	public List<ElasticLineInvoice> findLineInvoices(String invoice, String shoeSize, Float baseImponible,
			Float iva, Float importe) {
		// TODO Auto-generated method stub
		BoolQueryBuilder querySpec = QueryBuilders.boolQuery();

		if (!StringUtils.isEmpty(invoice)) {
			querySpec.must(QueryBuilders.termQuery("invoice", invoice));
		}
		
		if (!StringUtils.isEmpty(shoeSize)) {
			querySpec.must(QueryBuilders.termQuery("shoeSize", shoeSize));
		}
		
		if (baseImponible != null) {
			querySpec.must(QueryBuilders.termQuery("baseImponible", baseImponible));
		}
		
		if (iva != null) {
			querySpec.must(QueryBuilders.termQuery("iva", iva));
		}
		
		if (importe != null) {
			querySpec.must(QueryBuilders.termQuery("importe", importe));
		}

		//Si no he recibido ningun parametro, busco todos los elementos.
		if (!querySpec.hasClauses()) {
			querySpec.must(QueryBuilders.matchAllQuery());
		}

		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

		Query query = nativeSearchQueryBuilder.build();
		SearchHits<ElasticLineInvoice> result = elasticClient.search(query, ElasticLineInvoice.class);
		
		return result.getSearchHits().stream().map(SearchHit::getContent).toList();
	}

}
