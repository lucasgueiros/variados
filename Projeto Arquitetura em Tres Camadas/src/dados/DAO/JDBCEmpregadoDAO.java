package dados.DAO;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Conexao.ConnectionFactory;


//import Factory.ConnectionFactory;

public class JDBCEmpregadoDAO {
	private Connection con;
	
	public JDBCEmpregadoDAO(){
		
		this.con =  new ConnectionFactory().getConnection();
		
		//Utilizando a outra classe
		//Connect conexao = new Connect(); 
		//conexao.conecta();
		//con = conexao.getCon();
	}
	

	public ResultSet listaEmpregados() {
		Statement consultaEmpregadoSTM = null;
		String consultaEmpregadoSQL = "select * from empregado";
		try{
			consultaEmpregadoSTM =  this.con.createStatement();
			ResultSet consultaEmpregadoRS = consultaEmpregadoSTM.executeQuery(consultaEmpregadoSQL);

			return consultaEmpregadoRS;
			
		}catch(Exception e){
			e.printStackTrace();
		}
        return null;
	}


	public boolean insereEmpregado(int matricula, String nomeInicial,
			String nomeMeio, String nomeFinal, double salario, String sexo,
			int numSupervisor, int numDepartamento, String endereco) {
		// TODO Auto-generated method stub
		
		try{
			PreparedStatement insereEmpregadoSTM = null;
			String insereEmpregadoSQL = "insert into empregado (nominic,nomint,nomefim,numat,ender,sexo,salario,nsuper,ndepto)" +
					"values (?,?,?,?,?,?,?,?,?)";
			
			insereEmpregadoSTM = con.prepareStatement(insereEmpregadoSQL);
			
			insereEmpregadoSTM.setString(1, nomeInicial);
			insereEmpregadoSTM.setString(2, nomeMeio);
			insereEmpregadoSTM.setString(3, nomeFinal);
			insereEmpregadoSTM.setInt(4, matricula);
			insereEmpregadoSTM.setString(5, endereco);
			insereEmpregadoSTM.setString(6, sexo);
			insereEmpregadoSTM.setDouble(7,salario);
			insereEmpregadoSTM.setInt(8, numSupervisor);
			insereEmpregadoSTM.setInt(9, numDepartamento);
			
			if(insereEmpregadoSTM.executeUpdate() == 1){
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}


    public boolean empregadoExiste(int matricula) {

        PreparedStatement empregadoExisteSTM = null;
        try{
            String empregadoExistemSQL = "select * from empregado where numat = ?";

            empregadoExisteSTM = con.prepareStatement(empregadoExistemSQL);

            empregadoExisteSTM.setString(1, Integer.toString(matricula));

            ResultSet empregadoExistemRS = empregadoExisteSTM.executeQuery();

            while(empregadoExistemRS.next()){
                return true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public double maximoSalario() {
        Statement maximoSalarioSTM = null;
        double maximoSalario = 0;
        try{
            String maximoSalarioSQL = "select max(salario) as maximo_salario from empregado";
            maximoSalarioSTM = con.createStatement();

            ResultSet maximoSalarioRS = maximoSalarioSTM.executeQuery(maximoSalarioSQL);

            while(maximoSalarioRS.next()){
                maximoSalario = maximoSalarioRS.getDouble("maximo_salario") ;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return maximoSalario;
    }

    public int consultaEmpregadoParaSalario(double salario) {
        PreparedStatement consultaEmpregadoSalarioSTM = null;
        String consultaEmpregadoSalarioSQL = "select numat, salario from empregado where salario = ?";

        try {
            consultaEmpregadoSalarioSTM = con.prepareStatement(consultaEmpregadoSalarioSQL);
            consultaEmpregadoSalarioSTM.setDouble(1, salario);

            ResultSet consultaEmpregadoSalarioRS = consultaEmpregadoSalarioSTM.executeQuery();
            if(consultaEmpregadoSalarioRS.next()){
                return consultaEmpregadoSalarioRS.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
	
}
