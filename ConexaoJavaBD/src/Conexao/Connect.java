package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;

//Aos alunos http://www.guj.com.br/articles/7

public class Connect {
   
	private Connection con;
	private String url = "jdbc:postgresql://localhost:5432/empresa";
	private String usuario = "postgres";
	private String senha = "postgres";
	
	public Connect(){}

	public boolean conecta(){
		try {
		//	Class.forName("org.postgresql.Driver");			
			con = DriverManager.getConnection(url, usuario, senha);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean desconecta(){
		try {
			con.close();
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Connection getCon(){
		return con;
	}

}
