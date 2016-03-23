# Repositório

Público-alvo = LPW!!

Já que ninguém na internet sabe explicar o que é um repositório e como fazer do jeito que o professor ****** quer, então eu vou dizer, toma aí:

## O que é um repositório?

É uma coisa no seu ~~programa~~ ~~software~~ sistema que GUARDA objetos. É o famoso cadastro. Tipo, você quer guardar o nome e endereço dos clientes? Faça um Repositório de Clientes! Entenda que o repositório é só a "inteface", ou seja, ela só é um canal de comunicação entre o seu programa e aquilo que realmente vai guardar o objeto.

Em geral você vai querer guardar num banco de dados. Os mais tradicionais gostam de um arquivo de texto. Gente viciada em Java pode querer Serializar. Mas tanto faz! O importante é guardar em algum lugar que continue intacto depois de desligar o sistema. Acontece que fazer isso dá trabalho e pode dar muitos erros, então o esquema é o seguinte:

1 Crie uma interface repositório: isso serve para separar seu programa em duas partes: uma usa a interface e não tem a mínima ideia de onde está colocando os objetos que está guardando (já que ele joga para uma interface!)
1 Implemente a interface para memória, ie, crie uma classe que implemente a interface e coloque os objetos na memória. Só pra enganar o sistema por enquanto.
1 Agora faça o resto do sistema.
1 Depois, implemente a mesma interface para usar o banco de dados.
1 Agora troque de memória para banco de dados, e seu sistema vai estar funcionando com o BD!!!

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
public class RepositorioClienteImplMemo implements RepositorioGenerico<Cliente>{

    private List<Cliente> clientes = null;
    public RepositorioClienteImplMemo(){
        this.clientes = new ArrayList<>();
    }

    @Override
    public void inserir(Cliente t) {
        this.clientes.add(t);
    }

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

Se não entender me manda e-mail. Depois explico.


## Em breve, mais coisa aqui
