package control;

import java.util.ArrayList;
import java.util.Scanner;
import model.CarrinhoDeCompras;
import model.CartaoDeCredito;
import model.Cliente;
import model.Endereco;
import model.Item;
import model.Pedido;
import view.TelaCliente;
/*
 * Todo gerenciamento de usuários será por essa classe de controle
 */
public class GerenciamentoCliente {
    public static final Scanner input = new Scanner(System.in);
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
        System.out.print("Login: ");
        email = input.nextLine();
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

    public static void setUsuarios(ArrayList<Cliente> usuarios) {
        GerenciamentoCliente.usuarios = usuarios;
    }

    public static void mostrarTelaFinalizandoCompra(CarrinhoDeCompras novoCarrinho, Cliente novoCliente) throws InterruptedException {
        ArrayList<Endereco> listaEnderecos = novoCliente.getEnderecos();
        TelaCliente.imprimirListaDeEnderecos(listaEnderecos);
        if (novoCliente.getEnderecos().isEmpty()) {
            TelaCliente.mostrarCadastroEndereco(novoCliente);
            System.out.println("Novo endereço cadastrado com sucesso!");
            System.out.println("Digite qualquer coisa: ");
            int teste = input.nextInt();
            System.out.println(teste);
            Endereco enderecoSelec = novoCliente.getEnderecos().get(0);
            //(Endereco enderecoEntrega, CartaoDeCredito cartaoPagamento, int numPedido, String statusPedido)
            String statusPedido = "Pedido Criado";
            ArrayList<CartaoDeCredito> listaCartoes = novoCliente.getCartoesSalvo();
            TelaCliente.imprimirListaCartoes(listaCartoes);
            TelaCliente.mostrarCadastroDeCC(novoCliente);
            CartaoDeCredito novoCartao = novoCliente.getCartoesSalvo().get(0);
            ArrayList<Item> produtosPedido = novoCarrinho.getItens();
            double valorTotal = 0;
            for (Item item : produtosPedido) {
                valorTotal += item.getQuantidade() * item.getQuantidade();
            }
            Pedido novoPedido = new Pedido(enderecoSelec, novoCartao, 1, statusPedido, produtosPedido, valorTotal);
            novoCliente.addPedido(novoPedido);
            System.out.println("Pedido conclído com sucesso!");
            ArrayList<Item> novoItem = new ArrayList<>();            
            CarrinhoDeCompras novoCarrinhoDeCompras = new CarrinhoDeCompras(novoItem, statusPedido);
            TelaCliente.mostraMenuUsuario(novoCarrinhoDeCompras);
        } else {
            System.out.println("Deseja cadastrar um novo endereço? [S/N]");
            String teste = input.nextLine().toUpperCase();
            if ("S".equals(teste)) {
                TelaCliente.mostrarCadastroEndereco(novoCliente);
                System.out.println("Digite qualquer coisa: ");
                String avan = input.nextLine();
                System.out.println(avan);
                ArrayList<Endereco> listaEnderecos2 = novoCliente.getEnderecos();
                TelaCliente.imprimirListaDeEnderecos(listaEnderecos2);
                System.out.print("Selecione um endereço de entrega: ");
                int num1 = input.nextInt();
                Endereco enderecoSelec = novoCliente.getEnderecos().get(num1-1);
                cadastroCartaoDeCredito(novoCliente, enderecoSelec, novoCarrinho);
            } else {
                System.out.print("Selecione um endereço de entrega: ");
                int num1 = input.nextInt();
                Endereco enderecoSelec = novoCliente.getEnderecos().get(num1-1);
                cadastroCartaoDeCredito(novoCliente, enderecoSelec, novoCarrinho);
                System.out.println("Digite qualquer coisa para voltar ao ínicio:");
                String qualquer = input.nextLine();
                ArrayList<Item> novoItem = new ArrayList<>();            
                CarrinhoDeCompras novoCarrinhoDeCompras = new CarrinhoDeCompras(novoItem, qualquer);
                TelaCliente.mostraMenuUsuario(novoCarrinhoDeCompras);
            }
        }
    }

    public static void cadastroCartaoDeCredito(Cliente novoCliente, Endereco enderecoSelec, CarrinhoDeCompras novoCarrinho) {
        String teste1 = "S";
        while ("S".equals(teste1)) {
            ArrayList<CartaoDeCredito> listaCartoes = novoCliente.getCartoesSalvo();
            TelaCliente.imprimirListaCartoes(listaCartoes);
            System.out.println("Deseja cadastrar um novo cartão? [S/N]");
            teste1 = input.nextLine().toUpperCase();
            if ("S".equals(teste1)) {
                TelaCliente.mostrarCadastroDeCC(novoCliente);
                ArrayList<CartaoDeCredito> listaCartoes1 = novoCliente.getCartoesSalvo();
                TelaCliente.imprimirListaCartoes(listaCartoes1);
                CartaoDeCredito cartaoCompra = novoCliente.getCartoesSalvo().getLast();
                int num2 = 3;
                String statusPedido = "Peidido Criado!";
                ArrayList<Item> produtosPedido = novoCarrinho.getItens();
                double valorTotal = 0;
                for (Item item : produtosPedido) {
                    valorTotal += item.getQuantidade() * item.getQuantidade();
                }
                Pedido novoPedido = new Pedido(enderecoSelec, cartaoCompra, num2, statusPedido, produtosPedido, valorTotal);
                novoCliente.addPedido(novoPedido);
            } else {
                System.out.print("Selecione um cartão: ");
                int ccSelec = input.nextInt();
                CartaoDeCredito cartaoCompra = novoCliente.getCartoesSalvo().get(ccSelec-1);
                int num2 = 3;
                String statusPedido = "Peidido Criado!";
                ArrayList<Item> produtosPedido = novoCarrinho.getItens();
                double valorTotal = 0;
                for (Item item : produtosPedido) {
                    valorTotal += item.getQuantidade() * item.getQuantidade();
                }
                Pedido novoPedido = new Pedido(enderecoSelec, cartaoCompra, num2, statusPedido, produtosPedido, valorTotal);
                novoCliente.addPedido(novoPedido);
            }
        }
    }

    public static void mostrarClientesCadastrados() {
        int num = 0;
        for (Cliente cliente : usuarios) {
            num += 1;
            System.out.println(num + "° Cliente ===================================");
            System.out.println(cliente);
        }
        System.out.println("Digite para voltar: ");
        String espere = input.nextLine();
        System.out.println(espere);
    }


}
