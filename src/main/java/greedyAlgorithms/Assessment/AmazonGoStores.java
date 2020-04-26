package greedyAlgorithms.Assessment;

import java.util.ArrayList;
import java.util.List;

public class AmazonGoStores {

    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
        int total = 0;
        boolean isEven = rows % 2 == 0;
        int r = 0;
        boolean hasDiagonal = true;

        while (r < rows) {
            for (int c = 0; c < column; c += 2) {

                boolean found = false;
                if (r < rows - 1) {
                    Integer prevSameColumn = grid.get(r).get(c);
                    Integer nextSameColumn = grid.get(r + 1).get(c);

                    if (prevSameColumn.equals(1) && prevSameColumn.equals(nextSameColumn)) {
                        total++;
                        found = true;
                    }
                }

                if (c < column - 1) {
                    Integer prevSameRow = grid.get(r).get(c);
                    Integer nextSameRow = grid.get(r).get(c + 1);

                    if (prevSameRow.equals(nextSameRow) && nextSameRow.equals(1)) {
                        total++;
                        found = true;
                    }
                }

                if (!found && r < rows - 1 && c < column - 1) {
                    Integer prevDiagonal = grid.get(r).get(c);
                    Integer nextDiagonal = grid.get(r + 1).get(c + 1);
                    if (!prevDiagonal.equals(nextDiagonal) && prevDiagonal.equals(1)) {
                        hasDiagonal = false;
                    }
                }

            }

            if (isEven || r != rows - 2) {
                r += 2;
            } else if (r == rows - 2) {
                r++;
            }

        }

        return total > 0 ? total : (hasDiagonal ? rows : 0);
    }

    public List<List<Integer>> testCase0() {
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

    public List<List<Integer>> testCase1() {
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

    public List<List<Integer>> testCase2() {
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

    public static void main(String[] args) {
        AmazonGoStores a = new AmazonGoStores();

        List<List<Integer>> grid = a.testCase2();
        System.out.println("numberAmazonGoStores : " + a.numberAmazonGoStores(grid.size(), grid.get(0).size(), grid));

    }
}