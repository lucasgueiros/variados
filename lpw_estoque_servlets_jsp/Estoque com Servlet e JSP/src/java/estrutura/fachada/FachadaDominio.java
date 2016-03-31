/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estrutura.fachada;

import dominio.*;
import estrutura.repositorios.Repositorio;
import estrutura.repositorios.RepositorioMemoria;
import java.util.List;

/**
 *
 * @author lucas
 */
public class FachadaDominio {
    //Singleton
    private static FachadaDominio mySelf;
    public static FachadaDominio getInstance() {
        if(mySelf==null) return mySelf = new FachadaDominio();
        return mySelf;
    }
    
    // Repositórios
    private Repositorio<Produto> produtos;
    private Repositorio<Fornecedor> fornecedores;
    private Repositorio<Funcionario> funcionarios;
    private Repositorio<LoteEntrada> lotesEntrada;
    private Repositorio<LoteSaida> lotesSaida;
    
    // Contém os repositórios!!
    private FachadaDominio () {
        this.produtos = new RepositorioMemoria<>();
        this.funcionarios = new RepositorioMemoria<>();
        this.fornecedores = new RepositorioMemoria<>();
        this.lotesEntrada = new RepositorioMemoria<>();
        this.produtos = new RepositorioMemoria<>();
        this.lotesSaida = new RepositorioMemoria<>();
        
    }

    public Repositorio<Produto> getProdutos() {
        return produtos;
    }

    public Repositorio<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public Repositorio<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Repositorio<LoteEntrada> getLotesEntrada() {
        return lotesEntrada;
    }

    public Repositorio<LoteSaida> getLotesSaida() {
        return lotesSaida;
    }
    
}
