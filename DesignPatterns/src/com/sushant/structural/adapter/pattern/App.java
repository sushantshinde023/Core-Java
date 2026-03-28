package com.sushant.structural.adapter.pattern;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var pdfDocumentUploader= new PdfDocumentUploader();
		var onlineApplication=new OnlineJobApplication(pdfDocumentUploader);
		
		onlineApplication.uploadDocument();
		
		var wordDocumentAdapter=new WordDocumentAdapter();
		var onlineApplicationWithWord=new OnlineJobApplication(wordDocumentAdapter);
		onlineApplicationWithWord.uploadDocument();

	}

}
