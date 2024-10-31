package model;

import control.GerenciamentoLoja;
import java.util.ArrayList;

public class CarrinhoDeCompras {
    private ArrayList<Item> itens = new ArrayList<>();
    private String cupomDesconto;
    private double valorTotal;

    public CarrinhoDeCompras(ArrayList<Item> itens, String cupomDesconto) {
        this.itens = itens;
        this.cupomDesconto = cupomDesconto;
    }
    
    public ArrayList<Item> getItens(){
        return this.itens;
    }
    
    public boolean addItem(Produto produto, int quantidade){
        if (quantidade <= produto.getQuantidade()) {
            Item item = new Item(produto, quantidade);
            this.itens.add(item);
            this.valorTotal += produto.getValor() * quantidade;
            System.out.println(produto.getNomeProduto() + " foi adicionado ao carrinho!");
            GerenciamentoLoja.atualizarEstoque(produto, item);
            return false;
        } else {
            System.out.println("Só temos " + produto.getQuantidade() + ". TENTE NOVAMENTE!");
            return true;
        }

    }

    public boolean removeItem(Item item){
        return this.itens.remove(item);
    }

    public boolean removeitem(int index){
        Item i = this.itens.get(index);
        return this.itens.remove(i);
    }

    public String getCupomDesconto() {
        return cupomDesconto;
    }
    public void setCupomDesconto(String cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("========== CARRINHO DE COMPRAS ==========");
        if (itens.isEmpty()) {
            return ("\nSeu carrinho está vazio.\n=========================================");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
            return String.format("\nValor total: R$ %.2f\n=========================================", this.getValorTotal());
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
