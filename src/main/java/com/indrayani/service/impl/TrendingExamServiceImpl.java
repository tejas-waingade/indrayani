package com.indrayani.service.impl;

import com.indrayani.DTO.TrendingExamDTO;
import com.indrayani.entity.TrendingExamEntity;
import com.indrayani.mapper.TrendingExamMapper;
import com.indrayani.repository.TrendingExamRepository;
import com.indrayani.service.TrendingExamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrendingExamServiceImpl implements TrendingExamService {

	private final TrendingExamRepository repository;

	public TrendingExamServiceImpl(TrendingExamRepository repository) {
		this.repository = repository;
	}

	@Override
	public TrendingExamDTO save(TrendingExamDTO dto) {
		TrendingExamEntity entity = TrendingExamMapper.toEntity(dto);
		return TrendingExamMapper.toDTO(repository.save(entity));
	}

	@Override
	public List<TrendingExamDTO> findAll() {
		return repository.findAll().stream().map(TrendingExamMapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public TrendingExamDTO findById(Long id) {
		return repository.findById(id).map(TrendingExamMapper::toDTO).orElse(null);
	}
	
	@Override
	public TrendingExamDTO update(Long id, TrendingExamDTO dto) {
		TrendingExamEntity existing = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("TrendingExam not found with id: " + id));

		existing.setExamCode(dto.getExamCode());
		existing.setType(dto.getType());
		existing.setOrderNo(dto.getOrderNo());
		existing.setLaunchDate(dto.getLaunchDate());
		existing.setCreatedAt(dto.getCreatedAt());
		existing.setCreatedBy(dto.getCreatedBy());

		TrendingExamEntity updated = repository.save(existing);
		return TrendingExamMapper.toDTO(updated);
	}

	@Override
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("TrendingExam not found with id: " + id);
		}
		repository.deleteById(id);
	}

}
