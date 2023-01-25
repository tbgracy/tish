package com.tish.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tish.entities.Commande;

public class CommandeDAO extends DAO<Commande> {

	public CommandeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Commande obj) {
		String INSERT_COMMANDE_SQL = "INSERT INTO Commande (idUtilisateur, nombreCmd, dateCmd, etatCmd) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(INSERT_COMMANDE_SQL);
			prepare.setInt(1, obj.getIdUtilisateur());
			prepare.setInt(2, obj.getNombreCmd());
			prepare.setDate(3, (Date) obj.getDateCmd());
			prepare.setBoolean(4, obj.isEtatCmd());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(Commande obj) {
		String DELETE_COMMAND_SQL = "DELETE FROM Commande WHERE idCmd=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(DELETE_COMMAND_SQL);
			prepare.setInt(1, obj.getIdCmd());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(Commande obj) {
		String UPDATE_CMD_SQL = "UPDATE SET nombreCmd=?, etatCmd=? WHERE idCmd=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(UPDATE_CMD_SQL);
			prepare.setInt(1, obj.getNombreCmd());
			prepare.setBoolean(2, obj.isEtatCmd());
			prepare.setInt(3, obj.getIdCmd());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Commande find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getAll() {
		String GET_ALL_SQL = "SELECT * From Commande";
		List<Commande> list_cmd = new ArrayList<Commande>();
		try {
			ResultSet result = this.connect.createStatement().executeQuery(GET_ALL_SQL);

			while (result.next()) {
				Commande commande = new Commande(result.getInt("idCmd"), result.getInt("idUtilisateur"),
						result.getInt("nombreCmd"), result.getDate("dateCmd"), result.getBoolean("etatCmd"));
				list_cmd.add(commande);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list_cmd;
	}

}
