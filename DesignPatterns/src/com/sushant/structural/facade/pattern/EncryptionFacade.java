package com.sushant.structural.facade.pattern;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionFacade {
	
	private static final String ALGORITHM = "AES";
    private SecretKey secretKey;

    // Constructor takes password (simplified key management)
    public EncryptionFacade(String password) {
        this.secretKey = generateKey(password);
    }

    // Generate key from password
    private SecretKey generateKey(String password) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] key = sha.digest(password.getBytes());

            key = Arrays.copyOf(key, 16); // 128-bit AES
            return new SecretKeySpec(key, ALGORITHM);

        } catch (Exception e) {
            throw new RuntimeException("Error generating key", e);
        }
    }

    // Encrypt method (Facade hides complexity)
    public String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    // Decrypt method
    public String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            return new String(decryptedBytes);

        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }

}
