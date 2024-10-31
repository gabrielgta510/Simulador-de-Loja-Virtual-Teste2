package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/*
    * Falta o atributo VALOR TOTAL
*/

public class Pedido {
    private ArrayList<Item> produtosPedido = new ArrayList<>(); //O tipo aqui deve ser Item e não Object
    private LocalDateTime dataPedido;
    private Endereco enderecoEntrega; // Crie uma classe Endereço com rua, bairro endereço, telefone ...
    private String statusPedido;
    private int numPedido;
    private CartaoDeCredito cartaoPagamento;
    private double valorTotal;


    public Pedido(Endereco enderecoEntrega, CartaoDeCredito cartaoPagamento, int numPedido, String statusPedido, ArrayList<Item> produtosPedido, double valorTotal) {
        this.produtosPedido = produtosPedido;
        this.dataPedido = LocalDateTime.now();
        this.enderecoEntrega = enderecoEntrega;
        this.cartaoPagamento = cartaoPagamento;
        this.numPedido = numPedido;
        this.statusPedido = statusPedido;
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }
    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public String getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
    public int getNumPedido() {
        return numPedido;
    }
    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }
    public CartaoDeCredito getCartaoPagamento() {
        return cartaoPagamento;
    }
    public void setCartaoPagamento(CartaoDeCredito cartaoPagamento) {
        this.cartaoPagamento = cartaoPagamento;
    }

    public ArrayList<Item> getProdutosPedido() {
        return produtosPedido;
    }

    public void setProdutosPedido(ArrayList<Item> produtosPedido) {
        this.produtosPedido = produtosPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        int num = 0;
        num += 1;
        System.out.println(num + "° Pedido -------------------------");
        System.out.println("  Status do Pedido: " + statusPedido);
        System.out.println("\nProdutos comprados: ");
        for (Item item : produtosPedido) {
            System.out.println(String.format("%-20s %d X R$ %.2f\n", item.getNomeItem(), item.getQuantidade(), item.getValor()));
        }
        System.out.println("Valor total do pedido: " + valorTotal);
        System.out.println("  Pedido realizado em: " + dataPedido);
        System.out.println(enderecoEntrega);
        System.out.println(cartaoPagamento);
        return "------------------------------------";
    }
}
