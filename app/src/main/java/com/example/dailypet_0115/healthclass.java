package com.example.dailypet_0115;

public class healthclass {
    private String rHigh;
    private String rWeight;
    private String healthclass;

    public healthclass(){

    }

    public healthclass(String healthclass,String rHigh, String rWeight) {
        this.rHigh = rHigh;
        this.rWeight = rWeight;
        this.healthclass = healthclass;
    }

    public String getrHigh() {
        return rHigh;
    }

    public String getrWeight() {
        return rWeight;
    }

    public String getHealthclass() {
        return healthclass;
    }
}
