public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readValue("Principal", 1_000, 1000000);

        float annualInterestRate = (float) Console.readValue("Annual Interest Rate", 0, 30);

        byte periodYears = (byte) Console.readValue("Period (Years)", 1, 30);

        var calculator = new MortgageCalculator(principal,annualInterestRate,periodYears);

        var report = new MortgageReport(calculator);

        report.printMonthlyPayment();
        report.printMortgageBalance();
    }


}