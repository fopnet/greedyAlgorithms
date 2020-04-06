package greedyAlgorithms.FindRunningMedian;

import java.util.Scanner;

import org.junit.Test;

public class FindRunningMedianTest {

    @Test
    public void testFindRunningMedian() {
        System.setIn(FindRunningMedianTest.class.getResourceAsStream("./input.txt"));
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        FindRunningMedian median = new FindRunningMedian();
        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            double result = median.getMedian(Integer.parseInt(s));
            // System.out.println(s + " is balanced ? " + result );
            System.out.printf("%.1f\n", result);
        }

        scanner.close();
    }
}