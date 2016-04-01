package DAO;

import java.util.Date;
import java.sql.ResultSet;

public interface EmpregadoDAO {
	
	public  void listaEmpregados();
	
	public  ResultSet consultaEmpregadoParaSalario(double salario);
	
	public boolean empregadoExiste(int matricula);
	
	public double maximoSalario();
	
	public boolean insereEmpregado(int matricula, String nomeInicial, String nomeMeio, String nomeFinal,
								   double salario, String sexo, int numSupervisor, int numDepartamento, String endereco);
}
