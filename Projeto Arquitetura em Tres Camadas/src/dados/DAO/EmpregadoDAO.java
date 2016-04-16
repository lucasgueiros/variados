package dados.DAO;

public interface EmpregadoDAO {
	
	public  void listaEmpregados();
	
	public  int consultaEmpregadoParaSalario(double salario);
	
	public boolean empregadoExiste(int matricula);
	
	public double maximoSalario();
	
	public boolean insereEmpregado(int matricula, String nomeInicial, String nomeMeio, String nomeFinal,
								   double salario, String sexo, int numSupervisor, int numDepartamento, String endereco);
}
