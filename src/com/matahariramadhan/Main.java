package com.matahariramadhan;

public class Main {
    public static void main(String[] args) {
        int principal = 0;
        float annual_interest_rate = 0;
        int periods = 0;

        principal = (int) Console.readNumber("Principal", 1000, 1000000);
        annual_interest_rate = (float) Console.readNumber("Annual Interest Rate", 1, 30);
        periods = (int) Console.readNumber("Period (Years)", 1, 30);

        var calculator = new MortgageCalculator(principal, annual_interest_rate,periods);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}