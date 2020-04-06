package greedyAlgorithms.BalancedBrackets;

import java.util.Scanner;

import org.junit.Test;

public class BalancedBracketsTest {

    @Test
    public void testBalancedBrackets() {
        System.setIn(BalancedBracketsTest.class.getResourceAsStream("./input1000.txt"));
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        BalancedBrackets bb = new BalancedBrackets();
        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = bb.isBalanced(s);
            // System.out.println(s + " is balanced ? " + result );
            System.out.println(result);
        }

        scanner.close();
    }
}