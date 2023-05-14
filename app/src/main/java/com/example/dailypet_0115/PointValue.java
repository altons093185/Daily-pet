package com.example.dailypet_0115;

public class PointValue {
    long EnterDH;
    int  EnterH;

    public PointValue(){
    }
    public PointValue(long EnterDH,int EnterH){
        this.EnterDH=EnterDH;
        this.EnterH=EnterH;
    }
    public long getEnterDH(){
        return EnterDH;
    }
    public int getEnterH(){
        return EnterH;
    }
}
