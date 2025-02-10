package com.actico.architecture.testing.joyoftesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class SwitchTestTest {


    @Test
    void oldSchool() {
        assertThat(SwitchHandling.oldSchool(SwitchHandling.Switch.ON)).isEqualTo("Switch is ON");
        assertThat(SwitchHandling.oldSchool(SwitchHandling.Switch.OFF)).isEqualTo("Switch is OFF");
    }



    @ParameterizedTest
    @EnumSource(SwitchHandling.Switch.class)
    void oldSchool(SwitchHandling.Switch s) {
        if (s == SwitchHandling.Switch.ON) {
            assertThat(SwitchHandling.oldSchool(s)).isEqualTo("Switch is ON");
        } else if (s == SwitchHandling.Switch.OFF) {
            assertThat(SwitchHandling.oldSchool(s)).isEqualTo("Switch is OFF");
        } else {
            assertThat(SwitchHandling.oldSchool(s)).isEqualTo("Switch is in unknown state");
        }

    }

}