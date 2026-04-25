package servico;
import entidade.*;

import java.util.ArrayList;
import java.util.List;

public class InvestimentoService {
    private List<Investimento> investimentos = new ArrayList<>();

    public void fazerInvestimento(Cliente cliente, float valor){
        Conta conta = cliente.getConta();
        float saldo = conta.getSaldo();
        if(saldo < valor){
            System.out.println("Valor insuficiene");
            return;
        }
        Investimento invest = new Investimento(cliente, conta.getAgencia(), conta.getNumero());
        investimentos.add(invest);
        System.out.println("Investimento Feito");

    }
}
