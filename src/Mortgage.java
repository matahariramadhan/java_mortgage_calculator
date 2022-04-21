import java.text.NumberFormat;
import java.util.Locale;

public class Mortgage {
        int principal;
        double annual_interest_rate;
        int period;

        public Mortgage(int principal, double annual_interest_rate, int period) {
                this.principal = principal;
                this.annual_interest_rate = annual_interest_rate;
                this.period = period;
        }

        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
}
