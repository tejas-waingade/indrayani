package com.indrayani.mapper;

import java.util.List;

import org.springframework.stereotype.Service;
import com.indrayani.DTO.OrderDTO;
import com.indrayani.entity.OrderEntity;
import com.indrayani.entity.OrderExamMap;


@Service
public class OrderMapper {

	public static OrderDTO toDTO(OrderEntity entity) {
	    if (entity == null) return null;

	    OrderDTO dto = new OrderDTO();
	    dto.setUserId(entity.getUserId());
	    dto.setTotalAmount(entity.getTotalAmount());
	    dto.setPayableAmount(entity.getPayableAmount());
	    dto.setDiscount(entity.getDiscount());

	    if (entity.getOrderExamMaps() != null) {
	        dto.setExamCodes(
	            entity.getOrderExamMaps().stream()
	                .map(OrderExamMap::getExamCode)
	                .toList()
	        );
	    }

	    return dto;
	}

	public static OrderEntity toEntity(OrderDTO dto) {
	    if (dto == null) return null;

	    OrderEntity entity = new OrderEntity();
	    entity.setUserId(dto.getUserId());
	    entity.setTotalAmount(dto.getTotalAmount());
	    entity.setPayableAmount(dto.getPayableAmount());
	    entity.setDiscount(dto.getDiscount());

	    if (dto.getExamCodes() != null) {
	        List<OrderExamMap> examMaps = dto.getExamCodes().stream().map(code -> {
	            OrderExamMap map = new OrderExamMap();
	            map.setExamCode(code);
	            map.setOrder(entity);
	            return map;
	        }).toList();
	        entity.setOrderExamMaps(examMaps);
	    }

	    return entity;
	}

}
