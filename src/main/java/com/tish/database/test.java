package com.tish.database;
import com.tish.dao.*;
import com.tish.entities.Admin;

public class test {
	public static void main() {
		AdminDAO admin = new AdminDAO(DatabaseConnection.getInstance());
		admin.create(new Admin("Gracy", "12213223"));
		System.out.println(admin);
	}
}
