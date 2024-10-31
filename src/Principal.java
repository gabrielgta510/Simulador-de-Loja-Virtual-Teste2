import control.GerenciamentoCliente;
import control.GerenciamentoLoja;
import java.util.ArrayList;
import java.util.Arrays;
import model.CarrinhoDeCompras;
import model.CartaoDeCredito;
import model.Cliente;
import model.Endereco;
import model.Item;
import model.Pedido;
import model.Produto;
import view.TelaCliente;
import view.TelaPrincipal;

public class Principal {

    //Contas já existentes para testes.



    /*
     * Método apenas para escrever menu na tela.
     */

    public static void main(String[] args) throws InterruptedException {
        //GerenciamentoCliente gerenciamentoUsuario = new GerenciamentoCliente();
        //TelaPrincipal.mostraMenuInicial();
        
        Produto produto1 = new Produto("Camiseta", 10, 15.99f, 1);
        Produto produto2 = new Produto("Calça Jeans", 15, 59.99f, 2);
        Produto produto3 = new Produto("Tênis", 8, 79.99f, 3);
        Produto produto4 = new Produto("Boné", 20, 9.99f, 4);
        Produto produto5 = new Produto("Relógio", 13, 199.99f, 5);
        Produto produto6 = new Produto("Óculos de sol", 15, 49.99f, 6);
        Produto produto7 = new Produto("Chinelo", 12, 19.99f, 7);
        Produto produto8 = new Produto("Meia", 30, 3.99f, 8);
        Produto produto9 = new Produto("Cueca", 25, 9.99f, 9);
        Produto produto10 = new Produto("Tênis", 8, 79.99f, 10);

        GerenciamentoLoja.cadastrarProduto(produto1);
        GerenciamentoLoja.cadastrarProduto(produto2);
        GerenciamentoLoja.cadastrarProduto(produto3);
        GerenciamentoLoja.cadastrarProduto(produto4);
        GerenciamentoLoja.cadastrarProduto(produto5);
        GerenciamentoLoja.cadastrarProduto(produto6);
        GerenciamentoLoja.cadastrarProduto(produto7);
        GerenciamentoLoja.cadastrarProduto(produto8);
        GerenciamentoLoja.cadastrarProduto(produto9);
        GerenciamentoLoja.cadastrarProduto(produto10);

        Item item1 = new Item(produto5, 1);
        Item item2 = new Item(produto3, 1);
        Item item3 = new Item(produto7, 1);
        Item item4 = new Item(produto9, 1);
        Item item5 = new Item(produto2, 1);

        //====================================================================================== EXEMPLOS CRIADOS PELO GÊPETÔ!!!! =========================================================================
        Endereco endereco1 = new Endereco("Centro", "Maceió", "AL", "101", "Rua Principal");
        Endereco endereco2 = new Endereco("Jardins", "São Paulo", "SP", "202", "Avenida Paulista");
        Endereco endereco3 = new Endereco("Ipanema", "Rio de Janeiro", "RJ", "303", "Rua Visconde");
        
        CartaoDeCredito cartao1 = new CartaoDeCredito("João Silva", "1234567890123456", "12/25", "123");
        CartaoDeCredito cartao2 = new CartaoDeCredito("Maria Souza", "2345678901234567", "11/24", "456");

        ArrayList<Item> produtosPedido1 = new ArrayList<>(); // Supondo que a classe Item esteja definida
        produtosPedido1.add(item5);
        produtosPedido1.add(item2);
        produtosPedido1.add(item1);
        double valorTotal1 = 0;
        for (Item item : produtosPedido1) {
            valorTotal1 += item.getQuantidade() * item.getValor();
        }
        ArrayList<Item> produtosPedido2 = new ArrayList<>();
        produtosPedido1.add(item3);
        produtosPedido1.add(item4);
        double valorTotal2 = 0;
        for (Item item : produtosPedido2) {
            valorTotal2 += item.getQuantidade() * item.getValor();
        }

        Pedido pedido1 = new Pedido(endereco1, cartao1, 143, "Entregue", produtosPedido1, valorTotal1);
        Pedido pedido2 = new Pedido(endereco2, cartao2, 245, "Enviado", produtosPedido2, valorTotal2);

        ArrayList<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("joao.silva@example.com", "senha123", "João Silva", "123.456.789-00", "99999-9999", new ArrayList<>(Arrays.asList(endereco1)), "01/01/1980", new ArrayList<>(Arrays.asList(cartao1)), new ArrayList<>(Arrays.asList(pedido1))),
            new Cliente("maria.souza@example.com", "senha456", "Maria Souza", "234.567.890-01", "98888-8888", new ArrayList<>(Arrays.asList(endereco2)), "02/02/1990", new ArrayList<>(Arrays.asList(cartao2)), new ArrayList<>(Arrays.asList(pedido2))),
            new Cliente("carlos.lima@example.com", "senha789", "Carlos Lima", "345.678.901-23", "97777-7777", new ArrayList<>(Arrays.asList(endereco3)), "03/03/1985", new ArrayList<>(Arrays.asList(cartao1, cartao2)), new ArrayList<>(Arrays.asList(pedido1, pedido2)))));
        GerenciamentoCliente.setUsuarios(clientes);
        // Print ou utilize os objetos conforme necessário
        TelaPrincipal.mostraMenuInicial();

        ArrayList<Item> listaVazia = new ArrayList<>();
        CarrinhoDeCompras novoCarrinho = new CarrinhoDeCompras(listaVazia, null);
        TelaCliente.mostraMenuUsuario(novoCarrinho);
        /*     Teste da tela de finalizar compra   
        String email = "joao.silva@example.com";
        String senha = "senha123";
        Object novoCliente1 = GerenciamentoCliente.verificarLogin(email, senha);
        Item item1 = new Item(produto10, 1);
        produtosPedido.add(item1);
        Object CarrinhoDeCompras = new CarrinhoDeCompras(produtosPedido, senha);
        TelaCliente.mostrarTelaFinalizandoCompra((CarrinhoDeCompras) CarrinhoDeCompras, (Cliente) novoCliente1);
        */
    }
}