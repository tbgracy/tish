package com.tish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tish.entities.Tshirt;

public class TshirtDAO extends DAO<Tshirt> {

	public TshirtDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Tshirt obj) {
		String INSET_TSHIRT_SQL = "INSERT INTO Tshirt (motif, couleur, nombre, taille, prix) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(INSET_TSHIRT_SQL);
			prepare.setString(1, obj.getMotif());
			prepare.setString(2, obj.getCouleur());
			prepare.setInt(3, obj.getNombre());
			prepare.setString(4, obj.getMotif());
			prepare.setInt(5, obj.getPrix());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(int idTshirt) {
		String DELET_TSHIRT_SQL = "DELETE FROM Tshirt WHERE idTshirt=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(DELET_TSHIRT_SQL);
			prepare.setInt(1, idTshirt);
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(Tshirt obj) {
		String UPDATE_TSHIRT_SQL = "UPDATE Tshirt SET motif=?, couleur=?, nombre=?, taille=? , prix=? WHERE idTshirt=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(UPDATE_TSHIRT_SQL);
			prepare.setString(1, obj.getMotif());
			prepare.setString(2, obj.getCouleur());
			prepare.setInt(3, obj.getNombre());
			prepare.setString(4, obj.getTaille());
			prepare.setInt(5, obj.getPrix());
			prepare.setInt(6, obj.getIdTShirt());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Tshirt find(int id) {
		Tshirt tish = new Tshirt();
		String FIND_TSHIRT_SQL = "SELECT * FROM Tshirt WHERE idTshirt=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(FIND_TSHIRT_SQL);
			prepare.setInt(1, id);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				tish = new Tshirt(result.getInt("idTshirt"), result.getString("motif"), result.getString("couleur"),
<<<<<<< HEAD
						result.getInt("nombre"), result.getString("taille"));
				prepare.close();
				return tish;
			} else {
				return null;
			}
=======
						result.getInt("nombre"), result.getString("taille"), result.getInt("prix"));
			prepare.close();
>>>>>>> 97b70f5 (Add: champ prix)
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Tshirt> getAll() {
		String GET_ALL_SQL = "SELECT * FROM Tshirt";
		List<Tshirt> list_tish = new ArrayList<Tshirt>();
		try {
			ResultSet result = this.connect.createStatement().executeQuery(GET_ALL_SQL);
			while (result.next()) {
				Tshirt tish = new Tshirt(result.getInt("idTshirt"), result.getString("motif"),
						result.getString("couleur"), result.getInt("nombre"), result.getString("taille"),
						result.getInt("prix"));
				list_tish.add(tish);
			}
			return list_tish;
		} catch (SQLException e) {
			return null;
		}
	}
}
