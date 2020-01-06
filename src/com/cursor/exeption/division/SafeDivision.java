package com.cursor.exeption.division;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivision {
    private static final String FIRST_MASSAGE = "first";
    private static final String SECOND_MASSAGE = "second";
    private Integer firstNumber;
    private Integer secondNumber;
    private Scanner input = new Scanner(System.in);

    public SafeDivision() {
        this.firstNumber = inputInteger(FIRST_MASSAGE);
        this.secondNumber = inputInteger(SECOND_MASSAGE);
        input.close();
    }

    public Integer inputInteger(String massage) {
        System.out.println("Enter " + massage + " integer: ");
        Integer integerNumber = null;
        while (integerNumber == null) {
            try {
                integerNumber = input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Input error. Enter only digits");
            }
        }
        return integerNumber;
    }

    public void divideFirstNumberBySecond() {
        if (secondNumber != 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#.###");
            System.out.println(firstNumber + " / " + secondNumber + " = " +
                    decimalFormat.format((double) firstNumber / secondNumber));
        } else {
            throw new DivideByZeroException("Zero divide error");
        }
    }
}