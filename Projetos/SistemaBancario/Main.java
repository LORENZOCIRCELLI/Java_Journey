import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner input = new Scanner(System.in);
        Loading loading = new Loading();
        Banco banco = new Banco();
        MenuInicial menu = new MenuInicial();
        Tools tools = new Tools();
        banco.carregarContas();

        String CPF;
        int password;

        menu.menuInicial();

        System.out.println("\n\n");

        boolean ctrl = true;
        boolean ctrl2 =true;

        while (ctrl) {

            System.out.println("Escolha uma opção: ");
            System.out.println("1. Criar Conta");
            System.out.println("2. Entrar");
            System.out.println("9. Sair");
            System.out.print("Digite a opção desejada: ");
            
            ctrl2 =true;

            int option = input.nextInt();
            input.nextLine(); // Limpa o buffer após o nextInt()
            

            switch (option) {

                case 1 -> {
                    tools.cleanScreen();
                    System.out.println("\nBem-vindo! Será um prazer tê-lo conosco!");
                    System.out.println("Vamos começar?");
                    banco.createClient();
                    System.out.println("Seja bem-vindo!");
                }

                case 2 -> {
                    System.out.println("Bem-vindo de volta! Que bom que você está aqui!");

                    System.out.print("Digite seu CPF: ");
                    CPF = input.nextLine();

                    System.out.print("Digite sua senha: ");
                    password = input.nextInt();

                    while (ctrl2) {
                        System.out.println("\nO que você deseja fazer?");
                        System.out.println("1. Depositar");
                        System.out.println("2. Sacar");
                        System.out.println("3. Transferir");
                        System.out.println("4. Listar Contas");
                        System.out.println("5. Voltar");
                        System.out.print("Digite a opção desejada: ");
                    
                        int accountOption = input.nextInt();
                    
                        switch (accountOption) {
                            case 1 -> {
                                System.out.print("Digite o número da sua conta: ");
                                int accountNumber = input.nextInt();
                                banco.depositCorrente(CPF, accountNumber, password);
                            }
                            case 2 -> {
                                System.out.print("Digite o número da sua conta: ");
                                int accountNumber = input.nextInt();
                                banco.withdrawCorrente(CPF, accountNumber, password);
                            }
                            case 3 -> {
                                System.out.println("Função de transferência ainda não implementada.");
                            }
                            case 4 -> {
                                banco.listContas(CPF, password);
                            }
                            case 5 -> {
                                System.out.println("Voltando ao menu principal...");
                                ctrl2 = false;
                            }
                            default -> {
                                System.out.println("Opção inválida.");
                            }
                        }
                    }
                }
                    

                case 9 -> {
                    System.out.println("Obrigado por usar nosso sistema! Até logo!");
                    ctrl = false;
                    banco.salvarContas();
                }

                default -> {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }

        input.close();
    }
}
