package Test;

import Main.Block;
import Main.Grid;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashSet;
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

        Assert.assertEquals(new HashSet<>(List.of(grid[0][1], grid[1][0])), new HashSet<>(tests.get(0).getNeighbors()));
        Assert.assertEquals(new HashSet<>(List.of(grid[0][8], grid[1][9])), new HashSet<>(tests.get(1).getNeighbors()));
        Assert.assertEquals(new HashSet<>(List.of(grid[8][0], grid[9][1])), new HashSet<>(tests.get(2).getNeighbors()));
        Assert.assertEquals(new HashSet<>(List.of(grid[8][9], grid[9][8])), new HashSet<>(tests.get(3).getNeighbors()));
        Assert.assertEquals(new HashSet<>(List.of(grid[0][2], grid[0][4], grid[1][3])), new HashSet<>(tests.get(4).getNeighbors()));
        Assert.assertEquals(new HashSet<>(List.of(grid[4][0], grid[5][1], grid[6][0])), new HashSet<>(tests.get(5).getNeighbors()));
        Assert.assertEquals(new HashSet<>(List.of(grid[5][7], grid[6][6], grid[6][8], grid[7][7])), new HashSet<>(tests.get(6).getNeighbors()));
    }

    @Test
    public void testDestroy(){
        Grid g = new Grid();
        Block[][] grid = g.getGrid();

        // test that single-color destroys fail and that simple three-color destroys succeed
        grid[0][0].setColor('R');
        grid[0][1].setColor('T'); // 'T' means Test color! :D
        grid[1][0].setColor('T');
        grid[1][1].setColor('T');

        Assert.assertEquals(0, g.destroy(grid[0][0]).size());
        Assert.assertEquals(3, g.destroy(grid[0][1]).size());

        // test that double-color destroys fail and that BFS chains through a whole sequence of color neighbors.
        grid[0][0].setColor('R');
        grid[0][1].setColor('R');
        grid[0][2].setColor('T');
        grid[1][0].setColor('T');
        grid[1][1].setColor('T');
        grid[1][2].setColor('T');

        Assert.assertEquals(0, g.destroy(grid[0][0]).size());
        Assert.assertEquals(0, g.destroy(grid[0][1]).size());
        Assert.assertEquals(4, g.destroy(grid[0][2]).size());

        // test that diagonal neighbors are not included
        for (int i = 0; i < 4; i++){
            grid[9][i].setColor('T');
        }
        grid[8][1].setColor('T');
        grid[7][2].setColor('T'); // this one shouldn't be destroyed.

        Assert.assertEquals(5, g.destroy(grid[9][0]).size());

        // test a full line
        for (int i = 0; i < 10; i++){
            grid[i][6].setColor('X');
        }
        Assert.assertEquals(10, g.destroy(grid[1][6]).size());
    }
}
