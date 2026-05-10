package conexao;

import java.sql.Date;

public class Cliente_FlowBank {
    
    private Integer id;
    private String nome;
    private String email;
    private String celular;
    private Date data_nascimento;
    private String senha;
    
    //Getters
    public Integer getID() { return id; }
    public String getNome() { return nome; }   
    public String getEmail() { return email; }
    public String getCelular() { return celular; }
    public Date getData_Nascimento() { return data_nascimento; }
    public String getSenha() { return senha; }
    
    //Setters
    public void setId(Integer id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setCelular(String celular) { this.celular = celular; }
    public void setData_Nascimento(Date data_nascimento) { this.data_nascimento = data_nascimento; }
    public void setSenha(String senha) { this.senha = senha; }   
}
