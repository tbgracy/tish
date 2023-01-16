package com.tish.dao;

import com.tish.entities.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDAO extends DAO<Admin> {

    public AdminDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Admin obj) {
        String INSERT_ADMIN_SQL = "INSERT INTO admin(`nomUtilsateur`, `motDePasse`) VALUES(?, ?);";
        try {
            this.connect.createStatement().execute(INSERT_ADMIN_SQL, new String[]{obj.getNomUtilisateur(), obj.getMotDePasse()});
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(Admin obj) {
        String DELETE_ADMIN_SQL = "DELETE admin WHERE `admin`.`nomUtilisateur` = ?;";
        try {
            this.connect.createStatement().execute(DELETE_ADMIN_SQL, new String[]{obj.getNomUtilisateur()});
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Admin obj) {
        String UPDATE_ADMIN_SQL = "";
        try {
            this.connect.createStatement().execute(UPDATE_ADMIN_SQL, new String[]{obj.getNomUtilisateur()});
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Admin find(String nomUtilisateur) {
        Admin admin = new Admin();
        String FIND_ADMIN_SQL = "SELECT admin WHERE `admin`.`nomUtilisateur`=" + nomUtilisateur;
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(FIND_ADMIN_SQL);
            if (result.first()) admin = new Admin(nomUtilisateur, result.getString("motDePasse"));
        } catch (SQLException e) {
            return null;
        }
        return admin;
    }

    @Override
    public Admin find(Long id) {
        return null;
    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

}
