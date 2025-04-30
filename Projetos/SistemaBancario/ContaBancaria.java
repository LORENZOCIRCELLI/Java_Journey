import java.io.Serializable;

public interface ContaBancaria extends Serializable {

    int getAccount_number();
    int getPassword();
    double getBalance();
    Cliente getClient();
    String getType();
    

    void addBalance(double amount);
    void withdraw(double amount);
    void transfer(ContaBancaria destinationAccount, double amount);

}
