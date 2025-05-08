package com.indrayani.service.impl;

import com.indrayani.DTO.TransactionDTO;
import com.indrayani.entity.TransactionEntity;
import com.indrayani.mapper.TransactionMapper;
import com.indrayani.repository.TransactionRepository;
import com.indrayani.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository transactionRepository;
	private final TransactionMapper transactionMapper;

	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
		this.transactionRepository = transactionRepository;
		this.transactionMapper = transactionMapper;
	}

	@Override
	public TransactionDTO createTransaction(TransactionDTO transactionDto) {
		String generatedOrderId = "order_" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 14);

		transactionDto.setTransactionId(UUID.randomUUID().toString());
		transactionDto.setOrderId(generatedOrderId);
		transactionDto.setBanktransId("BANK-" + UUID.randomUUID().toString().substring(0, 6));

		LocalDateTime now = LocalDateTime.now();
		transactionDto.setTransactionDate(now);
		transactionDto.setCreatedAt(now);
		transactionDto.setUpdatedAt(now);

		TransactionEntity transactionEntity = transactionMapper.toEntity(transactionDto);
		TransactionEntity savedTransactionEntity = transactionRepository.save(transactionEntity);
		return transactionMapper.toDTO(savedTransactionEntity);
	}

	@Override
	public TransactionDTO getTransactionById(Long id) {
		TransactionEntity transactionEntity = transactionRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found with id: " + id));
		return transactionMapper.toDTO(transactionEntity);
	}

	@Override
	public TransactionDTO getTransactionByTransactionId(String transactionId) {
		TransactionEntity transactionEntity = transactionRepository.findByTransactionId(transactionId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Transaction not found with transactionId: " + transactionId));
		return transactionMapper.toDTO(transactionEntity);
	}

	@Override
	public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDto) {
		TransactionEntity existingTransactionEntity = transactionRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found with id: " + id));

		transactionMapper.updateEntityFromDto(transactionDto, existingTransactionEntity);
		existingTransactionEntity.setUpdatedAt(LocalDateTime.now());

		TransactionEntity updatedTransactionEntity = transactionRepository.save(existingTransactionEntity);
		return transactionMapper.toDTO(updatedTransactionEntity);
	}

	@Override
	public void deleteTransaction(Long id) {
		if (!transactionRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found with id: " + id);
		}
		transactionRepository.deleteById(id);
	}

	@Override
	public List<TransactionDTO> getAllTransactions() {
		return transactionRepository.findAll().stream().map(transactionMapper::toDTO).collect(Collectors.toList());
	}
}
