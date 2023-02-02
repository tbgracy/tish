package com.tish.dao;

import java.sql.Connection;
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
		// TODO:
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TshirtItem obj) {
		// TODO Auto-generated method stub
		return false;
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
