public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(TipoConta tipoConta) {
        super(tipoConta);
    }
    @Override
    public double depositar(double valor) {
        super.saldo += valor;
        return super.saldo;
    }
}
