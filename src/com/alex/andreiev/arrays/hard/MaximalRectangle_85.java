package com.alex.andreiev.arrays.hard;

/*
Given a rows x cols binary matrix filled with 0's and 1's,
find the largest rectangle containing only 1's and return its area.

Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = [["0"]]
Output: 0

Example 3:
Input: matrix = [["1"]]
Output: 1

Constraints:

    rows == matrix.length
    cols == matrix[i].length
    1 <= row, cols <= 200
    matrix[i][j] is '0' or '1'.
 */

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle_85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        var cols = matrix[0].length;
        var heights = new int[cols + 1]; // Include an extra element for easier calculation
        var maxArea = 0;

        for (var row : matrix) {
            for (var i = 0; i < cols; i++) {
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            }

            // Calculate max area using stack-based method
            var stack = new Stack<Integer>();
            for (var i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    var h = heights[stack.pop()];
                    var w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
        }

        return maxArea;
    }

    // speedy
//    public int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return 0;
//        }
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int[] heights = new int[n];
//        int[] leftBoundaries = new int[n];
//        int[] rightBoundaries = new int[n];
//        Arrays.fill(rightBoundaries, n);
//
//        int maxRectangle = 0;
//
//        for (int i = 0; i < m; i++) {
//            int left = 0;
//            int right = n;
//
//            updateHeightsAndLeftBoundaries(matrix[i], heights, leftBoundaries, left);
//
//            updateRightBoundaries(matrix[i], rightBoundaries, right);
//
//            maxRectangle = calculateMaxRectangle(heights, leftBoundaries, rightBoundaries, maxRectangle);
//        }
//
//        return maxRectangle;
//    }
//
//    private void updateHeightsAndLeftBoundaries(char[] row, int[] heights, int[] leftBoundaries, int left) {
//        for (int j = 0; j < heights.length; j++) {
//            if (row[j] == '1') {
//                heights[j]++;
//                leftBoundaries[j] = Math.max(leftBoundaries[j], left);
//            } else {
//                heights[j] = 0;
//                leftBoundaries[j] = 0;
//                left = j + 1;
//            }
//        }
//    }
//
//    private void updateRightBoundaries(char[] row, int[] rightBoundaries, int right) {
//        for (int j = rightBoundaries.length - 1; j >= 0; j--) {
//            if (row[j] == '1') {
//                rightBoundaries[j] = Math.min(rightBoundaries[j], right);
//            } else {
//                rightBoundaries[j] = right;
//                right = j;
//            }
//        }
//    }
//
//    private int calculateMaxRectangle(int[] heights, int[] leftBoundaries, int[] rightBoundaries, int maxRectangle) {
//        for (int j = 0; j < heights.length; j++) {
//            int width = rightBoundaries[j] - leftBoundaries[j];
//            int area = heights[j] * width;
//            maxRectangle = Math.max(maxRectangle, area);
//        }
//        return maxRectangle;
//    }
}
