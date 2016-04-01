<%-- 
    Document   : cadastrarProduto
    Created on : Sep 12, 2015, 12:53:10 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
        <link href="style.css" rel="stylesheet"/>
    </head>
    <body>
        <jsp:include page="WEB-INF/header.jsp">
            <jsp:param name="titulo" value="Formulário de cadastro de produtos"/>
        </jsp:include>
        
        <form action="CadastrarProdutoServlet" method="post">
            <table>
            
                <!--Vamos colocar o ID automaticamente -->
                <!--<tr> <td>id:</td> <td> <input type="number" name="id"> </td> </tr>-->
                <tr> <td>nome:</td> <td> <input type="text" name="nome"> </td> </tr>
                <tr> <td>descricao:</td> <td> <input type="text" name="descricao"> </td> </tr>
            
            </table>
            <input type="submit" id="enviar" value="Cadastrar">
        </form>
        
    </body>
</html>
