/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estrutura.repositorios;

import java.util.List;

/**
 *
 * @author lucas
 * @param <Tipo>
 */
public interface Repositorio<Tipo extends Identificavel> {
    
    public void adicionar(Tipo t);
    public Tipo remover(int id);
    public void alterar (Tipo t);
    public Tipo recuperar (int id);
    public List<Tipo> recuperar();

    public int proximoId();
    
}
