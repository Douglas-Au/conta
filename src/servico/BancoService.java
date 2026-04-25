package servico;
import entidade.*;
import java.util.ArrayList;

public class BancoService {
    private ClienteService clienteService;
    private ArrayList<Conta> contas;
    private ArrayList<Cliente> clientes;

    public BancoService() {
        clienteService = new ClienteService();
        contas = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public boolean cadastroConta (String cpf,
                                  String nome,
                                  String agencia,
                                  String numero) {
        Cliente novo = clienteService.cadastraCliente(cpf, nome);

        if (novo != null) {
            clientes.add(novo);
            Conta novaConta = new Corrente(novo,
                    agencia,
                    numero);
            clienteService.vincularConta(novo, novaConta);
            contas.add(novaConta);
            return true;
        }
        return false;

    }

    public boolean sacarValor(String agencia, String numero, float saque){
        if(saque < 0){
            //Valor não autorizado para saque
            return false;
        }
        for(Cliente c: clientes) {
            Conta conta = c.getConta();
            if(conta.getAgencia().equals(agencia) && conta.getNumero().equals(numero)){
                return conta.sacar(saque);
            }
        }
        //Cliente não encontrado
        return false;
    }

    public boolean depositarValor(String agencia, String numero, float deposito){
        if(deposito < 0){
            //Valor não autorizado para deposito
            return false;
        }
        for(Cliente c: clientes) {
            Conta conta = c.getConta();
            if(conta.getAgencia().equals(agencia) && conta.getNumero().equals(numero)){
                conta.depositar(deposito);
                //deposito feito com sucesso
                return true;
            }
        }
        //Cliente não encontrado
        return false;
    }

    @Override
    public String toString() {
        return "BancoService{" +
                "contas=" + contas +
                ", clientes=" + clientes +
                '}';
    }

    public boolean sacarValor(Cliente cliente, float valor) {
        return cliente.getConta().sacar(valor);
    }
}
