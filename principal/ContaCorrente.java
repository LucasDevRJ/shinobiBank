package principal;

public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(TipoConta tipoConta) {
        super(tipoConta);
    }

    public double calculaTaxa() {
        return 1.0 / 100;
    }

    @Override
    public double depositar(double valor) {
        double taxa = 0.01;
        double valorDaTaxa = valor * taxa;
        valor -= valorDaTaxa;
        super.saldo += valor;
        return super.saldo;
    }
}
