public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    @Override
    public double depositar(double valor) {
        return 0;
    }
}
