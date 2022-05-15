package org.oobootcamp.warmup.length;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FootBallCompareTest {
    @Test
    public void shouldBeEqualOriginalFootBallSquare(){
        FootBallSquare footBallSquare = new FootBallSquare(new Length(100,Unit.M), new Length(200,Unit.M));
        FootBallSquare origin = new FootBallSquare(new Length(100,Unit.M), new Length(200,Unit.M));
        assertThat(footBallSquare.equalOriginFootBall(origin)).isTrue();
    }

    @Test
    public void shouldNotBeEqualOriginalFootBallSquare(){
        FootBallSquare footBallSquare = new FootBallSquare(new Length(101,Unit.M), new Length(200,Unit.M));
        FootBallSquare origin = new FootBallSquare(new Length(100,Unit.M), new Length(200,Unit.M));
        assertThat(footBallSquare.equalOriginFootBall(origin)).isFalse();
    }
}
