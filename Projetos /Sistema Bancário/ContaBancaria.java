import java.io.Serializable;

public interface ContaBancaria extends Serializable {

    int getAccount_number();
    double getBalance();
    Cliente getClient();

    void addBalance(double amount);
    void withdraw(double amount);
    void transfer(ContaBancaria destinationAccount, double amount);

}
