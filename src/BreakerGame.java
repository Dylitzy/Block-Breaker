import javafx.application.Application;
import javafx.stage.Stage;

public class BreakerGame extends Application{
    @Override
    public void start(Stage stage) {
        stage.setHeight(700);
        stage.setWidth(700);
        stage.setResizable(false);
        stage.show();

        Grid game = new Grid();
        Block[][] grid = game.getGrid();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
