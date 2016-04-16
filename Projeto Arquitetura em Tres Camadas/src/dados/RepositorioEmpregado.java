package dados;

import negocio.Empregado;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by lucas on 11/04/16.
 */
public interface RepositorioEmpregado {

    public void inserir(Empregado e) ;
    public void remover(int matricula) ;
    public void alterar(Empregado e);
    public Empregado recuperar(int matricula);
    public List<Empregado> recuperarTodos();
    public boolean existe(int matricula);
    public Empregado consultaPorSalario(double salario);
    public double maiorSalario();
}
