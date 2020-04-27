package greedyAlgorithms.AssessmentTraining;

import java.util.Arrays;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Mdc {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr) {
        // int prod = Arrays.asList(arr).stream().reduce(1, (a, b)-> a * b);

        // int prod = getProd(arr);
        // int greatest = Integer.MAX_VALUE;
        // for (int i = 0; i < arr.length; i++) {
        // int mdc = mdc(prod, arr[i]);
        // if (mdc < greatest) {
        // greatest = mdc;
        // }
        // }

        // return greatest;
        int prod = getProd(arr);
        // return Arrays.stream(arr).reduce(prod, (a, b) -> mdc(a, b));
        return Arrays.stream(arr).map(i -> mdc(prod,i)).min().orElse(0);

    }

    public int mdc(int dividendo, int divisor) {
        return (0 == divisor) ? dividendo : mdc(divisor, dividendo % divisor);
        // if ((dividendo % divisor == 0)) {
        // return divisor;
        // } else {
        // return mdc(divisor, (dividendo % divisor));
        // }
    }

    int getProd(int[] arr) {
        return Arrays.stream(arr).reduce(1, (a, b) -> (a * b));
    }

    public static void main(String[] args) {
        Mdc mdc = new Mdc();
        int[] ints = { 2, 3, 4, 5, 6 };
        System.out.println(mdc.generalizedGCD(ints.length, ints));
    }
}