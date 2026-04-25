import servico.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //Criar um banco
        BancoService Banco = new BancoService();

        //Cadastro de Cliente no Banco
        Banco.cadastroConta("05250701256","Douglas Augusto de  Brito e Silva","0","1");
        Banco.cadastroConta("05250701256","Douglas Augusto de  Brito e Silva","0","1");

        //Checar Clientes
        System.out.println(Banco);
        Banco.depositarValor("0","1",900.55f);
        System.out.println(Banco);

        //Criar uma Conta Corrente para o Cliente
        //Fazer um investimento
    }
}