package com.indrayani.mapper;

import org.springframework.stereotype.Service;

import com.indrayani.DTO.UserDTO;
import com.indrayani.entity.UserEntity;

@Service
public class UserMapper {

    public static UserDTO toDTO(UserEntity entity) {
        if (entity == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setMobile(entity.getMobile());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEducation(entity.getEducation());
        dto.setOptedClasses(entity.getOptedClasses());
        dto.setCity(entity.getCity());
        dto.setDistrict(entity.getDistrict());
        dto.setState(entity.getState());
        dto.setPincode(entity.getPincode());
        dto.setAddressRole(entity.getAddressRole());
        dto.setIsActive(entity.getIsActive());
        dto.setIsDeleted(entity.getIsDeleted());
        dto.setIsMobileVerified(entity.getIsMobileVerified());
        dto.setIsEmailVerified(entity.getIsEmailVerified());
        dto.setEmailOtp(entity.getEmailOtp());
        dto.setMobileOtp(entity.getMobileOtp());
        dto.setEmailOtpGeneratedAt(entity.getEmailOtpGeneratedAt());
        dto.setMobileOtpGeneratedAt(entity.getMobileOtpGeneratedAt());
        dto.setFcmToken(entity.getFcmToken());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setGoogleId(entity.getGoogleId());

        return dto;
    }

    public static UserEntity toEntity(UserDTO dto) {
        if (dto == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setMobile(dto.getMobile());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEducation(dto.getEducation());
        entity.setOptedClasses(dto.getOptedClasses());
        entity.setCity(dto.getCity());
        entity.setDistrict(dto.getDistrict());
        entity.setState(dto.getState());
        entity.setPincode(dto.getPincode());
        entity.setAddressRole(dto.getAddressRole());
        entity.setIsActive(dto.getIsActive());
        entity.setIsDeleted(dto.getIsDeleted());
        entity.setIsMobileVerified(dto.getIsMobileVerified());
        entity.setIsEmailVerified(dto.getIsEmailVerified());
        entity.setEmailOtp(dto.getEmailOtp());
        entity.setMobileOtp(dto.getMobileOtp());
        entity.setEmailOtpGeneratedAt(dto.getEmailOtpGeneratedAt());
        entity.setMobileOtpGeneratedAt(dto.getMobileOtpGeneratedAt());
        entity.setFcmToken(dto.getFcmToken());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setGoogleId(dto.getGoogleId());

        return entity;
    }
}
