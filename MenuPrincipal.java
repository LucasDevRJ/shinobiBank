import java.util.Scanner;

public class MenuPrincipal {
    Scanner entrada = new Scanner(System.in);
    public void exibeMenuPrincipal() {
        int opcao;
        do {
            System.out.println("----------|ESCOLHA SUA CONTA|----------");
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
                    finalizaPrograma();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 3);
    }
}
