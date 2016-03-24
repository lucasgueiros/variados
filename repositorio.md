# Repositório

Público-alvo = LPW!!

Já que ninguém na internet sabe explicar o que é um repositório e como fazer do jeito que o professor ****** quer, então eu vou dizer, toma aí:

## O que é um repositório?

É uma coisa no seu ~~programa~~ ~~software~~ sistema que GUARDA objetos. É o famoso cadastro. Tipo, você quer guardar o nome e endereço dos clientes? Faça um Repositório de Clientes! Entenda que o repositório é só a __interface__, ou seja, ela só é um canal de comunicação entre o seu programa e aquilo que realmente vai guardar o objeto.

Em geral você vai querer guardar num banco de dados. Os mais tradicionais gostam de um arquivo de texto. Gente viciada em Java pode querer Serializar. Mas tanto faz! O importante é guardar em algum lugar que continue intacto depois de desligar o sistema. Acontece que fazer isso dá trabalho e pode dar muitos erros, então o esquema é o seguinte:

1. Crie uma interface repositório: isso serve para separar seu programa em duas partes: uma usa a interface e não tem a mínima ideia de onde está colocando os objetos que está guardando (já que ele joga para uma interface!)
2. Implemente a interface para memória, ie, crie uma classe que implemente a interface e coloque os objetos na memória. Só pra enganar o sistema por enquanto.
3. Agora faça o resto do sistema.
4. Depois, implemente a mesma interface para usar o banco de dados.
5. Agora troque de memória para banco de dados, e seu sistema vai estar funcionando com o BD!!!

## Criando a interface

A interface é ~~quase~~ sempre igual:

````java
import java.util.List;

/**
 * @author prof. Eduardo
 */
public interface RepositorioGenerico <T>{
    public void inserir(T t);
    public void alterar(T t);
    public T recuperar(int codigo);
    public void deletar(T t);
    public List<T> recuperarTodos();
} // p.s.: valeu, professor!
````

Se não entendeu, me manda e-mail.


## Implementando pra memória

Implemete essas interface numa classe chamada Repositorio_Tipo_Memoria (no lugar de _Tipo_ coloque a classe, eg, RepositorioClienteMemoria). Exemplo:

````java
/**
 * @author prof. Eduardo
 */
// Isso quer dizer que essa classe é um Repositório
// de objetos da Classe Cliente que os guarda na memória
public class RepositorioClienteImplMemo
              implements RepositorioGenerico<Cliente>{ 

    private List<Cliente> clientes = null;

    public RepositorioClienteImplMemo(){
        this.clientes = new ArrayList<>();
    }

    @Override
    public void inserir(Cliente t) {
        this.clientes.add(t);
    }

    // copia os valores do Cliente t para um cliente com o CPF igual.
    @Override
    public void alterar(Cliente t) {
        for(Cliente c: this.clientes){
            if(c.getCPF()==t.getCPF()){
                c.setNome(t.getNome());
                c.setEndereco(t.getEndereco());
                c.setFidelidade(t.getFidelidade());
                c.setTelefone(t.getTelefone());
                return;
            }
        }
    }

    @Override
    public Cliente recuperar(int codigo) {
        for(Cliente c:this.clientes){
            if(c.getCPF()==codigo){
                return c;
            }
        }
        return null;
    }

    @Override
    public void deletar(Cliente t) {
        this.clientes.remove(t);
    }
    @Override
    public List<Cliente> recuperarTodos() {
        return this.clientes;
    }
}
````

## Criando um Repositório de Banco de Dados

Depois que seu sistema estiver funcionando apenas guardando tudo em memória, agora é a vez de colocar as coisas no Banco de Dados. Você tem duas opções, mas nas duas vocẽ vai usar algum tipo de DAO (Data Acess Object), um padrão bem legal que não vou perder meu tempo falando aqui. Aqui vou apresentar uma implementação do RepositorioCliente usando um DAO com Hibernate:

````java
import java.util.List;

/**
 * @author prof. Eduardo
 */
public class RepositorioClienteImplDB implements RepositorioGenerico<Cliente>{

    DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    @Override
    public void inserir(Cliente t) {
        dao.persist(t);
    }

    @Override
    public void alterar(Cliente t) {
        dao.update(t);
    }

    @Override
    public Cliente recuperar(int codigo) {
        return ((Cliente)dao.recover("from Cliente where cpf="+codigo).get(0));
    }

    @Override
    public void excluir(Cliente t) {
        dao.delete(t);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return dao.recover("from Cliente");
    }
    
}
````

Como você pode ver, é uma implementação bem simples com apenas dois códigos HQL. Para Hibernate é só assim mesmo. Perceba que ele usa Singleton no DAO, ou seja, todos os repositórios acessa um único DAO.

## Criando uma AbstractFactory para criar o repositório

Lá está  você fazendo aquela página de cadastro. Aí você vai tentar cadastrar um Cliente. Ele é o objeto cliente. Como você faz??

````java
RepositorioGenerico<Cliente> repositorio = new RepositorioClienteImplMemporia();
repositorio.inserir(cliente);
````

Agora imagina que você precisa, em outra página, adicionar um produto:
````java
RepositorioGenerico<Produto> repositorio = new RepositorioProdutoImplMemoria<>();
repositorio.inserir(produto);
````
Em outro lugar, você insere um fornecedor:
````java
RepositorioGenerico<Fornecedor> repositorio = new RepositorioFornecedorImplMemoria<>();
repositorio.inserir(fornecedor);
````
Agora você quer mudar pra Banco de Dados, certo? Vai ter coragem de procurar esses três lugares e mudar neles de ImplMemoria para ImplBD? Esse exemplo ainda é pequeno, mas isso pode ser um saco. Então usamos um Fabrica de Repositórios, funciona assim:
````java
// você quer um Repositório de Cliente
// Para isso, é só pegar uma instância da Fabrica e pede um!:
RepositorioGenerico<Cliente> repositorio = FabricaDeRepositorios.getInstace().getRepositorioCliente();
// agora adicione lá 
repositorio.insert(cliente);
````
Esse código não tem a menor ideia de ONDE ele está guardando (memória, banco de dados, arquivo de texto, na nuvem etc). Ele apenas confia que a Fabrica lhe dará um repositório prontinho para ele adicionar o cliente. O código da Fábrica pode ser feito de várias formas. Esse é apenas um exemplo:

````java
public class FabricaDeRepositorios {

    private RepositorioGenerico<Cliente> clientes = new RepositorioClienteImplMemoria();

    public RepositorioGenerico<Cliente> getRepositorioCliente() {
        return clientes;
    }
    // repete algo parecido para cada classe
}
````
Nesse caso, quando você quiser mudar para Banco de Dados, você só vai precisar mudar nessa classe!!
