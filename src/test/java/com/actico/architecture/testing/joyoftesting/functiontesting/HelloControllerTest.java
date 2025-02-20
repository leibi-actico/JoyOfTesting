package com.actico.architecture.testing.joyoftesting.functiontesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils;

import static org.assertj.core.api.Assertions.assertThat;

class HelloControllerTest {

    @Test
    void getHello() {
        var randomString = RandomStringUtils.random(10);
        assertThat(HelloController.getHello(randomString)).isEqualTo("Hello" + randomString);
    }

    @Test
    @DisplayName("Should return Hello Peter when name is Peter")
    @Disabled("For demonstration purposes")
    void getHelloWithName() {
        assertThat(HelloController.getHello("Peter")).isEqualTo("Hello Peter");
    }
}