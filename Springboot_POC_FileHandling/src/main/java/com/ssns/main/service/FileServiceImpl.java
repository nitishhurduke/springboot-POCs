package com.ssns.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssns.main.model.Document;
import com.ssns.main.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository repo;
	@Override
	public List<Document> getFiles(){
		List<Document> docs = repo.findAll();
		return docs;
	}
	public List<Document> fileUpload(Document d) {
		repo.save(d);
		return getFiles();
	}
}
