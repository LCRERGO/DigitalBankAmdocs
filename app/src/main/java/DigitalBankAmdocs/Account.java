package DigitalBankAmdocs;

import static java.lang.Math.pow;
import static java.lang.Math.abs;

public abstract class Account implements IAccount {
    private static final int DEFAULT_AGENCY = 1000;
    private static long SEQUENCE_NUMBER = 42;

    protected int agency;
    protected int number;
    protected double balance;
    protected Client client;

    public Account(Client client) {
        agency = Account.DEFAULT_AGENCY;
        number = abs((int)getSequenceNumber() % 4000000);
        this.client = client;
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
        System.out.println("Holder: " +  client.getName());
        System.out.println("Agency: " + agency);
        System.out.println("Number: " +  number);
        System.out.println("Balance: " + balance);
    }

    private long getSequenceNumber() {
        final long modulus = (long)pow(2, 48);
        final long a = 252149039;
        final long c = 11;

        SEQUENCE_NUMBER = ((a * SEQUENCE_NUMBER + c) % modulus);
        return SEQUENCE_NUMBER;
    }
}
