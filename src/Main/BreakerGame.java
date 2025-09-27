package Main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Map;
import static java.util.Map.entry;

public class BreakerGame extends Application{
    final static int DIMENSION = 600;
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
    Button NewGame = new Button("New Game");

    BorderPane screen;
    GridPane board;
    HBox topLabels;
    Grid gameGrid;

    @Override
    public void start(Stage stage) {
        board = new GridPane();
        screen = new BorderPane();
        topLabels = new HBox(50);

        moves.setStyle("-fx-font-size: 16px;");
        highscore.setStyle("-fx-font-size: 16px;");
        score.setStyle("-fx-font-size: 16px;");

        topLabels.getChildren().add(score);
        topLabels.getChildren().add(moves);
        topLabels.getChildren().add(highscore);

        topLabels.setAlignment(Pos.CENTER);
        screen.setTop(topLabels);

        NewGame.setMinHeight(50);
        NewGame.setMinWidth(100);
        NewGame.setStyle("-fx-font-size: 16px;");
        BorderPane.setAlignment(NewGame, Pos.CENTER);
        screen.setBottom(NewGame);

        gameGrid = new Grid();
        Block[][] grid = gameGrid.getGrid();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                final Block b = grid[i][j];
                gameGrid.setNeighbors(b);
                Button button = new Button();
                button.setMinSize(50, 50);
                button.setStyle("-fx-background-color:" + colors.get(b.getColor()));
                button.setOnAction(e -> action(b));
                board.add(button, i, j);
            }
        }

        board.setGridLinesVisible(true);
        screen.setCenter(board);
        board.setAlignment(Pos.CENTER);

        Scene scene = new Scene(screen);
        stage.setWidth(DIMENSION);
        stage.setHeight(DIMENSION);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void action(Block b){
        //gameGrid.destroy(b);
        System.out.println(b);
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
