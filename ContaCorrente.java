public class ContaCorrente extends ContaBancaria {
    public ContaCorrente() {

    }
    public ContaCorrente(double saldo) {
        super(saldo);
    }

    @Override
    public double depositar(double valor) {
        double taxa = 0.01;
        double valorDaTaxa = valor * taxa;
        valor -= valorDaTaxa;
        return valor;
    }
}
