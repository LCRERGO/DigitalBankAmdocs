package DigitalBankAmdocs;

public abstract class Account implements IAccount {
    /* TODO: alter sequence number algorithm */
    private static final int DEFAULT_AGENCY = 1;
    private static int SEQUENCE_NUMBER = 1;

    protected int agency;
    protected int number;
    protected double balance;
    protected Client client;

    public Account(Client client) {
        agency = Account.DEFAULT_AGENCY;
        number = SEQUENCE_NUMBER++;
        client = client;
    }

    @Override
    public void withdraw(double value) {
        balance -= value;
    }

    @Override
    public void deposit(double value) {
        balance += value;
    }

    @Override
    public void transfer(double value, IAccount dest) {
        this.withdraw(value);
        dest.deposit(value);
    }

    public int getAgency() { return agency; }
    public int getNumber() { return number; }
    public double getBalance() { return balance; }

    @Override
    public void printExtract() {
        System.out.println(String.format("Holder: %s", client.getName()));
        System.out.println(String.format("Agency: %d", agency));
        System.out.println(String.format("Number: %d", number));
        System.out.println(String.format("Balance: %d", balance));
    }
}
