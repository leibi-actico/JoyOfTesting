package com.actico.architecture.testing.joyoftesting.streamapi;

import java.util.List;
import java.util.Optional;

public class StreamApi {

    public static List<Integer> getEvenNumbersBiggerThanTen(List<Integer> numbers) {
        return numbers.stream()
                .filter(StreamApi::isEven)
                .map(StreamApi::isBiggerThanTen)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    private static Optional<Integer> isBiggerThanTen(Integer number) {
        return Optional.ofNullable(number > 10 ? number : null);
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

}
