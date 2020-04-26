package greedyAlgorithms.Assessment;

import java.util.List;

public class AmazonGoStores {

    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
        int total = 0;
        int totalEntireDiagonal = 0;
        boolean hasDiagonalComplete = true;

        for (int r = 0; r < rows; r = nextIndex(r, rows)) {
            for (int c = 0; c < column; c = nextIndex(c, column)) {

                boolean found = false;
                if (r < rows - 1) {
                    Integer prevSameColumn = grid.get(r).get(c);
                    Integer nextSameColumn = grid.get(r + 1).get(c);

                    if (prevSameColumn.equals(1) && prevSameColumn.equals(nextSameColumn)) {
                        total++;
                        found = true;
                    }
                }

                if (!found && c < column - 1) {
                    Integer prevSameRow = grid.get(r).get(c);
                    Integer nextSameRow = grid.get(r).get(c + 1);

                    if (prevSameRow.equals(nextSameRow) && nextSameRow.equals(1)) {
                        total++;
                        found = true;
                    }
                }

                if (found)
                    hasDiagonalComplete = false;

                if (hasDiagonalComplete && r < rows - 1 && c < column - 1) {
                    Integer prevDiagonal = grid.get(r).get(c);
                    Integer nextDiagonal = grid.get(r + 1).get(c + 1);
                    if (prevDiagonal.equals(nextDiagonal) && prevDiagonal.equals(1)) {
                        totalEntireDiagonal += 2;
                    }
                }

                // if (isEven || c != rows - 2 - 1) {
                // c += 2;
                // } else if (c == rows - 2 - 1) {
                // c++;
                // }

            }

            // if (isEven || r != rows - 2 - 1) {
            // r += 2;
            // } else if (r == rows - 2 - 1) {
            // r++;
            // }
        }

        if (hasDiagonalComplete && rows % 2 != 0)
            totalEntireDiagonal -= 1;

        return total > 0 ? total : (hasDiagonalComplete ? totalEntireDiagonal : 0);
    }

    int nextIndex(int curr, int columnsOrRows) {
        boolean isEven = columnsOrRows % 2 == 0;
        if (isEven || curr != columnsOrRows - 2 - 1) {
            curr += 2;
        } else if (curr == columnsOrRows - 2 - 1) {
            curr++;
        }
        return curr;
    }
 
}