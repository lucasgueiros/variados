package DAO;


import java.util.Date;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import Conexao.ConnectionFactory;
import Conexao.Connect;


//import Factory.ConnectionFactory;

public class JDBCEmpregadoDAO implements EmpregadoDAO{
	private Connection con;
	
	public JDBCEmpregadoDAO(){
		
		this.con =  new ConnectionFactory().getConnection();
		
		//Utilizando a outra classe
		//Connect conexao = new Connect(); 
		//conexao.conecta();
		//con = conexao.getCon();
	}
	

	@Override
	public void listaEmpregados() {
		Statement consultaEmpregadoSTM = null;
		String consultaEmpregadoSQL = "select * from empregado";
		try{
			consultaEmpregadoSTM =  this.con.createStatement();
			ResultSet consultaEmpregadoRS = consultaEmpregadoSTM.executeQuery(consultaEmpregadoSQL);
			
			while(consultaEmpregadoRS.next()){
				System.out.println ("Nome inicial : "+consultaEmpregadoRS.getString(1)+ " " +
						"Nome meio: "+consultaEmpregadoRS.getString("nomint")+ " " +
						"Nome fim: "+consultaEmpregadoRS.getString(3) +" " +
						"Data Nascimento: "+consultaEmpregadoRS.getDate("dtnasc")+" " +
						"Endereço: "+consultaEmpregadoRS.getString("ender")+ " " +
						"Sexo: "+consultaEmpregadoRS.getString("sexo")+ " " +
						"Salário: "+consultaEmpregadoRS.getString("salario")+" " );
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	@Override
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


	@Override
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


	@Override
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


	@Override
	public ResultSet consultaEmpregadoParaSalario(double salario) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
