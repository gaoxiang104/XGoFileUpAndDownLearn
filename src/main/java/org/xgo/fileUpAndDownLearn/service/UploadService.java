package org.xgo.fileUpAndDownLearn.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private static final String UPLOAD_PATH = "/static/upload/";

	
	/**
	 * 最基础的上传文件
	 * @param file
	 * @return 文件名称
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String base(MultipartFile file) throws IllegalStateException, IOException {
		
		String fileName = file.getOriginalFilename();
		// 文件上传的路径：tomcat根目录+/static/upload/
		File targetFile = new File(System.getProperty("catalina.home")+UPLOAD_PATH, fileName);
		
		file.transferTo(targetFile);
		
		return fileName;
	}

}
