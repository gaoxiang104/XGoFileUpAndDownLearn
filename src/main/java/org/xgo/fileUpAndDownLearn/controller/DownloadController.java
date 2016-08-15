package org.xgo.fileUpAndDownLearn.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/download")
public class DownloadController {
	private static final Logger log = LogManager.getLogger("down_c");
	
	@RequestMapping("base.ctrl")  
	public void download(HttpServletResponse res) throws Exception {  
		log.info("download() start");
	    OutputStream os = res.getOutputStream();  
	    try {  
	        res.reset();  
	        res.setHeader("Content-Disposition", "attachment; filename=download.txt");  
	        res.setContentType("application/octet-stream; charset=utf-8");  
	        os.write("你好啊！".getBytes("UTF8"));
	        os.flush();  
	    } finally {  
	        if (os != null) {  
	            os.close();  
	        }  
	    }  
	} 
	
}
