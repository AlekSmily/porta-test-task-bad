import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PortaTestTaskTest {
    // To check thees cases need to change static field sortedNumbersList to public

    @BeforeEach
    void setSortedNumbersListToNull() {
        PortaTestTask.sortedNumbersList = null;
    }

    @Test
    void findMaxNumber() {
        List<Long> arrList = Arrays.asList(-5L, -4L, 3L, 4L, 5L);
        long expected = 5L;
        assertEquals(expected, PortaTestTask.findMaxNumber(arrList));
    }

    @Test
    void findMinNumber() {
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
        // Test case 3: Array has an even number of zero
        List<Long> testArrList4 = Arrays.asList(0L, 0L, 0L, 0L, 0L, 0L, -0L, 0L, 0L, -0L, 0L, 0L);
        double expected4 = 0.0;
        assertEquals(expected4, PortaTestTask.findMedian(testArrList4));
    }

    @Test
    void getMaxIncreasingSequence() {
        List<Long> arrList5 = Arrays.asList(-5L, -4L, -8L, 4L, 5L);
        long expected5 = 3L;
        assertEquals(expected5, PortaTestTask.getMaxIncreasingSequence(arrList5));
    }
}