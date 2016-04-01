<%-- 
    Document   : index
    Created on : Sep 12, 2015, 12:05:55 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estoque com Servlet e JSP</title>
        <link href="style.css" rel="stylesheet"/>
    </head>
    <body>
        <jsp:include page="WEB-INF/header.jsp">
            <jsp:param name="titulo" value="Índice"/>
            <jsp:param name="indice" value="false"/>
        </jsp:include>
        
        <ul>
            <li> Cadastrar: <ul>
                <li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>      
            </ul></li>
            <li> Consultar e Alterar: <ul>
                <li><a href="ListarTodosOsProdutos">Consultar Produtos</a></li>      
            </ul></li>
        </ul>
        
        
        <!--<a href="cadastrarFuncionario.html">Cadastrar Funcionário</a> <br/>
        <a href="cadastrarFornecedor.html">Cadastrar Fornecedor</a> <br/>-->
    </body>
</html>
