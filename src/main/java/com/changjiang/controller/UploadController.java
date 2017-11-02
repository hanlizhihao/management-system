package com.changjiang.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class UploadController {
	@RequestMapping(value="/upload",produces="text/plain;charset=UTF-8",method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile image,@RequestParam("idNumber") String idNumber){
		try {
			FileUtils.writeByteArrayToFile(new File("E:/tomcat9.0/webapps/shopImage",
					image.getOriginalFilename()),image.getBytes());
			System.out.println(idNumber);
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return "wrong";
		}catch (NullPointerException e) {
			System.out.println("file为空");
			return "nullPointException";
		}
	}
}
