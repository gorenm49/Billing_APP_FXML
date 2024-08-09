import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SqlUtil {
 /*   private final JdbcTemplate jdbcTemplate;

    public SqlUtil(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method for executing SELECT queries
    public <T> List<T> query(String query, ResultSetHandler<T> handler, Object... params) {
        return jdbcTemplate.executeQuery(query, resultSet -> {
            List<T> results = (List<T>) handler.handle(resultSet);
            return results;
        }, params);
    }

    // Method for executing single-row SELECT queries
    public <T> T queryForSingle(String query, ResultSetHandler<T> handler, Object... params) {
        return jdbcTemplate.executeQuery(query, resultSet -> {
            if (resultSet.next()) {
                return handler.handle(resultSet);
            } else {
                return null;
            }
        }, params);
    }

    // Method for executing INSERT, UPDATE, DELETE queries
    public int update(String query, Object... params) {
        return jdbcTemplate.executeUpdate(query, params);
    }

    // Method to fetch all rows as a list of maps
    public List<Map<String, Object>> queryForMapList(String query, Object... params) {
        return jdbcTemplate.executeQuery(query, resultSet -> {
            int columnCount = resultSet.getMetaData().getColumnCount();
            return resultSetToList(resultSet, columnCount);
        }, params);
    }

    // Method to fetch a single row as a map
    public Map<String, Object> queryForMap(String query, Object... params) {
        return jdbcTemplate.executeQuery(query, resultSet -> {
            if (resultSet.next()) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                return resultSetToMap(resultSet, columnCount);
            } else {
                return null;
            }
        }, params);
    }

    private List<Map<String, Object>> resultSetToList(ResultSet resultSet, int columnCount) throws SQLException {
        return resultSetToMapStream(resultSet, columnCount).collect(Collectors.toList());
    }

    private Map<String, Object> resultSetToMap(ResultSet resultSet, int columnCount) throws SQLException {
        return resultSetToMapStream(resultSet, columnCount).findFirst().orElse(null);
    }

    private Stream<Map<String, Object>> resultSetToMapStream(ResultSet resultSet, int columnCount) throws SQLException {
        return StreamSupport.stream(new ResultSetSpliterator(resultSet), false)
                .map(rs -> {
                    try {
                        Map<String, Object> row = new LinkedHashMap<>();
                        for (int i = 1; i <= columnCount; i++) {
                            row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                        }
                        return row;
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    // Functional interface for handling ResultSet
    @FunctionalInterface
    public interface ResultSetHandler<T> {
        T handle(ResultSet resultSet) throws SQLException;
    }*/
}
