package com.actico.architecture.testing.joyoftesting.exceptions;

import java.io.IOException;
import java.util.Random;

public class SomeOtherInterfaceImpl implements SomeInterface {
    private final Random random = new Random();

    @Override
    public String getName() throws IOException {
        if (someCheck()) {
            return "My Name";
        } else {
            throw new IOException("Random number is odd");
        }
    }

    private boolean someCheck() {
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber % 2 == 0;
    }

}
