package se.yrgo.adventofcode.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> getListOfLines(String path) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        return reader.lines().collect(Collectors.toList());
    }


}
