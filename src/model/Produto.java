package model;

public class Produto {
    private String nomeProduto = null;
    private Integer quantidade = null;
    private double valor;
    private float precoDeCusto;
    private Integer num;

    public Produto(String nomeProduto, Integer quantidade, float precoDeCusto, Integer numero) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoDeCusto = precoDeCusto;
        this.valor = precoDeCusto * 1.5;
        this.num = numero;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public double getValor() {
        return valor;
    }

    public float getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(float precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
        this.valor = precoDeCusto * 1.5;
    }

    @Override
    public String toString() {
        return String.format("%-2d - %-20s ", num, nomeProduto);
    }
    
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
