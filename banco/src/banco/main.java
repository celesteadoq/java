package banco;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        controler conta = new controler();
        Scanner input = new Scanner(System.in);

        conta.criarConta();

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Pagar Boleto");
            System.out.println("5 - Verificar uso do Cheque Especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    conta.depositar();
                    break;
                case 3:
                    conta.saque();
                    break;
                case 4:
                    conta.pagamento();
                    break;
                case 5:
                    conta.estaUsandoChequeEspecial();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        input.close();
    }
}
