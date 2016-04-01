<%-- 
    Document   : apresentaProdutos
    Created on : Sep 12, 2015, 1:26:10 PM
    Author     : lucas
--%>

<%@page import="java.util.List"%>
<%@page import="dominio.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel="stylesheet"/>
    </head>
    <body>
        <jsp:include page="WEB-INF/header.jsp">
            <jsp:param name="titulo" value="Lista de Produtos"/>
        </jsp:include>
        
        <% List<Produto> produtos = (List<Produto>) session.getAttribute("produtos"); %>
        
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Descrição</th>
            </tr>
            <% for (Produto p : produtos) { %>
                <tr>
                    <td><%=p.getId()%></td>
                    <td><%=p.getNome()%></td>
                    <td><%=p.getDescricao()%></td>
                </tr>
            <% } %>
        </table>
        
    </body>
</html>
