package com.indrayani.mapper;

	import com.indrayani.DTO.ExamResultDTO;
	import com.indrayani.entity.ExamResultEntity;
    import org.springframework.stereotype.Service;

	@Service
	public class ExamResultMapper {

	    public ExamResultDTO toDTO(ExamResultEntity entity) {

	        return new ExamResultDTO(
	            entity.getResultId(),
	            entity.getUserId(),
	            entity.getExamCode(),
	            entity.getScore(),
	            entity.getAttemptedAt(),
	            entity.getTimeTaken(),
	            entity.getSkipAns(),
	            entity.getUnskipAns(),
	            entity.getWrongAns(),
	            entity.getRightAns(),
	            entity.getTotalQuestions(),
	            entity.getQuestionAvgTime()
	        );
	    }

	    public ExamResultEntity toEntity(ExamResultDTO dto) {

	        ExamResultEntity entity = new ExamResultEntity();
	        entity.setResultId(dto.getResultId());
	        entity.setUserId(dto.getUserId());
	        entity.setExamCode(dto.getExamCode());
	        entity.setScore(dto.getScore());
	        entity.setAttemptedAt(dto.getAttemptedAt());
	        entity.setTimeTaken(dto.getTimeTaken());
	        entity.setSkipAns(dto.getSkipAns());
	        entity.setUnskipAns(dto.getUnskipAns());
	        entity.setWrongAns(dto.getWrongAns());
	        entity.setRightAns(dto.getRightAns());
	        entity.setTotalQuestions(dto.getTotalQuestions());
	        entity.setQuestionAvgTime(dto.getQuestionAvgTime());
	        return entity;
	    }
	}

