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
    private static List<Long> sortedNumbersList;

    public static void main(String[] args) {
        // Read path to file
        System.out.println("Write absolute path to your file: ");
        Path filePath;
        try (BufferedReader filePathReader = new BufferedReader(new InputStreamReader(System.in));) {
            filePath = Paths.get(filePathReader.readLine());
        } catch (IOException e) {
            System.err.println("Error reading from console");
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

        System.out.println("Max number: " + findMaxNumber(allNumbers));
        System.out.println("Min number: " + findMinNumber(allNumbers));
        System.out.println("Arithmetic mean: " + calculateArithmeticMean(allNumbers));

        getMaxSeq(allNumbers);
        System.out.println((System.currentTimeMillis() - startTimePoint) / 1000 + " сек");

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

    // The method find median in list of numbers.
    public static long findMedian(List<Long> numbersList) {
        return 1L;
    }

    // The method takes a list of numbers and returns the maximum element.
    public static long findMaxNumber(List<Long> numbersList) {
        List<Long> sortedNumbersList = sortNumbersAsc(numbersList);
        return sortedNumbersList.get(sortedNumbersList.size() - 1);
    }

    // The method takes a list of numbers and returns the minimum element.
    public static long findMinNumber(List<Long> numbersList) {
        List<Long> sortedNumbersList = sortNumbersAsc(numbersList);
        return sortedNumbersList.get(0);
    }

    /* The method copies the original list of numbers and then sorts and assigns it to a variable sortedNumbersList.
     When the method is called again, it returns the result from the variable sortedNumbersList.
     This avoids wasting resources on re-sorting. */
    private static List<Long> sortNumbersAsc(List<Long> numbersList) {
        ArrayList<Long> copyNumbersList = new ArrayList<>(numbersList);
        if (sortedNumbersList == null) {
            Collections.sort(copyNumbersList);
            sortedNumbersList = copyNumbersList;
        }
        return sortedNumbersList;
    }
}