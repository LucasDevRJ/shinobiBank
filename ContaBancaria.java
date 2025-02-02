public abstract class ContaBancaria implements Conta {
    public double saldo;
    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public void consultarSaldo() {
        System.out.println("Saldo: ¥" + this.saldo);
    }
}
