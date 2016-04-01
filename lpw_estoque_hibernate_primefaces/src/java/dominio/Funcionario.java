package dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import estrutura.repositorios.Identificavel;
import java.util.Date;

/**
 *
 * @author lucas
 */
public class Funcionario implements Identificavel<Funcionario> {
    
    private String nome;
    private int id;
    private Date nascimento;
    private String email;
    private String senha;

    public Funcionario(String nome, int id, Date nascimento, String email, String senha) {
        this.nome = nome;
        this.id = id;
        this.nascimento = nascimento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
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

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public void alterar(Funcionario t) {
        if(t==null) return;
        this.email = t.email;
        this.nascimento = t.nascimento;
        this.nome = t.nome;
    }

    public boolean testeSenha(String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean podeConsultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean podeAlterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean podeCadastrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
