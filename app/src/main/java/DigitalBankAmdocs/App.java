/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package DigitalBankAmdocs;

public class App {
    public static void main(String[] args) {
        Client venilton = new Client("Venilton");

        Account cc = new CheckingAccount(venilton);
        Account savings = new SavingsAccount(venilton);
        System.out.println(venilton.getName());

        cc.deposit(100);
        cc.transfer(100, savings);

        cc.printExtract();
        savings.printExtract();
    }
}
