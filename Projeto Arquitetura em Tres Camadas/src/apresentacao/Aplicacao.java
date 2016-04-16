package apresentacao;


import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;

import negocio.Empregado;
import negocio.Fachada;
import negocio.FachadaInterface;

public class Aplicacao {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
 		FachadaInterface fachada = new Fachada();
 		int opcao;
 		
		do{
			String menu = "MENU\n";
			menu += "1 – Listar Empregados\n";
			menu += "2 – Verificar se o empregado existe\n";
			menu += "3 – Maior salário da empresa\n";
			menu += "4 – Inserir um empregado\n";
			menu += "5 - Remover empregado\n";
			menu += "6 - Consultar empregado\n";
            menu += "7 - Alterar salário do empregado\n";
            menu += "8 – Sair";

            opcao = Integer.parseInt((JOptionPane.showInputDialog(menu)));
            int matricula;
         
            switch(opcao){
         	case  1:
				List<Empregado> empregados = fachada.recuperarTodosEmpregado();
				for(Empregado e:empregados) {
					System.out.println(e.toString());
				}
                if(empregados.isEmpty()) {
                    System.out.println("Não há nenhum empregado");
                }
         	break;
         	
         	case 2: 
         		matricula = Integer.parseInt((JOptionPane.showInputDialog("Digite a matrícula do empregado")));
         		if (fachada.existeEmpregado(matricula)){
         			JOptionPane.showMessageDialog(null, "Este empregado existe na base de dados");
         		}else{
         			JOptionPane.showMessageDialog(null, "Este empregado NÃO existe na base de dados");
         		}
         		break;
         	case 3:	
         		JOptionPane.showMessageDialog(null,"O maior salário da empresa é: "+ fachada.maiorSalarioEmpregados() +".");
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
				Empregado e = new Empregado(matricula,nomeInicial,nomeMeio,nomeFinal,salario,sexo,numSupervisor,numDepartamento,endereco);
				fachada.inserirEmpregado(e);
         		break;
                case 5:
                    matricula = Integer.parseInt((JOptionPane.showInputDialog("Digite a matrícula do empregado")));
                    e = fachada.recuperarEmpregado(matricula);
                    fachada.removerEmpregado(matricula);
                    System.out.println("Removido:\n" + e);
                    break;
                case 6:
                    matricula = Integer.parseInt((JOptionPane.showInputDialog("Digite a matrícula do empregado")));
                    e = fachada.recuperarEmpregado(matricula);
                    if(e == null) {
                        System.out.println("O empregado NÃO existe");
                    } else {
                        System.out.println("Encontrado:\n" + e);
                    }
                    break;
                case 7:
                    matricula = Integer.parseInt((JOptionPane.showInputDialog("Digite a matrícula do empregado")));
                    e = fachada.recuperarEmpregado(matricula);
                    if(e == null) {
                        System.out.println("O empregado NÃO existe");
                    } else {
                        System.out.println("Encontrado:\n" + e);
                        salario = Double.parseDouble((JOptionPane.showInputDialog("Atualmente o salário dele é " + e.getSalario() + " . Digite o novo salário do empregado")));
                        e.setSalario(salario);
                        fachada.alterarEmpregado(e);
                    }
                    break;
         	}

		}while(opcao!=8);
         
	}
         
}
	

