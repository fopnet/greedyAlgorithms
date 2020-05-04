package greedyAlgorithms.AssessmentTraining;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Eight houses, represented as cells, are arranged in a straight line. Each day
 * every cell competes with its adjacent cells (neighbors). An integer value of
 * 1 represents an active cell and a value of O represents an inactive cell. If
 * the neighbors on both the sides of a cell are either active or inactive, the
 * cell becomes inactive on the next day; otherwise the cell becomes active. The
 * two cells on each end have a single adjacent cell, so assume that the
 * unoccupied space on the opposite side is an inactive cell. Even after
 * updating the cell state, consider its previous state when updating the state
 * of other cells. The state information of all cells should be updated
 * simultaneously.
 * 
 * Write an algorithm to output the state of the cells after the given number of
 * days. Input The input to the function/method consists of two arguments:
 * states, a list of integers representing the current state of cells; days, an
 * integer representing the number of days.
 */
public class HouseCells {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        List<Integer> result = Arrays.stream(states).boxed().collect(Collectors.toList());

        // WRITE YOUR CODE HERE
        for (int day = 0; day < days; day++) {
            ArrayList<Integer> previous = new ArrayList<>(result);
            result = new ArrayList<>(states.length);

            for (int i = 0; i < previous.size(); i++) {
                boolean n1 = i == 0 ? false : previous.get(i - 1).equals(1);
                boolean n2 = i == previous.size() - 1 ? false : previous.get(i + 1).equals(1);
                boolean value = n1 ^ n2;
                result.add(value ? Integer.valueOf(1) : Integer.valueOf(0));
            }
        }

        return result;
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        HouseCells s = new HouseCells();
        int[] cells = { 1, 0, 0, 0, 0, 1, 0, 0 };
        List<Integer> result = s.cellCompete(cells, 1);
        result.stream().map(i -> i + " ").forEach(System.out::print);
    }
}