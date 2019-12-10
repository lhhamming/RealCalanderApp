package com.hamming;

public class Daily extends Appointment  {
    public Daily(String description, String date) {
        super(description, date);
    }

    @Override
    public String getDate() {
        return super.date();
    }
}
