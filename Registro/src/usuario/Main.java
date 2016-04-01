package usuario;

import dao.PessoaDAO;
import dominio.Pessoa;

import javax.swing.*;

/**
 * Created by lucas on 01/04/16.
 */
public class Main {

    PessoaDAO daoPessoa = new PessoaDAO();

    public static void main(String [] args) {
        new Main().menu();
    }

    private void menu() {
        int option = 0;
        do{
            option = Integer.parseInt(JOptionPane.showInputDialog("" +
                    "Escolha uma opção:\n" +
                    " 1 - Adicionar usuário\n"));
            switch (option) {
                case 1: daoPessoa.insert(readPessoa()); break;
            }
        } while(option!=0);

    }

    public Pessoa readPessoa() {
        String nome, cpf, nomeDaMae;
        nome = JOptionPane.showInputDialog("Nome");
        cpf = JOptionPane.showInputDialog("Cpf");
        nomeDaMae = JOptionPane.showInputDialog("Nome da mae");
        return new Pessoa(nome,cpf,nomeDaMae);
    }

}
