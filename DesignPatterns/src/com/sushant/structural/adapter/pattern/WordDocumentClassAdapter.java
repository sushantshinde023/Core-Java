package com.sushant.structural.adapter.pattern;

public class WordDocumentClassAdapter extends WordDocumentUploader implements DocumentUploader{

	@Override
	public void upload() {
		// TODO Auto-generated method stub
		uploadWordDocument();
		
	}
	
	//if want to change behavior override 
	public void uploadWordDocument() {
		System.out.println("Preparing word document upload...");
		System.out.println("Uploading word document ...");
	}
	

}
