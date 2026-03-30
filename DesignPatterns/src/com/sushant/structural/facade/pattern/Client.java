package com.sushant.structural.facade.pattern;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 EncryptionFacade service = new EncryptionFacade("mySecretPassword");

	        String original = "Hello Sushant!";
	        
	        String encrypted = service.encrypt(original);
	        String decrypted = service.decrypt(encrypted);

	        System.out.println("Original: " + original);
	        System.out.println("Encrypted: " + encrypted);
	        System.out.println("Decrypted: " + decrypted);

	}

}
