package principal;

import java.util.Scanner;

public class MenuPrincipal {
    Scanner entrada = new Scanner(System.in);
    ContaCorrente contaCorrente = new ContaCorrente(TipoConta.CORRENTE);
    ContaPoupanca contaPoupanca = new ContaPoupanca(TipoConta.POUPANCA);
    boolean programaFinalizado = false;
    public void exibeMenuPrincipal() {
        while (!programaFinalizado) {
            System.out.println("----------|SHINOBI BANK|----------");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");
            System.out.println("3 - Sair");
            System.out.println("---------------------------------------");
            System.out.print("Digite a sua opção desejada: ");
            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    exibeMenuConta(contaCorrente);
                    break;
                case 2:
                    exibeMenuConta(contaPoupanca);
                    break;
                case 3:
                    finalizaPrograma();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void exibeMenuConta(ContaBancaria contaBancaria) {
        verificaSaldoIgualZero(contaBancaria);
        ContaBancaria outraConta = retornaOutraConta(contaBancaria);
        int opcao;
        do {
            System.out.printf("----------|CONTA %s|----------\n", contaBancaria.retornaTipoConta());
            System.out.printf("1 - Consultar Saldo da Conta %s\n", contaBancaria.retornaTipoConta());
            System.out.printf("2 - Depositar na Conta %s\n", contaBancaria.retornaTipoConta());
            System.out.printf("3 - Transferir para Conta %s\n", outraConta.retornaTipoConta());
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
                case 4:
                    exibeMenuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
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

    public ContaBancaria retornaOutraConta(ContaBancaria contaBancaria) {
        TipoConta tipoContaReceber = contaBancaria.retornaTipoConta() == TipoConta.CORRENTE ? TipoConta.CORRENTE : TipoConta.POUPANCA;
        if (tipoContaReceber == TipoConta.CORRENTE) {
            contaBancaria = contaPoupanca;
        } else {
            contaBancaria = contaCorrente;
        }
        return contaBancaria;
    }

    public void consultarSaldo(ContaBancaria contaBancaria) {
        System.out.printf("Saldo Atual do Ninja: ¥%.2f\n", contaBancaria.consultarSaldo());
    }
    public void depositar(ContaBancaria contaBancaria) {
        System.out.print("Digite o valor do deposito da Conta do Ninja: ¥");
        double deposito = entrada.nextDouble();

        System.out.printf("O valor de ¥%.2f foi depositado com sucesso.\n", deposito);

        if (contaBancaria.retornaTipoConta() == TipoConta.CORRENTE) {
            contaCorrente.depositar(deposito);
            double taxa = contaCorrente.calculaTaxa();
            double valorDepositoTaxa = deposito * taxa;
            double valorDepositoAposTaxa = deposito - valorDepositoTaxa;
            System.out.printf("Valor da taxa %.2f%% do deposito: ¥%.2f.\n", taxa*100, valorDepositoTaxa);
            System.out.printf("Valor após a taxa depositado: ¥%.2f.\n", valorDepositoAposTaxa);
        } else {
            contaPoupanca.depositar(deposito);
        }
    }
    public void transferir(ContaBancaria contaBancaria) {
        ContaBancaria outraConta = retornaOutraConta(contaBancaria);

        System.out.print("Digite o valor da transferência para a Conta Poupança: ¥");
        double valorTransferencia = entrada.nextDouble();

        while (valorTransferencia <= 0.0 || valorTransferencia > contaBancaria.saldo) {
            System.out.println("Valor invalido ou saldo insuficiente.");
            consultarSaldo(contaBancaria);
            System.out.print("Digite o valor da transferência: ¥");
            valorTransferencia = entrada.nextDouble();
        }

        double valorTransferido = contaBancaria.transferir(outraConta, valorTransferencia);
        System.out.printf("Valor Transferido da Conta %s: ¥%.2f\n",contaBancaria.retornaTipoConta(), valorTransferido);
        System.out.println("Tipo de Conta a Receber: " + outraConta.retornaTipoConta());
    }

    public void finalizaPrograma() {
        programaFinalizado = true;
        System.out.println("Programa finalizado.");
    }
}
