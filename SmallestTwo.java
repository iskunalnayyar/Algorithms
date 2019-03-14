/**
 * Write a program that should output the smallest value among the a values. The second line should output the second-smallest value.
 *
 * SmallestTwo.java
 *
 * Version:
 * 1.2
 * 09/07/2018
 *
 * @author - Kunal Nayyar

 */

import java.util.Scanner;

public class SmallestTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int input = 0;
        int i;
        n = sc.nextInt();
        int[] intArray = new int[n];
        for (i = 0; i < n; i++) {
            input = sc.nextInt();
            intArray[i] = input;

        }
        sc.close();
        sort(intArray);
        printSmallestTwo(intArray);

    }

    private static void printSmallestTwo(int[] anArray) {

        System.out.println(anArray[0]);
        System.out.println(anArray[1]);
    }

    private static void sort(int[] anArray) {

        int n = anArray.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (anArray[j] > anArray[j + 1]) {
                    // swap temp and arr[i]
                    int temp = anArray[j];
                    anArray[j] = anArray[j + 1];
                    anArray[j + 1] = temp;
                }
    }


}
