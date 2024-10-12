package com.digiAuth.Document;

public class Document {
	
	private String docName;
	private long docID;
	
	public Document() {
	}
	
	public Document(String docName, long docID) {
		super();
		this.docName = docName;
		this.docID = docID;
	}

	
	
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public long getDocID() {
		return docID;
	}

	public void setDocID(long docID) {
		this.docID = docID;
	}
	
	
}
