import java.util.Random;

public class Grid {
    private Block[][] grid;

    public Grid(){
        Random rand = new Random();
        grid = new Block[10][10];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                char[] colors = "ROYGBP".toCharArray();
                grid[i][j] = new Block(colors[rand.nextInt(6)], i, j);
            }
        }
    }

    public Block[][] getGrid() {
        return grid;
    }
}
