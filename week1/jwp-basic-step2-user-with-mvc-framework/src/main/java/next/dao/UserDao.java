package next.dao;

import java.util.List;

import core.jdbc.SQLManager;
import next.model.User;

public class UserDao {
    public void insert(User user) {
        SQLManager.queryUpdate("INSERT INTO USERS VALUES (?, ?, ?, ?)",
                user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }

    public void update(User user) {
        SQLManager.queryUpdate("UPDATE USERS SET userId=?, password=?, name=?, email=? WHERE userId=?",
                user.getUserId(), user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }

    public List<User> findAll() {
        return SQLManager.queryGet(
                rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email")),
                "SELECT * FROM USERS;"
        );
    }

    public User findByUserId(String userId) {
        List<User> users = SQLManager.queryGet(
                rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email")),
                "SELECT userId, password, name, email FROM USERS WHERE userId=?",
                userId
        );
        return !users.isEmpty() ? users.get(0) : null;
    }
}
