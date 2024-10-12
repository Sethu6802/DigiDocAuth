package com.digiAuth.service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.*;

import com.digiAuth.Document.Document;

public class DocService {

	private HashMap<String,List<Document>> list = new HashMap<>();
	Logger log = Logger.getLogger("DocService.class");
	
	public void addDocument(String username, Document document) {
		list.putIfAbsent(username, new ArrayList<>());
		
		List<Document> docs = list.get(username);
		for(Document doc: docs) {
			
			if(doc.getDocName().equalsIgnoreCase(document.getDocName())) {
				log.info("This document already exists");
				return;
			}
			
		}
		
		docs.add(document);
		log.info("Document Added");
	}
	
	public List<Document> getAllDocuments(String username){
		return list.getOrDefault(username, new ArrayList<>());
	}
	
}
