package dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import estrutura.repositorios.Identificavel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lucas
 */
public class LoteEntrada implements Identificavel<LoteEntrada> {
    
    private List<ItemEntrada> itens;
    private Fornecedor fornecedor;
    private Date data;
    private int id;

    public LoteEntrada(int id, Fornecedor fornecedor, Date data) {
        this.id = id;
        this.itens = new ArrayList<>();
        this.fornecedor = fornecedor;
        this.data = data;
    }
    
    public Iterator<ItemEntrada> iterator() {
        return itens.iterator();
    }

    public boolean add(ItemEntrada e) {
        return itens.add(e);
    }

    public boolean remove(ItemEntrada o) {
        return itens.remove(o);
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Date getEntrada() {
        return data;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void alterar(LoteEntrada t) {
        if(t==null) return;
        this.data = t.data;
        this.fornecedor = t.fornecedor;
        this.itens = t.itens;
    }
    
    
    
}
