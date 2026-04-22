package entidade;

public class Corrente extends Conta {
    private float limite;
    private Investimento investimento;

    public Corrente(Cliente cliente,
                    String agencia,
                    String numero) {
        super(cliente, agencia, numero);
        this.limite = 1000.0f;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

    public boolean sacar(float valor) {
        //tem saldo?
        boolean resposta = super.sacar(valor);
        if (resposta) return true;
        //n"ao tem saldo, mas tem saldo + investimento
        if (saldo + investimento.getSaldo() >= valor ) {
            investimento.sacar(valor-this.saldo);
            this.saldo = 0;
            return true;
        }
        //não tem saldo, mas tem saldo+limite+investimeto
        if (saldo + limite + investimento.getSaldo() >= valor) {
            //TODO?? fome
            limite -= (valor-saldo);
            saldo =0;
            return true;
        }
        return false;
    }
}
