/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estrutura.builders;

import dominio.Fornecedor;

/**
 *
 * @author lucas
 */
public class FornecedorBuilder {
    
    private static int lastId = 0;
    private String nome;
    private String cnpj;
    private final int id;
    private String email;
    
    public FornecedorBuilder() {
        this.id = ++lastId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    public Fornecedor build(){
        return new Fornecedor(id,nome,cnpj,email);
    }
    
    
}
