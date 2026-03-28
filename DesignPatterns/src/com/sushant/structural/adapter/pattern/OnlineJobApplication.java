package com.sushant.structural.adapter.pattern;

public class OnlineJobApplication {
	
	private final DocumentUploader documentUploader;

	public OnlineJobApplication(DocumentUploader documentUploader) {
		super();
		this.documentUploader = documentUploader;
	}
	
	public void uploadDocument() {
		documentUploader.upload();
	}

}
