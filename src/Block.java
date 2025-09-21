public class Block {
    private char color;
    private final int x;
    private final int y;
    private final Block[] neighbors;

    public Block(char color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
        this.neighbors = new Block[8];
    }

    public int[] getCoordinates(){
        return new int[]{x, y};
    }

    public char getColor() {
        return color;
    }

    public void setNeighbor(int i, Block b){
        neighbors[i] = b;
    }

    public Block[] getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ") color: " + color;
    }
}
