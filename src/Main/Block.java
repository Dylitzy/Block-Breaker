package Main;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private char color;
    private final int row;
    private final int col;
    private final List<Block> neighbors;

    /**
     * Initializes a new block instance.
     * @param color color of block
     * @param row row position of block
     * @param col column position of block
     */
    public Block(char color, int row, int col){
        this.color = color;
        this.row = row;
        this.col = col;
        this.neighbors = new ArrayList<>();
    }

    /**
     * Return this block's coordinates
     * @return the (row, col) coordinate pair for this block
     */
    public int[] getCoordinates(){
        return new int[]{row, col};
    }

    /**
     * Get color attribute
     * @return block color
     */
    public char getColor() {
        return color;
    }

    public static char randomColor() {
        char[] colors = "ROYGCBP".toCharArray();
        return colors[(int) Math.floor(Math.random() * 7)];
    }

    /**
     * Set this block's color to a new color—important for destroy logic
     * @param newColor the new color
     */
    public void setColor(char newColor){
        color = newColor;
    }

    /**
     * Adds another block to this block's list of neighbors
     * @param b The other block to be added
     */
    public void addNeighbor(Block b){
        neighbors.add(b);
    }

    /**
     * Get this block's list of neighbors.
     * @return list of neighbors.
     */
    public List<Block> getNeighbors() {
        return neighbors;
    }

    /**
     * Represents this block as a string.
     * @return a string representation of the block.
     */
    @Override
    public String toString() {
        return "(" + row + "," + col + ") color: " + color;
    }
}
