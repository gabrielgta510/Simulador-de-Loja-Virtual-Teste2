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


    public Pedido(Endereco enderecoEntrega, CartaoDeCredito cartaoPagamento, int numPedido, String statusPedido, ArrayList<Item> produtosPedido) {
        this.produtosPedido = produtosPedido;
        this.dataPedido = LocalDateTime.now();
        this.enderecoEntrega = enderecoEntrega;
        this.cartaoPagamento = cartaoPagamento;
        this.numPedido = numPedido;
        this.statusPedido = statusPedido;
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
    
}
