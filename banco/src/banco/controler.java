package banco;
import java.util.Scanner;
public class controler {

	
	Scanner scan = new Scanner(System.in);
	
	private double saldo;
	private double chequeEspecial;
	double valorUsadoChequeEspecial = 0; 
	double deposito;
	double depositoInicial;
	
	
	public void criarConta() {
        System.out.print("Informe o valor de depósito inicial: ");
        depositoInicial = scan.nextDouble();
        if (depositoInicial <= 0) {
            System.out.println("Valor inválido. A conta será criada com saldo zero.");
            saldo = 0;
            chequeEspecial = 0;
        } else {
            saldo = depositoInicial;
            chequeEspecial = calcularChequeEspecial();
        }
        System.out.println("Conta criada com sucesso. Cheque especial: R$ " + chequeEspecial);
    }
	
	
    public void depositar() {
        System.out.print("Informe o valor a ser depositado: ");
        double deposito = scan.nextDouble();
        if (deposito <= 0) {
            System.out.println("Insira um valor válido.");
        } else {
            if (valorUsadoChequeEspecial > 0) {
                double valorComTaxa = valorUsadoChequeEspecial * 1.2;
                if (deposito >= valorComTaxa) {
                    deposito -= valorComTaxa;
                    valorUsadoChequeEspecial = 0;
                    System.out.println("Cheque especial quitado com taxa de 20%.");
                } else {
                    double partePaga = deposito / 1.2;
                    valorUsadoChequeEspecial -= partePaga;
                    deposito = 0;
                    System.out.println("Parte do cheque especial foi paga.");
                }
            }
            saldo += deposito;
            System.out.println("Depósito realizado. Saldo atual: R$ " + saldo);
        }
    }
	
    private double calcularChequeEspecial() {
        if (depositoInicial <= 500.00) {
            return 50.00;
        } else {
            return depositoInicial * 0.5;
        }
    }
	
    public void saque() {
        System.out.print("Informe o valor a ser sacado: ");
        double saque = scan.nextDouble();
        double totalDisponivel = saldo + (chequeEspecial - valorUsadoChequeEspecial);
        if (saque <= saldo) {
            saldo -= saque;
        } else if (saque <= totalDisponivel) {
            double restante = saque - saldo;
            saldo = 0;
            valorUsadoChequeEspecial += restante;
            System.out.println("Usando R$ " + restante + " do cheque especial.");
        } else {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
        }
    }
	public void pagamento() {
		System.out.print("informe o valor do boleto");
		double pagamento  = scan.nextDouble();
		this.saldo = saldo - pagamento;
		 System.out.println("Saldo: R$ " + saldo);
		
	}
	
    public void consultarSaldo() {
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Cheque Especial Disponível: R$ " + (chequeEspecial - valorUsadoChequeEspecial));
        System.out.println("Usado do Cheque Especial: R$ " + valorUsadoChequeEspecial);
    }
    
    public void estaUsandoChequeEspecial() {
        if (valorUsadoChequeEspecial > 0) {
            System.out.println("Você está usando o cheque especial.");
        } else {
            System.out.println("Você não está usando o cheque especial.");
        }
    }
	
	
}

