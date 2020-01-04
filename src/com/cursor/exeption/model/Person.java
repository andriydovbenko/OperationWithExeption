package com.cursor.exeption.model;

import com.cursor.exeption.driving.CarNotReadyToDriveException;
import com.cursor.exeption.driving.NotReadyToDriveException;

public class Person {
    private String NAME;
    private boolean isSober;
    private Car AUDI;

    public Person(String name, String carModel) {
        this.NAME = name;
        this.AUDI = new Car(carModel);
    }

    public void soberUp() {
        if (isSober) {
            System.out.println("Person " + NAME + " is sober");
        } else {
            System.out.println("Sobering Up");
            this.isSober = true;
            System.out.println("Person " + NAME + " is sober now");
        }
    }

    public void driveCar() throws NotReadyToDriveException {
        if (isSober) {
            System.out.println("Person " + NAME + " can drive a car\n");
            try {
                AUDI.drive();
            } catch (CarNotReadyToDriveException e) {
                System.out.println(e.getMessage() + "\nCheck out car's tank." +
                        " Is there a gasoline? " + AUDI.isGasolineInsideOFTank() +
                        "\ntype of Exception: " + e.getClass().getSimpleName() + "\n");
            }
        } else {
            throw new NotReadyToDriveException("Person " + NAME
                    + " is drunk and can not drive a car");
        }
    }

    public boolean isSober() {
        return isSober;
    }

    public void startRefuel() {
        AUDI.refuel();
    }
}