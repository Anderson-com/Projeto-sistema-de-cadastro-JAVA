package MODEL;

public class Usuario {

    private String login;
    private String senha;
    private String tipo;
    private String cpf;

    public Usuario() {
    }
    public Usuario(String login, String senha, String tipo, String cpf) {
        
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
