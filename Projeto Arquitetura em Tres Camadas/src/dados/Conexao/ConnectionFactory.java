package dados.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	
	public class ConnectionFactory {
		public Connection getConnection() {
	        try {
	            return DriverManager.getConnection(
	          "jdbc:postgresql://localhost:5432/empresa", "postgres", "rmvll6fls");
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}
	
	