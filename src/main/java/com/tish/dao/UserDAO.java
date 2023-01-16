package com.tish.dao;

import com.tish.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends DAO<User> {
    public UserDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(User obj) {
        String INSERT_USER_SQL = "INSERT INTO user(`nomUtilisateur`, `motDePasse`, `numeroTel`) VALUES (?,?,?);";
        try {
            this.connect.createStatement().execute(INSERT_USER_SQL, new String[]{obj.getNomUtilsateur(), obj.getMotDePasse(), obj.getMotDePasse()});
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(User obj) {
        String DELETE_USER_SQL = "DELETE user WEHRE `user`.`idUtilisateur` = ?;";
        try {
            this.connect.createStatement().execute(DELETE_USER_SQL, new String[]{String.valueOf(obj.getIdUtilisateurL())});
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(User obj) {
        String UPDATE_USER_SQL = "";
        try {
            this.connect.createStatement().execute(UPDATE_USER_SQL, new String[]{String.valueOf(obj.getIdUtilisateurL())});
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public User find(String username) {
        return null;
    }

    @Override
    public User find(Long id) {
        User user = new User();
        String FIND_USER_SQL = "SELECT admin WHERE `admin`.`idUtilisateur`=" + id;
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(FIND_USER_SQL);
            if (result.first()) user = new User(id, result.getString("nomUtilisateur"), result.getString("motDePasse"), result.getString("numeroTel"));
        } catch (SQLException e) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        String GET_ALL_SQL = "SELECT * FROM `user`";
        List<User> list_user = null;
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(GET_ALL_SQL);
            int size = result.getFetchSize();
            for (int i = 0; i < size; i++) {
                User user = (User) result.getObject(i);
                assert false;
                list_user.set(i, user);
            }
        } catch (SQLException e) {
            return null;
        }
        return list_user;
    }
}
