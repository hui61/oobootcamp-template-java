package org.oobootcamp.warmup.length;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void shouldEqualTheOriginLength() {
        Length length = new Length(100, Unit.CM);
        Length length1 = new Length(1, Unit.M);
    }
}
