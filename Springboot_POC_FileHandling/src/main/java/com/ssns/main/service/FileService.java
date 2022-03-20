package com.ssns.main.service;

import java.util.List;

import com.ssns.main.model.Document;

public interface FileService {

	List<Document> fileUpload(Document d);

	List<Document> getFiles();

}
