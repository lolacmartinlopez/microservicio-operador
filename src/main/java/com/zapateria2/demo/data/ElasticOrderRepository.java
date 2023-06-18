package com.zapateria2.demo.data;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.zapateria2.demo.model.pojo.ElasticOrder;

public interface  ElasticOrderRepository extends ElasticsearchRepository<ElasticOrder, String>{

	ElasticOrder save(ElasticOrder order);

	Boolean delete(ElasticOrder order);

	Optional<ElasticOrder> findById(String orderId);

}
