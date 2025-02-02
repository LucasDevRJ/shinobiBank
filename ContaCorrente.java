public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(TipoConta tipoConta) {
        super(tipoConta);
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
