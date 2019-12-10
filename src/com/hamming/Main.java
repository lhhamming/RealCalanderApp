package com.hamming;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Test appointments
        ArrayList<Appointment> appointments = new ArrayList<>();


        //Dit is elke dag. Dus ongeacht of hij wel of niet voorkomt met de dag, hij moet altijd worden toegevoegd.
        appointments.add(new Daily("Test daily", "10 12 2020"));

        //Dit is elke maand
        appointments.add(new Monthly("Test Monthly", "9 12 2019"));
        //Dit is een eenmalige. Je hebt hierbij alles van nodig. Als hij niet op die datum is
        //Dan komt hij ook niet meer vaker voor
        appointments.add(new OneTime("Test Onetime", "8 12 2019"));

        System.out.println(appointments);


        //Get date from user.
        Scanner userInput = new Scanner(System.in);
        System.out.println("Op welke datum wilt u checken of er een afspraak is?");
        System.out.println("Vul alstublieft het zo in: 10 4 2019 ");
        System.out.println("Dus eerst Dag Maand en dan Jaar");
        String dateToCheck = userInput.nextLine();

        String[] Datesplit = dateToCheck.split(" ");
        int Year = Integer.parseInt(Datesplit[2]);
        int Month = Integer.parseInt(Datesplit[1]);
        int Day = Integer.parseInt(Datesplit[0]);

        ArrayList<Appointment> CurrentAppointments = new ArrayList<>();
        for (Appointment a : appointments){
            if(a instanceof Daily){
                //Deze opdracht komt elke dag weer voor.
                //Dit betekent dat als de dag nog niet geweest is dat hij voorbij zou moeten komen dat hij tot die tijd
                //zichzelf blijft aanroepen.
                if(a.oneTimeDateChecker(Year,Month,Day)){
                    CurrentAppointments.add(a);
                }
            }
            if(a instanceof OneTime){
                if(a.occursOn(Year,Month,Day)){
                 CurrentAppointments.add(a);
                }
            }
            if(a instanceof Monthly){
                if(a.monthlyOccursOn(Year,Month)){
                    CurrentAppointments.add(a);
                }
            }
        }


        System.out.println(CurrentAppointments);

    }
}
