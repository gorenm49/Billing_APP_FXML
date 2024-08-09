import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestClass extends Application {
    private static final String URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String USER = "yourusername";
    private static final String PASSWORD = "yourpassword";

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(URL, USER, PASSWORD);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX with JDBC Template");

        Button fetchButton = new Button("Fetch Data");
        Label resultLabel = new Label();

        fetchButton.setOnAction(event -> {
            String query = "SELECT NOW()";
            String result = jdbcTemplate.executeQuery(query, resultSet -> {
                if (resultSet.next()) {
                    return resultSet.getString(1);
                } else {
                    return "No data found";
                }
            });
            resultLabel.setText("Current time: " + result);
        });

        VBox vbox = new VBox(fetchButton, resultLabel);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}