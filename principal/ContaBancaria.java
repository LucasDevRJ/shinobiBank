package principal;

public abstract class ContaBancaria implements Conta {
    public double saldo;
    TipoConta tipoConta;
    public ContaBancaria(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
    @Override
    public double consultarSaldo() {
        return this.saldo;
    }
    @Override
    public double transferir(ContaBancaria contaBancaria, double valorTransferencia) {
        contaBancaria.saldo += valorTransferencia;
        this.saldo -= valorTransferencia;
        return valorTransferencia;
    }
    @Override
    public TipoConta retornaTipoConta() {
        return this.tipoConta;
    }
}
