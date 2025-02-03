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
//        this.saldo -= valorTransferencia;
//        contaBancaria.saldo += valorTransferencia;
//        return valorTransferencia;
        contaBancaria.saldo += valorTransferencia;
        System.out.println(contaBancaria.saldo);
        this.saldo -= valorTransferencia;
        System.out.println(contaBancaria.saldo);
        return valorTransferencia;
    }
    @Override
    public TipoConta exibeTipoConta() {
        return this.tipoConta;
    }
}
