<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="p1.poo.fatecpg.noturno.Disciplinas"%>

<%
    Disciplinas arrayDisci = null;
    try{
        arrayDisci = (Disciplinas) application.getAttribute("arrayDisic");
    }catch(Exception e){
        
    }
    
    if(request.getParameter("alterar") != null){
        int i = Integer.parseInt(request.getParameter("i"));
        float nota = Float.parseFloat(request.getParameter("nota"));
        arrayDisci.getList().get(i).setNota(nota);
        response.sendRedirect(request.getContextPath()+"/disciplinas.jsp");
        
    }

%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sobre</title>
    </head>
    <body>
        <h1>Sobre</h1>
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Ementa</th>
                    <th>Ciclo</th>
                    <th>Nota</th>
                </tr>
            </thead>
            <tbody>
                <%for(int i = 0; i<arrayDisci.getList().size(); i++){%>
                <tr>
                    <td><%= arrayDisci.getList().get(i).getNome()%></td>
                    <td><%= arrayDisci.getList().get(i).getEmenta()%></td>
                    <td><%= arrayDisci.getList().get(i).getCiclo()%></td>
                    <td>
                        <form method="post">
                            <%= arrayDisci.getList().get(i).getNota()%>
                            <input type="number" name="nota" value="0.0" step="0.1" max="10" min="0"/><br/>
                            <input type="submit" name="alterar" value="Alterar Nota"/>
                            <input type="hidden" name="i" value="<%= i%>"/>
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
