package com.actico.architecture.testing.joyoftesting.streamapi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StreamApiTest {


    @Test
    void getEvenNumbersBiggerThanTen_empty() {
        // GIVEN
        List<Integer> numbers = List.of();
        // WHEN
        List<Integer> evenNumbersBiggerThanTen = StreamApi.getEvenNumbersBiggerThanTen(numbers);
        // THEN
        assertThat(evenNumbersBiggerThanTen).isEmpty();
    }

    @Test
    void getEvenNumbersBiggerThanTen_onlyOneOddSmallerThan10() {
        // GIVEN
        List<Integer> numbers = List.of(1);
        // WHEN
        List<Integer> evenNumbersBiggerThanTen = StreamApi.getEvenNumbersBiggerThanTen(numbers);
        // THEN
        assertThat(evenNumbersBiggerThanTen).isEmpty();
    }

    @Test
    void getEvenNumbersBiggerThanTen_onlyOneEvemSmallerThan10() {
        // GIVEN
        List<Integer> numbers = List.of(2);
        // WHEN
        List<Integer> evenNumbersBiggerThanTen = StreamApi.getEvenNumbersBiggerThanTen(numbers);
        // THEN
        assertThat(evenNumbersBiggerThanTen).isEmpty();
    }


    @Test
    void getEvenNumbersBiggerThanTen_onlyOneOddBiggerThan10() {
        // GIVEN
        List<Integer> numbers = List.of(111);
        // WHEN
        List<Integer> evenNumbersBiggerThanTen = StreamApi.getEvenNumbersBiggerThanTen(numbers);
        // THEN
        assertThat(evenNumbersBiggerThanTen).isEmpty();
    }

    @Test
    void getEvenNumbersBiggerThanTen_onlyOneEvemBiggerThan10() {
        // GIVEN
        List<Integer> numbers = List.of(22);
        // WHEN
        List<Integer> evenNumbersBiggerThanTen = StreamApi.getEvenNumbersBiggerThanTen(numbers);
        // THEN
        assertThat(evenNumbersBiggerThanTen).containsExactly(22);
    }


    @Test
    void getEvenNumbersBiggerThanTen() {
        // GIVEN
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        // WHEN
        List<Integer> evenNumbersBiggerThanTen = StreamApi.getEvenNumbersBiggerThanTen(numbers);
        // THEN
        assertThat(evenNumbersBiggerThanTen).containsExactly(12);
    }

}