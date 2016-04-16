package negocio;

import java.util.List;

/**
 * Created by lucas on 11/04/16.
 */
public interface FachadaInterface {

    public void inserirEmpregado(Empregado e) ;

    public Empregado recuperarEmpregado(int matricula);

    public void removerEmpregado(int matricula);

    public List<Empregado> recuperarTodosEmpregado();

    public void alterarEmpregado(Empregado e);

    public boolean existeEmpregado(int matricula);

    public double maiorSalarioEmpregados();

}
