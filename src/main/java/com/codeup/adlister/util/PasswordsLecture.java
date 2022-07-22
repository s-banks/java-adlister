package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordsLecture {
	public static void main(String[] args) {
		String password = "password";
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println(hash);
		boolean passwordMatch = BCrypt.checkpw(password, hash);
		System.out.println(passwordMatch);
		passwordMatch = BCrypt.checkpw("password123", hash);
		System.out.println(passwordMatch);

	}


}
