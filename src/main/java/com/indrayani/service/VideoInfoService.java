package com.indrayani.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indrayani.DTO.VideoInfoDTO;
import com.indrayani.entity.VideoInfoEntity;
import com.indrayani.mapper.VideoInfoMapper;
import com.indrayani.repository.VideoInfoRepository;

@Service
public class VideoInfoService {
	
	@Autowired
	private VideoInfoRepository videoInfoRepository;

	@Autowired
	private VideoInfoMapper videoInfoMapper;

	public VideoInfoDTO getVideoInfoById(long id) {
		return videoInfoRepository.findById(id).map(videoInfoMapper::toDTO).orElse(null);
	}

	public List<VideoInfoDTO> getAllVideoInfos() {
		return videoInfoRepository.findAll().stream().map(videoInfoMapper::toDTO).collect(Collectors.toList());
	}

	public VideoInfoDTO addVideoInfo(VideoInfoDTO videoInfoDTO) {
		VideoInfoEntity videoInfoEntity = videoInfoMapper.toEntity(videoInfoDTO);
		VideoInfoEntity saveVideoInfo = videoInfoRepository.save(videoInfoEntity);
		return videoInfoMapper.toDTO(saveVideoInfo);
	}

	public VideoInfoDTO updateVideoInfo(Long id, VideoInfoDTO videoInfoDTO) {
		if (videoInfoRepository.existsById(id)) {
			videoInfoDTO.setId(id);
			VideoInfoEntity updatedVideoInfo = videoInfoRepository.save(videoInfoMapper.toEntity(videoInfoDTO));
			return videoInfoMapper.toDTO(updatedVideoInfo);
		}
		return null;
	}

	public void deleteVideoInfo(Long id) {
		videoInfoRepository.deleteById(id);
	}
}
