public class Block {
    private final char color;
    private final int x;
    private final int y;

    public Block(char color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinates(){
        return new int[]{x, y};
    }

    @Override
    public String toString() {
        return String.valueOf(color);
    }
}
