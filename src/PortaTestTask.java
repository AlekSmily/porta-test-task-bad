import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PortaTestTask {
    public static List<Long> sortedNumbersList;

    public static void main(String[] args) {
        // Read path to file
        System.out.println("Write absolute path to your file: ");
        Path filePath;
        try (BufferedReader filePathReader = new BufferedReader(new InputStreamReader(System.in));) {
            filePath = Paths.get(filePathReader.readLine());
        } catch (IOException e) {
            System.err.println("Error reading from console!");
            throw new RuntimeException();
        }

        // Start time point
        long startTimePoint = System.currentTimeMillis();

        // Read all lines from file and store them to list
        List<String> allStringsOfNumbers;
        try {
            allStringsOfNumbers = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.err.println("ERROR! You need to specify the real path to the existing TEXT file!");
            throw new RuntimeException();
        }

        // Checking the file for data content
        if (allStringsOfNumbers.isEmpty()) {
            System.err.println("ERROR! File is empty!");
            throw new RuntimeException();
        }

        // Parse string to long
        List<Long> allNumbers = new ArrayList<>();
        try {
            for (String str : allStringsOfNumbers) {
                allNumbers.add(Long.parseLong(str));
            }
        } catch (NumberFormatException e) {
            System.err.println("ERROR! The file must contain integers! Each number must be written on a separate line without spaces!");
            throw new RuntimeException();
        }

        // Do our statistics methods
        System.out.println("Max number in file: " + findMaxNumber(allNumbers));
        System.out.println("Min number in file: " + findMinNumber(allNumbers));
        System.out.println("Median: " + findMedian(allNumbers));
        System.out.println("Arithmetic mean: " + calculateArithmeticMean(allNumbers));

        // Print execution time
        System.out.println("Execution time: " + (System.currentTimeMillis() - startTimePoint) / 1000 + " seconds");
    }

    public static long[] getMaxSeq(List<Long> arrList) {
        int maxInc = 1;
        int maxDec = 1;
        int maxIncSeq = 1;
        int maxDecSeq = 1;
        for (int i = 0, j = 1; i < arrList.size() - 1; i++, j++) {
            if (arrList.get(i) < arrList.get(j)) {
                maxIncSeq++;
            } else if (arrList.get(i) > arrList.get(j)) {
                if (maxIncSeq > maxInc) {
                    maxInc = maxIncSeq;
                    maxIncSeq = 1;
                }
                maxDecSeq++;
            } else {
                if (maxIncSeq > maxInc) {
                    maxInc = maxIncSeq;
                }
                if (maxDecSeq > maxDec) {
                    maxDec = maxDecSeq;
                }
                maxIncSeq = 1;
                maxDecSeq = 1;
            }
            if (j == arrList.size() - 1) {
                if (maxIncSeq > maxInc) {
                    maxInc = maxIncSeq;
                }
                if (maxDecSeq > maxDec) {
                    maxDec = maxDecSeq;
                }
            }
        }
        System.out.println(maxInc + " " + maxDec);
        return new long[]{maxInc, maxDec};
    }

    // The method calculate arithmetic mean.
    public static long calculateArithmeticMean(List<Long> numbersList) {
        long sum = 0;
        for (Long l : numbersList) {
            sum += l;
        }
        // Checking division by zero
        if (sum != 0) {
            return sum / numbersList.size();
        }
        return 0L;
    }

    /**
     * The method find median in list of numbers
     *
     * @param numbersList must be {@link java.util.List} of {@link java.lang.Long}
     * @return median double in numbersList
     */
    public static double findMedian(List<Long> numbersList) {
        if (numbersList.size() == 1) { // The case when there is one element in the array
            return numbersList.get(0);
        } else if (numbersList.size() % 2 != 0) { // The case when the array has an odd number of elements
            List<Long> sortedNumbersAsc = sortNumbersAsc(numbersList);
            return sortedNumbersAsc.get(sortedNumbersAsc.size() / 2);
        } else { // The case when the array has an even number of elements
            double[] sortedNumbersAsc = sortNumbersAsc(numbersList).stream()
                    .mapToDouble(Long::doubleValue)
                    .toArray();
            double fistIndex = sortedNumbersAsc[(sortedNumbersAsc.length / 2 - 1)];
            double secondIndex = sortedNumbersAsc[(sortedNumbersAsc.length / 2)];
            return 0.5 * (fistIndex + secondIndex);
        }
    }

    /**
     * The method find max number in a list and returns it
     *
     * @param numbersList must be {@link java.util.List} of {@link java.lang.Long}
     * @return max {@link java.lang.Long} number in numbersList
     */
    public static Long findMaxNumber(List<Long> numbersList) {
        List<Long> sortedNumbersList = sortNumbersAsc(numbersList);
        return sortedNumbersList.get(sortedNumbersList.size() - 1);
    }

    /**
     * The method find min number in a list and returns it
     *
     * @param numbersList must be {@link java.util.List} of {@link java.lang.Long}
     * @return min {@link java.lang.Long} number in numbersList
     */
    public static Long findMinNumber(List<Long> numbersList) {
        List<Long> sortedNumbersList = sortNumbersAsc(numbersList);
        return sortedNumbersList.get(0);
    }

    /* The method copies the original list of numbers and then sorts and assigns it to a variable sortedNumbersList.
     When the method is called again, it returns the result from the variable sortedNumbersList.
     This avoids wasting resources on re-sorting. */

    /**
     * The method sorts a list of numbers in ascending order
     *
     * @param numbersList must be {@link java.util.List} of {@link java.lang.Long}
     * @return sorted {@link java.util.List} of {@link java.lang.Long}
     */
    private static List<Long> sortNumbersAsc(List<Long> numbersList) {
        if (sortedNumbersList == null) {
            ArrayList<Long> copyNumbersList = new ArrayList<>(numbersList);
            Collections.sort(copyNumbersList);
            sortedNumbersList = copyNumbersList;
        }
        return sortedNumbersList;
    }
}