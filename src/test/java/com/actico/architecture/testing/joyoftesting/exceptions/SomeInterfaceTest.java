package com.actico.architecture.testing.joyoftesting.exceptions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SomeInterfaceTest {

    private final SomeInterface someInterface = new SomeInterfaceImpl();
    private final SomeInterface someOtherInterface = new SomeOtherInterfaceImpl();

    @Test
    void getName() throws Exception {
        assertThat(someInterface.getName()).isEqualTo("My Name");
    }

    @Test
    @Disabled
    void getNameWithException() {
        assertThatThrownBy(someOtherInterface::getName).isInstanceOf(Exception.class);
    }

    @Test
    @Disabled
    void getNameWithExceptionSuccess() throws Exception {
        assertThat(someOtherInterface.getName()).isEqualTo("My Name");
    }
}