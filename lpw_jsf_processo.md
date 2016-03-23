# Processo para construir sistemas com JavaServer Faces, Primefaces e Hibernate

Notas iniciais:
(Opcional) -> Nem todos os sistemas precisam, mas você precisa saber
[xxx] -> é opcional e não faz qualquer diferença
(??) -> Tenho dúvida! Ajudem-me
Podem fazer uma conta no GitHub e editar. As mudanças tem que ser confirmadas pro mim (lucasgueiros)

## Camada de negócio e construtores (builders)

### Camada de negócio

* Fazer o diagrama de classes (UML)
* Criar o projeto no NetBeans:
  * Escolha Java Web Application
  * Dê um nome ao projeto
  * Selecione a versão do Java e o servidor HTTP (usamos Tomcat)
  * Selecione o JavaServer Pages
    * Em Components selecione PrimeFaces 
  * Selecione Hiberntate
    * Escolha a opção para criar uma nova conexão
    * Escolha o driver do seu DBMS
    * host=localhost
    * A porta depende do DBMS. No postgresql é 5432
    * Entre no seu DBMS e crie uma base de dados
    * Coloque o nome da base no campo database
  * Finalize a contrução do projeto
* Crie um pacote negocio
* Programe as classes de acordo com seu diagrama

### Fazer os contrutores (builders)

* Crie um pacote para contrutores/builders
* Coloque todos os atributos da classe a ser contruída no builder
* Crie métodos get/set para cada atributo no builder
* Crie um construtor vazio
* Crie um método build() que contrói (new) e retorna o novo objeto
* A anotação @ManagedBean permite que você acesse uma instância da classe pelas páginas JSF.
  * Use o atributo name para dar um nome
* A anotação @RequestScoped faz com o que um objeto novo seja criaddo a cada requisição

## Camada de Persistência (Parte I)

### Fazer um repositório genérico

* Crie uma interface repositório genérica (com <>)
* Chame de Repositorio<T> ou RepositorioGenerico<T>. Vou usar o primeiro.
* Coloque os métodos do CRUD básico:
  * void/boolean adicionar ( Classe c ); 
   * boolean -> operação bem ou mal sucesidada
  * void/boolean/Classe remover (Classe c);
   * boolean -> operação bem ou mal sucesidada (mais usado ainda)
   * Classe -> retorna o objeto removido (muito usado)
  * void/boolean/Classe alterar (Classe c);
   * boolean -> operação bem ou mal sucesidada
   * Classe -> retorna o objeto alterado (pouco usado)
  * Clase recuperar (int id);
  * Collection<Classe> recuperar/recuperarTodos ();
* (Opcional) Crie um novo pacote para as implementações
* (Opcional) Crie uma interface para cada Classe que vai ter um repositório
  * extends Repositorio<T>
  * Pode adicionar outros métodos mais específicos
  * Quando for fazer implementações, use essas interfaces ao invés da genérica

## Implementar o repositório memória

* Crie uma classe Repositorio[Classe][Impl]Memoria
  * implements Repositorio<Classe>
* Adicione a implementação de todos os métodos
* Crie uma Collection (List, Set, Map etc) e coloque como atributo
* O método recuperar()/recuperarTodos() crie uma cópia da collection (normalmente lista)
  * Crie a nova collection
  * Adicione todos os elementos da original
  * retorne-a
* O método recuperar(int id) pode ser feito de duas formas
  * Percorra a collection elemento a elemento buscando pelo elemento com esse id 
  * Use um Map que mapeie os ids e os objetos. Assim basta dar get e retornar

## Criando a camada de aplicação

### Criar os controladores

* Controladores servem para relacionar o domínio, a persistência e a apresentação
* Crie a classe ControladorClasse
* Coloque um contrutor vazio
  * (??) Coloque a anotação @Deprecated
* Coloque um atributo RepositorioClasse (se tiver usando interfaces específicas, coloque-a aqui)
  * Inicialize-o no construtor com a implementação memória
* Coloque os método adicionar, remover, alterar, recuperar(int id), recuperar()
  * (Dica) No NetBeans, coloque em inserir código -> métodos delegados. Selecione o repositório e pronto
* Coloque a anotação @ManagedBean com o nome e @SessionScoped
  * @SessionScoped faz com que um objeto desse seja criado para cada sessão
```java
/**
 * @author Ismael
 */

@ManagedBean ( name = "controlador_classe" )
@SessionScoped
public class ControladorClasse {

  private RepositorioGenerico<Classe> repositorioClasse = null;

  public ControladorClasse(){
    this.repositorioClasse = new RepositorioClasseImplDB();
  }

  public void inserir(Classe classe){
    this.repositorioClasse.inserir(classe);
  }

  public void alterar(Classe classe){
    this.repositorioConsole.alterar(console);
  }

  public Classe recuperar(int codigo){
    return this.repositorioClasse.recuperar(codigo);
  }

  public List<Classe> recuperarTodos(){
    return this.repositorioClasse.recuperarTodos();
  }

  public void excluir(Classe classe){
    this.repositorioConsole.excluir(console);
  }
}
```

