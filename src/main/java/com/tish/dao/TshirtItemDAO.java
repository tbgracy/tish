package com.tish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.tish.entities.TshirtItem;

public class TshirtItemDAO extends DAO<TshirtItem> {

	public TshirtItemDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TshirtItem obj) {
		String INSERT_ITEM_SQL = "INSERT INTO TshirtItem(idCmd, idTshirt, quantite) VALUES (?, ?, ?)";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(INSERT_ITEM_SQL);
			prepare.setInt(1, obj.getIdCmd());
			prepare.setInt(2, obj.getIdTshirt());
			prepare.setInt(3, obj.getQuantite());
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		String DELETE_ITEM_SQL = "DELETE FROM TshirtItem WHERE idCmd=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(DELETE_ITEM_SQL);
			prepare.setInt(1, id);
			prepare.executeUpdate();
			prepare.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(TshirtItem obj) {
		String UPDATE_ITEM_SQL = "UPDATE TshirtItem SET idTshirt=?, quantite=? WHERE idCmd=?";
		try {
			PreparedStatement prepare = this.connect.prepareStatement(UPDATE_ITEM_SQL);
			prepare.setInt(1, obj.getIdTshirt());
			prepare.setInt(2, obj.getQuantite());
			prepare.setInt(3, obj.getIdCmd());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public TshirtItem find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TshirtItem> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
