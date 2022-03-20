package com.ssns.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssns.main.model.Document;
import com.ssns.main.service.FileService;

@RestController
@RequestMapping("/document") // Class Level mapping - All methods of this class will be mapped by '/document/method_mapping'
public class FileController {

	@Autowired
	FileService service;
	
	
//	@PostMapping("add",consumes = MediaTyp)
	@RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<Document> filesUpload(@RequestPart(required = true, value = "adrs_proof") MultipartFile adrs_proof, //MultipartFile is an interface to handle uploaded file
			@RequestPart(required = true, value = "photo") MultipartFile photo,
			@RequestPart(required = true, value = "signature") MultipartFile signature,
			@RequestPart(required = true, value = "thumb") MultipartFile thumb,
			@RequestPart(required = false,value = "doc") String doc //to get Text (we will use it to get JSON object and handle it in String form)
			) throws IOException {
		
		System.out.println(adrs_proof.getBytes()); 
		System.out.println(photo.getOriginalFilename());
		System.out.println(thumb.getSize());
		System.out.println(signature.getContentType());
		
		System.out.println(doc);
	
		/* 
		 * We have to Convert JSON object into Java Object
		 * 		for this purpose we have two approaches 
		 * 		1.use ObjectMapper class - readvalue(byte[],class.name)
		 * 		2.use 3rd party library by google called Gson
		 * */
		
		ObjectMapper obj = new ObjectMapper();
		Document d1 = obj.readValue(doc, Document.class);
		
//		Gson gson = new Gson();
//		Document d1 = gson.fromJson(doc,Document.class);
		
		Document d = new Document();
		
		d.setAdrs_proof(adrs_proof.getBytes());
		d.setPhoto(photo.getBytes());
		d.setSignature(signature.getBytes());
		d.setThumb(thumb.getBytes());
		d.setCustomer_id(d1.getCustomer_id());
		
		List<Document> docs  = service.fileUpload(d);
		
		return docs;
	}
	@GetMapping(value="/files",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Document> getFiles(){
		return service.getFiles();
	}
	@GetMapping("/images")
	public Image
}
