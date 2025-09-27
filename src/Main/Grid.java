package Main;

import java.util.Random;

public class Grid {
    private Block[][] grid;

    public Grid(){
        Random rand = new Random();
        grid = new Block[10][10];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                char[] colors = "ROYGCBP".toCharArray();
                grid[i][j] = new Block(colors[rand.nextInt(7)], i, j);
            }
        }
    }

    public void setNeighbors(Block b){
        int[] cors = b.getCoordinates();
        int row = cors[0];
        int col = cors[1];

        if (row != 0){
            b.addNeighbor(grid[row - 1][col]);
        }
        if (row != 9){
            b.addNeighbor(grid[row + 1][col]);
        }

        if (col != 0){
            b.addNeighbor(grid[row][col - 1]);
        }
        if (col != 9){
            b.addNeighbor(grid[row][col + 1]);
        }
    }

    public void destroy(Block b){
        // stub
    }

    public Block[][] getGrid() {
        return grid;
    }
}
