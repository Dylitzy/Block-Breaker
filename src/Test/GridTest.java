package Test;

import Main.Block;
import Main.Grid;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class GridTest {

    @Test
    public void testSetNeighbors(){
        Grid g = new Grid();
        Block[][] grid = g.getGrid();

        Block Test1 = grid[0][0];
        Block Test2 = grid[0][9];
        Block Test3 = grid[9][0];
        Block Test4 = grid[9][9];
        Block Test5 = grid[0][3];
        Block Test6 = grid[5][0];
        Block Test7 = grid[6][7]; // DO NOT SAY IT.

        List<Block> tests = List.of(Test1, Test2, Test3, Test4, Test5, Test6, Test7);
        
        for (Block test: tests){
            g.setNeighbors(test);
        }

        Assert.assertEquals(List.of(grid[0][1], grid[1][0], grid[1][1]), tests.get(0).getNeighbors());
        Assert.assertEquals(List.of(grid[0][8], grid[1][8], grid[1][9]), tests.get(1).getNeighbors());
        Assert.assertEquals(List.of(grid[8][0], grid[8][1], grid[9][1]), tests.get(2).getNeighbors());
        Assert.assertEquals(List.of(grid[8][8], grid[8][9], grid[9][8]), tests.get(3).getNeighbors());
        Assert.assertEquals(List.of(grid[0][2], grid[0][4], grid[1][2], grid[1][3], grid[1][4]), tests.get(4).getNeighbors());
        Assert.assertEquals(List.of(grid[4][0], grid[4][1], grid[5][1], grid[6][0], grid[6][1]), tests.get(5).getNeighbors());
        Assert.assertEquals(List.of(grid[5][6], grid[5][7], grid[5][8], grid[6][6], grid[6][8], grid[7][6], grid[7][7], grid[7][8]), tests.get(6).getNeighbors());
    }

    @Test
    public void testDestroy(){
        // stub
    }
}
