package com.actico.architecture.testing.joyoftesting.trywithressources;

import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@NoArgsConstructor
public class TryWithRessources {
    public Optional<String> readFirstLineFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return Optional.of(br.readLine());
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
