/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorio;

/**
 *
 * @author lucas
 */
public interface Persistivel<Tipo> {
    public void setId(long id);
    public long getId();
    public void alterar(Tipo t);
}
