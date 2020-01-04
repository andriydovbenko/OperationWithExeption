package com.cursor.exeption;

import com.cursor.exeption.division.DivideByZeroException;
import com.cursor.exeption.division.SafeDivision;
import com.cursor.exeption.driving.NotReadyToDriveException;
import com.cursor.exeption.model.Person;
import com.cursor.exeption.stacktrace.ExceptionStackTrace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Executor {

    public void executeProject() {
        executeExampleOfCarsExceptions();
        executeExampleOfNullPointerException();
        executeExampleOfIOException();
        executeSafeDivision();
        executeStackTrace();
    }

    private void executeExampleOfCarsExceptions() {
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
    }

    private void executeExampleOfNullPointerException() {
        Person nonExist = null;
        try {
            System.out.println("\nNon exist person is trying to drive a car:");
            nonExist.driveCar();
        } catch (NullPointerException | NotReadyToDriveException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }

    private void executeExampleOfIOException() {
        String file = "non exist path";
        System.out.println("\nExample IOException:");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }

    private void executeSafeDivision() {
        SafeDivision safeDivision = new SafeDivision();
        try {
            safeDivision.divideFirstNumberBySecond();
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage() + "\n" + getClass().getSimpleName());
        }
    }

    private void executeStackTrace() {
        try {
            new ExceptionStackTrace().catchAndRethrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}