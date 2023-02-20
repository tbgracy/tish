package com.tish.dao;

import com.tish.entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDAO extends DAO<Admin> {

	public AdminDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Admin obj) {
		String INSERT_ADMIN_SQL = "INSERT INTO Admin (nomUtilisateur, motDePasse) VALUES(?, ?)";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(INSERT_ADMIN_SQL);
			prepare.setString(1, obj.getNomUtilisateur());
			prepare.setString(2, obj.getMotDePasse());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int idAdmin) {
		String DELETE_ADMIN_SQL = "DELETE FROM Admin WHERE nomUtilisateur=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(DELETE_ADMIN_SQL);
			prepare.setInt(1, idAdmin);
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(Admin obj) {
		String UPDATE_ADMIN_SQL = "UPDATE Admin SET nomUtilisateur=?, nomPassword=? WHERE idAdmin=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(UPDATE_ADMIN_SQL);
			prepare.setString(1, obj.getNomUtilisateur());
			prepare.setString(2, obj.getMotDePasse());
			prepare.setInt(3, obj.getIdAdmin());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public Admin find(String nomUtilisateur) {
		Admin admin = new Admin();
		String FIND_ADMIN_SQL = "SELECT nomUtilisateur, motDePasse FROM Admin WHERE nomUtilisateur=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(FIND_ADMIN_SQL);
			prepare.setString(1, nomUtilisateur);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				admin = new Admin(nomUtilisateur, result.getString("motDePasse"));
			prepare.close();
			return admin;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Admin find(int id) {
		return null;
	}

	@Override
	public List<Admin> getAll() {
		return null;
	}

}
