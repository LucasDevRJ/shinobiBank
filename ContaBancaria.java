public abstract class ContaBancaria implements Conta {
    public double saldo;
    TipoConta tipoConta;
    public ContaBancaria() {

    }
    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }
    public double consultarSaldo() {
        return this.saldo;
    }

    public double transferir(ContaBancaria contaBancaria, double valorDaTransferencia) {
        contaBancaria.saldo += valorDaTransferencia;
        this.saldo -= valorDaTransferencia;
        return valorDaTransferencia;
    }
}
