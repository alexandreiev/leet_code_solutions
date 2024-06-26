package com.alex.andreiev.arrays.hard;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:
    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105
 */

public class TrappingRainWater_42 {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int storedWater = 0;

        // Fill left and right arrays
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        var rightIndex = 0;

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
            rightIndex = n-i-1;
            right[rightIndex] = Math.max(right[rightIndex + 1], height[rightIndex]);
        }

        // Calculate trapped water
        for (int i = 1; i < n-1; i++) {
            int minHeight = Math.min(left[i], right[i]);
            storedWater += minHeight - height[i];
        }

        return storedWater;
    }
}
