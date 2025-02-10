package com.actico.architecture.testing.joyoftesting.exceptions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SomeInterfaceTest {

    private final SomeInterface someInterface = new SomeInterfaceImpl();
    private final SomeInterface someOtherInterface = new SomeOtherInterfaceImpl();

    @Test
    void getName() throws Exception {
        assertThat(someInterface.getName()).isEqualTo("My Name");
    }

    @Test
    @Disabled("This test is disabled because it is flaky")
    void getNameWithExceptionSuccess() throws Exception {
        assertThat(someOtherInterface.getName()).isEqualTo("My Name");
    }
}