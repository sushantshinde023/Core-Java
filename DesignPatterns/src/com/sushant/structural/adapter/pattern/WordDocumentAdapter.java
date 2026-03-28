package com.sushant.structural.adapter.pattern;

public class WordDocumentAdapter implements DocumentUploader{
	
	private final WordDocumentUploader wordDocumentUploader;
	
	public WordDocumentAdapter() {
		wordDocumentUploader = new WordDocumentUploader();
	}

	@Override
	public void upload() {
		// TODO Auto-generated method stub
		wordDocumentUploader.uploadWordDocument();
		
	}

}
