package entidade;

public class Conta {
    protected Cliente cliente;
    protected String agencia;
    protected String numero;
    protected float saldo;

    public Conta (Cliente cliente,
                  String agencia,
                  String numero) {
        this.cliente=cliente;
        this.agencia=agencia;
        this.numero = numero;
        saldo = 0;
    }

    public boolean sacar(float valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return  true;
        }
        return false;
    }

    public void depositar(float valor) {
        saldo += valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                ", agencia='" + agencia + '\'' +
                ", numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
