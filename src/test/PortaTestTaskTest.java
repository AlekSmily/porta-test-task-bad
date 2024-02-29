import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PortaTestTaskTest {

    @Test
    void getMaxSeq() {
        // Test case 1: Increasing and then decreasing sequence
        List<Long> arrList1 = Arrays.asList(1L, 2L, 3L, 2L, 1L);
        long[] expected1 = {3L, 3L};
        assertArrayEquals(expected1, PortaTestTask.getMaxSeq(arrList1));

        // Test case 2: All elements are equal
        List<Long> arrList2 = Arrays.asList(5L, 5L, 5L, 5L);
        long[] expected2 = {1L, 1L};
        assertArrayEquals(expected2, PortaTestTask.getMaxSeq(arrList2));

        // Test case 3: Single element
        List<Long> arrList3 = Collections.singletonList(7L);
        long[] expected3 = {1L, 1L};
        assertArrayEquals(expected3, PortaTestTask.getMaxSeq(arrList3));

        // Test case 4: Decreasing and then increasing sequence
        List<Long> arrList4 = Arrays.asList(5L, 4L, 3L, 4L, 5L);
        long[] expected4 = {3L, 3L};
        assertArrayEquals(expected4, PortaTestTask.getMaxSeq(arrList4));

        // Test case 5: with negative numbers
        List<Long> arrList5 = Arrays.asList(-5L, -4L, 3L, 4L, 5L);
        long[] expected5 = {5L, 1L};
        assertArrayEquals(expected5, PortaTestTask.getMaxSeq(arrList5));
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
}