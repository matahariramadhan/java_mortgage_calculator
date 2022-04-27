package com.matahariramadhan;

public class MortgageCalculator {
    private int principal;
    private float monthlyInterestRate;
    private int monthlyPeriod;

    public MortgageCalculator(int principal, float monthlyInterestRate, int monthlyPeriod) {
        this.principal = principal;
        this.monthlyInterestRate = monthlyInterestRate;
        this.monthlyPeriod = monthlyPeriod;
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
