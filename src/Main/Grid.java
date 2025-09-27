package Main;

import java.util.*;

public class Grid {
    private final Block[][] grid;

    /**
     * Initializes a new Grid instance.
     * First, construct the blocks and randomize their color.
     * Then, set each newly constructed block's neighbors.
     */
    public Grid(){
        grid = new Block[10][10];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                grid[i][j] = new Block(Block.randomColor(), i, j);
            }
        }

        for (Block[] blocks : grid) {
            for (Block block : blocks) {
                setNeighbors(block);
            }
        }
    }

    /**
     * Set the neighbors for Block b in the grid.
     * @param b The block to set neighbors for
     */
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

    /**
     * When this block is selected, calculate the nearby ones that must be destroyed, and do so.
     * @param b The block to be destroyed
     * @return The list of affected blocks (for testing purposes only)
     */
    public List<Block> destroy(Block b){
        List<Block> destroyed = new ArrayList<>();
        Queue<Block> toBeProcessed = new ArrayDeque<>();
        Map<Block, Boolean> processedBlocks = new HashMap<>();

        toBeProcessed.add(b);
        processedBlocks.put(b, true);
        while (!toBeProcessed.isEmpty()){
            Block currentBlock = toBeProcessed.poll();
            char currentBlockColor = currentBlock.getColor();
            destroyed.add(currentBlock);
            List<Block> neighbors = currentBlock.getNeighbors();
            for (Block n : neighbors){
                if (processedBlocks.get(n) == null && n.getColor() == currentBlockColor){
                    toBeProcessed.add(n);
                    processedBlocks.put(n, true);
                }
            }
        }

        if (destroyed.size() < 3){
            return new ArrayList<>();
        }

        return destroyed;
    }

    public Block[][] getGrid() {
        return grid;
    }
}
