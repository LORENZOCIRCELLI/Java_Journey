public class ContaPoupança implements ContaBancaria{
    
    private int account_number;
    private double balance;
    private Cliente client;

    public ContaPoupança(int account_number, float balance, Cliente client) {
        this.account_number = account_number;
        this.balance = balance;
        this.client = client;
    }
    public void setAccount_number(int account_number) {

        this.account_number = account_number;

    }
    public void setBalance(float balance){

        this.balance = balance;

    }

    public void setClient(Cliente client){

        this.client = client;

    }
    @Override
    public int getAccount_number() {

        return account_number;

    }
    @Override
    public double getBalance() {

        return balance;

    }
    @Override
    public Cliente getClient(){

        return client;

    }
    @Override
    public void addBalance(double amount) {

        this.balance += amount;

    }
    @Override
    public void withdraw(double amount) {

        if (amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Saldo insuficiente.");
        }

    }
    @Override
    public void transfer(ContaBancaria destinationAccount, double amount) {

        if (amount <= balance) {
            this.balance -= amount;
            destinationAccount.addBalance(amount);
        } else {
            System.out.println("Saldo insuficiente.");
        }

    }

    @Override
public String toString() {
    return "ContaCorrente{" +
           "Número da Conta=" + getAccount_number() +
           ", Saldo=" + getBalance() +
           ", Cliente=" + getClient().getName() +
           '}';
}

}
