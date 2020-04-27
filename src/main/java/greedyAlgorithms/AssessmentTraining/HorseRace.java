package greedyAlgorithms.AssessmentTraining;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class HorseRace {
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
        HorseRace s = new HorseRace();
        int[] cells = { 1, 0, 0, 0, 0, 1, 0, 0 };
        List<Integer> result = s.cellCompete(cells, 1);
        result.stream().map(i -> i + " ").forEach(System.out::print);
    }
}