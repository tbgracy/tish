package com.tish.dao;

import com.tish.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User> {
	public UserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(User obj) {
		String INSERT_USER_SQL = "INSERT INTO Utilisateur (nomUtilisateur, motDePasse, numeroTel) VALUES (?, ?, ?)";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(INSERT_USER_SQL);
			prepare.setString(1, obj.getNomUtilisateur());
			prepare.setString(2, obj.getMotDePasse());
			prepare.setString(3, obj.getNumeroTel());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(User obj) {
		String DELETE_USER_SQL = "DELETE FROM Utilisateur WEHRE idUtilisateur=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(DELETE_USER_SQL);
			prepare.setInt(1, obj.getIdUtilisateur());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(User obj) {
		String UPDATE_USER_SQL = "UPDATE Utilisateur SET nomUtilisateur=?, motDePasse=?, numeroTel=? WHERE idUtilisateur=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(UPDATE_USER_SQL);
			prepare.setString(1, obj.getNomUtilisateur());
			prepare.setString(2, obj.getMotDePasse());
			prepare.setString(3, obj.getNumeroTel());
			prepare.setInt(4, obj.getIdUtilisateur());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public User find(String username) {
		User user = new User();
		String FIND_USER_SQL = "SELECT * FROM Utilisateur WHERE nomUtilisateur=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(FIND_USER_SQL);
			prepare.setString(1, username);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				user = new User(result.getInt("idUtilisateur"), result.getString("nomUtilisateur"),
						result.getString("motDePasse"), result.getString("numeroTel"));
				prepare.close();
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User find(int id) {
		User user = new User();
		String FIND_USER_SQL = "SELECT * FROM Utilisateur WHERE idUtilisateur=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(FIND_USER_SQL);
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery();
			if (result.next())
				user = new User(result.getInt("idAdmin"), result.getString("nomUtilisateur"),
						result.getString("motDePasse"), result.getString("numeroTel"));
			prepare.close();
		} catch (SQLException e) {
			return null;
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		String GET_ALL_SQL = "SELECT * FROM Utilisateur";
		List<User> list_user = new ArrayList<User>();
		try {
			ResultSet result = this.connect.createStatement().executeQuery(GET_ALL_SQL);

			while (result.next()) {
				User user = new User(result.getInt("idUtilisateur"), result.getString("nomUtilisateur"),
						result.getString("motDePasse"), result.getString("numeroTel"));
				list_user.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list_user;
	}
}
