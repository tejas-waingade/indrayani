package com.indrayani.mapper;

import org.springframework.stereotype.Service;
import com.indrayani.DTO.OrderDTO;
import com.indrayani.entity.OrderEntity;


@Service
public class OrderMapper {

    public static OrderDTO toDTO(OrderEntity entity) {
        if (entity == null) return null;

        OrderDTO dto = new OrderDTO();
        dto.setUserId(entity.getUserId());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setPayableAmount(entity.getPayableAmount());
        dto.setDiscount(entity.getDiscount());
        if(entity.getOrderExamMaps() != null){
            dto.setExamIds(entity.getOrderExamMaps().stream().map(orderExamMap -> orderExamMap.getExam().getId()).toList());
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

        return entity;
    }
}
