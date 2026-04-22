package servico;

import entidade.Cliente;
import entidade.Conta;
import entidade.Corrente;

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


    public boolean sacarValor(Cliente cliente, float valor) {
        return cliente.getConta().sacar(valor);
    }
}
