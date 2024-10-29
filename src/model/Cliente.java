package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cliente {
    private String email;                    //aplique aqui a ideia de encapsulamento: valide o email antes de salvá-lo no atributo
    private LocalDateTime dataRegistro;      // Este tipo de data é melhor para manipular
    private String senha;
    private String nomeCliente;
    private String cpf;
    private String telefone;
    private ArrayList<Endereco> listaEnderecos = new ArrayList<>();
    private double saldoConta;
    private String dataNascimento;
    private ArrayList<CartaoDeCredito> cartoesSalvo = new ArrayList<>();
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private Integer numPedido = 0;
    
    public Integer getNumPedido() {
        return numPedido;
    }
    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public ArrayList<Endereco> getEnderecos() {
        return listaEnderecos;
    }
    public double getSaldoConta() {
        return saldoConta;
    }
    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    //Salvar novo Enderço e excluir Endereço.
    //Falar com o professor!
    public void addEndereco(Endereco endereco) {
        listaEnderecos.add(endereco);
    }
    public void excluiEndereco(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }
    
    
    //Salvar novo cartão e excluir cartão.
    public void addCartao(CartaoDeCredito cc) {
        cartoesSalvo.add(cc);
    }
    public void excluiCartao(CartaoDeCredito cc) {
        cartoesSalvo.remove(cc);
    }
    

    //Salvar novo Pedido.
    public void addPedido(Pedido pedi) {
        listaPedidos.add(pedi);
    }
    //O cliente não pode excluir um pedido

    //Criar conta - construtor
    public Cliente(String email, String senha, String nomeCliente, String cpf, String telefone,
            ArrayList<Endereco> listaEnderecos, String dataNascimento,
            ArrayList<CartaoDeCredito> cartoesSalvo, ArrayList<Pedido> listaPedidos) {
        this.email = email;
        this.senha = senha;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.listaEnderecos = listaEnderecos;
        this.dataNascimento = dataNascimento;
        this.cartoesSalvo = cartoesSalvo;
        this.listaPedidos = listaPedidos;
        this.dataRegistro = LocalDateTime.now();
    }

    public ArrayList<CartaoDeCredito> getCartoesSalvo() {
        return cartoesSalvo;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }
}

