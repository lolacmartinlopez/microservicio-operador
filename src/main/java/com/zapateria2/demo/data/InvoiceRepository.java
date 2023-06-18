package com.zapateria2.demo.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zapateria2.demo.model.pojo.Invoice;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	Optional<Invoice> findById(Long invoiceId);
}