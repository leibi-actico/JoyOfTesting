package com.actico.architecture.testing.joyoftesting.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SomeInterfaceTest {

    private SomeInterface someInterface = new SomeInterfaceImpl();

    @Test
    void getName() throws Exception {
        assertThat(someInterface.getName()).isEqualTo("My Name");
    }


}