import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int principal = 0;
        float annual_interest_rate = 0;
        int period = 0;

        principal = (int) readNumber("Principal: ", 1000, 1000000);
        annual_interest_rate = (float) readNumber("Annual Interest Rate: ", 0, 30);
        period = (int) readNumber("Period (Years): ", 0, 30);


        double mortgage = calculateMortgage(principal,annual_interest_rate, period);

        Locale locale = new Locale("en", "US");
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;

            System.out.println("Please enter principal between" + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(int principal, float annualInterestRate, int periods){
        final  byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthly_interest_rate = annualInterestRate / MONTHS_IN_YEAR /  PERCENT;
        int monthly_period = periods * MONTHS_IN_YEAR;

        double mortgage = principal * (
                (monthly_interest_rate * Math.pow(1 + monthly_interest_rate, monthly_period))
                        / (Math.pow(1 + monthly_interest_rate, monthly_period) - 1)
        );
        return mortgage;
    }
}