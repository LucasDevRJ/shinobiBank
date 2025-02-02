public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(double saldo) {
        super(saldo);
    }

    @Override
    public void consultarSaldo() {

    }

    @Override
    public void depositar(double valor) {
        super.saldo += valor;
    }
}
