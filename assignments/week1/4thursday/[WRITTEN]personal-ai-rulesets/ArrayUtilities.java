package com.revature.ai;

public class ArrayUtilities {

    /* Undisciplined Approach
    public static int[] removeDuplicates(int[] arr) {
        return java.util.Arrays.stream(arr).distinct().toArray();
    } */

    /**
     * Removes duplicate values from an array without using external collection classes.
     * Demonstrates manual array copying for resizing.
     */
    public static int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int[] temp = new int[arr.length];
        int uniqueCount = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }

        // Resizing using standard array replication:
        int[] result = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i]; // Copy only unique values
        }
        return result;
    }

    public static void main(String[] args) {
        int[] scores = {10, 20, 20, 30, 10};
        int[] uniqueScores = removeDuplicates(scores);
        System.out.println("Cleaned array: " + java.util.Arrays.toString(uniqueScores)); // [10, 20, 30]
    }
}