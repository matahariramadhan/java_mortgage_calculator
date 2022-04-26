package com.matahariramadhan;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private int principal;
    private float monthlyInterestRate;
    private int monthlyPeriod;
    private Locale locale = new Locale("en", "US");

    public MortgageReport(int principal, float monthlyInterestRate, int monthlyPeriod) {
        this.principal = principal;
        this.monthlyInterestRate = monthlyInterestRate;
        this.monthlyPeriod = monthlyPeriod;
    }

    public void printMortgage() {
        double mortgage = Main.calculateMortgage(principal, monthlyInterestRate, monthlyPeriod);
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        System.out.println("\nMORTGAGE\n" +
                "---------\n" +
                "Monthly Payment: " +
                mortgageFormatted +
                "\n");
    }

    public void printPaymentSchedule() {
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
