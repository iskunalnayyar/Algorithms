import java.util.Scanner;


/**
 * Write a program that should output YES if given plants can be put in given set of bigger planters
 *
 * FindMaxPairs.java
 *
 * Version:
 * 1.3
 * 14/07/2018
 *
 * @author - Kunal Nayyar

 */


public class Planters {
    static String check(int[] iniArray) {
        int pointerToEmpty = 0;
        for (int i = 0; i < iniArray.length; i++) {

            if (i == 0) {
                if (iniArray[0] == 1) {
                    return "NO";
                } else if (iniArray[i] < iniArray[i + 1]) {
                    swap(iniArray, iniArray, i, i + 1);
                    pointerToEmpty = i + 1;
                }
            }
            if (i < iniArray.length - 1) {
                if (iniArray[i] < iniArray[i + 1]) {
                    swap(iniArray, iniArray, i + 1, pointerToEmpty);
                    pointerToEmpty = i;
                }
            }
            if (i == iniArray.length - 1) {
                return "YES";
            }

        }
        return "YES";
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

    private static void swap(int anArray[], int anotherArray[], int p, int e) {

        int temp = anArray[p];
        anArray[p] = anotherArray[e];
        anotherArray[e] = temp;

    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }

    private static int[] initializaion(int arr1[], int arr2[]) {
        // 1 is plant, 2 is empty planters
        int iniArray[] = new int[arr1.length + arr2.length];
        int j = 0;
        if (arr1.length >= arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (i < arr2.length) {
                    if (arr1[i] < arr2[i]) {
                        iniArray[j] = 0;
                        iniArray[j + 1] = 1;
                        j = j + 2;
                    } else if ((i != arr2.length - 1) & arr1[i] >= arr2[i]) {
                        iniArray[j] = 1;
                        iniArray[j + 1] = 0;
                        j = j + 2;
                    } else {
                        iniArray[j] = 1;
                        j = j + 1;
                    }

                } else {
                    iniArray[j] = 1;
                    j = j + 1;

                }
            }

        }
        // for empty planters > plants
        else {
            for (int i = 0; i < arr2.length; i++) {
                if (i < arr1.length) {
                    if (arr1[i] < arr2[i]) {
                        iniArray[j] = 0;
                        iniArray[j + 1] = 1;
                        j = j + 2;
                    } else if (arr1[i] >= arr2[i]) {
                        iniArray[j] = 1;
                        iniArray[j + 1] = 0;
                        j = j + 2;
                    } else {
                        iniArray[j] = 0;
                        j = j + 1;

                    }
                } else {
                    iniArray[j] = 0;
                    j = j + 1;

                }
            }
        }

        return iniArray;
    }


    //  Driver method
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int p, r;
        int input;
        p = sc.nextInt();
        r = sc.nextInt();
        

        int pArray[] = new int[p];
        for (int i = 0; i < p; i++) {
            input = sc.nextInt();
            pArray[i] = input;
        }
//
        int[] rArray = new int[r];
        for (int i = 0; i < r; i++) {
            input = sc.nextInt();
            rArray[i] = input;
        }
        sc.close();

        String answer;
        mergeSort(pArray, 0, pArray.length - 1);
        mergeSort(rArray, 0, rArray.length - 1);
        //print(rArray);
        int[] iniArray;

        iniArray = initializaion(pArray, rArray);
        //print(iniArray);
        answer = check(iniArray);

        System.out.println(answer);
        //print(iniArray);

    }
}
