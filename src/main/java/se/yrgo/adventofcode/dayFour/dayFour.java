package se.yrgo.adventofcode.dayFour;

import se.yrgo.adventofcode.utils.Utils;

import java.io.FileNotFoundException;
import java.util.List;

public class dayFour {

    public static void part2() {
        List<String> listOfLines = null;
        int count = 0;
        try {
            listOfLines = Utils.getListOfLines("C:\\YRGO\\aoc22\\src\\main\\resources\\input4.txt");
            for (String string : listOfLines) {
                String[] string1 = string.split("-");
                String[] splitMiddle = string1[1].split(",");

                int elf1Start = Integer.parseInt(string1[0]);
                int elf1End = Integer.parseInt(splitMiddle[0]);
                int elf2Start = Integer.parseInt(splitMiddle[1]);
                int elf2End = Integer.parseInt(string1[2]);

                if ((elf1End >= elf2Start && elf1Start <= elf2End) ) {
                    System.out.println(string);
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        List<String> listOfLines = null;
        int count = 0;
        try {
            listOfLines = Utils.getListOfLines("C:\\YRGO\\aoc22\\src\\main\\resources\\input4.txt");
            for (String string : listOfLines) {
                        String[] string1 = string.split("-");
                        String[] splitMiddle = string1[1].split(",");

                        int elf1Start = Integer.parseInt(string1[0]);
                        int elf1End = Integer.parseInt(splitMiddle[0]);
                        int elf2Start = Integer.parseInt(splitMiddle[1]);
                        int elf2End = Integer.parseInt(string1[2]);

                        if ((elf1Start <= elf2Start && elf1End >= elf2End) || (elf2Start <= elf1Start && elf2End >= elf1End)) {
                            count++;
                        }
                    }
            System.out.println(count);
            part2();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }




}
