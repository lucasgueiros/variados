/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estrutura.repositorios;

/**
 *
 * @author lucas
 */
public interface Identificavel<Tipo> {
    public int getId();
    public void alterar(Tipo t);
}
