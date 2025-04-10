package com.indrayani.service;

import com.indrayani.DTO.TrendingExamDTO;
import java.util.List;

public interface TrendingExamService {
    TrendingExamDTO save(TrendingExamDTO dto);
    List<TrendingExamDTO> findAll();
    TrendingExamDTO findById(Long id);
}
