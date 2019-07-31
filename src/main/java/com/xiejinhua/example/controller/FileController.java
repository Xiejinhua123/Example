package com.xiejinhua.example.controller;

import java.io.*;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FileController {

	// 实现Spring Boot 的文件下载功能，映射网址为/download
	@GetMapping("/download/{fileName}")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws UnsupportedEncodingException {

		// 如果文件名不为空，则进行下载
		if (fileName != null) {
			// 设置文件路径
			String realPath = "E://a/";
			File file = new File(realPath, fileName);

			// 如果文件名存在，则进行下载
			if (file.exists()) {

				// 配置文件下载
				response.setHeader("content-type", "application/octet-stream");
				response.setContentType("application/octet-stream");
				// 下载文件能正常显示中文
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

				// 实现文件下载
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					System.out.println("Download the song successfully!");
				} catch (Exception e) {
					System.out.println("Download the song failed!");
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}

}