package com.sushant.structural.adapter.pattern;

public class WordDocumentAdapter implements DocumentUploader{
	
	private final WordDocumentUploader wordDocumentUploader;
	
	public WordDocumentAdapter() {
		wordDocumentUploader = new WordDocumentUploader();
	}

	@Override
	public void upload() {
		// TODO Auto-generated method stub
		//Here we are  just calling the method on the wordDocumentUploader objects
		// so if we want to override the behavior of Adaptee class , it might be better to use the class Adapter pattern
		// see : WordDocumentClassAdapter
		wordDocumentUploader.uploadWordDocument();
		
	}

}
