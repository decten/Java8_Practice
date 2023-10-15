package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
        List<String> names = nameStream.collect(Collectors.toList());

        String[] cityArray = new String[]{"San Jose", "Seoul", "Busan"};
        Stream<String> cityName = Arrays.stream(cityArray);
        List<String> cityList = cityName.collect(Collectors.toList());

        Stream.of(3, -5, 7, 10, -3)
            .filter(x -> x > 0)
            .collect(Collectors.toList());

        Stream.of(3, -5, 7, 10, -3)
            .map(x -> "Number is " + x)
            .collect(Collectors.toList());

        Stream.of(3, -5, 7, 10, -3)
            .sorted()
            .collect(Collectors.toList());

        Stream.of(3, -5, 4, -5, 2, 3)
            .distinct()
            .collect(Collectors.toList());

        String[][] cities = new String[][]
            {
                {"Seoul", "Busan"},
                {"San Francisco", "New York"},
                {"Madrid", "Barcelona"}
            };
        Arrays.stream(cities)
            .flatMap(x -> Arrays.stream(x))
            .collect(Collectors.toList());
    }
}