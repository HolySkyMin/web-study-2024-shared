package core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLManager {
    public static void queryUpdate(String sql, String... params) {
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

    public static <T> List<T> queryGet(SQLResultMapper<T> mapper, String sql, String... params) {
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
}
