import java.io.Serializable;

public class ContaCorrente implements Serializable extends ContaBancaria {
    
    private static final long serialVersionUID = 1L;
    private int account_number;
    private float balance;
    private Cliente client;

    public ContaCorrente(int account_number, float balance, Cliente client) {
        this.account_number = account_number;
        this.balance = balance;
        this.client = client;
    }

    public void setAccount_number(int account_number) {

        this.account_number = account_number;

    }

    public void setBalance(float balance) {

        this.balance = balance;

    }

    public void setClient(Cliente client){

        this.client = client;

    }

    public int getAccount_number() {

        return account_number;

    }

    public double getBalance() {

        return balance;

    }

    public Cliente getClient() {

        return client;

    }

    public void addBalance(double amount) {

        this.balance += amount;

    }

    public void withdraw(double amount) {

        if (amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Saldo insuficiente.");
        }

    }

    public void transfer(ContaBancaria destinationAccount, double amount) {

        if (amount <= balance) {
            this.balance -= amount;
            destinationAccount.addBalance(amount);
        } else {
            System.out.println("Saldo insuficiente.");
        }

    }





}