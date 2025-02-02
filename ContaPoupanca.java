public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca() {

    }
    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    @Override
    public double depositar(double valor) {
        super.saldo += valor;
        return super.saldo;
    }
}
