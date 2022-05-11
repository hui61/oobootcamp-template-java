package org.oobootcamp.warmup.length;


public class FootBallSquare {
    private Length width;
    private Length length;

    public FootBallSquare(Length width, Length length){
        this.length = length;
        this.width = width;
    }

    public Boolean equalOriginFootBall(FootBallSquare footBallSquare){
        return  this.width.equals(footBallSquare.width) && this.length.equals(footBallSquare.length);
    }
}
