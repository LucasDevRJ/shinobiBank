public abstract class ContaBancaria implements Conta {
    public double saldo;
    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public double consultarSaldo() {
        return this.saldo;
    }
}