### Criar as páginas de JSF

* Para links diretos para páginas JSF, use faces/nome_da_pagina.xhtml.

#### Criando páginas de cadastro

* Crie uma página JSF com o h:form com id
* Crie uma "caixa" com p:fieldset
  * legend: é tipo um título da página
* Crie uma tabela com p:panelGrid
  * columns: diz quantas colunas a tabela vai ter. Por enquanto duas
* Coloque pares desses dois elementos para cada campo do formulário:
  * h:outputText para colocar uma label em cada campo (atributo value)
  * p:inputText para a "caixa de texto" onde o usuário vai digitar
    * O atributo value vai receber o nome do campo correspondente "#{builder.campo}"
* No final, dentro do fieldset e fora do panelGrid, coloque o button:
  * use a tag p:commandButton com os atributos:
    * value: o texto que vai aparecer no botão
    * action: mande-o cadastrar o objeto gerado pelo builder:
      * "#{controlador.adicionar( builder.build() ) }"

Exemplo: 
```xhtml
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:p="http://primefaces.org/ui">
    <h:head>
        <title>Facelet Title</title>
    </h:head>
    <h:body>
        <h:form id="formulario">
            <p:fieldset legend="Cadastrar cursos">
                <p:panelGrid columns="2">
                    <h:outputText value="Id*:"/>
                    <p:inputText value="#{builder_curso.id}"/>
                    
                    <h:outputText value="Nome*:"/>
                    <p:inputText value="#{builder_curso.nome}"/>
                    
                </p:panelGrid>
                
                <p:commandButton value="Cadastar" action="#{ctrl_curso.adicionar(builder_curso.build())}"/>
                
            </p:fieldset>
        </h:form>
    </h:body>
</html>
```

#### Criando página de consulta

