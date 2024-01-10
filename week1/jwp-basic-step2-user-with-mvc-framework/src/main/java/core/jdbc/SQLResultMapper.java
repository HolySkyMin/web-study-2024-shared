package core.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface SQLResultMapper<T> {
    T map(ResultSet from) throws SQLException;
}
