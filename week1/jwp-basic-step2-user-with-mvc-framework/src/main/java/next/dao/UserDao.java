package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import next.model.User;

@FunctionalInterface
interface SQLResultMapper<T> {
    T map(ResultSet from) throws SQLException;
}

public class UserDao {
    public void queryUpdate(String sql, String... params) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            con = ConnectionManager.getConnection();
            statement = con.prepareStatement(sql);
            for(int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public <T> List<T> queryGet(SQLResultMapper<T> mapper, String sql, String... params) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            con = ConnectionManager.getConnection();
            statement = con.prepareStatement(sql);
            for(int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            rs = statement.executeQuery();

            ArrayList<T> items = new ArrayList<T>();
            while(rs.next())
                items.add(mapper.map(rs));
            return items;
        } finally {
            if (rs != null)
                rs.close();
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void insert(User user) throws SQLException {
        queryUpdate("INSERT INTO USERS VALUES (?, ?, ?, ?)",
                user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }

    public void update(User user) throws SQLException {
        queryUpdate("UPDATE USERS SET userId=?, password=?, name=?, email=? WHERE userId=?",
                user.getUserId(), user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }

    public List<User> findAll() throws SQLException {
        return queryGet(
                rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email")),
                "SELECT * FROM USERS;"
        );
    }

    public User findByUserId(String userId) throws SQLException {
        List<User> users = queryGet(
                rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email")),
                "SELECT userId, password, name, email FROM USERS WHERE userId=?",
                userId
        );
        return !users.isEmpty() ? users.get(0) : null;
    }
}
