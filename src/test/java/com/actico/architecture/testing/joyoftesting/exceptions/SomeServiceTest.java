package com.actico.architecture.testing.joyoftesting.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SomeServiceTest {
    private final SomeService someService = new SomeService();


    @Test
    void getSomeServiceMessage() {
        assertThat(someService.getSomeServiceMessage()).isEqualTo("Some Service Message with My Name");
    }
}