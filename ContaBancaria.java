public abstract class ContaBancaria implements Conta {
    public double saldo;
    TipoConta tipoConta;
    public ContaBancaria() {

    }
    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public double consultarSaldo() {
        return this.saldo;
    }
}
