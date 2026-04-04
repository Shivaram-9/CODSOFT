import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double usdToInr = 83.0; // fixed rate
        double eurToInr = 90.0;

        System.out.println("Currency Converter");
        System.out.println("1. USD to INR");
        System.out.println("2. EUR to INR");

        System.out.print("Select option: ");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        double result = 0;

        if (choice == 1) {
            result = amount * usdToInr;
            System.out.println("Converted Amount in INR: " + result);
        } 
        else if (choice == 2) {
            result = amount * eurToInr;
            System.out.println("Converted Amount in INR: " + result);
        } 
        else {
            System.out.println("Invalid Choice!");
        }

        sc.close();
    }
}
