import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator calculator;
    private final NumberFormat currency;
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgageBalance() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        for (double balance : calculator.getRemainingBalance())
            System.out.println(currency.format(balance));
    }

    public void printMonthlyPayment() {
        double mortgageAmount = calculator.mortgageAmount();
        String mortgageResult = currency.format(mortgageAmount);
        System.out.println("MORTGAGE");
        System.out.println("________________");
        System.out.println("Monthly Payments: " + mortgageResult);
    }

}
