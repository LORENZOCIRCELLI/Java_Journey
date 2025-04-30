import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Scanner input = new Scanner(System.in);
    private final Random random = new Random();
    private final Loading loading = new Loading();

    private final List<Cliente> clientes = new ArrayList<>();

    Map<Cliente, List<ContaBancaria>> contas = new HashMap<>();

    public void createClient() {

        System.out.println();
        System.out.print("Digite seu nome: ");
        String name = input.next();
        System.out.print("Digite seu CPF: ");
        String cpf = input.next();
        System.out.print("Digite o seu endereço: ");
        input.nextLine(); // consome a quebra de linha pendente
        String adress = input.nextLine();
        System.out.print("Digite uma senha: ");
        int password = input.nextInt();

        Cliente client = new Cliente(name, cpf, adress, password);
        clientes.add(client);

        loading.loadingBar();

        System.out.println("Por padrão, você terá uma conta corrente.");
        int account_number = random.nextInt(10000);
        System.out.println("O número da sua conta é: " + account_number);

        ContaCorrente contaCorrente = new ContaCorrente(account_number, 0, client);
        contas.put(client, new ArrayList<>());
        contas.get(client).add(contaCorrente);
    }

    public void createPoupanca(){

        System.out.println(
            "\nVocê escolheu abrir uma Conta Poupança. Excelente decisão!\n" +
            "\nA Conta Poupança é ideal para quem deseja guardar dinheiro com segurança\n" +
            "e ainda obter rendimentos mensais sobre o valor depositado.\n" +
            "\nBenefícios da Conta Poupança:\n" +
            "- Rendimento automático mensal com base no saldo disponível.\n" +
            "- Sem tarifas de manutenção.\n" +
            "- Perfeita para quem quer começar a economizar.\n" +
            "\nLembre-se:\n" +
            "- O rendimento da poupança pode variar conforme a taxa Selic.\n" +
            "- Mantenha seu CPF e número da conta em segurança.\n" +
            "- Você pode movimentar sua conta a qualquer momento.\n" +
            "\nVamos prosseguir com a criação da sua Conta Poupança...\n");

        System.out.print("Digite o seu CPF: ");
        String cpf = input.next();

        Cliente clienteEncontrado = null;

        for(Cliente cliente : contas.keySet()){

            if(cliente.getCPF().equals(cpf)){
                clienteEncontrado = cliente;
                break;
            }

            if(clienteEncontrado == null){
                System.out.println("Cliente não encontrado. Insira o CPF novamente");
                return;

            }

        }

        List<ContaBancaria> contasDoCliente = contas.get(clienteEncontrado);

        ContaCorrente contaCorrente = null;

        for(ContaBancaria conta : contasDoCliente){

            if(conta instanceof ContaCorrente contaCorrente1){

                contaCorrente = contaCorrente1;

                break;

            }

        }
        
        System.out.println("Você deseja depositar algum valor inicial na sua poupança? (s/n)");

        char resposta = input.next().toLowerCase().charAt(0);

        if(resposta == 's'){

            System.out.println("Seu saldo atual é: " + contaCorrente.getBalance());

            System.out.println("Digite o valo que você deseja depositar: ");
            double valor = input.nextDouble();

            if(valor > contaCorrente.getBalance()){

                System.out.println("Você não possui saldo suficiente na sua conta corrente para fazer esse depósito.");

                while(valor > contaCorrente.getBalance()){

                    System.out.println("Digite o valor que deseja depositar: ");
                    valor = input.nextDouble();

                }

            }

            contaCorrente.withdraw(valor);

            ContaPoupanca contaPoupanca = new ContaPoupanca (contaCorrente.getAccount_number(), valor, clienteEncontrado);

            contas.get(clienteEncontrado).add(contaPoupanca);
            
            System.out.println("Conta Poupança criada com sucesso!");

        }

    }

    public void listContas(String cpf, int password){

        for(Cliente cliente : clientes){

            if(cliente.getCPF().equals(cpf)){
            System.out.println("============================================================");
            System.out.println(cliente.getName());
            System.out.println("============================================================");

            List<ContaBancaria> contasDoCliente = contas.get(cliente);

            for(ContaBancaria conta : contasDoCliente){

                String type = conta.getType();

                System.out.println("============================================================");


                System.out.println("Tipo de conta: " +type);
                System.out.println("Saldo da Conta: " + conta.getBalance());
                System.out.println("Numero da Conta: " + conta.getAccount_number());

                System.out.println("============================================================");


            }

        }

        }

    }

    public void depositCorrente(String cpf, int account_number, int password){

        for(Cliente cliente : clientes){

            if(cliente.getCPF().equals(cpf)){

                if(contas.containsKey(cliente)){

                    List<ContaBancaria> contasDoCliente = contas.get(cliente);

                    for(ContaBancaria conta : contasDoCliente){

                        if(conta.getAccount_number() == account_number){

                            if(conta.getClient().getPassword() == password){
    
                                System.out.println("O seu saldo atual é: " +conta.getBalance());
                                System.out.print("Digite o valor que você deseja depositar: ");
                                double amount = input.nextDouble();

                                conta.addBalance(amount);

                                System.out.println("Deposito realizado com sucesso!");
                                System.out.println("O seu saldo após o depósito é: " +conta.getBalance());



                        }else{

                            System.out.println("Senha Incorreta!");
                            return;

                        }

                        }else{

                            System.out.println("Conta não encontrada");
                            return;

                        }

                    }


                }else{

                    System.out.println("Cliente não encontrado");
                    return;

                }

            }

        }

    }

    public void depositPoupanca(String cpf, int account_number, int password){

        for(Cliente cliente : clientes){

            if(cliente.getCPF().equals(cpf)){

                if(contas.containsKey(cliente)){

                    List<ContaBancaria> contasDoCliente = contas.get(cliente);

                    for(ContaBancaria conta : contasDoCliente){

                        if(conta.getAccount_number() == account_number){

                            if(conta.getPassword() == password){

                                System.out.println("O seu saldo atual é: " + conta.getBalance());
                                System.out.println("Insira o valor que você quer adicionar na sua conta poupança: ");
                                double amount = input.nextDouble();

                                System.out.println("O seu saldo atual após o depósito é: ");

                            }

                        }



                    }

                }

            }

        }

    }

    public void withdrawCorrente(String cpf, int account_number, int password){

        for(Cliente cliente : clientes){

            if(cliente.getCPF().equals(cpf)){

                List<ContaBancaria> contasDoCliente = contas.get(cliente);

                for(ContaBancaria conta : contasDoCliente){

                    if(conta.getAccount_number() == account_number){

                        if(conta.getClient().getPassword() == password){

                            System.out.println("O seu saldo atual é: " + conta.getBalance());
                            System.out.print("Digite o valor que você deseja retirar: ");
                            double value = input.nextDouble();

                            if(value <= conta.getBalance()){

                                conta.withdraw(value);

                                System.out.println("Retirada realizada com sucesso!");
                                System.out.println("O seu saldo após a retirada é: " + conta.getBalance());

                            }

                        } else {

                            System.out.println("Senha incorreta.");
                            return;

                        }

                    }else{

                        System.out.println("Conta não encontrada.");
                        return;

                    }


                }
                

            }else{

                System.out.println("Cliente não encontrado.");
                return;
            }

        }

    }

    public void witdhdrawPoupanca(String cpf, int account_number, int password){

        for(Cliente cliente : clientes){

            if(cliente.getCPF().equals(cpf)){

                List<ContaBancaria> contas = this.contas.get(cliente);

                for(ContaBancaria conta : contas){

                    if(conta.getAccount_number() == account_number) {

                        if(conta.getClient().getPassword() == password){

                            System.out.println("O seu saldo atual é: " + conta.getBalance());
                            System.out.print("Digite o valor que você deseja retirar: ");
                            double value = input.nextDouble();

                            conta.withdraw(value);

                            System.out.println("Retirada realizada com sucesso!");
                            System.out.println("O seu saldo após a retirada é: " + conta.getBalance());

                        } else {

                            System.out.println("Senha incorreta.");

                        }

                    }else{

                        System.out.println("Conta não encontrada.");
                        return;

                    }

                }

            }else{

                System.out.println("Cliente não encontrado.");
                return;

            }

        }

    }

    public ContaBancaria searchAccount(String clientCpf, String account_number) {
        for (Cliente cliente : clientes) {
            if (cliente.getCPF().equals(clientCpf)) {
                List<ContaBancaria> contasDoCliente = contas.get(cliente);
                if (contasDoCliente != null) {
                    for (ContaBancaria conta : contasDoCliente) {
                        if (conta.getAccount_number() == Integer.parseInt(account_number)) {
                            System.out.println("Conta encontrada: " + conta);
                            return conta;
                        }
                    }
                    System.out.println("Conta não encontrada para este cliente.");
                } else {
                    System.out.println("Este cliente não possui contas.");
                }
                return null; // cliente encontrado, mas conta não
            }
        }
    
        System.out.println("Cliente com esse CPF não encontrado.");
        return null; // nenhum cliente encontrado
    }

    public void salvarContas() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contas.dat"))) {
            BancoEstado estado = new BancoEstado(clientes, contas);
            out.writeObject(estado);
            System.out.println("Contas salvas com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar contas: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public void carregarContas() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("contas.dat"))) {
            BancoEstado estado = (BancoEstado) in.readObject();
            this.clientes.clear();
            this.clientes.addAll(estado.clientes);
            this.contas = estado.contas;
            System.out.println("Contas carregadas com sucesso.");
        } catch (Exception e) {
            System.out.println("Nenhuma conta carregada (arquivo pode não existir ou estar corrompido).");
        }
    }
    

}