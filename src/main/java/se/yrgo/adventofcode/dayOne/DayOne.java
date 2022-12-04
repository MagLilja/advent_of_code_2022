package se.yrgo.adventofcode.dayOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayOne {

    public static List<Integer> readInput() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\YRGO\\aoc22\\src\\main\\java\\input.txt"));
        List<Integer> elfCaloryList = new ArrayList<>();
        final int[] currentElfCalories = {0};
        reader.lines().forEach(calory -> {

            if (!calory.trim().isEmpty()) {
                currentElfCalories[0] += Integer.parseInt(calory.trim());
            } else {
                elfCaloryList.add(currentElfCalories[0]);
                currentElfCalories[0] = 0;
            }

        });

        int maxValueIndex = 0;
        Integer maxValue = null;
        for (int i = 0, n = elfCaloryList.size(); i < n; ++i) {
            Integer value = elfCaloryList.get(i);
            if (value == null || maxValue != null && value <= maxValue)
                continue;
            maxValue = value;
            maxValueIndex = i;
        }

        System.out.println("Elf " + maxValueIndex);
        System.out.println("is carrying the most calories: " + maxValue);
        return elfCaloryList;

    }


    public static void getTopThreeTotalCalories() throws IOException {

        readInput().stream()
                .sorted(Comparator.reverseOrder())
                .limit(3).reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
    }


}
