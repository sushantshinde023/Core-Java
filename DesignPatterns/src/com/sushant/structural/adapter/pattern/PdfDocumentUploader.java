package com.sushant.structural.adapter.pattern;

public class PdfDocumentUploader implements DocumentUploader {

	@Override
	public void upload() {
		System.out.println("Processing upload....");
		System.out.println("Document Uploaded");

	}

}
