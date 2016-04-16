package dados.DAO;

import java.sql.ResultSet;

public interface ConsultasImportantesDAO {
	
	public ResultSet projetosDoDepartamento(int numDepartamento);
	
	public double HorasTrabalhadasNoProjeto(int numProjeto);

}
