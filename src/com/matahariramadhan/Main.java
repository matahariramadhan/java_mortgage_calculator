package com.matahariramadhan;

public class Main {
    public static void main(String[] args) {
        final  byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float annual_interest_rate = 0;
        int period = 0;

        principal = (int) Console.readNumber("Principal", 1000, 1000000);
        annual_interest_rate = (float) Console.readNumber("Annual Interest Rate", 1, 30);
        period = (int) Console.readNumber("Period (Years)", 1, 30);

        float monthlyInterestRate = annual_interest_rate / MONTHS_IN_YEAR /  PERCENT;
        int monthlyPeriod = period * MONTHS_IN_YEAR;

        var calculator = new MortgageCalculator(principal, monthlyInterestRate,monthlyPeriod);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}