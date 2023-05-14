package com.example.dailypet_0115;

import java.sql.Date;

public class HRhistory extends HRID{
    public String PetHeightNumber, PetWeightNumber;
    public java.util.Date timestamp;
    String user_id;



    public HRhistory(String user_iD,String PetHeightNumber, String PetWeightNumber,java.util.Date timestamp) {
        setUser_id(user_iD);
        this.PetHeightNumber = PetHeightNumber;
        this.PetWeightNumber = PetWeightNumber;
        this.timestamp=timestamp;
    }


   /* public HRhistory(Date timestamp){
        this.timestamp = timestamp;
    }*/

    public String getPetHeightNumber() {
        return PetHeightNumber;
    }

    public void setPetHeightNumber(String PetHeightNumber) {
        this.PetHeightNumber = PetHeightNumber;
    }

    public String getPetWeightNumber() {
        return PetWeightNumber;
    }

    public void setPetWeightNumber(String PetWeightNumber) {
        this.PetWeightNumber = PetWeightNumber;
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
