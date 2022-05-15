package org.oobootcamp.warmup.length;


public class FootBallSquare {
    private Length width;
    private Length length;

    public FootBallSquare(Length width, Length length){
        this.length = length;
        this.width = width;
    }

    public Boolean equalOriginFootBall(FootBallSquare footBallSquare){
        return  this.width.getValue().equals(footBallSquare.width.getValue()) && this.length.getValue().equals(footBallSquare.length.getValue());
    }
}
