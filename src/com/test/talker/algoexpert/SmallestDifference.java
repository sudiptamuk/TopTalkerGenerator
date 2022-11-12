package com.test.talker.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestDifference {

    public static void main(String[] args) {

        //int[] arrayOne = {10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123};
        //int[] arrayTwo = {-1441, -124, -25, 1014, 1500, 660, 410, 245, 530};

        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        int[] outputArray = smallestDifference(arrayOne, arrayTwo);

        System.out.println("Output");
        System.out.println(Arrays.toString(outputArray));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        //[-1, 5, 10, 20, 28, 3]
        //[26, 134, 135, 15, 17]

        //[-1, 3, 5, 10, 20, 28]
        //[15, 17, 26, 134, 135]

        int[] outputArray = new int[2];
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        System.out.println("arrayOne[0]:" + arrayOne[0]);
        System.out.println("arrayTwo[0]:" + arrayTwo[0]);

        int lowestDiff = Math.abs(arrayOne[0] - arrayTwo[0]);
        System.out.println("First lowestDiff:" + lowestDiff);

        for(int i = 0; i< arrayTwo.length; i++) {
            int lastDiff = 0;
            for(int j = 0; j< arrayOne.length; j++) {
                int arrOneItem = arrayOne[j];
                int arrTwoItem = arrayTwo[i];
                System.out.println("arrOneItem:" + arrOneItem + ";arrTwoItem:" + arrTwoItem);
                int tempDiff = Math.abs(arrOneItem - arrTwoItem);
                if(tempDiff <= lastDiff) {
                    lowestDiff = tempDiff;
                    outputArray[0] = arrOneItem;
                    outputArray[1] = arrTwoItem;
                    System.out.println("lowestDiff:" + lowestDiff + ";tempDiff:" + tempDiff);
                    lastDiff = tempDiff;
                }else{
                    break;
                }
            }
        }



        return outputArray;
    }
}
