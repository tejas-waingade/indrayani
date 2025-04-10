package com.indrayani.service;

import org.springframework.stereotype.Service;

public class TrendingExamImplService {

	@Service
	public class TrendingExamServiceImpl implements TrendingExamService {

		private final TrendingUpcomingExamRepository repository;

	public TrendingExamImplService(TrendingExamRepository repository) {
        this.repository = repository;
    }

		@Override
		public TrendingExamDTO save(TrendingExamDTO dto) {
			TrendingUpcomingExamEntity entity = TrendingExamMapper.toEntity(dto);
			TrendingUpcomingExamEntity saved = repository.save(entity);
			return TrendingUpcomingExamMapper.toDTO(saved);
		}

		@Override
		public List<TrendingExamDTO> findAll() {
			return repository.findAll().stream().map(TrendingUpcomingExamMapper::toDTO).collect(Collectors.toList());
		}

		@Override
		public TrendingUpcomingExamDTO findById(Long id) {
			return repository.findById(id).map(TrendingUpcomingExamMapper::toDTO).orElse(null);
		}
	}
}
