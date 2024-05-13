package com.alex.andreiev.arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuccessfulPairsOfSpellsAndPotions_2300Test {

    @Test
    void successfulPairs() {
        var target = new SuccessfulPairsOfSpellsAndPotions_2300();
        assertArrayEquals(new int[]{4, 0, 3}, target.successfulPairs(
            new int[] {5, 1, 3},
            new int[] {1, 2, 3, 4, 5},
            7
        ));

        assertArrayEquals(new int[]{2, 0, 2}, target.successfulPairs(
            new int[] {3, 1, 2},
            new int[] {8, 5, 8},
            16
        ));


        assertArrayEquals(new int[]{28,33,33,33,33,33,33,23,34,33,33,29,32,33,0,33,33,33,33,13,22,33,31,0,33,17,13,33,33,30,27,0,33,33,33,33,33,27,33,0},
            target.successfulPairs(
                new int[] {15,39,38,35,33,25,31,12,40,27,29,16,22,24,7,36,29,34,24,9,11,35,21,3,33,10,9,27,35,17,14,3,35,35,39,23,35,14,31,7},
                new int[] {25,19,30,37,14,30,38,22,38,38,26,33,34,23,40,28,15,29,36,39,39,37,32,38,8,17,39,20,4,39,39,7,30,35,29,23},
            317
        ));

        assertArrayEquals(new int[]{0,21,19,0,0,0,0,39,0,42,0,0,42,16,0,9,0,28,9,33,16,28,37,0,9,39,28,0,30,37,16,21,21,0,39,44,33,31,30,19,33,44,5,14,28,44,39,33,16,44,0,39,33,16,5,39,39,42,14,44,0,0,37,44,34,21,37,0,42,0,9,37,37,37,28,0,39,31,42,0,19,0,34,37,0,33,0,28,44,15},
            target.successfulPairs(
                new int[] {13,22,21,13,11,9,13,35,7,38,10,10,38,19,3,16,13,24,16,27,20,24,32,5,16,35,24,2,25,32,20,22,22,3,35,39,27,26,25,21,27,40,15,17,24,40,35,27,20,40,9,35,27,19,15,34,35,37,17,40,8,3,33,39,29,22,30,1,37,2,16,30,32,31,24,6,34,26,36,4,21,2,29,31,3,27,6,24,40,18},
                new int[] {33,16,35,14,26,23,23,2,37,23,15,20,25,34,23,29,4,18,26,24,16,37,15,11,33,24,12,13,7,24,3,26,1,3,38,33,19,3,34,22,30,39,18,7,21,4,33,18,39,5,34,14,32,5,20,22,5,25,15},
                533
            ));

        assertArrayEquals(new int[]{72,72,71,68,72,71,29,71,72,72,72,68,68,72,59,71,71,68,71,72,68,72,71,59,72,72,71,72,72,72,51,71,0,71,59,72,72,72,68,71,0,72,71,71,71,72,68,71,46,71,71,68,71,71,59,71,29,72,68,46,72,71,68,71,46,68,72,51,59,71,71,68,68,71,0},
            target.successfulPairs(
                new int[] {36,36,22,11,35,21,4,25,30,35,31,10,8,39,7,22,18,9,23,30,9,37,22,7,36,40,17,37,38,27,6,15,1,15,7,31,36,29,9,15,3,37,15,17,25,35,9,21,5,17,25,8,18,25,7,19,4,33,9,5,29,13,9,18,5,10,31,6,7,24,13,11,8,19,2},
                new int[] {30,11,5,20,19,36,39,24,20,37,33,22,32,28,36,24,40,27,36,37,38,23,39,11,40,19,37,32,25,29,28,37,31,36,32,40,38,22,17,38,20,33,29,17,36,33,35,25,28,18,17,19,40,27,40,28,40,40,40,39,17,34,36,11,22,29,22,35,35,22,18,34},
                135
            ));

    }
}