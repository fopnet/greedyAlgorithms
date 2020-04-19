package greedyAlgorithms.FindRunningMedian;

import java.util.List;
import java.util.stream.IntStream;


/**
 * FindRunningMedian
 */
public class FindRunningMedian {

    List<Integer> numbers = null;

    FindRunningMedian() {
        this.numbers = new SortedList<Integer>();
    }

     /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        FindRunningMedian fm = new FindRunningMedian();
        
        return IntStream.of(a).mapToDouble(i-> fm.getMedian(i)).toArray();
    }

    Double getMedian(int n) {
        this.numbers.add(n);

        int mediumIdx = this.numbers.size() / 2;
        if (this.numbers.size() % 2 == 0) { // even
            return (double) (this.numbers.get(mediumIdx - 1) + this.numbers.get(mediumIdx)) / 2;
        } else { // odd
            return (double)(this.numbers.get(mediumIdx));
        }
    }

    public double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}