package com.indrayani.controller;

import com.indrayani.DTO.TransactionDTO;
import com.indrayani.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private final TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping
	public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDto) {
		TransactionDTO createdTransaction = transactionService.createTransaction(transactionDto);
		return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
		TransactionDTO transactionDto = transactionService.getTransactionById(id);
		return new ResponseEntity<>(transactionDto, HttpStatus.OK);
	}

	@GetMapping("/byTransactionId/{transactionId}")
	public ResponseEntity<TransactionDTO> getTransactionByTransactionId(@PathVariable String transactionId) {
		TransactionDTO transactionDto = transactionService.getTransactionByTransactionId(transactionId);
		return new ResponseEntity<>(transactionDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable Long id,
			@RequestBody TransactionDTO transactionDto) {
		TransactionDTO updatedTransaction = transactionService.updateTransaction(id, transactionDto);
		return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
		transactionService.deleteTransaction(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
		List<TransactionDTO> transactions = transactionService.getAllTransactions();
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}
}