* Crie uma nova página JSF
* Coloque o h:form de sempre com id
* Abra um p:dataTable com dois atributos (imagine como o for(Classe var : lista)
  * var: é o objeto que está naquela linha
  * value: é a lista de objetas (recupere do controlador)
  * emptyMessage: é uma mensagem a ser exibida quando não tiver nada a tabela
* Para cada coluna, abra um p:column
  * headerText: é o nome da coluna
* Dentro do p:column coloque um h:outputText
  * No value coloque o valor do atributo, recuperando de var
  
Exemplo:
```xhtml
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:p="http://primefaces.org/ui">
    <h:head>
        <title>Facelet Title</title>
    </h:head>
    <h:body>
        <h:form id="formulario">
            <p:dataTable var="curso" value="#{ctrl_curso.recuperar()}" emptyMessage="Nenhum curso cadastrado" >

                <p:column headerText="Id">
                    <h:outputText value="#{curso.id}" />
                </p:column>

                <p:column headerText="Nome">
                    <h:outputText value="#{curso.nome}"/>
                </p:column>

            </p:dataTable>
        </h:form>
    </h:body>
</html>
```

#### Adicionando função remover

#### Adicionando função alterar

#### Adicionando consultar personalizadas

#### Criando menus de confirmação

#### Verificando campos obrigatórios

## Camda de persistência (Parte II - Banco de Dados)

### Fazer o DaoManager do Hibernate

* Crie um pacote para ele
* Copie esse código aqui (ou decore para a prova hehehe):

```java
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Eduardo
 */
public class DaoManagerHiber {
    private static DaoManagerHiber myself = null;
    
    private SessionFactory sessionFactory;
    private Session s;

    private DaoManagerHiber(){

    try{

        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        s = sessionFactory.openSession();
        

    }catch(Throwable th){

        System.err.println("Enitial SessionFactory creation failed"+th);

        throw new ExceptionInInitializerError(th);

    }

  }
    
    public static DaoManagerHiber getInstance(){
        if(myself==null)
            myself = new DaoManagerHiber();
        
        return myself;
    }
  
    public void persist(Object o){
        
        Transaction tr = null;
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
        
        s.save(o);
        
        tr.commit();
        
        s.flush();
    }
    
    public List recover(String hql){
        Transaction tr = null;
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
         
        
        Query query = s.createQuery(hql);
        
        s.flush();
        
        return query.list();
    }
    
    public List recoverSQL(String sql){
        Transaction tr = null;
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
         
        
        Query query = s.createSQLQuery(sql);
        
        s.flush();
        
        return query.list();
    }
    
    public List recover(Object o){
        
        Criteria c = s.createCriteria(o.getClass());
        
        c.add(Example.create(o).enableLike(MatchMode.ANYWHERE).ignoreCase().excludeProperty("codigo"));
        
        List l = c.list();
        s.flush();
        
        return l;
    }
    
    public void update(Object o){
        Transaction tr = null;
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
         
        
        s.update(o);
        
        tr.commit();
        
        s.flush();
    }
    
    public void delete(Object o){
        Transaction tr = null;
        try{
            s.clear();
            s = sessionFactory.openSession();
            tr = s.beginTransaction();
        }catch(Exception ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();
        }
        
        
        s.delete(o);
        
        tr.commit();
        
        s.flush();
    }
    
    public static void main(String args[]){
        SchemaExport se = new SchemaExport(new AnnotationConfiguration().configure());
		se.create(true, true);
                
       
    }
    
}
```

### Colocar anotações nas classes do domínio

### Implementar o repositório para Banco de Dados

* Crie um pacote para colocarar as implementações
* Crie uma classe 
* Crie os métodos
  * Inserir
  * Alterar
  * Remover
  * Recuperar
  * Recupear todos
* Esses métodos delegam as tarefas para o DaoManager
* Os métodos inserir, alterar e remover recebem o objeto
* Os métodos recuperar e recuperar todos usar HQL para recuperar
  * recuperar: "from <Classe> where codigo=" + codigo
  * recuperarTodos: "from <Classe>"
* O método recuperar recebe o codigo/id do objeto. Depois de chamar do Dao para pegar o HQL ele recebe uma lista e deve pegar o primeiro elemento

```java
/**
 * @author Ismael
**/
@Override
public void inserir(Classe o) {
  DaoManagerHiber.getInstance().persist(o);
}
@Override
public void alterar(Classe o) {
  DaoManagerHiber.getInstance().update(o);
}
@Override
public Classe recuperar(int codigo) {
  return (Classe) DaoManagerHiber.getInstance().recover("from NomeDaClasse where codigo="+codigo).get(0);
}
@Override
public void excluir(Classe o) {
  DaoManagerHiber.getInstance().delete(o);
}
@Override
public List<Classe> recuperarTodos() {
  return DaoManagerHiber.getInstance().recover("from NomeDaClasse");
}
```

### Subsituir implementação memória pela de banco de dados

* Basta alterar os controladores.
* Nos seus contrutores, deve ter a inicialização do RepositorioClasse[Impl]Memoria
* Subistitua por RepositorioClasse[Impl]DB
* Prontinho!

# Parte de Ismael

Procedimentos para a criação de um projeto em LPW
1° Declara o Entity e o Table

* declara antes do class
* @ Entity e @ Table

2° Declara o Id e o GeneratedValue

* @Id obrigatório e o @GeneratedValue antes da primaryKey
* se quiser colocar o @Column (length = 20[tamanho opcional]) private string variável;

3° Se precisar colocar o @ManyToMany e etc, se tiver alguma lista.

4° Colocar os construtores

* @Deprecated no construtor vazio.

5° Onde tiver lista, iniciar dentro do construtor

6° É necessário criar um banco de dados.

* Create database NomeDoBanco;

7° Alterar o hibernate config do projeto

* altera o nome do banco de dados no connection.url depois do 3306/nome?
* coloca um connection.password, se o banco de dados tiver senha.

8° Fazer o mapeamento das classes

* <mapping class=”cordenadas da classe”/>

9°Copia o Dao e o executa com o drivr do JDBC o mysql (importa da biblioteca)

* o Dao é o responsável por gerenciar o banco de dados, pode dar erro nos many’s.

10° Criar os repositórios (comportamentos)

* criar um novo pacote, esse pacote normalmente será chamado de comportamentos
* criar uma interface (repositório genérico)
* criar outros repositórios, mas dessa vez serão classes
* Essas novas classes implementarão o repositório genérico.
* dentro delas faz o CRUD, segue o passo a passo:
* ->


11) Inserir o JSF

* @ManagedBean (name =”bClasse”), serve para identificar as classes no JSF
* @RequestScoped
* fazer isso nos Builders, antes do class

12)Criar os controladores, mas como?

* criar um pacote, esse pacote normalmente será chamado de controladores
* criar classe
* criar um objeto, private RepositorioGenerico<classe>
* criar um construtor
* colocar os métodos
* Notações: @ManagedBean , @SessionScoped , colocar um objeto no escopo da seção.
* exemplo de um controlador:




13) Criar página cadastro, mas como?

* Vai na pasta páginas web.
* Cria uma página JSF
* No body, criar o form, como? -> <h:form id=”NomeDoID”></h:form>
* Dentro do form, cria o fieldset, faz uma caixa com uma borda superior na pag da web.<p:fieldset></p:fieldset>
* - Dentro do fieldset cria um panelgrid.
* exemplo:


```xhtml
<h:body>
 <h:form id="formulario">

 <p:fieldset legend="Cadastro de Console">

 <p:panelGrid columns="2">

 <h:outputText value ="Nome"/>

 <p:inputText value="#{bConsole.nome}"

 </p:panelGrid>

 </p:fieldset>

 </h:form>

</h:body>
```
