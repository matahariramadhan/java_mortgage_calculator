package com.matahariramadhan;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        final  byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float annual_interest_rate = 0;
        int period = 0;

        principal = (int) Console.readNumber("Principal", 1000, 1000000);
        annual_interest_rate = (float) Console.readNumber("Annual Interest Rate", 0, 30);
        period = (int) Console.readNumber("Period (Years)", 0, 30);

        float monthlyInterestRate = annual_interest_rate / MONTHS_IN_YEAR /  PERCENT;
        int monthlyPeriod = period * MONTHS_IN_YEAR;

        Locale locale = new Locale("en", "US");

        printMortgage(principal, monthlyInterestRate, monthlyPeriod, locale);
        printPaymentSchedule(principal, monthlyInterestRate, monthlyPeriod, locale);
    }

    private static void printMortgage(int principal, float monthlyInterestRate, int monthlyPeriod, Locale locale) {
        double mortgage = calculateMortgage(principal, monthlyInterestRate, monthlyPeriod);
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        System.out.println("\nMORTGAGE\n" +
                "---------\n" +
                "Monthly Payment: " +
                mortgageFormatted +
                "\n");
    }

    private static void printPaymentSchedule(int principal, float monthlyInterestRate, int monthlyPeriod, Locale locale) {
        System.out.println(
                "\nPAYMENT SCHEDULE\n" +
                "-----------------");
        for (int numberOfPaymentMade = 1; numberOfPaymentMade <= monthlyPeriod; numberOfPaymentMade++) {
            double balance = calculateBalance(principal, monthlyInterestRate, monthlyPeriod, numberOfPaymentMade);
            String balanceFormatted = NumberFormat.getCurrencyInstance(locale).format(balance);
            System.out.println(balanceFormatted);
        }
    }

    public static double calculateMortgage(int principal, float monthlyInterestRate, int monthlyPeriod){
        double mortgage = principal * (
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, monthlyPeriod))
                        / (Math.pow(1 + monthlyInterestRate, monthlyPeriod) - 1)
        );
        return mortgage;
    }

    public static double calculateBalance(int principal, float monthlyInterestRate, int monthlyPeriod, int numberOfPaymentMade){
        int numberOfPayment = monthlyPeriod;
        double balance = principal * (
                (
                        Math.pow((1+monthlyInterestRate), numberOfPayment) - Math.pow((1+monthlyInterestRate), numberOfPaymentMade)
                )/(
                        Math.pow((1+monthlyInterestRate), numberOfPayment) - 1
                )
        );
        return balance;
    }
}