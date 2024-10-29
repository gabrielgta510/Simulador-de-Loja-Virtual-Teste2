package model;

public class CartaoDeCredito {
    private String nomeImpresso;
    private String numCartao;
    private String validade;
    private String cvc;

    
    public String getNomeImpresso() {
        return nomeImpresso;
    }
    public CartaoDeCredito(String nomeImpresso, String numCartao, String validade, String cvc) {
        this.nomeImpresso = nomeImpresso.toUpperCase();
        this.numCartao = numCartao;
        this.validade = validade;
        this.cvc = cvc;
    }
    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }
    public String getNumCartao() {
        return numCartao;
    }
    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }
    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    public String getCvc() {
        return cvc;
    }
    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    @Override
    public String toString() {
        int num = 0;
        num += 1;
        return num + "° Cartão de Crédito ---------------" +
                "\nNome impresso: " + nomeImpresso +
                "\nNúmero do cartão: " + numCartao +
                "\nValidade: " + validade +
                "\nCVV: " + cvc + "\n------------------------------------";
    }
    
}
