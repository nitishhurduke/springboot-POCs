package com.ssns.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssns.main.model.Document;

@Repository
public interface FileRepository extends JpaRepository<Document, Integer>{

}
