package com.example.dailypet_0115;

import android.support.annotation.NonNull;

import com.google.firebase.firestore.Exclude;

public class StepID {
    @Exclude
    public String StepID;
    public<T extends StepID>T withId(@NonNull final String id){
    this.StepID=id;
    return (T)this;
    }
}
