package com.alex.andreiev.arrays.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostProfitAssigningWork_826Test {

    @Test
    void maxProfitAssignment() {
        var target = new MostProfitAssigningWork_826();
        assertEquals(100, target.maxProfitAssignment(new int[] {2,4,6,8,10},
                new int[] {10,20,30,40,50}, new int[] {4,5,6,7}));

        assertEquals(0, target.maxProfitAssignment(new int[] {85,47,57},
                new int[] {24,66,99}, new int[] {40,25,25}));

        assertEquals(190, target.maxProfitAssignment(new int[] {13,37,58},
                new int[] {4,90,96}, new int[] {34,73,45}));
    }
}