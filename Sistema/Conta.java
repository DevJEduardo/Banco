package Sistema;

public class Conta {

    private int numero, digito;

    private String cliente, TipoConta;

    private Double saldo = 500.0;

    private Double limite = 1000.0;

    public Conta(int numero, int digito, String cliente, String tipoConta) {
        this.numero = numero;
        this.digito = digito;
        this.cliente = cliente;
        TipoConta = tipoConta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoConta() {
        return TipoConta;
    }

    public void setTipoConta(String tipoConta) {
        TipoConta = tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public void deposita (float valor) {
        this.saldo += valor;
    }

    public boolean saca (float valor) {
        if (this.saldo == 0 || this.saldo < valor) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    public boolean transfere (Conta destinatario, float valor) {
        boolean retirou = this.saca(valor);
        if (!retirou) {
            return false;
        } else {
            destinatario.deposita(valor);
            return true;
        }
    }
}