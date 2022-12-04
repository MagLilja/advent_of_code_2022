package se.yrgo.adventofcode.dayTwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DayTwo {

    public static void getDataFromInput() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\YRGO\\aoc22\\src\\main\\java\\input2.txt"));
        List<List<String>> strategyList = new ArrayList<>();

        AtomicInteger totalScore = new AtomicInteger();
        int SCORE_FOR_LOSS = 0;
        int SCORE_FOR_WIN = 6;
        int SCORE_FOR_DRAW = 3;

        int SCORE_FOR_PAPER = 2;
        int SCORE_FOR_ROCK = 1;
        int SCORE_FOR_SCISSORS = 3;

        reader.lines().forEach(string -> {
            String[] strategy = string
                    .replace("B", "paper")
                    .replace("C", "scissors")
                    .replace("A", "rock")
                    .replace("Y", "paper")
                    .replace("Z", "scissors")
                    .replace("X", "rock")
                    .split(" ");
            strategyList.add(List.of(strategy[0], strategy[1]));
        });

        strategyList.forEach((pair) -> {

            String elf = pair.get(0);
            String me = pair.get(1);

            if (me.equals("rock")){
                totalScore.addAndGet(SCORE_FOR_ROCK);
            }
            if (me.equals("paper")){
                totalScore.addAndGet(SCORE_FOR_PAPER);
            }
            if (me.equals("scissors")){
                totalScore.addAndGet(SCORE_FOR_SCISSORS);
            }

            if (elf.equals("rock") && me.equals("scissors")) {
                totalScore.addAndGet(SCORE_FOR_LOSS);
            } else if (elf.equals("scissors") && me.equals("paper")) {
                totalScore.addAndGet(SCORE_FOR_LOSS);
            } else if (elf.equals("paper") && me.equals("rock")) {
                totalScore.addAndGet(SCORE_FOR_LOSS);
            } else if (elf.equals("rock") && me.equals("paper")) {
                totalScore.addAndGet(SCORE_FOR_WIN);
            } else if (elf.equals("scissors") && me.equals("rock")) {
                totalScore.addAndGet(SCORE_FOR_WIN);
            } else if (elf.equals("paper") && me.equals("scissors")) {
                totalScore.addAndGet(SCORE_FOR_WIN);
            } else if (elf.equals("rock") && me.equals("rock")) {
                totalScore.addAndGet(SCORE_FOR_DRAW);
            } else if (elf.equals("scissors") && me.equals("scissors")) {
                totalScore.addAndGet(SCORE_FOR_DRAW);
            } else if (elf.equals("paper") && me.equals("paper")) {
                totalScore.addAndGet(SCORE_FOR_DRAW);
            }
        });

        part2();

    }


    public static void part2() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\YRGO\\aoc22\\src\\main\\java\\input2.txt"));
        List<List<String>> strategyList = new ArrayList<>();

        AtomicInteger totalScore = new AtomicInteger();
        int SCORE_FOR_LOSS = 0;
        int SCORE_FOR_WIN = 6;
        int SCORE_FOR_DRAW = 3;

        int SCORE_FOR_PAPER = 2;
        int SCORE_FOR_ROCK = 1;
        int SCORE_FOR_SCISSORS = 3;

        reader.lines().forEach(string -> {
            String[] strategy = string
                    .replace("B", "paper")
                    .replace("C", "scissors")
                    .replace("A", "rock")
                    .replace("Y", "draw")
                    .replace("Z", "win")
                    .replace("X", "lose")
                    .split(" ");
            strategyList.add(List.of(strategy[0], strategy[1]));
        });

        strategyList.forEach((pair) -> {

            String elf = pair.get(0);
            String me = pair.get(1);

            if (elf.equals("scissors") && me.equals("win")) {
                totalScore.addAndGet(SCORE_FOR_WIN);
                totalScore.addAndGet(SCORE_FOR_ROCK);
            } else if (elf.equals("paper") && me.equals("win")) {
                totalScore.addAndGet(SCORE_FOR_WIN);
                totalScore.addAndGet(SCORE_FOR_SCISSORS);
            } else if (elf.equals("rock") && me.equals("win")) {
                totalScore.addAndGet(SCORE_FOR_WIN);
                totalScore.addAndGet(SCORE_FOR_PAPER);
            } else if (elf.equals("scissors") && me.equals("lose")) {
                totalScore.addAndGet(SCORE_FOR_LOSS);
                totalScore.addAndGet(SCORE_FOR_PAPER);
            } else if (elf.equals("paper") && me.equals("lose")) {
                totalScore.addAndGet(SCORE_FOR_LOSS);
                totalScore.addAndGet(SCORE_FOR_ROCK);
            } else if (elf.equals("rock") && me.equals("lose")) {
                totalScore.addAndGet(SCORE_FOR_LOSS);
                totalScore.addAndGet(SCORE_FOR_SCISSORS);
            } else if (elf.equals("scissors") && me.equals("draw")) {
                totalScore.addAndGet(SCORE_FOR_DRAW);
                totalScore.addAndGet(SCORE_FOR_SCISSORS);
            } else if (elf.equals("paper") && me.equals("draw")) {
                totalScore.addAndGet(SCORE_FOR_DRAW);
                totalScore.addAndGet(SCORE_FOR_PAPER);
            } else if (elf.equals("rock") && me.equals("draw")) {
                totalScore.addAndGet(SCORE_FOR_DRAW);
                totalScore.addAndGet(SCORE_FOR_ROCK);
            }


        });

        System.out.println(totalScore);



    }
}


