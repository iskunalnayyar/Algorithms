import java.util.Scanner;

/**
 * Write a program that converts string u to v, with minimum steps possible.
 *
 * SmallestTwo.java
 *
 * Version:
 * 1.5
 * 09/07/2018
 *
 * @author - Kunal Nayyar

 */

import static java.lang.Math.abs;

public class StringPuzzle {
    private int[] charConversion1(String str1, String str2) {
        int[] diffArray = new int[str1.length()];
        for (int i = 0; i < str1.length(); i++) {
            diffArray[i] = str1.charAt(i) - str2.charAt(i);
        }

        return diffArray;
    }


    // count for depth help, countSimilar counts similar, anothercount for last similar item.
    private int distance1(int[] array, int[] iniArray, int answer) {
        int minVal;
        int indexMin;
        int finalans = answer;
        int[] minArray;
        int similar = 0;
        int counter;
        int x;

        for (int i = 0; i < iniArray.length; i++) {
            x = iniArray[i];
            if (x != 0) {
                counter = i;
                if (i != iniArray.length - 1) {

                    while ((iniArray[counter + 1] == x)) {
                        if (counter < iniArray.length - 2) {
                            counter++;
                            similar++;
                        } else if (counter == iniArray.length - 2) {
                            similar++;
                            counter++;
                            break;
                        }
                    }

                    if (similar != 0) {
                        minArray = getMinValue1(array, i, counter);
                        indexMin = minArray[1];
                        minVal = minArray[0];
                        array = subtract1(array, minVal, similar, i);
                        iniArray = update1(array, iniArray, indexMin, similar, i);
                        finalans = finalans + abs(minVal);
                        i = counter - similar - 1;
                        similar = 0;
                        //counter = i;
                    }
                }
            }
        }

        return finalans;
    }

    private static int[] update1(int[] valArray, int[] array, int indexMin, int countSimilar, int anotherSimilar) {
        //array[indexMin] = 0;

        for (int i = anotherSimilar; i <= countSimilar + anotherSimilar; i++) {
            if (valArray[i] == 0) {
                array[i] = 0;
            }
        }
        return array;
    }


    private static void print1(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }

    private static int[] subtract1(int[] array, int minVal, int countSimilar, int anothercountSimilar) {
        for (int i = anothercountSimilar; i <= countSimilar + anothercountSimilar; i++) {
            array[i] = array[i] - minVal;
        }
        return array;
    }

    private static int[] getMinValue1(int[] numbers, int count, int anothercount) {
        int minValue = numbers[count];
        int index = 0;
        int[] anArray = new int[2];
        if (minValue > 0) {
            for (int i = count; i < anothercount + 1; i++) {
                if (numbers[i] < minValue) {
                    minValue = numbers[i];
                    index = i;
                }
            }
            anArray[0] = minValue;
            anArray[1] = index;
        } else {
            for (int i = count; i < anothercount + 1; i++) {
                if (abs(numbers[i]) < abs(minValue)) {
                    minValue = numbers[i];
                    index = i;
                }
            }
            anArray[0] = minValue;
            anArray[1] = index;
        }
        return anArray;
    }

    private int[] initialization1(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i <= array.length - 1; i++) {
            // not neg and not followed by 0 or neg
            if (i != array.length - 1) {
                if (array[i] > 0) {
                    newArray[i] = 1;
                }
                // neg and not followed by 0 or pos
                else if (array[i] < 0) {
                    newArray[i] = -1;
                } else {
                    newArray[i] = 0;
                }
            } else if (i == array.length - 1) {
                if (array[i] < 0)
                    newArray[i] = -1;
                else if (array[i] > 0)
                    newArray[i] = 1;
                else newArray[i] = 0;

            }

        }
        return newArray;
    }

    public static void main(String args[]) {
        String str1; //= "cbcabcbbbaacbacccacbccaaccbacbbcabbccbaaaaabcacccaabaacccacabccaccababbacbcccaaabacbcbcaaabcaabcacab";
        String str2; //= "cbbaccaccaaabccaabbaaacbbcababcabcbaacaccbccbabbaccaacacbaaaaacbbbbbcacaccabbcccccaaccbaababcccbbacb";
        Scanner sc = new Scanner(System.in);


        str1 = sc.next();


        str2 = sc.next();

        sc.close();


        int answer = 0;

        StringPuzzle editDistance2 = new StringPuzzle();
        int[] diffArray = editDistance2.charConversion1(str1, str2);
        int[] iniArray = editDistance2.initialization1(diffArray);

        answer = editDistance2.distance1(diffArray, iniArray, answer);
        //System.out.println(answer);
        int counter = 0;
        int similar = 0;
        for (int i = 0; i <= diffArray.length - 1; i++) {
            if (diffArray[i] != 0) {
                answer = answer + abs(diffArray[i]);
            }

        }
            //print(iniArray);
            System.out.println(answer);



    }
}

