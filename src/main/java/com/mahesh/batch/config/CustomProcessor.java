package com.mahesh.batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.mahesh.batch.model.TransactionDetails;

public class CustomProcessor implements ItemProcessor<TransactionDetails, TransactionDetails> {

	@Override
	public TransactionDetails process(TransactionDetails item) throws Exception {
		
		return item;
	}

}
