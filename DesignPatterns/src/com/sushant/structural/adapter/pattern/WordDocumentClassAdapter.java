package com.sushant.structural.adapter.pattern;


/*
 * With this class adapter pattern we can only use it now with WordDocumentUploader, so if we have other file type
 * we will not be able to use this adapter pattern with them(other file type), we will need different adapter for each one 
 * 
 * */
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
