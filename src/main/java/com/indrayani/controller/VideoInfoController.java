package com.indrayani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indrayani.DTO.VideoInfoDTO;
import com.indrayani.service.VideoInfoService;

@RestController
@RequestMapping("/videoInfo")
public class VideoInfoController {

    @Autowired
    private VideoInfoService videoInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<VideoInfoDTO> getVideoInfoById(@PathVariable Long id) {
        VideoInfoDTO videoInfoDTO = videoInfoService.getVideoInfoById(id); 
        if (videoInfoDTO != null) {
            return ResponseEntity.ok(videoInfoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<VideoInfoDTO>> getAllVideoInfos() {
        List<VideoInfoDTO> videoInfoDTOs = videoInfoService.getAllVideoInfos(); 
        return ResponseEntity.ok(videoInfoDTOs);
    }

    @PostMapping
    public ResponseEntity<VideoInfoDTO> addVideoInfo(@RequestBody VideoInfoDTO videoInfoDTO) { 
        VideoInfoDTO addedVideoInfo = videoInfoService.addVideoInfo(videoInfoDTO);
        return new ResponseEntity<>(addedVideoInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoInfoDTO> updateVideoInfo(@PathVariable Long id, @RequestBody VideoInfoDTO videoInfoDTO) { 
        VideoInfoDTO updatedVideoInfo = videoInfoService.updateVideoInfo(id, videoInfoDTO);
        if (updatedVideoInfo != null) {
            return ResponseEntity.ok(updatedVideoInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideoInfo(@PathVariable Long id) {
        videoInfoService.deleteVideoInfo(id);
        return ResponseEntity.noContent().build();
    }
}







