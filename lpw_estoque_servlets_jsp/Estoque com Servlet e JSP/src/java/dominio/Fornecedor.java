package dominio;

import estrutura.repositorios.Identificavel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author lucas
 */
public class Fornecedor implements Identificavel<Fornecedor> {
    
    private String nome;
    private String cnpj;
    private int id;
    private String email;

    public Fornecedor(String nome, String cnpj, int id, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.id = id;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public void alterar(Fornecedor t) {
        if(t==null) return;
       this.cnpj = t.cnpj;
       this.email = t.email;
       this.nome = t.nome;
    }
    
    
    
    
}
