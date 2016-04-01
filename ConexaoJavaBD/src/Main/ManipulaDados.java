package Main;


import java.text.ParseException;
import javax.swing.JOptionPane;

import DAO.JDBCEmpregadoDAO;

public class ManipulaDados {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
 		JDBCEmpregadoDAO manipulaEmpregado = new JDBCEmpregadoDAO();
 		int opcao;
 		
		do{
 		 String menu = "MENU\n";
         menu += "1 – Listar Empregados\n";
         menu += "2 – Verificar se o empregado existe\n";
         menu += "3 – Maior salário da empresa\n";
         menu += "4 – Inserir um empregado\n";
         menu += "5 – Sair";
         opcao = Integer.parseInt((JOptionPane.showInputDialog(menu)));
         int matricula;
         
         switch(opcao){
         	case  1: manipulaEmpregado.listaEmpregados();
         	break;
         	
         	case 2: 
         		matricula = Integer.parseInt((JOptionPane.showInputDialog("Digite a matrícula do empregado")));
         		if (manipulaEmpregado.empregadoExiste(matricula) == true){
         			JOptionPane.showMessageDialog(null, "Este empregado existe na base de dados");
         		}else{
         			JOptionPane.showMessageDialog(null, "Este empregado NÃO existe na base de dados");
         		}
         		break;
         	case 3:	
         		JOptionPane.showMessageDialog(null,"O maior salário da empresa é: "+manipulaEmpregado.maximoSalario()+"");
         		break;
         	case 4:
         		matricula = Integer.parseInt((JOptionPane.showInputDialog("Digite a matrícula do empregado")));
         		String nomeInicial = (JOptionPane.showInputDialog("Digite o nome inicial do empregado"));
         		String nomeMeio = (JOptionPane.showInputDialog("Digite o nome do meio do empregado"));
         		String nomeFinal = (JOptionPane.showInputDialog("Digite o nome final do empregado"));
         		Double salario = Double.parseDouble((JOptionPane.showInputDialog("Digite o salário do empregado")));
         		String sexo = (JOptionPane.showInputDialog("Digite o sexo do empregado"));
         		int numSupervisor = Integer.parseInt((JOptionPane.showInputDialog("Digite a matrícula do supervisor do empregado")));		
         		int numDepartamento = Integer.parseInt((JOptionPane.showInputDialog("Digite o número do departamento do empregado")));
         		String endereco = (JOptionPane.showInputDialog("Digite o endereço do empregado"));
         		manipulaEmpregado.insereEmpregado(matricula, nomeInicial, nomeMeio, nomeFinal, salario, sexo, numSupervisor, numDepartamento, endereco);
         		break;
         	}
         
		}while(opcao!=5);
         
	}
         
}
	

