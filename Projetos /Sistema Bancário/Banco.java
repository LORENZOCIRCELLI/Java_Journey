import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Banco implements Serializable{

    Scanner input = new Scanner(System.in);
    Random random = new Random();

    public static final long serialVersionUID = 1L;

    List <ContaBancaria> contas = new ArrayList<>();

    public void addConta(){

            System.out.println("Digite seu nome: ");
            String name = input.next();
            System.out.println("Digite seu CPF: ");
            String cpf = input.next();
            System.out.println("Digite o seu endereço: ");
            String adress = input.next();
            System.out.println("Digte uma senha: ");
            int password = input.nextInt();

            Cliente client = new Cliente(name, cpf, adress);

            System.out.println("Por padrão, você terá uma conta corrente.Posteriormente, você poderá abrir uma conta poupança.");
            int account_number = random.nextInt(10000);
            System.out.println("O número da sua conta é: " + account_number);
            System.out.println("O número da sua conta é pessoal e instransferível. Não compartilhe com ninguém.");
            System.out.println("Você pode depositar, sacar e transferir valores entre contas. Para isso, você precisará do número da conta de destino.");                
            System.out.println("Você pode fazer transferências entre contas do mesmo banco e de bancos diferentes.");

            ContaCorrente contaCorrente = new ContaCorrente(account_number, 0, client);

            contas.add(contaCorrente);

    }
    
    public void addContaPoupanca(Cliente client){

        System.out.println("Qual o valor você deseja adicionar a sua conta poupança?");
        double value = input.nextDouble();

        int account_number = random.nextInt(10000);

        System.out.println("O numero da sua conta poupança sera: " +account_number);

        System.out.println("Você pode depositar, sacar e transferir valores entre contas. Para isso, você precisará do número da conta de destino.");
        System.out.println("Você pode fazer transferências entre contas do mesmo banco e de bancos diferentes.");
        System.out.println("A sua conta poupança rende 1% ao mês.");

        ContaPoupança contaPoupanca = new ContaPoupança(account_number, value, client);
        contas.add(contaPoupanca);

        System.out.println("Conta poupança criada com sucesso!");

    }

    public ContaBancaria searchAccount(int account_number){
        ContaBancaria conta = null;
        for(ContaBancaria contas : contas){

            if(contas.getAccount_number() == account_number){

                System.out.println("Conta encontrada: \n" + conta);
                conta = contas;

            }
        }
        return conta;

    }

    public ContaBancaria searchAccount(String name){

        ContaBancaria conta = null;
        for(ContaBancaria contas : contas){

            if(contas.getClient().getName().equals(name)){

                System.out.println("Conta encontrada: " + conta);
                conta = contas;  

            }

        }
        return conta;

    }

    
}
