package com.indrayani.mapper;

import org.springframework.stereotype.Service;
import com.indrayani.DTO.VideoInfoDTO;
import com.indrayani.entity.VideoInfoEntity;

 @Service
public class VideoInfoMapper {

	  public VideoInfoDTO toDTO(VideoInfoEntity videoInfoEntity) {
	        return new VideoInfoDTO(
	            videoInfoEntity.getId(),
	            videoInfoEntity.getTitle(),
	            videoInfoEntity.getContent(),
	            videoInfoEntity.getType(),
	            videoInfoEntity.getImage(),
	            videoInfoEntity.getExternal_url(),
	            videoInfoEntity.getCreated_at(),
	            videoInfoEntity.getCreated_by(),
	            videoInfoEntity.getUpdated_at(),
	            videoInfoEntity.getUpdated_by()
	        );
	    }

	  public VideoInfoEntity toEntity(VideoInfoDTO videoInfoDTO) {
	        VideoInfoEntity entity = new VideoInfoEntity();
	        entity.setTitle(videoInfoDTO.getTitle());
	        entity.setContent(videoInfoDTO.getContent());
	        entity.setType(videoInfoDTO.getType());
	        entity.setImage(videoInfoDTO.getImage());
	        entity.setExternal_url(videoInfoDTO.getExternal_url());
	        entity.setCreated_at(videoInfoDTO.getCreated_at());
	        entity.setCreated_by(videoInfoDTO.getCreated_by());
	        entity.setUpdated_at(videoInfoDTO.getUpdated_at());
	        entity.setUpdated_by(videoInfoDTO.getUpdated_by());
	        return entity;
	    }
 }

