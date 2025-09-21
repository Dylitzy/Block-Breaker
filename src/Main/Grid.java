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
        int x = cors[0];
        int y = cors[1];
        int i = 0;

        if (y != 9){
            for (int j = x != 0 ? x - 1 : x; j <= x + 1; j++){
                b.setNeighbor(i++, grid[j][y + 1]);
            }
        }

        if (x != 0)
            b.setNeighbor(i++, grid[x - 1][y]);
        if (x != 9)
            b.setNeighbor(i++, grid[x + 1][y]);

        if (y != 0){
            for (int j = x != 0 ? x - 1 : x; j <= x + 1; j++){
                b.setNeighbor(i++, grid[j][y - 1]);
            }
        }
    }

    public void destroy(Block b){
        int count = 0;
        Block[] neighbors = b.getNeighbors();
        for (Block neighbor : neighbors){
            if (neighbor.getColor() == b.getColor()){
                count++;
            }
        }
        if (count >= 3){
        }
    }

    public Block[][] getGrid() {
        return grid;
    }
}
