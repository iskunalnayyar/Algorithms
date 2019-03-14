


import java.util.Scanner;


import static java.lang.Math.abs;




/**
 * Write a program that should output the most occured sum of pairs of a given input
 *
 * FindMaxPairs.java
 *
 * Version:
 * 1.4
 * 14/07/2018
 *
 * @author - Kunal Nayyar

 */

public class FindMaxPairs {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int input;
        int input_arr_len = sc.nextInt();

        int[] input_array = new int[input_arr_len]; //= {-2,3,5,7,1,0};

        for (int i = 0; i < input_arr_len; i++) {
            input = sc.nextInt();
            input_array[i] = input;
        }
        sc.close();


        mergeSort(input_array, 0, input_arr_len - 1);

        int i, j;
        long max_sum_possible, min_sum_possible;


        // finding maximum possible sum
        max_sum_possible = input_array[0] + input_array[1];
        min_sum_possible = input_array[input_arr_len - 1] + input_array[input_arr_len - 2];

        int count_array_Size = 0;

        //for both positive max and min sums
        if ((max_sum_possible > 0 && min_sum_possible >= 0)) {
            count_array_Size = (int) (abs(max_sum_possible) - abs(min_sum_possible));
        }
        //for both neg
        else if (max_sum_possible < 0 && min_sum_possible < 0) {
            count_array_Size = (int) (abs(min_sum_possible) - abs(max_sum_possible));
        }
        // for either neg and one positive
        else if ((max_sum_possible > 0 && min_sum_possible < 0) || (max_sum_possible < 0 && min_sum_possible > 0)) {
            count_array_Size = (int) (abs(max_sum_possible) + abs(min_sum_possible));
        }

        long offset = min_sum_possible;

        long[] count_array = new long[count_array_Size + 1];

        long sum_for_now;

        for (i = 0; i <= input_arr_len - 2; i++) {

            for (j = i + 1; j <= input_arr_len - 1; j++) {

                sum_for_now = (input_array[i] + input_array[j]);


                count_array[(int) (sum_for_now - offset)] = count_array[(int) (sum_for_now - offset)] + 1;

            }
        }

        long maxcountindex = 0, maxcount = 0;

        for (int index = 0; index < count_array.length - 1; index++)
            if (count_array[index] > maxcount) {
                maxcount = count_array[index];
                maxcountindex = index;
            }


        //System.out.println("Sum with max pair count");
        System.out.println((int) (maxcountindex + (offset)));


    }


    private static void merge(int arr[], int l, int m, int r) {
        /**
         * Merge sort
         */
        int i, j, k;
        int diff1 = m - l + 1;
        int diff2 = r - m;

        int Larray[] = new int[diff1];
        int Rarray[] = new int[diff2];

        for (i = 0; i < diff1; i++)
            Larray[i] = arr[l + i];
        for (j = 0; j < diff2; j++)
            Rarray[j] = arr[m + 1 + j];

        i = 0;
        j = 0;
        k = l;
        while (i < diff1 && j < diff2) {
            if (Larray[i] > Rarray[j]) {
                arr[k] = Larray[i];
                i++;
            } else {
                arr[k] = Rarray[j];
                j++;
            }
            k++;
        }

        while (i < diff1) {
            arr[k] = Larray[i];
            i++;
            k++;
        }
        while (j < diff2) {
            arr[k] = Rarray[j];
            j++;
            k++;
        }
    }


    private static void mergeSort(int arr[], int left, int right) {
        /**
         * mergeSort
         */
        if (left < right) {

            int m = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);

            merge(arr, left, m, right);
        }
    }


}
