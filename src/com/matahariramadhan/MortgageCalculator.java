package com.matahariramadhan;

public class MortgageCalculator {
    final  byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    private int principal;
    private float monthlyInterestRate;
    private int monthlyPeriod;

    public MortgageCalculator(int principal, float annualInterestRate, int periods) {
        this.principal = principal;
        monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR /  PERCENT;
        this.monthlyPeriod  = periods * MONTHS_IN_YEAR;
    }

    public double calculateMortgage(){
        double mortgage = principal * (
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, monthlyPeriod))
                        / (Math.pow(1 + monthlyInterestRate, monthlyPeriod) - 1)
        );
        return mortgage;
    }

    public double calculateBalance(int numberOfPaymentMade){
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

    public int getMonthlyPeriod() {
        return monthlyPeriod;
    }
}
