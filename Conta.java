public interface Conta {
    double consultarSaldo();
    double depositar(double valor);
    double transferir(ContaBancaria contaBancaria, double valorTransferencia);
    TipoConta exibeTipoConta();
}
