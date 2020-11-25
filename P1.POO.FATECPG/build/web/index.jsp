<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="p1.poo.fatecpg.noturno.Disciplinas"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <%@include file="WEB-INF/jspf/style.jspf"%>
    <body>
        <div align="center">
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Página Inicial</h1>
        <p>Nome: José Vinícius Henrique Pereira</p>
        <p>RA: 1290481913041</p>
        <p>Disciplinas Matriculadas: <%= Disciplinas.getList().size()%></p>
        </div>
    </body>
</html>
