package dados;

import dados.DAO.JDBCEmpregadoDAO;
import negocio.Empregado;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lucas on 11/04/16.
 */
public class RepositorioEmpregadoDB implements RepositorioEmpregado {

    JDBCEmpregadoDAO dao = new JDBCEmpregadoDAO();

    public void listaEmpregados() {

    }

    public boolean empregadoExiste(int matricula) {
        return dao.empregadoExiste(matricula);
    }

    public double maximoSalario() {
        return dao.maximoSalario();
    }


    @Override
    public void inserir(Empregado e) {
        dao.insereEmpregado(e.getMatricula(), e.getNomeInicial(), e.getNomeMeio(), e.getNomeFinal(), e.getSalario(), e.getSexo(), e.getNumSupervisor(), e.getNumDepartamento(), e.getEndereco());
    }

    @Override
    public void remover(int matricula) {

    }

    @Override
    public void alterar(Empregado e) {

    }

    @Override
    public Empregado recuperar(int matricula) {
        return null;
    }

    @Override
    public List<Empregado> recuperarTodos() {
        ResultSet rs = dao.listaEmpregados();
        List<Empregado> es = new LinkedList<>();
        try {
            while (rs.next()) {
                Empregado en = new Empregado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6) , rs.getInt(7), rs.getInt(8), rs.getString(9));
                es.add(en);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return es;
    }

    @Override
    public boolean existe(int matricula) {
        return dao.empregadoExiste(matricula);
    }

    @Override
    public Empregado consultaPorSalario(double salario) {
        return this.recuperar(dao.consultaEmpregadoParaSalario(salario));
    }

    @Override
    public double maiorSalario() {
        return dao.maximoSalario();
    }


}
