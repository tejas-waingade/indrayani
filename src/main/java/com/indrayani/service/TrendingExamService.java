package com.indrayani.service;

import com.indrayani.DTO.TrendingExamDTO;
import java.util.List;

public interface TrendingExamService {
	TrendingExamDTO save(TrendingExamDTO dto);

	List<TrendingExamDTO> findAll();

	TrendingExamDTO findById(Long id);
	
	TrendingExamDTO update(Long id, TrendingExamDTO dto);

	void delete(Long id);

}
