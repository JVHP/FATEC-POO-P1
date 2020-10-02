<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="p1.poo.fatecpg.noturno.Disciplinas"%>

<%
    Disciplinas arrayDisci = null;
    try{
        arrayDisci = (Disciplinas) application.getAttribute("arrayDisci");
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
        <title>Disciplinas</title>
    </head>
    <%@include file="WEB-INF/jspf/style.jspf"%>
    <body>
        <div align="center">
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Disciplinas</h1>
        <table class="table-sm table-bordered">
            <thead>
                <tr align="center">
                    <th class="table-spot">Nome</th>
                    <th class="table-spot">Ementa</th>
                    <th class="table-spot">Ciclo</th>
                    <th class="table-spot">Nota</th>
                </tr>
            </thead>
            <tbody>
                <%for(int i = 0; i<arrayDisci.getList().size(); i++){%>
                <tr align="center">
                    <td style="width: 120px;"><%= arrayDisci.getList().get(i).getNome()%></td>
                    <td style="width: 400px; font-size: 11px"><%= arrayDisci.getList().get(i).getEmenta()%></td>
                    <td style="width: 80px;"><%= arrayDisci.getList().get(i).getCiclo()%>º</td>
                    <td>
                        <form method="post">
                            <%= arrayDisci.getList().get(i).getNota()%>
                            <input type="number" name="nota" value="0.0" step="0.1" max="10" min="0" style="width: 50px; background-color: #232323"/><br/>
                            <input type="submit" name="alterar" value="Alterar Nota"/>
                            <input type="hidden" name="i" value="<%= i%>"/>
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
        </div>
    </body>
</html>
