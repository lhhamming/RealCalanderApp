package com.hamming;

public class OneTime extends Appointment  {
    public OneTime(String description, String date) {
        super(description, date);
    }

    @Override
    public String getDate() {
        return super.date();
    }
}
