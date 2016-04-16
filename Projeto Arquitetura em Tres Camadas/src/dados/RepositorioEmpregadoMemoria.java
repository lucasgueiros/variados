package dados;

import negocio.Empregado;

import java.util.*;

/**
 * Created by lucas on 11/04/16.
 */
public class RepositorioEmpregadoMemoria  implements RepositorioEmpregado {

    Map<Integer,Empregado> es = new HashMap<>();

    @Override
    public void inserir(Empregado e) {
        es.put(e.getMatricula(),e);
    }

    @Override
    public void remover(int matricula) {
        es.remove(matricula);
    }

    @Override
    public void alterar(Empregado e) {
        es.put(e.getMatricula(),e);
    }

    @Override
    public Empregado recuperar(int matricula) {
        return es.get(matricula);
    }

    @Override
    public List<Empregado> recuperarTodos() {
        List<Empregado> ess = new LinkedList<Empregado>() ;

        for(Empregado e :es.values()) {
            ess.add(e);
        }

        return ess;
    }

    @Override
    public boolean existe(int matricula) {
        return es.containsKey(matricula);
    }

    @Override
    public Empregado consultaPorSalario(double salario) {
        List<Empregado> ess = recuperarTodos();
        for(Empregado e : ess) {
            if(e.getSalario() == salario) {
                return e;
            }
        }
        return null;
    }

    @Override
    public double maiorSalario() {
        double maior = 0;
        for(Empregado e: es.values()) {
            if(e.getSalario() > maior){
                maior = e.getSalario();
            }
        }
        return maior;
    }
}
