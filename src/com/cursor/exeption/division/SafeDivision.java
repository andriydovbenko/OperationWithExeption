package com.cursor.exeption.division;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivision {
    private Integer firstNumber;
    private Integer secondNumber;

    public SafeDivision() {
        this.firstNumber = inputInteger(" first");
        this.secondNumber = inputInteger(" second");
        try {
            divideFirstNumberBySecond();
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage() + "\n" + getClass().getSimpleName());
        }
    }

    public Integer inputInteger(String number) {
        System.out.println("Enter" + number + " integer: ");
        Integer integerNumber = null;
        while (integerNumber == null) {
            try {
                Scanner input = new Scanner(System.in);
                integerNumber = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input error. Enter only digits");
            }
        }
        return integerNumber;
    }

    private void divideFirstNumberBySecond() {
        if (secondNumber != 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#.###");
            System.out.println(firstNumber + " / " + secondNumber + " = " +
                    decimalFormat.format((double) firstNumber / secondNumber));
        } else {
            throw new DivideByZeroException("Zero divide error");
        }
    }
}