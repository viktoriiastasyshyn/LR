package org.example;

import java.util.Scanner;

class FibonacciNumber {
    private int index;
    private long value;

    public FibonacciNumber(int index, long value){
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public long getValue() {
        return value;
    }

    public void printInfo() {
       System.out.println("Fibonacci("+ index +") = "+ value);
    }
}

public class Main {
    public static long Fibonacci(int n){
        if(n <= 2) return 1;
        long a = 1, b = 1, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static long sumFibonacci(int n){
        return Fibonacci(n + 2) - 1;
    }

    public static void main(String[] args) {
        int n;

        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть кількість чисел Фібоначчі N: ");
            n = scanner.nextInt();
            scanner.close();
        }

        if (n <= 0){
            System.out.println("N має бути додатнім.");
            return;
        }

        FibonacciNumber[] numbers = new
                FibonacciNumber[n];
        System.out.println("Числа Фібоначчі: ");
        for (int i = 1; i <= n; i++){
            long value = Fibonacci(i);
            numbers[i-1] = new FibonacciNumber(i, value);
            numbers[i-1].printInfo();
        }

        long sum = sumFibonacci(n);
        System.out.println("Сума перших " + n +" чисел Фібоначчі = " + sum);
    }
}


