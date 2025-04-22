package com.indrayani.service;

import com.indrayani.DTO.TransactionDTO;
import java.util.List;

public interface TransactionService {
	TransactionDTO createTransaction(TransactionDTO transactionDto);

	TransactionDTO getTransactionById(Long id);

	TransactionDTO getTransactionByTransactionId(String transactionId);

	TransactionDTO updateTransaction(Long id, TransactionDTO transactionDto);

	void deleteTransaction(Long id);

	List<TransactionDTO> getAllTransactions();
}