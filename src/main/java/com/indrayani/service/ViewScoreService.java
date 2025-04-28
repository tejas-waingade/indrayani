package com.indrayani.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.indrayani.DTO.ViewScoreDTO;
import com.indrayani.entity.ViewScoreEntity;
import com.indrayani.mapper.ViewScoreMapper;
import com.indrayani.repository.ViewScoreRepository;

@Service
public class ViewScoreService {

	@Autowired
	private ViewScoreRepository viewScoreRepository;

	@Autowired
	private ViewScoreMapper viewScoreMapper;

	public List<ViewScoreDTO> getAllViewScores() {
		List<ViewScoreEntity> viewScoreEntities = viewScoreRepository.findAll();
		return viewScoreEntities.stream().map(viewScoreMapper::toDTO).collect(Collectors.toList());
	}

	public ViewScoreDTO createViewScore(ViewScoreDTO viewScoreDTO) {
		ViewScoreEntity entity = viewScoreMapper.toEntity(viewScoreDTO);
		ViewScoreEntity savedEntity = viewScoreRepository.save(entity);
		return viewScoreMapper.toDTO(savedEntity);
	}

	public ViewScoreDTO updateViewScore(Long id, ViewScoreDTO viewScoreDTO) {
		Optional<ViewScoreEntity> optionalViewScore = viewScoreRepository.findById(id);
		if (optionalViewScore.isPresent()) {
			ViewScoreEntity existingEntity = optionalViewScore.get();
			ViewScoreEntity updatedEntity = viewScoreMapper.toEntity(viewScoreDTO);
			updatedEntity.setId(existingEntity.getId());
			ViewScoreEntity savedEntity = viewScoreRepository.save(updatedEntity);
			return viewScoreMapper.toDTO(savedEntity);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "View score not found");
		}
	}

	public void deleteViewScore(Long id) {
		if (viewScoreRepository.existsById(id)) {
			viewScoreRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "View score not found");
		}
	}
}
