package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

import com.example.demo.Controladores.HomeController;
import com.hazelcast.com.google.common.base.Charsets;
import com.hazelcast.org.apache.calcite.avatica.util.Base64;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtils {
	
	
	public static String imageToString (String resource) {
		try(var in =  FurryAdvisorApplication.class.getClassLoader().getResourceAsStream(resource)) {
			return Base64.encodeBytes(in.readAllBytes());
		} catch (IOException ex) {
			ex.printStackTrace();
			return "";
		}
	}
	
	public static String imageToString (MultipartFile resource) {
		try(var in = resource.getInputStream()) {
			return Base64.encodeBytes(in.readAllBytes());
		} catch (IOException ex) {
			ex.printStackTrace();
			return "";
		}
	}
	
	public static Resource imageStringToResource (String image) {
		try {
			return new InputStreamResource(new ByteArrayInputStream(Base64.decode(image)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
