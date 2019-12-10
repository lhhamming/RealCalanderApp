package com.hamming;

public class Monthly extends Appointment {


    public Monthly(String description, String date) {
        super(description, date);
    }

    @Override
    public String getDate() {
        return super.date();
    }


}
