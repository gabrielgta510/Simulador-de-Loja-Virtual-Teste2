package model;

public class Item {
    private Produto produto = null;
    private String nomeItem;
    private double valor;
    private int quantidade;
    
    public Item(Produto produto, int quantidade) {
        this.nomeItem = produto.getNomeProduto();
        this.valor = produto.getValor();
        if (quantidade <= produto.getQuantidade()) {
            this.quantidade = quantidade;
        }
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
        this.nomeItem = produto.getNomeProduto();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %d X R$ %.2f\n", nomeItem, quantidade, valor);
    }
}
