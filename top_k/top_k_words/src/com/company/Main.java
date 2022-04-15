package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<String> topKFrequent(String[] words, int k) {
        return Stream.of(words)
                .sorted()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(enumerate -> enumerate.getKey())
                .limit(k)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
	String[] words ={"dsad", "erwewr","ewq","ee","ee", "ewq"};
    topKFrequent(words, 3).stream().forEach(System.out::println);
    }
}

