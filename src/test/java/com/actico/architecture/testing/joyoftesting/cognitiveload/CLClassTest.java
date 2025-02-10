package com.actico.architecture.testing.joyoftesting.cognitiveload;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CLClassTest {

    private final CLClass clClass = new CLClass();

    @Test
    void getCoffeeWithCoffee() throws URISyntaxException, IOException, InterruptedException {

        assertThat(clClass.getCoffee()).isEqualTo("Black Coffee, Frapino Mocka");

    }

}