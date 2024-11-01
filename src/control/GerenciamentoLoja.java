package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Item;
import model.Produto;

public class GerenciamentoLoja {
    private static ArrayList<Produto> estoque = new ArrayList<>();
    private static Map<Integer, Produto> produtosPorNumero = new HashMap<>();
    private static Integer numero = 10;

    public static Integer getNumero() {
        return numero;
    }

    public static void setNumero() {
        int num = GerenciamentoLoja.getNumero() + 1;
        GerenciamentoLoja.numero = num;
    }

    public static Object buscaProduto(Integer indice) {
        //implementação simples de um buscador.
        Produto produtoBuscado = estoque.get(indice);
        return produtoBuscado;
    }

    public static String verificarEstoque(Object produto, Integer quantidade) {
        Integer qtd = ((Produto) produto).getQuantidade();
        if (quantidade <= qtd) {
            return String.format("%s adicionado ao carrinho com sucesso!", ((Produto) produto).getNomeProduto());
        } else {
            return "Selecione um valor menor!";
        }
    }

    public static void atualizarEstoque(Object produto, Object item) {
        int quantidade = ((Item) item).getQuantidade();
        int qtd = ((Produto) produto).getQuantidade();
        System.out.println("O valor antes: " + qtd);
        ((Produto) produto).setQuantidade(qtd - quantidade);
        System.out.println("O valor depois: " + qtd);
    }

    public static Object criarProduto(String nomeProduto, Integer quantidade, float precoDeCusto) {
        numero += 1;
        Produto novoProduto = new Produto(nomeProduto, quantidade, precoDeCusto, numero);
        return novoProduto;
    }
    
    public static String cadastrarProduto(Object novoProduto) {
        estoque.add((Produto) novoProduto);
        produtosPorNumero.put(numero, (Produto) novoProduto);
        return ((Produto) novoProduto).getNomeProduto() + " foi cadastrado com sucesso!";
    }

    public static String mostrarEstoque() {
        if (estoque.isEmpty()) {
            return "A lista de produtos está vazia.";
        } else {
            // Imprimir a tabela
            System.out.println("Nome:                     |Custo:      |Quantidade:");
            System.out.println("----------------------------------------------------");
            double total = 0;
            for (Produto produto : estoque) {
                String msg = String.format("|R$ %-7.2f  |%d", produto.getPrecoDeCusto(), produto.getQuantidade());
                System.out.println(produto + msg);
                total += produto.getPrecoDeCusto() * produto.getQuantidade();
            }
            System.out.println("----------------------------------------------------");
            return String.format("Total gasto no estoque: R$ %.2f\n", total);
        }
    }

    public static void mostrarProdutosCliente() {
        System.out.println("Produtos:");
        for (Produto produto : estoque) {
            String msg = String.format("|R$ %.2f", produto.getValor());
            System.out.println(produto + msg);
        }
    }

    public static ArrayList<Produto> getEstoque() {
        return estoque;
    }

    public static void setEstoque(ArrayList<Produto> estoque) {
        GerenciamentoLoja.estoque = estoque;
    }

    public static void setProdutosPorNumero(Map<Integer, Produto> produtosPorNumero) {
        GerenciamentoLoja.produtosPorNumero = produtosPorNumero;
    }
}
