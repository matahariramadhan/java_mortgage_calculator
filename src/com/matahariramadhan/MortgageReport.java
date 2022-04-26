package com.matahariramadhan;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    public static void printMortgage(int principal, float monthlyInterestRate, int monthlyPeriod, Locale locale) {
        double mortgage = Main.calculateMortgage(principal, monthlyInterestRate, monthlyPeriod);
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        System.out.println("\nMORTGAGE\n" +
                "---------\n" +
                "Monthly Payment: " +
                mortgageFormatted +
                "\n");
    }

    public static void printPaymentSchedule(int principal, float monthlyInterestRate, int monthlyPeriod, Locale locale) {
        System.out.println(
                "\nPAYMENT SCHEDULE\n" +
                "-----------------");
        for (int numberOfPaymentMade = 1; numberOfPaymentMade <= monthlyPeriod; numberOfPaymentMade++) {
            double balance = Main.calculateBalance(principal, monthlyInterestRate, monthlyPeriod, numberOfPaymentMade);
            String balanceFormatted = NumberFormat.getCurrencyInstance(locale).format(balance);
            System.out.println(balanceFormatted);
        }
    }
}
