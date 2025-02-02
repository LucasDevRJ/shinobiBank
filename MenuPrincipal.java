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
        TipoConta tipoContaTransferir = contaBancaria.tipoConta == TipoConta.CORRENTE ? TipoConta.CORRENTE : TipoConta.POUPANCA;
        if (tipoContaTransferir == TipoConta.CORRENTE) {
            contaBancaria = contaCorrente;
        } else {
            contaBancaria = contaPoupanca;
        }
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
                    consultarSaldo(contaBancaria);
                    break;
                case 2:
                    depositar(contaBancaria);
                    break;
                case 3:
                    transferir(contaBancaria);
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
                conta.saldo = entrada.nextDouble();
            } while (conta.saldo <= 0);
        }
        return conta.saldo;
    }

    public ContaBancaria retornaTipoConta(ContaBancaria contaBancaria) {
        TipoConta tipoContaTransferir = contaBancaria.tipoConta == TipoConta.CORRENTE ? TipoConta.CORRENTE : TipoConta.POUPANCA;
        if (tipoContaTransferir == TipoConta.CORRENTE) {
            contaBancaria = contaCorrente;
        } else {
            contaBancaria = contaPoupanca;
        }
        return contaBancaria;
    }

    public void consultarSaldo(ContaBancaria contaBancaria) {
        System.out.printf("Saldo Atual do Ninja: ¥%.2f\n", contaBancaria.consultarSaldo());
    }
    public void depositar(ContaBancaria contaBancaria) {
        System.out.print("Digite o valor do deposito da Conta do Ninja: ¥");
        double deposito = entrada.nextDouble();
        double taxa = 1.0 / 100;
        double valorDepositoTaxa = deposito * taxa;
        if (contaBancaria.tipoConta == TipoConta.CORRENTE) {
            contaCorrente.depositar(deposito);
        } else {
            contaPoupanca.depositar(deposito);
        }
        System.out.printf("O valor de ¥%.2f foi depositado com sucesso.\n", deposito);
        System.out.printf("Valor da taxa %d%% do deposito: ¥%.2f.\n", 1,  valorDepositoTaxa);
    }
    public void transferir(ContaBancaria contaBancaria) {
        System.out.print("Digite o valor da transferência para a Conta Poupança: ¥");
        double valorTransferencia = entrada.nextDouble();

        contaBancaria = retornaTipoConta(contaBancaria);

        while (valorTransferencia <= 0.0 || valorTransferencia > contaBancaria.saldo) {
            System.out.println("Valor invalido ou saldo insuficiente.");
            consultarSaldo(contaBancaria);
            System.out.print("Digite o valor da transferência: ¥");
            valorTransferencia = entrada.nextDouble();
        }

        double valorTransferido = contaBancaria.transferir(contaBancaria, valorTransferencia);
        System.out.println("Valor Transferido para a Conta Poupança: ¥" + valorTransferido);
        System.out.println("Tipo de Conta a Receber: " + contaBancaria.tipoConta);
    }
}
