package negocio;

import dados.RepositorioEmpregado;
import dados.RepositorioEmpregadoDB;
import dados.RepositorioEmpregadoMemoria;

import java.util.List;

/**
 * Created by lucas on 11/04/16.
 */
public class ControladorEmpregado {
    private RepositorioEmpregado empregados = new RepositorioEmpregadoMemoria();

    public void inserir(Empregado e) {
        empregados.inserir(e);
    }

    public Empregado recuperar(int matricula) {
        return empregados.recuperar(matricula);
    }

    public List<Empregado> recuperarTodos() {
        return empregados.recuperarTodos();
    }

    public void remover(int matricula) {
        empregados.remover(matricula);
    }

    public void alterar(Empregado e) {
        empregados.alterar(e);
    }

    public boolean existe(int matricula) {
        return empregados.existe(matricula);
    }

    public double maiorSalario() {
        return empregados.maiorSalario();
    }

    public Empregado consultaPorSalario(double salario) {
        return empregados.consultaPorSalario(salario);
    }
}
