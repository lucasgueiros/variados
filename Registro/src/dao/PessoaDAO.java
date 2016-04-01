package dao;

import bd.Conexao;
import dominio.Pessoa;

import java.sql.PreparedStatement;

/**
 * Created by lucas on 01/04/16.
 */
public class PessoaDAO {
    private Conexao conexao;

    public PessoaDAO() {
        conexao = new Conexao();
        conexao.conecta();
    }

    public void insert(Pessoa p) {
        try {
            String sql = "insert into pessoa (nome,cpf,mae) values (?,?,?)";
            PreparedStatement statement = conexao.getConnection().prepareStatement(sql);
            statement.setString(1,p.getNome());
            statement.setString(2,p.getCpf());
            statement.setString(3,p.getNomeDaMae());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
