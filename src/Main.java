import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthly_interest_rate = 0;
        int monthly_period = 0;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Principal ($1k - $1M): ");
            int input = scanner.nextInt();
            if (input >= 1000 && input <= 1000_000){
                principal = input;
                break;
            }

            System.out.println("Please enter principal between 1000 and 1000000");
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            float annual_interest_rate = scanner.nextFloat();
            if (annual_interest_rate > 0 && annual_interest_rate <= 30){
                monthly_interest_rate = annual_interest_rate / MONTHS_IN_YEAR /  PERCENT;
                break;
            }

            System.out.println("Enter value greater than 0 and less then or equal to 30");
        }

        while (true){
            System.out.print("Period (Years): ");
            int period = scanner.nextByte();
            if (period > 0 && period <= 30){
                monthly_period = period * MONTHS_IN_YEAR;
                break;
            }

            System.out.println("Enter value between 0 and 30");
        }

        double mortgage = principal * (
                (monthly_interest_rate * Math.pow(1 + monthly_interest_rate, monthly_period))
                        / (Math.pow(1 + monthly_interest_rate, monthly_period) - 1)
        );

        Locale locale = new Locale("en", "US");
        String mortgageFormatted = NumberFormat.getCurrencyInstance(locale).format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}