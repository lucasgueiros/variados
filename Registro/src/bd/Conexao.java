package bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Escrita originalmente por: prof. Marcelo
 * Atualizada por Lucas Gueiros em 30/03/16.
 */
public class Conexao {

    private Connection connection = null;
    private String url;
    private String user;
    private String password;

    public Conexao() {
        /*
           endereco = localhost
           gerenciador = postgresql, logo eu uso jdb:postgresql
           porta = 5432
           banco = registrok
         */
        url = "jdbc:postgresql://localhost:5432/registro";
        user = "registro_user";
        password = "registro_password";
    }

    public boolean conecta(){
        try {
            //Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean desconecta(){
        try {
            connection.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public Connection getConnection(){
        return connection;
    }
}
