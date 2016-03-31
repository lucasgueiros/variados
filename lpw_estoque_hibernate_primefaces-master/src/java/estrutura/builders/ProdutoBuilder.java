/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estrutura.builders;

import dominio.Produto;

/**
 *
 * @author lucas
 */
public class ProdutoBuilder {
    private static int lastId;
    private int id;
    private String nome;
    private String descricao;

    public ProdutoBuilder () {
        this.id = ++lastId;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Produto build() {
        return new Produto(id, nome, descricao);
    }
    
    
}
