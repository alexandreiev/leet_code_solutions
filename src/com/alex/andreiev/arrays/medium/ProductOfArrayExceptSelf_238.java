package com.alex.andreiev.arrays.medium;

/*
Given an integer array nums, return an array answer such that answer[i] is
equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

Hint 1
Think how you can efficiently utilize prefix and suffix products
to calculate the product of all elements except self for each index.
Can you pre-compute the prefix and suffix products in linear time to avoid redundant calculations?

Hint 2
Can you minimize additional space usage by reusing memory or modifying the input array to store intermediate results?

 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;

        // calculate prefix product
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            // multiply a prefix product to suffix product
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
