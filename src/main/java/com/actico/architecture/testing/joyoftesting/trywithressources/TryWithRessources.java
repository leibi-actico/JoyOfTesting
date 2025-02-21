package com.actico.architecture.testing.joyoftesting.trywithressources;

import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
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

    public Optional<String> readFirstLineFromFileWithExplicitCheckBeforeTheTry(String path) {
        var realPath = Path.of(path);
        boolean exists = Files.exists(realPath, LinkOption.NOFOLLOW_LINKS);
        if (exists) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                return Optional.of(br.readLine());
            } catch (IOException e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
