import javafx.application.Application;
import javafx.stage.Stage;

public class BreakerGame extends Application {
    @Override
    public void start(Stage stage) {
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
