import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Map;
import static java.util.Map.entry;

public class BreakerGame extends Application{
    final static Map<Character, String> colors = Map.ofEntries(
            entry('R', "red"),
            entry('O', "orange"),
            entry('Y', "yellow"),
            entry('G', "green"),
            entry('C', "lightblue"),
            entry('B', "blue"),
            entry('P', "purple")
    );
    Label highscore = new Label("Highscore: 0");
    Label score = new Label("Score: 0");
    Label moves = new Label("Moves: 0");
    BorderPane screen;
    GridPane board;

    @Override
    public void start(Stage stage) {
        board = new GridPane();
        screen = new BorderPane();

        Grid game = new Grid();
        Block[][] grid = game.getGrid();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                final Block b = grid[i][j];
                Button button = new Button();
                button.setMinSize(50, 50);
                button.setStyle("-fx-background-color:" + colors.get(b.getColor()));
                button.setOnAction(e->action(b));
                board.add(button, i, j);
            }
        }

        board.setGridLinesVisible(true);
        screen.setCenter(board);

        Scene scene = new Scene(screen);
        stage.setHeight(700);
        stage.setWidth(700);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void action(Block b){
        System.out.println(b);
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
