import java.util.Scanner;

public class MenuPrincipal {
    Scanner entrada = new Scanner(System.in);
    ContaCorrente contaCorrente = new ContaCorrente();
    ContaPoupanca contaPoupanca = new ContaPoupanca();

    public void exibeMenuPrincipal() {
        int opcao;
        do {
            System.out.println("----------|SHINOBI BANK|----------");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");
            System.out.println("3 - Sair");
            System.out.println("---------------------------------------");
            System.out.print("Digite a sua opção desejada: ");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    exibeMenuContaCorrente();
                    break;
                case 2:
                    exibeMenuContaPoupanca();
                    break;
                case 3:
                    //finalizaPrograma();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 3);
    }

    public void exibeMenuContaCorrente() {
        verificaSaldoIgualZero(contaCorrente);

        int opcao;
        do {
            System.out.println("----------|CONTA CORRENTE|----------");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Voltar");
            System.out.println("------------------------------------");

            System.out.print("Digite a sua opção desejada: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    consultaSaldoContaCorrente();
                    break;
                case 2:
                    depositarContaCorrente();
                    break;
                case 3:
                    exibeMenuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }

    public void exibeMenuContaPoupanca() {
        verificaSaldoIgualZero();

        int opcao;
        do {
            System.out.println("----------|CONTA POUPANÇA|----------");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Voltar");
            System.out.println("------------------------------------");

            System.out.print("Digite a sua opção desejada: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    consultaSaldoContaCorrente();
                    break;
                case 2:
                    depositarContaCorrente();
                    break;
                case 3:
                    exibeMenuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }

    public double verificaSaldoIgualZero(ContaBancaria conta) {
        if (conta.saldo == 0.0) {
            do {
                System.out.print("Digite o valor valido(positivo) e inicial da Conta Corrente do Ninja: ¥");
                contaCorrente.saldo = entrada.nextDouble();
            } while (contaCorrente.saldo <= 0);
        }
        return contaCorrente.saldo;
    }

    public void consultaSaldoContaCorrente() {
        System.out.printf("Saldo Atual do Ninja: ¥%.2f\n", contaCorrente.saldo);
    }

    public void depositarContaCorrente() {
        System.out.print("Digite o valor do deposito da Conta Corrente do Ninja: ¥");
        double deposito = entrada.nextDouble();
        double valorDepositado = contaCorrente.depositar(deposito);
        System.out.printf("O valor de ¥%.2f foi depositado com sucesso.\n", valorDepositado);
    }
}
