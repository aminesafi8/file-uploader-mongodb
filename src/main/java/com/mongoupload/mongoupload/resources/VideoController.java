package com.mongoupload.mongoupload.resources;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongoupload.mongoupload.documents.Photo;
import com.mongoupload.mongoupload.documents.Video;
import com.mongoupload.mongoupload.services.PhotoService;
import com.mongoupload.mongoupload.services.VideoService;

@RestController
public class VideoController {
	@Autowired
	VideoService videoService;

	@PostMapping("/videos/add")
	public String addVideo(@RequestParam("title") String title, @RequestParam("file") MultipartFile file, Model model)
			throws IOException {
		String id = videoService.addVideo(title, file);
		return "redirect:/videos/" + id;
	}

	@GetMapping("/videos/{id}")
	public String getVideo(@PathVariable String id, Model model) throws Exception {
		Video video = videoService.getVideo(id);
		model.addAttribute("title", video.getTitle());
		model.addAttribute("url", "/videos/stream/" + id);
		return "videos";
	}
	
	@GetMapping("/videos/stream/{id}")
	public void streamVideo(@PathVariable String id, HttpServletResponse response) throws Exception {
	    Video video = videoService.getVideo(id);
	    FileCopyUtils.copy(video.getStream(), response.getOutputStream());        
	}
	
}
