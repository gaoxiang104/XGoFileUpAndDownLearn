package org.xgo.fileUpAndDownLearn.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.xgo.fileUpAndDownLearn.service.UploadService;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {
	private static final Logger log = LogManager.getLogger("upload_c");

	@Autowired
	UploadService uploadService;

	@RequestMapping(value = "/base.ctrl")
	public void baseUpload(@RequestParam MultipartFile file, HttpServletResponse response) throws IOException {
		String error = null;
		Object object = null;

		OutputStream os = response.getOutputStream();
		response.setContentType("text/html; charset=utf-8");

		if (file.getBytes().length == 0) {
			error = "上传的文件是空的";
			log.warn("baseUpload({}) warn : {}", file, error);
			os.write(error.getBytes("UTF8"));
			os.flush();
		} else {
			try {
				object = uploadService.base(file);
				log.info("baseUpload({}) info : {}", file, object);
				os.write((object + "上传成功").toString().getBytes("UTF8"));
				os.flush();
			} catch (Exception e) {
				log.error("baseUpload({}) error : {}", file, error);
				log.error("StackTrace : {}", e);
				os.write(e.toString().getBytes());
				os.flush();
			}
		}
	}
}
