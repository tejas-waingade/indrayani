package com.indrayani.service;

import com.indrayani.DTO.TrendingExamDTO;
import com.indrayani.entity.TrendingExamEntity;
import com.indrayani.mapper.TrendingExamMapper;
import com.indrayani.repository.TrendingExamRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrendingExamImplService implements TrendingExamService {

	private final TrendingExamRepository repository;

	public TrendingExamImplService(TrendingExamRepository repository) {
		this.repository = repository;
	}

	@Override
	public TrendingExamDTO save(TrendingExamDTO dto) {
		TrendingExamEntity entity = TrendingExamMapper.toEntity(dto);
		TrendingExamEntity saved = repository.save(entity);
		return TrendingExamMapper.toDTO(saved);
	}

	@Override
	public List<TrendingExamDTO> findAll() {
		return repository.findAll().stream().map(TrendingExamMapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public TrendingExamDTO findById(Long id) {
		return repository.findById(id).map(TrendingExamMapper::toDTO).orElse(null);
	}

	public TrendingExamDTO update(Long id, TrendingExamDTO dto) {
	    return repository.findById(id)
	            .map(existing -> {
	                TrendingExamEntity updatedEntity = TrendingExamMapper.toEntity(dto);
	                updatedEntity.setId(existing.getId()); // preserve ID
	                TrendingExamEntity saved = repository.save(updatedEntity);
	                return TrendingExamMapper.toDTO(saved);
	            })
	            .orElse(null);
	}

	public boolean deleteById(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
