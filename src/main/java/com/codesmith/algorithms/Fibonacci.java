package com.codesmith.algorithms;

import java.util.ArrayList;

/**
 * Algorithms for calculating the Fibonacci series
 *  fibo(n) = fibo(n-2) + fibo(n-1)
 *      where 
 *          fibo(0) results 0 
 *          fibo(1) results 1
 */
public class Fibonacci {
    /**
     * Get the Fibonacci series as an array
     * @param n number of iterations to calculate
     * @return Array containing the result Fibonacci series
     */
    public static ArrayList<Integer> getSeries(int n) {
        return seriesIterative(n);
    }

    /**
     * Get Fibonacci result for n'th iteration
     * @param n number of iterations to calculate
     * @return Fibonacci result for the n'th iteration
     */
    public static Integer getResult(int n) {
        return resultIterative(n);
    }

    /**
     * Get Fibonacci result for n'th iteration
     * @param n number of iterations to calculate
     * @param recursive if true uses the recursive algorithm
     * @return Fibonacci result for the n'th iteration
     */
    public static Integer getResult(int n, boolean recursive) {
        return recursive ? resultRecursive(n) : getResult(n);
    }

    /**
     * Get Fibonacci series as an array
     * @param n number of iterations to calculate
     * @return Fibonacci result for the n'th iteration
     */
    private static ArrayList<Integer> seriesIterative(int n) {
        ArrayList<Integer> seriesArray = new ArrayList<Integer>();
        // f(0) and f(1)
        seriesArray.add(0);
        if(n>0) {
            seriesArray.add(1);
        }

        // Calculate rest of the series
        for(int i=2; i<=n; ++i) {
            seriesArray.add(seriesArray.get(i-2) + seriesArray.get(i-1));
        }
        return seriesArray;
    }

    /**
     * Recursive implementation of Fibonacci function
     * @param n number of iterations to calculate
     * @return the result for n'th iteration of fibonacci
     */
    private static Integer resultRecursive(int n) {
        return (n <= 1) ? 
            n : resultRecursive(n-1) + resultRecursive(n-2);
    }

    /**
     * Iterative implementation of Fibonacci 
     * Uses temp variable for calculating the result
     * @param n number of iterations to calculate
     * @return the result for n'th iteration of fibonacci
     */
    private static Integer resultIterative(int n) {
        int res=0, a=0, b=1; // Previous values for f(n-2) and f(n-1)
        for(int i=0; i<n; ++i) {
            res = b;
            b = a + b;
            a = res;
        }
        return res;
    }
}