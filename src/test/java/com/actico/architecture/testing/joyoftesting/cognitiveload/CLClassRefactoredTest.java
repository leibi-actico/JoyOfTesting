package com.actico.architecture.testing.joyoftesting.cognitiveload;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Disabled
class CLClassRefactoredTest {

    private final CLClassRefactored clClass = new CLClassRefactored();

    @Test
    void getCoffeeWithCoffee() throws IOException, InterruptedException {

        assertThat(clClass.getCoffee()).isEqualTo("Black Coffee, Frapino Mocka");

    }

}