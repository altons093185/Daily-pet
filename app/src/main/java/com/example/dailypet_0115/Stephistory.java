package com.example.dailypet_0115;

import java.sql.Date;

public class Stephistory extends StepID{
    public String Step;
    public java.util.Date timestamp;
    String user_id;



    public Stephistory(String Step, java.util.Date timestamp) {
        setUser_id(user_id);
        this.Step = Step;
        this.timestamp=timestamp;
    }

    public String getStep() {
        return Step;
    }

    public void setStep(String Step) {
        this.Step = Step;
    }

    public java.util.Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
