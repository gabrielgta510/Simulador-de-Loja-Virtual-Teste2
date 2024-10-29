package model;

public class Endereco {
    private String rua;
    private String numLugar;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String bairro, String cidade, String estado, String numLugar, String rua) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numLugar = numLugar;
        this.rua = rua;
    }
    
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumLugar() {
        return numLugar;
    }
    public void setNumLugar(String numLugar) {
        this.numLugar = numLugar;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        int num = 0;
        num += 1;
        System.out.println(num + "° Endereço ------------------------");
        return String.format("Rua: %s, N°: %s\nBairro: %s\nCidade: %s, %s\n------------------------------------", rua, numLugar, bairro, cidade, estado);
    }
}
