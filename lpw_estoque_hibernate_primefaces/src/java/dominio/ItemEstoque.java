package dominio;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author lucas
 */
class ItemEstoque {
    private Produto p;
    private int quantidade;

    public ItemEstoque(Produto p, int quantidade) {
        this.p = p;
        this.quantidade = quantidade;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
