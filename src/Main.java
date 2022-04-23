import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int principal = 0;
        float annual_interest_rate = 0;
        int period = 0;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1000_000)
                break;

            System.out.println("Please enter principal between 1000 and 1000000");
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            annual_interest_rate = scanner.nextFloat();
            if (annual_interest_rate > 0 && annual_interest_rate <= 30)
                break;

            System.out.println("Enter value greater than 0 and less then or equal to 30");
        }

        while (true){
            System.out.print("Period (Years): ");
            period = scanner.nextByte();
            if (period > 0 && period <= 30)
                break;

            System.out.println("Enter value between 0 and 30");
        }

        double mortgage = calculateMortgage(principal,annual_interest_rate, period);

        Locale locale = new Locale("en", "US");
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
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