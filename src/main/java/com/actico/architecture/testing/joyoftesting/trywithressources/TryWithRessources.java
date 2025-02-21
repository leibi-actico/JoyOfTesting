package com.actico.architecture.testing.joyoftesting.trywithressources;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Optional;

@NoArgsConstructor
@Log4j2
public class TryWithRessources {
    public Optional<String> readFirstLineFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return Optional.of(br.readLine());
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public Optional<String> readFirstLineFromFileWithExplicitCheckBeforeTheTry(String path) {
        if (!Files.exists(Path.of(path), LinkOption.NOFOLLOW_LINKS)) {
            log.warn("Maybe we want to tell the user that the file does not exist");
            return Optional.empty();
        }
        return readFirstLineFromFile(path);
    }
}
