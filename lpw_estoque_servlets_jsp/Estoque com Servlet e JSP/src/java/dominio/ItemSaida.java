/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import estrutura.repositorios.Identificavel;
import java.util.Objects;

/**
 *
 * @author lucas
 */
public class ItemSaida{
    private Produto p;
    private int qtd;

    public ItemSaida(Produto p, int qtd) {
        this.p = p;
        this.qtd = qtd;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.p);
        hash = 37 * hash + this.qtd;
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
        final ItemSaida other = (ItemSaida) obj;
        if (!Objects.equals(this.p, other.p)) {
            return false;
        }
        if (this.qtd != other.qtd) {
            return false;
        }
        return true;
    }

    
}
