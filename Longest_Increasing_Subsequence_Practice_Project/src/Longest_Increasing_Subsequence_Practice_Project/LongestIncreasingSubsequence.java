package Longest_Increasing_Subsequence_Practice_Project;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int findLISLength(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] lisLengths = new int[n];
        Arrays.fill(lisLengths, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lisLengths[i] < lisLengths[j] + 1) {
                    lisLengths[i] = lisLengths[j] + 1;
                }
            }
        }

        int maxLIS = Arrays.stream(lisLengths).max().orElse(0);
        return maxLIS;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int lisLength = findLISLength(nums);

        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);
    }
}

