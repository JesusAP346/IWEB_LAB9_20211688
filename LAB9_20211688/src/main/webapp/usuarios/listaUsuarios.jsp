<%--
  Created by IntelliJ IDEA.
  User: Blanca
  Date: 19/06/2024
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab9_20211688.beans.UsuarioB" %>
<jsp:useBean id="lista" scope="request" type="ArrayList<com.example.lab9_20211688.beans.UsuarioB>"/>


<html>
<head>
    <title>Lista de empleados</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<h1>Lista de usuarios operativos</h1>


<table class="table table-striped table-hover mt-3">
    <tr class="table-info">
        <th>Usuario id</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Tipo de licencia</th>
        <th>Estado de licencia</th>
        <th>Pais de procedencia</th>
        <th>Cantidad de reservas en lo que va del año</th>


    </tr>
    <%for(UsuarioB usuarioB : lista){%>
    <tr>
        <td><%=usuarioB.getIdUsuario() %></td>
        <td><%=usuarioB.getNombre() %></td>
        <td><%=usuarioB.getApellido() %></td>
        <td><%=usuarioB.getLicenciaB().getCategoria() %></td>
        <td><%=usuarioB.getLicenciaB().getEstado() %></td>
        <td><%=usuarioB.getLicenciaB().getPais().getNombre() %></td>
        <td>a</td>
    </tr>
    <% } %>

</table>

</body>
</html>
