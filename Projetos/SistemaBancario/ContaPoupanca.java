public class ContaPoupanca implements ContaBancaria{

    
    private int account_number;
    private double balance;
    private Cliente client;
    private int password;

    public ContaPoupanca(int account_number, double balance, Cliente client) {
        this.account_number = account_number;
        this.balance = balance;
        this.client = client;
    }

    public ContaPoupanca(int account_number, float balance, Cliente client, int password) {
        this.account_number = account_number;
        this.balance = balance;
        this.client = client;
        this.password = password;
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

    public void setPassword(int password){

        this.password = password;

    }

    @Override
    public int getPassword() {

        return password;

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
    public String getType(){
    
        String type = "Conta Poupança";
        return type;
    
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

