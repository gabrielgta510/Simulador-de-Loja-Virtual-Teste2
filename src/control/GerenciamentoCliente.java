package control;

import java.util.ArrayList;
import model.CartaoDeCredito;
import model.Cliente;
import model.Endereco;
import model.Item;
import model.Pedido;
import model.Produto;
/*
 * Todo gerenciamento de usuários será por essa classe de controle
 */
public class GerenciamentoCliente {
    public static ArrayList<Cliente> usuarios = new ArrayList<>();
    public static ArrayList<String> listaEmails = new ArrayList<>();

    public static void salvarNovoCartao(Cliente cliente, String nome, String num, String val, String cvc) {
        CartaoDeCredito novoCC = new CartaoDeCredito(nome, num, val, cvc);
        ((Cliente) cliente).addCartao(novoCC);
    }

    public static Object verificarLogin(String email, String senha) {
        for (Cliente clienteCAD : usuarios) {
            if ((clienteCAD.getEmail().equals(email)) && (clienteCAD.getSenha().equals(senha))) {
                return clienteCAD;
            }
        }
        return "E-mail e/ou senha incorreto(s).";
    }

    public static boolean verificaEmail(String email) {
        for (Cliente clienteCAD : usuarios) {
            if ((clienteCAD.getEmail().equals(email))) {
                return true;
            }
        }
        return false;
    }

    public static Object criarContaCliente(String email, String senha, String nomeCliente, String cpf, 
                                        String telefone, ArrayList<Endereco> listaEnderecos, String dataNascimento,
                                        ArrayList<CartaoDeCredito> cartoesSalvo, ArrayList<Pedido> listaPedidos) {
        Cliente novoCliente = new Cliente(email, senha, nomeCliente, cpf, telefone, listaEnderecos, dataNascimento, cartoesSalvo, listaPedidos);
        usuarios.add(novoCliente);
        return novoCliente;
    }

    public static void cadastrarEnderecoCliente(Cliente novoCliente, String bairro, String cidade, String estado, String numLugar, String rua) {
        Endereco novEndereco = new Endereco(bairro, cidade, estado, numLugar, rua);
        novoCliente.addEndereco(novEndereco);
        System.out.println("Endereço cadastrado com sucesso!");
    }

    static String calculaFrete(double valorTotal) {
        if (valorTotal >= 150) {
            return "O frete é grátis!";
        } else {
            return "O frete é R$30.";
        }
    }

    public static void addItemNoCarrinho(Object produto, Integer quantidade) {
        Item itemBuscado = new Item((Produto) produto, quantidade);

    }

    public static void criaCarrinhoDeCompras() {

    }

    public static void setUsuarios(ArrayList<Cliente> usuarios) {
        GerenciamentoCliente.usuarios = usuarios;
    }
}
