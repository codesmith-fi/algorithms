package com.codesmith.algorithms;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTest {
    // Private array for verifying results of Fibonacci calculation
    private static final List<Integer> expectedSeries = 
        Collections.unmodifiableList(
            new ArrayList<Integer>() {
                private static final long serialVersionUID = 42L;                
                {
                    add(0);
                    add(1);
                    add(1);
                    add(2);
                    add(3);
                    add(5);
                    add(8);
                    add(13);
                    add(21);
                    add(34);
                    add(55);                    
                }
            }
        );

    @Test 
    public void testGetSeries() {
        final int iterationCount = 10;
        ArrayList<Integer> f = Fibonacci.getSeries(iterationCount);
        assertNotNull("Result array should exist", f);
        assertFalse("Result array should have atleast one item",
            f.size()==0);
        assertTrue("Result array should have size of 11", 
            f.size()==iterationCount+1);
        for(int i=0; i<expectedSeries.size(); ++i) {
            String resString = String.format(
                "Expected result for iteration %d should be %d", 
                i, expectedSeries.get(i));
            assertEquals(resString, expectedSeries.get(i), f.get(i));
        }
    }

    @Test
    public void testGetResultNonRecursive() {
        for(int i=0; i<expectedSeries.size(); ++i) {
            verifyResult(i, false);
        }
    }

    @Test
    public void testGetResultRecursive() {
        for(int i=0; i<expectedSeries.size(); ++i) {
            verifyResult(i, true);
        }
    }

    private void verifyResult(int n, boolean recursive) {
        // Test case sanity test
        assertTrue("Test is faulty, accessing invalid expectedResult index",
            (n < expectedSeries.size()));

        String resString = String.format(
            "Result for iteration %d should be %d", 
            n, expectedSeries.get(n));
        if(recursive) {
            assertEquals(resString, 
                Fibonacci.getResult(n, true), expectedSeries.get(n));
        } else {
            assertEquals(resString, 
                Fibonacci.getResult(n), expectedSeries.get(n));
        }
    }
}
