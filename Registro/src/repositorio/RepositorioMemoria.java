/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorio;

import repositorio.excecoes.IdNaoDisponivelException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lucas
 * @param <Tipo>
 */
public abstract class RepositorioMemoria<Tipo extends Persistivel> implements Repositorio<Tipo> {

    
    protected final Map<Long,Tipo> elementos = new HashMap<>();
    private static long maxid = 1;
    
    @Override
    public void adicionar(Tipo t) throws IdNaoDisponivelException {
        if(t.getId()==-1)
            t.setId(maxid++);
        else if(elementos.containsKey(t.getId()))
            throw new IdNaoDisponivelException();
        else if(maxid < t.getId() )
            maxid = t.getId();
        elementos.put(t.getId(), t);
    }

    @Override
    public Tipo remover(long id) {
        return elementos.remove(id);
    }

    @Override
    public void atualizar(Tipo t) {
        try {
            elementos.get(t.getId()).alterar(t);
        } catch(NullPointerException e) {
            return;
        }
    }

    @Override
    public List<Tipo> recuperar() {
        ArrayList<Tipo> al = new ArrayList<>();
        for (Map.Entry<Long, Tipo> e : elementos.entrySet()) {
            al.add(e.getValue());
        }
        return al;
    }

    @Override
    public Tipo recuperar(long id) {
        return elementos.get(id);
    }
    
}
