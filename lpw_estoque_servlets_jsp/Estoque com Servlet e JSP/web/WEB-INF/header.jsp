<%-- 
    Document   : header
    Created on : Sep 12, 2015, 12:32:46 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel="stylesheet"/>
    </head>
    <body>
        <h1 class="sistema_titulo"> Sistema estoque </h1>
        <p>Por Lucas Gueiros</p>
        
        <% if (null != session.getAttribute("mensagem")) { %>
            <p> <%=session.getAttribute("mensagem")%> </p>
            <% session.removeAttribute("mensagem"); %>
        <% } %>
 
        
        <% 
        String indice_param = request.getParameter("indice");
        
        if (indice_param==null || indice_param.equals("true")) { %>
            <p><a href="index.jsp">Índice</a></p>
        <% } %>
        
        <% if (null != request.getParameter("titulo")) { %>
            <h2><%=request.getParameter("titulo")%></h2>
        <% } %>
        
        
    </body>
</html>
