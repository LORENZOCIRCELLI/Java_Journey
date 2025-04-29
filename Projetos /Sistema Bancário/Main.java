import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        String sistema = System.getProperty("os.name").toLowerCase();

        try {
            if (sistema.contains("win")) {
                // Windows usa o comando "cls", mas precisa ser executado dentro do cmd
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux e macOS usam "clear"
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        Banco banco = new Banco();

        System.out.println();
        System.out.println();



        String[] asciiArt = {   
            "██████╗  █████╗ ███╗   ██╗██╗  ██╗    ███████╗██╗   ██╗███████╗████████╗███████╗███╗   ███╗",
            "██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝    ██╔════╝╚██╗ ██╔╝██╔════╝╚══██╔══╝██╔════╝████╗ ████║",
            "██████╔╝███████║██╔██╗ ██║█████╔╝     ███████╗ ╚████╔╝ ███████╗   ██║   █████╗  ██╔████╔██║",
            "██╔══██╗██╔══██║██║╚██╗██║██╔═██╗     ╚════██║  ╚██╔╝  ╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║",
            "██████╔╝██║  ██║██║ ╚████║██║  ██╗    ███████║   ██║   ███████║   ██║   ███████╗██║ ╚═╝ ██║",
            "╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝    ╚══════╝   ╚═╝   ╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝",
            "                                                                                           "
        };

        for (String linha : asciiArt) {
            System.out.println(linha);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nSistema carregado! Bem-vindo! 🚀");

        Scanner input = new Scanner(System.in);

        Boolean ctrl = true;

        while(ctrl){

            int option = 0;

            System.out.println();
            System.out.println();

            System.out.println("Escolha uma opção: ");
            System.out.println("1. CRIAR CONTA");
            System.out.println("2. ENTRAR");
            System.out.println("9. SAIR");

            option = input.nextInt();

            switch(option){

                case 1 -> {
                    System.out.println("Bem-vindo! Será um prazer tê-lo conosco!");
                    System.out.println("Vamos começar?");
                    
                    banco.addConta(); // Sem passar contaCorrente
                    

                    System.out.println("Seja bem-vindo!");
                }

                case 2 -> {
                    System.out.println("Bem-vindo de volta! Que bom que você está aqui!");
                    
                    System.out.println("Digite seu CPF: ");
                    input.nextLine(); // Limpa o buffer
                    String CPF  = input.nextLine();
                    
                    System.out.println("Digite sua senha: ");
                    int password = input.nextInt();
                    
                    System.out.println("O que você deseja fazer?");
                    System.out.println("1. Sacar");
                    System.out.println("2. Depositar");
                    System.out.println("3. Transferir");
                    System.out.println("4. Extrato da Conta");
                    System.out.println("5. Sair");
                    
                    int account_option = input.nextInt();
                    
                    switch(account_option){
                        
                        case 1 -> {
                            
                            System.out.println("Digite o número da sua conta: ");
                            int account_number = input.nextInt();
                        
                            ContaBancaria conta = banco.searchAccount(account_number);
                        
                            if (conta != null) {
                                System.out.println("Digite sua senha: ");
                                password = input.nextInt();
                        
                                if (conta.getClient().getPassword() == password) {
                                    System.out.println("O seu saldo atual é: " + conta.getBalance());
                                    System.out.println("Digite o valor que você deseja retirar: ");
                                    double value = input.nextDouble();
                        
                                    conta.withdraw(value);
                        
                                    System.out.println("Depósito realizado com sucesso!");
                                    System.out.println("O seu saldo após o depósito é: " + conta.getBalance());
                                } else {
                                    System.out.println("Senha incorreta.");
                                }
                            } else {
                                System.out.println("Conta não encontrada.");
                            }
                            
                        }
                        
                        case 2 -> {
                            System.out.println("Digite o número da sua conta: ");
                            int account_number = input.nextInt();
                        
                            ContaBancaria conta = banco.searchAccount(account_number);
                        
                            if (conta != null) {
                                System.out.println("Digite sua senha: ");
                                password = input.nextInt();
                        
                                if (conta.getClient().getPassword() == password) {
                                    System.out.println("O seu saldo atual é: " + conta.getBalance());
                                    System.out.println("Digite o valor que você deseja depositar: ");
                                    double value = input.nextDouble();
                        
                                    conta.addBalance(value);
                        
                                    System.out.println("Depósito realizado com sucesso!");
                                    System.out.println("O seu saldo após o depósito é: " + conta.getBalance());
                                } else {
                                    System.out.println("Senha incorreta.");
                                }
                            } else {
                                System.out.println("Conta não encontrada.");
                            }
                        }

                    }

                }

                case 9 -> {
                    System.out.println("Obrigado por usar nosso sistema! Até logo!");
                    ctrl = false;
                    break;
                }

            }

        }

    }
}
