public class MortgageCalculator {
    private final static byte monthsInYears = 12;
    private final static byte percentage = 100;
    private int principal;
    private float annualInterestRate;
    private byte periodYears;

    public MortgageCalculator(int principal, float annualInterestRate, byte periodYears) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.periodYears = periodYears;
    }

    public double mortgageBalance(short paymentCount) {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayments = getNumberOfPayments();
        double balance = principal *
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, paymentCount)) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return balance;
    }

    public double mortgageAmount() {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayments = getNumberOfPayments();
        double mortgageAmount = principal *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return mortgageAmount;
    }

    public double [] getRemainingBalance(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month += 1)
            balances[month-1]= mortgageBalance(month);
        return balances;
    }

    private short getNumberOfPayments() {
        return (short) (periodYears * monthsInYears);
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / percentage / monthsInYears;
    }
}
