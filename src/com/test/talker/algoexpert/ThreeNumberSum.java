package com.test.talker.algoexpert;

import java.util.*;

public class ThreeNumberSum {

    public static void main(String[] args) {

        int[] inputArray = {12, 3, 1, 2, -6, 5, -8, 6};

        List<Integer[]> outputArray = threeNumberSum(inputArray, 0);

        System.out.println("Output");
        outputArray.forEach(a -> {
            System.out.println(Arrays.toString(a));
        });
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        // [12, 3, 1, 2, -6, 5, -8, 6]
        // targetgetsum = 0
        // [-8, -6, 1, 2, 3, 5, 6, 12]
        // [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]

        List<Integer[]> outputList = new ArrayList<>();

        Arrays.sort(array);
        int len = array.length;
        if(array.length > 2) {
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        int firstElement = array[i];
                        int secondElement = array[j];
                        int sum = firstElement + secondElement;
                        int nextElement = array[k];
                        if (nextElement == (targetSum - sum)) {
                            Integer[] anItem = {firstElement, secondElement, nextElement};
                            outputList.add(anItem);
                            System.out.println(Arrays.toString(anItem));
                        } else if (nextElement > (targetSum - sum)) {
                            break;
                        }
                    }
                }
            }
        }


        return outputList;
    }
}
