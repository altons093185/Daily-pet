package com.example.dailypet_0115;

import android.support.annotation.NonNull;

import com.google.firebase.firestore.Exclude;

public class HRID {
@Exclude
    public String HRID;
    public<T extends HRID>T withId(@NonNull final String id){
    this.HRID=id;
    return (T)this;
    }
}
