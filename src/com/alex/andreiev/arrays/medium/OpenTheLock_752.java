package com.alex.andreiev.arrays.medium;

/*
You have a lock in front of you with 4 circular wheels.
Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
Each move consists of turning one wheel one slot.
The lock initially starts at '0000', a string representing the state of the 4 wheels.
You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
the wheels of the lock will stop turning and you will be unable to open it.
Given a target representing the value of the wheels that will unlock the lock,
return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".

Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".

Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation: We cannot reach the target without getting stuck.

Constraints:
    1 <= deadends.length <= 500
    deadends[i].length == 4
    target.length == 4
    target will not be in the list deadends.
    target and deadends[i] consist of digits only.

Hint 1
We can think of this problem as a shortest path problem on a graph:
there are `10000` nodes (strings `'0000'` to `'9999'`), and
 there is an edge between two nodes if they differ in one digit,
 that digit differs by 1 (wrapping around, so `'0'` and `'9'` differ by 1),
 and if *both* nodes are not in `deadends`.
 */

import java.util.*;

public class OpenTheLock_752 {
    public int openLock(String[] deadends, String target) {
        // Map the next slot digit for each current slot digit.
        var nextSlot = Map.of(
            '0', '1',
            '1', '2',
            '2', '3',
            '3', '4',
            '4', '5',
            '5', '6',
            '6', '7',
            '7', '8',
            '8', '9',
            '9', '0'
        );
        // Map the previous slot digit for each current slot digit.
        var prevSlot = Map.of(
            '0', '9',
            '1', '0',
            '2', '1',
            '3', '2',
            '4', '3',
            '5', '4',
            '6', '5',
            '7', '6',
            '8', '7',
            '9', '8'
        );

        // Set to store visited and dead-end combinations.
        var visitedCombinations = new HashSet<>(Arrays.asList(deadends));
        // Queue to store combinations generated after each turn.
        var pendingCombinations = new LinkedList<String>();

        // Count the number of wheel turns made.
        var turns = 0;

        // If the starting combination is also a dead-end,
        // then we can't move from the starting combination.
        if (visitedCombinations.contains("0000")) {
            return -1;
        }

        // Start with the initial combination '0000'.
        pendingCombinations.add("0000");
        visitedCombinations.add("0000");

        while (!pendingCombinations.isEmpty()) {
            // Explore all the combinations of the current level.
            var currLevelNodesCount = pendingCombinations.size();
            for (int i = 0; i < currLevelNodesCount; i++) {
                // Get the current combination from the front of the queue.
                var currentCombination = pendingCombinations.poll();

                // If the current combination matches the target,
                // return the number of turns/level.
                if (currentCombination.equals(target)) {
                    return turns;
                }

                // Explore all possible new combinations by turning each wheel in both directions.
                for (int wheel = 0; wheel < 4; wheel += 1) {
                    // Generate the new combination by turning the wheel to the next digit.
                    var newCombination = currentCombination.toCharArray();
                    newCombination[wheel] = nextSlot.get(newCombination[wheel]);
                    // If the new combination is not a dead-end and was never visited,
                    // add it to the queue and mark it as visited.
                    var str = new String(newCombination);
                    if (!visitedCombinations.contains(str)) {
                        pendingCombinations.add(str);
                        visitedCombinations.add(str);
                    }

                    // Generate the new combination by turning the wheel to the previous digit.
                    newCombination = currentCombination.toCharArray();
                    newCombination[wheel] = prevSlot.get(newCombination[wheel]);
                    // If the new combination is not a dead-end and is never visited,
                    // add it to the queue and mark it as visited.
                    str = new String(newCombination);
                    if (!visitedCombinations.contains(str)) {
                        pendingCombinations.add(str);
                        visitedCombinations.add(str);
                    }
                }
            }
            // We will visit next-level combinations.
            turns += 1;
        }
        // We never reached the target combination.
        return -1;
    }
}
