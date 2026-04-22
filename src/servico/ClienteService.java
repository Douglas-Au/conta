package servico;

import entidade.Cliente;
import entidade.Conta;

public class ClienteService {

    public Cliente cadastraCliente(String cpf, String nome) {
        if (!checaNome(nome)) return null;
        if (!checaCPF(cpf)) return null;
        return new Cliente(cpf, nome);
    }

    public boolean vincularConta(Cliente cliente, Conta conta) {
        if (conta != null)
            if (cliente != null)
                cliente.setConta(conta);

        return true;
    }

    private boolean checaNome(String nome) {
        if (nome.isEmpty()) return false;
        if (nome.split(" ").length ==1) return false;
        return true;
    }

    private boolean checaCPF(String cpf) {
        //TODO
        return true;
    }


}
