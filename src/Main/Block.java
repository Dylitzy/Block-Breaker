package Main;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private char color;
    private final int row;
    private final int col;
    private final List<Block> neighbors;

    public Block(char color, int row, int col){
        this.color = color;
        this.row = row;
        this.col = col;
        this.neighbors = new ArrayList<>();
    }

    public int[] getCoordinates(){
        return new int[]{row, col};
    }

    public char getColor() {
        return color;
    }

    public void addNeighbor(Block b){
        neighbors.add(b);
    }

    public List<Block> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ") color: " + color;
    }
}
