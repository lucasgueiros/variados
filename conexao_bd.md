# Conexão com Banco de Dados em Java

Passo a passo de como fazer conexão com banco de dados usando Java e sem Hibernate. Se quiser seguir o tutorial baixe a pasta CadastroSemBD. No cadastro a conexão já está feita. No CadastroSemBD já está tudo pronto, exceto a conexão com o Banco de Dados. Fazer conexão com o BD precisa de duas coisas: o DAO e o Repositório, que é só implementar, besteirinha!

O foco dessa parte não está nos repositórios, mas sim na parte do BD!! Mais informações sobre respositórios no arquivo respositorios.md .

## Criando conexões

1. Descubra as informações de conexão:
  1. URL da conexao( Endereço IP, gerenciador, porta e nome) 
  1. Usuário
  1. Senha
1. Salve essas informações nas variáveis url, user, password
1. Instancie a conexão

Tudo isso pode estar em uma única classe, em java:
````java
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
            connection = DriverManager.getConnection(url, user, password);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
````
Nada complicado

### Desconectando

Assim, ó:
````java
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
````

## Criando um DAO Manager Específico

Cada DAO Manager, na forma tradicional, cuida de uma classe. Ele é quem faz as consultas, então vamos lá:

## Implementando métodos

## Implementando um DAO Manager Genérico
