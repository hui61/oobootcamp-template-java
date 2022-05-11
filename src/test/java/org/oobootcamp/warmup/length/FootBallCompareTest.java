package org.oobootcamp.warmup.length;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FootBallCompareTest {
    @Test
    public void shouldBeEqualOriginalFootBallSquare(){
        FootBallSquare footBallSquare = new FootBallSquare(new Length(100), new Length(200));
        FootBallSquare origin = new FootBallSquare(new Length(100), new Length(200));
        assertThat(footBallSquare.equalOriginFootBall(origin)).isTrue();
    }

    @Test
    public void shouldNotBeEqualOriginalFootBallSquare(){
        FootBallSquare footBallSquare = new FootBallSquare(new Length(101), new Length(200));
        FootBallSquare origin = new FootBallSquare(new Length(100), new Length(200));
        assertThat(footBallSquare.equalOriginFootBall(origin)).isFalse();
    }
}
