package com.tish;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Securite {
	public static String hasher(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes());
			byte[] digest = md.digest();
			String hex = String.format("%064x", new BigInteger(1, digest));
			return hex;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return text;
	}
}
