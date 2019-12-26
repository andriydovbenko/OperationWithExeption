package com.cursor.exeption;

import com.cursor.exeption.division.SafeDivision;
import com.cursor.exeption.driving.NotReadyToDriveException;
import com.cursor.exeption.model.Person;
import com.cursor.exeption.stacktrace.ExceptionStackTrace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Executor {
    public void checkExampleOfExceptions() {
        //first task
        String nameOfPerson = "Anton";
        String carOfPerson = "Audi";
        Person anton = new Person(nameOfPerson, carOfPerson);
        try {
            anton.driveCar();
        } catch (NotReadyToDriveException e) {
            System.out.println(e.getMessage() + "\nCheck person " + nameOfPerson +
                    " on drunkenness. He is sober? = " + anton.isSober() +
                    "\ntype of Exception: " + e.getClass().getSimpleName() + "\n");
        }
        anton.soberUp();
        try {
            anton.driveCar();
        } catch (NotReadyToDriveException e) {
            System.out.println(e.getMessage());
        }
        anton.startRefuel();
        try {
            anton.driveCar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Person nonExist = null;
        try {
            System.out.println("\nNon exist person is trying to drive a car:");
            nonExist.driveCar();
        } catch (NullPointerException | NotReadyToDriveException e) {
            System.out.println(e.getClass().getSimpleName());
        }
        String file = "some path";
        System.out.println("\nExample IOException:");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        //second task
        new SafeDivision();

        //third task
        try {
            new ExceptionStackTrace().catchAndRethrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}