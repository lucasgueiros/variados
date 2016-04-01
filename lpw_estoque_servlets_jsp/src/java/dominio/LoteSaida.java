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
public class LoteSaida implements Identificavel<LoteSaida> {
    private int id;
    private List<ItemSaida> itens;
    private Funcionario funcionario;
    private Date data;

    public LoteSaida(int id, Funcionario funcionario, Date data) {
        itens = new ArrayList<>();
        this.funcionario = funcionario;
        this.data = data;
    }

    public Iterator<ItemSaida> iterator() {
        return itens.iterator();
    }

    public boolean add(ItemSaida e) {
        return itens.add(e);
    }

    public ItemSaida remove(int index) {
        return itens.remove(index);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Date getData() {
        return data;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void alterar(LoteSaida t) {
        if(t==null) return;
        this.data = t.data;
        this.funcionario = t.funcionario;
        this.itens = t.itens;
    }
    
    
    
}
