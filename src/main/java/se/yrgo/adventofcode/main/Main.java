package se.yrgo.adventofcode.main;

import se.yrgo.adventofcode.dayTwo.DayTwo;

import java.io.IOException;

public class Main {

        public static void main(String[] args) {

            try {
                DayTwo.getDataFromInput();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
}
