package model;
import java.time.LocalDateTime;

public class Usuario {
    private String email = null;                    //aplique aqui a ideia de encapsulamento: valide o email antes de salvá-lo no atributo
    private LocalDateTime dataRegistro = null;      // Este tipo de data é melhor para manipular
    private String senha;
    
    /*
     * Corrigir o construtor respeitando o encapsulamento
     */
    public Usuario(String email, String senha) {
        this.email = email; //Esta atribuição vai burlar a validação de email.
                            //Use o método this.setEmail(String email)
        this.senha = senha;
        this.dataRegistro = LocalDateTime.now(); //Mesmo comentário da linha anterior
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //condicional que testa primeiro cadastro: ENCAPSULAMENTO!
        this.email = email;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro() {
        //Requer alguma camada de segurança?
        this.dataRegistro = LocalDateTime.now();
    }    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
