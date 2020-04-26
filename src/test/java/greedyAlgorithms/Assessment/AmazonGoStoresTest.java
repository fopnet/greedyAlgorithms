package greedyAlgorithms.Assessment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AmazonGoStoresTest {

    public List<List<Integer>> getTestCase0() {
        List<List<Integer>> grid = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            grid.add(new ArrayList<Integer>(4));
        }

        grid.get(0).add(1);
        grid.get(0).add(1);
        grid.get(0).add(0);
        grid.get(0).add(0);

        grid.get(1).add(0);
        grid.get(1).add(0);
        grid.get(1).add(1);
        grid.get(1).add(0);

        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(0);

        grid.get(3).add(1);
        grid.get(3).add(0);
        grid.get(3).add(1);
        grid.get(3).add(1);

        grid.get(4).add(1);
        grid.get(4).add(1);
        grid.get(4).add(1);
        grid.get(4).add(1);

        return grid;

    }

    public List<List<Integer>> getTestCase1() {
        int rows = 4;
        int coluns = 4;
        List<List<Integer>> grid = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<Integer>(coluns));
        }

        grid.get(0).add(1);
        grid.get(0).add(1);
        grid.get(0).add(0);
        grid.get(0).add(0);

        grid.get(1).add(0);
        grid.get(1).add(0);
        grid.get(1).add(0);
        grid.get(1).add(0);

        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(1);
        grid.get(2).add(1);

        grid.get(3).add(0);
        grid.get(3).add(0);
        grid.get(3).add(0);
        grid.get(3).add(0);

        return grid;

    }

    public List<List<Integer>> getTestCase2() {
        int rows = 7;
        int coluns = 7;
        List<List<Integer>> grid = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<Integer>(coluns));
        }

        grid.get(0).add(1);
        grid.get(0).add(0);
        grid.get(0).add(0);
        grid.get(0).add(0);
        grid.get(0).add(0);
        grid.get(0).add(0);
        grid.get(0).add(0);

        grid.get(1).add(0);
        grid.get(1).add(1);
        grid.get(1).add(0);
        grid.get(1).add(0);
        grid.get(1).add(0);
        grid.get(1).add(0);
        grid.get(1).add(0);

        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(1);
        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(0);
        grid.get(2).add(0);

        grid.get(3).add(0);
        grid.get(3).add(0);
        grid.get(3).add(0);
        grid.get(3).add(1);
        grid.get(3).add(0);
        grid.get(3).add(0);
        grid.get(3).add(0);

        grid.get(4).add(0);
        grid.get(4).add(0);
        grid.get(4).add(0);
        grid.get(4).add(0);
        grid.get(4).add(1);
        grid.get(4).add(0);
        grid.get(4).add(0);

        grid.get(5).add(0);
        grid.get(5).add(0);
        grid.get(5).add(0);
        grid.get(5).add(0);
        grid.get(5).add(0);
        grid.get(5).add(1);
        grid.get(5).add(0);

        grid.get(6).add(0);
        grid.get(6).add(0);
        grid.get(6).add(0);
        grid.get(6).add(0);
        grid.get(6).add(0);
        grid.get(6).add(0);
        grid.get(6).add(1);
        return grid;

    }

    public void testTemplate(List<List<Integer>> grid, int expected) {
        AmazonGoStores a = new AmazonGoStores();
        int actual = a.numberAmazonGoStores(grid.size(), grid.get(0).size(), grid);
        assertEquals(expected, actual);
        System.out.println("numberAmazonGoStores : " + a.numberAmazonGoStores(grid.size(), grid.get(0).size(), grid));
    }

    @Test
    public void testCase0() {
        testTemplate(getTestCase0(), 3);
    }

    @Test
    public void testCase1() {
        testTemplate(getTestCase1(), 2);
    }

    @Test
    public void testCase2() {
        testTemplate(getTestCase2(), 7);
    }
}