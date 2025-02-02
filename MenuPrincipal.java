import java.util.Scanner;

public class MenuPrincipal {
    Scanner entrada = new Scanner(System.in);
    ContaCorrente contaCorrente = new ContaCorrente();
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
                    //exibeMenuContaPoupanca();
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
        if (contaCorrente.saldo == 0.0) {
            System.out.print("Digite o valor incial da Conta Corrente do Ninja: ¥");
            contaCorrente.saldo = entrada.nextDouble();
        }
        System.out.println("----------|CONTA CORRENTE|----------");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Depositar");
        System.out.println("3 - Voltar");
        System.out.println("------------------------------------");

        System.out.print("Digite a sua opção desejada: ");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                System.out.printf("Saldo Atual do Ninja: ¥%.2f\n", contaCorrente.saldo);
                break;
        }
    }
}
