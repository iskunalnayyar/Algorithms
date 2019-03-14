

/**
 * Write a program that takes in input an integer number n and prints out all the prime numbers that are smaller than n
 *
 * Primes.java
 *
 * Version:
 * 1.1
 * 09/07/2018
 *
 * @author - Kunal Nayyar

 */


import java.util.Scanner;

public class Primes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        // j is 2 since we don't have to check with 0 or 1 as they're composite and not prime numbers
        for (int j = 2; j<= n; j++) {
            isPrime(j);
        }
    }

    private static void isPrime(int n) {
        /**
         * Checks if number is prime or not,
         * using divisors from 1 till "square-root" of that number,
         * as that covers all distinct divisors possible for any number.
         *
         * @param n integer number to be checked
         */

        int count = 0;
        double endI = Math.sqrt(n);                    //square-root of n
        int newEndI = (int) Math.round(endI);        //check divisors from 2 to sqrt(n)
        for (int i = 1; i <= newEndI; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 1) {
            System.out.println(n); // returns if the condition is true
        }
    }
}
