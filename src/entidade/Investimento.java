package entidade;

public class Investimento extends Conta{
    private float txRendimento;
    private float rendimentos;

    public Investimento(Cliente cliente,
                        String agencia,
                        String numero) {
        super(cliente, agencia, numero);
        txRendimento = 0.1485f/365;
        rendimentos = 0;
    }

    public float getSaldo() {
        return saldo + rendimentos;
    }
    public void render() {
        float rendeu = this.saldo * txRendimento;
        this.rendimentos += rendeu;
    }

    public boolean sacar (float valor) {
        if (saldo + rendimentos >= valor){
            float proporcao = valor / (saldo + rendimentos);
            float saqueRendimento = (rendimentos*proporcao);

            saldo = saldo - (saldo*proporcao);
            rendimentos = rendimentos - (saqueRendimento -
                        (saqueRendimento*0.15f));

            return true;
        }
        return false;

    }
}
