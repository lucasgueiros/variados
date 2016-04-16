package negocio;

import dados.RepositorioEmpregado;
import dados.RepositorioEmpregadoDB;

import java.util.List;

/**
 * Created by lucas on 11/04/16.
 */
public class Fachada implements FachadaInterface{

    private ControladorEmpregado ctrlEmpregado = new ControladorEmpregado();

    public void inserirEmpregado(Empregado e) {
        ctrlEmpregado.inserir(e);
    }

    public Empregado recuperarEmpregado(int matricula) {
        return ctrlEmpregado.recuperar(matricula);
    }

    public void removerEmpregado(int matricula) {
        ctrlEmpregado.remover(matricula);
    }

    public List<Empregado> recuperarTodosEmpregado() {
        return ctrlEmpregado.recuperarTodos();
    }

    public void alterarEmpregado(Empregado e) {
        ctrlEmpregado.alterar(e);
    }

    public boolean existeEmpregado(int matricula) {
        return ctrlEmpregado.existe(matricula);
    }

    public double maiorSalarioEmpregados() {
        return ctrlEmpregado.maiorSalario();
    }
}
