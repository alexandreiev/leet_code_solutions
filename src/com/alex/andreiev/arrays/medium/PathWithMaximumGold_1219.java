package com.alex.andreiev.arrays.medium;

/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing
the amount of gold in that cell, 0 if it is empty.
Return the maximum amount of gold you can collect under the conditions:
    Every time you are located in a cell you will collect all the gold in that cell.
    From your position, you can walk one step to the left, right, up, or down.
    You can't visit the same cell more than once.
    Never visit a cell with 0 gold.
    You can start and stop collecting gold from any position in the grid that has some gold.

Example 1:
Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.

Example 2:
Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.

Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 15
    0 <= grid[i][j] <= 100
    There are at most 25 cells containing gold.

Hint 1
Use recursion to try all such paths and find the one with the maximum value.
 */

public class PathWithMaximumGold_1219 {
    private final int[] DIRECTIONS = new int[] {0, 1, 0, -1, 0};

    public int getMaximumGold(int[][] grid) {
        var m = grid.length;
        var n = grid[0].length;

        var maxGold = 0;
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                maxGold = Math.max(maxGold, dfs(i, j, grid));
            }
        }
        return maxGold;
    }

    int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int maxGold = 0;
        var origVal = grid[row][col];
        grid[row][col] = 0;

        for (var dir = 0; dir < 4; dir++) {
            maxGold = Math.max(maxGold, dfs(row + DIRECTIONS[dir], col + DIRECTIONS[dir+1], grid));
        }

        grid[row][col] = origVal;
        return maxGold + origVal;
    }
}
