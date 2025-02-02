import java.util.Scanner;

public class MenuPrincipal {
    Scanner entrada = new Scanner(System.in);
    ContaCorrente contaCorrente = new ContaCorrente(TipoConta.CORRENTE);
    ContaPoupanca contaPoupanca = new ContaPoupanca(TipoConta.POUPANCA);

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
                    exibeMenuConta(contaCorrente);
                    break;
                case 2:
                    exibeMenuConta(contaPoupanca);
                    break;
                case 3:
                    //finalizaPrograma();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 3);
    }

    public void exibeMenuConta(ContaBancaria contaBancaria) {
        verificaSaldoIgualZero(contaBancaria);
        TipoConta tipoContaTransferir = contaBancaria.tipoConta == TipoConta.CORRENTE ? TipoConta.POUPANCA : TipoConta.CORRENTE;
        int opcao;
        do {
            System.out.printf("----------|CONTA %s|----------\n", contaBancaria.tipoConta);
            System.out.printf("1 - Consultar Saldo da Conta %s\n", contaBancaria.tipoConta);
            System.out.printf("2 - Depositar na Conta %s\n", contaBancaria.tipoConta);
            System.out.printf("3 - Transferir para Conta %s\n", tipoContaTransferir);
            System.out.println("4 - Voltar");
            System.out.println("------------------------------------");

            System.out.print("Digite a sua opção desejada: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    consultarSaldo(contaCorrente);
                    break;
                case 2:
                    depositar(contaPoupanca);
                    break;
                case 3:
                    transferir(contaPoupanca);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }

//    public void exibeMenuContaPoupanca() {
//        verificaSaldoIgualZero(contaPoupanca);
//
//        int opcao;
//        do {
//            System.out.println("----------|CONTA POUPANÇA|----------");
//            System.out.println("1 - Consultar Saldo");
//            System.out.println("2 - Depositar");
//            System.out.println("3 - Voltar");
//            System.out.println("------------------------------------");
//
//            System.out.print("Digite a sua opção desejada: ");
//            opcao = entrada.nextInt();
//
//            switch (opcao) {
//                case 1:
////                    consultarSaldo();
//                    break;
//                case 2:
////                    depositarContaCorrente();
//                    break;
//                case 3:
////                    exibeMenuPrincipal();
//                    break;
//                default:
//                    System.out.println("Opção inválida.");
//            }
//        } while (opcao != 3);
//    }
    public double verificaSaldoIgualZero(ContaBancaria conta) {
        if (conta.saldo == 0.0) {
            do {
                System.out.print("Digite o valor valido(positivo) e inicial da Conta Corrente do Ninja: ¥");
                conta.saldo = entrada.nextDouble();
            } while (conta.saldo <= 0);
        }
        return conta.saldo;
    }

    public void consultarSaldo(ContaBancaria contaBancaria) {
        System.out.printf("Saldo Atual do Ninja: ¥%.2f\n", contaBancaria.consultarSaldo());
    }
    public void depositar(ContaBancaria contaBancaria) {
        System.out.print("Digite o valor do deposito da Conta do Ninja: ¥");
        double deposito = entrada.nextDouble();
        double valorDepositado;
        if (contaBancaria.tipoConta == TipoConta.CORRENTE) {
            valorDepositado = contaCorrente.depositar(deposito);
        } else {
            valorDepositado = contaPoupanca.depositar(deposito);
        }
        System.out.printf("O valor de ¥%.2f foi depositado com sucesso.\n", valorDepositado);
    }
    public void transferir(ContaPoupanca contaPoupanca) {
        System.out.print("Digite o valor da transferência para a Conta Poupança: ¥");
        double valorTransferencia = entrada.nextDouble();

        while (valorTransferencia <= 0.0 || valorTransferencia > contaCorrente.saldo) {
            System.out.println("Valor invalido ou saldo insuficiente.");
            consultarSaldo(contaCorrente);
            System.out.print("Digite o valor da transferência: ¥");
            valorTransferencia = entrada.nextDouble();
        }

        double valorTransferido = contaCorrente.transferir(contaPoupanca, valorTransferencia);
        System.out.println("Valor Transferido para a Conta Poupança: ¥" + valorTransferido);
        System.out.println("Tipo de Conta a Receber: " + contaPoupanca.tipoConta);
    }
    public void transferir(ContaCorrente contaCorrente) {
        System.out.print("Digite o valor da transferência para a Conta Corrente: ¥");
        double valorTransferencia = entrada.nextDouble();

        while (valorTransferencia <= 0.0 || valorTransferencia > contaPoupanca.saldo) {
            System.out.println("Valor invalido ou saldo insuficiente.");
            consultarSaldo(contaPoupanca);
            System.out.print("Digite o valor da transferência: ¥");
            valorTransferencia = entrada.nextDouble();
        }

        double valorTransferido = contaPoupanca.transferir(contaCorrente, valorTransferencia);
        System.out.println("Valor Transferido para a Conta Corrente: ¥" + valorTransferido);
        System.out.println("Tipo de Conta a Receber: " + contaCorrente.tipoConta);
    }
}
