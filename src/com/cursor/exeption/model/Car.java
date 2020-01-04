package com.cursor.exeption.model;

import com.cursor.exeption.driving.CarNotReadyToDriveException;

public class Car {

    private boolean isGasolineInsideOFTank = false;
    private String MODEL;

    public Car(String model) {
        this.MODEL = model;
    }

    public void drive() throws CarNotReadyToDriveException {
        System.out.println("Trying to drive the car");
        if (isGasolineInsideOFTank) {
            System.out.println("You ara driving the car");
        } else {
            throw new CarNotReadyToDriveException("The car " +
                    MODEL + " can not move, because tank is empty");
        }
    }

    public void refuel() {
        if (isGasolineInsideOFTank) {
            System.out.println("Car is refueled");
        } else {
            System.out.println("Car has been refueled");
            this.isGasolineInsideOFTank = true;
        }
    }

    public boolean isGasolineInsideOFTank() {
        return isGasolineInsideOFTank;
    }
}