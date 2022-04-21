import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annual_interest_rate = scanner.nextFloat();
        float monthly_interest_rate = annual_interest_rate / MONTHS_IN_YEAR /  PERCENT;

        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();
        int monthly_period = period * MONTHS_IN_YEAR;


        double mortgage = principal * (
                (monthly_interest_rate * Math.pow(1 + monthly_interest_rate, monthly_period))
                        / (Math.pow(1 + monthly_interest_rate, monthly_period) - 1)
        );

        Locale locale = new Locale("en", "US");
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}