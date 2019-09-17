package com.lion.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadFileController {
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request,
						 @RequestParam("userFile") MultipartFile part) {
		try {
			String fileName = part.getOriginalFilename();
			System.out.println(fileName);
			part.transferTo(new File("D://tmp//" + fileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "path";
	}
	
	@RequestMapping("/toUpload")
	public String toUpload() {
		return "upload";
	}
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpServletRequest requst,
						   @RequestParam String fileName,
						   @RequestHeader("User-Agent") String userAgent) throws IOException {
		File file = new File("D://tmp//" + fileName);
		
		BodyBuilder builder = ResponseEntity.ok();
		builder.contentLength(file.length());
		builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
		fileName = URLEncoder.encode(fileName, "UTF-8");
		
		if (userAgent.indexOf("MSIE") > 0) {
			builder.header("Content-Disposition", "attachment;filename=" + fileName);
		} else {
			builder.header("Content-Disposition", "attachment;filename*=UTF-8''" + fileName);
		}
		return builder.body(FileUtils.readFileToByteArray(file));
	}
	
	@RequestMapping("/toDownload")
	public String toDownload() {
		return "download";
	}
}
