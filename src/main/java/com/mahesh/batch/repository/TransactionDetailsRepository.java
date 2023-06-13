package com.mahesh.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahesh.batch.model.TransactionDetails;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, String>{

}
