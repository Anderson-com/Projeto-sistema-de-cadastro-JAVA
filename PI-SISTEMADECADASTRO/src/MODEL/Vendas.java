package MODEL;

import java.text.SimpleDateFormat;

public class Vendas {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String produto;
    private Double valor;
    private String data;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Vendas(String cpf, String nome, String email, String telefone, String produto, Double valor, String data) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produto = produto;
        this.valor = valor;
        setDataVenda(data);
    }
     public void setDataVenda(String data) {
        try {
            DATE_FORMAT.parse(data);
            this.data = data;
        } catch (Exception e) {
            throw new IllegalArgumentException("Data inválida. Use o formato DD/MM/AAAA");
        }
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getProduto() { return produto; }
    public Double getValor() { return valor; }
    public String getData () { return data;}

    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setProduto(String produto) { this.produto = produto; }
    public void setValor(Double valor) { this.valor = valor; }
    public void setData(String data) { this.data = data; }
    
}
