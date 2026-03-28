package com.sushant.structural.adapter.pattern;

/*
 * This class we can't use with the OnlineJobApplication class because it doesn't implement DocumentUploader and 
 * OnlineJobApplication class expects a documentUploader in its constructor
 * So we will use Adapter pattern for this class . This is Adaptee class we will create Adaptor
 * */
public class WordDocumentUploader {
	
	public void uploadWordDocument() {
		System.out.println("Processing word document upload....");
		System.out.println("Document Uploaded");
	}
}
