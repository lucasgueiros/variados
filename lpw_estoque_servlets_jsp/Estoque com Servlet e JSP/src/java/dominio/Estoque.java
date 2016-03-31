package dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import estrutura.repositorios.Identificavel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Estoque {
    
    private List<ItemEstoque> itens = new ArrayList<>();

    public Iterator<ItemEstoque> iterator() {
        return itens.iterator();
    }

    public boolean add(ItemEstoque e) {
        return itens.add(e);
    }

    public boolean remove(Object o) {
        return itens.remove(o);
    }
    
}
