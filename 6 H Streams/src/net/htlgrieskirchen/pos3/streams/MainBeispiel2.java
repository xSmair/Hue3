package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainBeispiel2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(101);
        }

        String[] strings = new String[10];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = RandomStringFactory.generateRandomString(10);
        }
    }

    public static double average(int[] average){
        return Arrays.stream(average).average().getAsDouble();
    }

    public static List<String> upperCase(String[] strings){
        return Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList());
    }
}
