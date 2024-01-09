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
    public void queryUpdate(String sql, String... params) {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            for(int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
            statement.close();
            con.close();
        } catch(SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public <T> List<T> queryGet(SQLResultMapper<T> mapper, String sql, String... params) {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            for(int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            ResultSet rs = statement.executeQuery();

            ArrayList<T> items = new ArrayList<T>();
            while(rs.next())
                items.add(mapper.map(rs));

            rs.close();
            statement.close();
            con.close();
            return items;
        } catch(SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void insert(User user) {
        queryUpdate("INSERT INTO USERS VALUES (?, ?, ?, ?)",
                user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }

    public void update(User user) {
        queryUpdate("UPDATE USERS SET userId=?, password=?, name=?, email=? WHERE userId=?",
                user.getUserId(), user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }

    public List<User> findAll() {
        return queryGet(
                rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email")),
                "SELECT * FROM USERS;"
        );
    }

    public User findByUserId(String userId) {
        List<User> users = queryGet(
                rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email")),
                "SELECT userId, password, name, email FROM USERS WHERE userId=?",
                userId
        );
        return !users.isEmpty() ? users.get(0) : null;
    }
}
