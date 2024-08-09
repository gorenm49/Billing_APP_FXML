import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
    private final String url;
    private final String user;
    private final String password;

    public JdbcTemplate(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public <T> T executeQuery(String query, ResultSetHandler<T> handler, Object... params) {
        try (Connection connection = getConnection();
             PreparedStatement statement = createPreparedStatement(connection, query, params);
             ResultSet resultSet = statement.executeQuery()) {
            return handler.handle(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query, Object... params) {
        try (Connection connection = getConnection();
             PreparedStatement statement = createPreparedStatement(connection, query, params)) {
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private PreparedStatement createPreparedStatement(Connection connection, String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement;
    }

    @FunctionalInterface
    public interface ResultSetHandler<T> {
        T handle(ResultSet resultSet) throws SQLException;
    }
}