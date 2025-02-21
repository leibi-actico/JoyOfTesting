package com.actico.architecture.testing.joyoftesting.trywithressources;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TryWithRessourcesTest {
    private final TryWithRessources tryWithRessources = new TryWithRessources();

    @Test
    void testReadFirstLineFromFile() {
        String path = "src/test/resources/test.txt";
        assertThat(tryWithRessources.readFirstLineFromFile(path)).isPresent().contains("Hello World");
    }

    @Test
    void testReadFirstLineFromFileWhichIsNotAvailable() {
        String path = "src/test/resources/notExisting.txt";
        assertThat(tryWithRessources.readFirstLineFromFile(path)).isEmpty();
    }

}