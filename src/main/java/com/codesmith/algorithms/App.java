package com.codesmith.algorithms;

public class App {
    public static void main(String[] args) {
        int val = 0;
        if(args.length > 0) {
            val=Integer.parseInt(args[0]);
        }

        System.out.println("Fibonacci result for " + val + " is:");
        System.out.println(Fibonacci.getResult(val));

        System.out.println("Fibonacci series up to " + val + " is:");
        System.out.println(Fibonacci.getSeries(val));
    }
}
