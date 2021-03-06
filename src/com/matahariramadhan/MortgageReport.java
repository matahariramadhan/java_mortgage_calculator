package com.matahariramadhan;

import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println(
                "\nPAYMENT SCHEDULE\n" +
                "-----------------");
        for(double balance : calculator.getRemainingBalance()){
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMORTGAGE\n" +
                "---------\n" +
                "Monthly Payment: " +
                mortgageFormatted +
                "\n");
    }
}
