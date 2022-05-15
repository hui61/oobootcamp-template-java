package org.oobootcamp.warmup.length;


public class Length {
    public Integer getValue() {
        return value;
    }

    private Integer value;
    private Unit unit;
    public Length(Integer value, Unit unit){
        this.value = value;
        this.unit = unit;
    }
    private boolean compare(Length length){
        return this.transfortToMM(length).equals(this.transfortToMM(this));
    }

    public static Integer transfortToMM(Length length){
        if(length.unit.equals(Unit.M)){
            return  length.value *100;
        }
        else if (length.unit.equals(Unit.CM)){
            return length.value *1;
        }
        else{
            return length.value * 10;
        }
    }
}
