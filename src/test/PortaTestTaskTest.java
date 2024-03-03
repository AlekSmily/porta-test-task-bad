import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PortaTestTaskTest {
    /*
    !!! To check thees cases need to change static field sortedNumbersList to public !!!
     */
    @BeforeEach
    void setSortedNumbersListToNull() {
        PortaTestTask.sortedNumbersList = null;
    }

    @Test
    void findMaxNumberTest() {
        List<Long> arrList = Arrays.asList(-5L, -4L, 3L, 4L, 5L);
        long expected = 5L;
        assertEquals(expected, PortaTestTask.findMaxNumber(arrList));
    }

    @Test
    void findMinNumberTest() {
        List<Long> arrList = Arrays.asList(-5L, -4L, 3L, 4L, 5L);
        long expected = -5L;
        assertEquals(expected, PortaTestTask.findMinNumber(arrList));
    }

    @Test
    void findMedianTest() {
        // Test case 1: Single element
        List<Long> testArrList1 = Collections.singletonList(5L);
        double expected1 = 5.0;
        assertEquals(expected1, PortaTestTask.findMedian(testArrList1));

        // Test case 2: Array has an odd number of elements
        List<Long> testArrList2 = Arrays.asList(3L, 6L, 2L, 18L, -5L, 0L, -8L, 9L, 14L, -34L, 45L);
        double expected2 = 3.0;
        assertEquals(expected2, PortaTestTask.findMedian(testArrList2));
    }

    @Test
    void findMedianTest3() {
        // Test case 3: Array has an even number of elements
        List<Long> testArrList3 = Arrays.asList(3L, 6L, 2L, 18L, -5L, 0L, -8L, 9L, 14L, -34L, 45L, 55L);
        double expected3 = 4.5;
        assertEquals(expected3, PortaTestTask.findMedian(testArrList3));
    }

    @Test
    void findMedianTest4() {
        // Test case 4: Array has an even number of zero
        List<Long> testArrList4 = Arrays.asList(0L, 0L, 0L, 0L, 0L, 0L, -0L, 0L, 0L, -0L, 0L, 0L);
        double expected4 = 0.0;
        assertEquals(expected4, PortaTestTask.findMedian(testArrList4));
    }

    @Test
    void findMedianTest5() {
        // Test case 5: Array has two elements
        List<Long> testArrList5 = Arrays.asList(25L, -12L);
        double expected5 = 6.5;
        assertEquals(expected5, PortaTestTask.findMedian(testArrList5));
    }

    @Test
    void maxIncreasingSequenceTest() {
        // Test case 1
        List<Long> arrList = Arrays.asList(-5L, -4L, -8L, 4L, 5L);
        long expected = 3L;
        assertEquals(expected, PortaTestTask.maxIncreasingSequence(arrList));

        // Test case 2
        List<Long> arrList2 = Arrays.asList(5L, 4L, 4L, -4L, -5L);
        long expected2 = 1L;
        assertEquals(expected2, PortaTestTask.maxIncreasingSequence(arrList2));

        // Test case 3
        List<Long> arrList3 = Arrays.asList(5L, 5L, 5L, 5L, 5L);
        long expected3 = 1L;
        assertEquals(expected3, PortaTestTask.maxIncreasingSequence(arrList3));
    }

    @Test
    void maxDescendingSequence() {
        // Test case 1
        List<Long> arrList = Arrays.asList(-4L, -5L, -8L, 4L, 5L);
        long expected = 3L;
        assertEquals(expected, PortaTestTask.maxDescendingSequence(arrList));

        // Test case 2
        List<Long> arrList2 = Arrays.asList(3L, 4L, 4L, 5L);
        long expected2 = 1L;
        assertEquals(expected2, PortaTestTask.maxDescendingSequence(arrList2));

        // Test case 3
        List<Long> arrList3 = Arrays.asList(5L, 5L, 5L, 5L, 5L);
        long expected3 = 1L;
        assertEquals(expected3, PortaTestTask.maxDescendingSequence(arrList3));

    }

    @Test
    void calculateArithmeticMean() {
        List<Long> testArrList = Arrays.asList(3L, 6L, 2L, 18L, -5L, 0L, -8L, 9L, 14L, -34L, 45L, 55L);
        double expected = 8.75;
        assertEquals(expected, PortaTestTask.calculateArithmeticMean(testArrList));
    }

    @Test
    void calculateArithmeticMean2() {
        List<Long> testArrList2 = Arrays.asList(0L, 0L, 0L, 0L);
        double expected2 = 0.0;
        assertEquals(expected2, PortaTestTask.calculateArithmeticMean(testArrList2));
    }
}