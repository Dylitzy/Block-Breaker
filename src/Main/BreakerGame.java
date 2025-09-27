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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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

    int highscore;
    int score;
    int moves;
    Label highscoreLabel;
    Label scoreLabel;
    Label movesLabel;
    Button NewGame = new Button("New Game");

    BorderPane screen;
    GridPane board;
    HBox topLabels;
    Grid gameGrid;

    Button[][] buttons;

    @Override
    public void start(Stage stage) {
        board = new GridPane();
        screen = new BorderPane();
        topLabels = new HBox(50);

        moves = 0;
        score = 0;
        Scanner scan;
        try{
            scan = new Scanner(new File("src/highscore.txt"));
            highscore = Integer.parseInt(scan.nextLine());
        }
        catch (FileNotFoundException ignored){
            System.err.println("you bozo");
        }

        movesLabel = new Label("Moves: " + moves);
        highscoreLabel = new Label("Highscore: " + highscore);
        scoreLabel = new Label("Score: " + score);

        movesLabel.setStyle("-fx-font-size: 16px;");
        highscoreLabel.setStyle("-fx-font-size: 16px;");
        scoreLabel.setStyle("-fx-font-size: 16px;");

        topLabels.getChildren().add(scoreLabel);
        topLabels.getChildren().add(movesLabel);
        topLabels.getChildren().add(highscoreLabel);

        topLabels.setAlignment(Pos.CENTER);
        screen.setTop(topLabels);

        NewGame = new Button("New Game");
        NewGame.setMinHeight(50);
        NewGame.setMinWidth(100);
        NewGame.setStyle("-fx-font-size: 16px;");
        NewGame.setOnAction(e -> resetGame());
        BorderPane.setAlignment(NewGame, Pos.CENTER);
        screen.setBottom(NewGame);

        gameGrid = new Grid();
        Block[][] grid = gameGrid.getGrid();
        buttons = new Button[10][10];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                final Block b = grid[i][j];
                Button button = new Button();
                button.setMinSize(50, 50);
                button.setStyle("-fx-background-color:" + colors.get(b.getColor()));
                button.setOnAction(e -> action(b));
                buttons[i][j] = button;
                board.add(button, j, i);
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
        moves++;
        movesLabel.setText("Moves: " + moves);
        System.out.println(b);
    }

    public void resetGame(){
        gameGrid = new Grid();
        updateGrid();
        score = 0;
        moves = 0;

        scoreLabel.setText("Score: " + score);
        movesLabel.setText("Moves: " + moves);
    }

    public void updateGrid(){
        Block[][] grid = gameGrid.getGrid();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                final Block b = grid[i][j];
                buttons[i][j].setStyle("-fx-background-color:" + colors.get(b.getColor()));
            }
        }
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
