package se.yrgo.adventofcode.dayThree;

import se.yrgo.adventofcode.utils.Utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DayThree {
    public static void main(String[] args) {
        List<String> listOfLines;
        try {
            listOfLines = Utils.getListOfLines("C:\\YRGO\\aoc22\\src\\main\\resources\\input3.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<String[]> rugsackList = new ArrayList<>();

        listOfLines.forEach(string -> {

            //split string in half
            final int mid = string.length() / 2; //get the middle of the String
            String[] parts = {string.substring(0, mid), string.substring(mid)};
            rugsackList.add(parts);
        });

        AtomicInteger totalPart1 = new AtomicInteger();
        List<Character> prioritiesArray = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

        rugsackList.forEach(strings -> {
            char[] charArray = strings[0].toCharArray();
            for (char c : charArray) {
                if (strings[1].contains(String.valueOf(c))) {
                    int value = prioritiesArray.indexOf(c) + 1;
                    totalPart1.addAndGet(value);
                    return;
                }
            }
        });

        System.out.println(totalPart1);

        // PART 2

        List<String[]> groupList = new ArrayList<>();
        System.out.println(listOfLines);
        AtomicInteger totalPart2 = new AtomicInteger();

        for (int i = 0; i < listOfLines.size(); i = i + 3) {
            groupList.add(new String[]{listOfLines.get(i), listOfLines.get(i + 1), listOfLines.get(i + 2)});
        }

        groupList.forEach(strings -> {
            char[] charArray = strings[0].toCharArray();
            for (char c : charArray) {
                if (strings[1].contains(String.valueOf(c)) && strings[2].contains(String.valueOf(c))) {
                    int value = prioritiesArray.indexOf(c) + 1;
                    totalPart2.addAndGet(value);
                    return;
                }
            }
        });

        System.out.println(totalPart2);
    }
};

