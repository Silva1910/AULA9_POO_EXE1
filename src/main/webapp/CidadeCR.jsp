<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CIDADE DE CURITIBA</title>
<link rel="stylesheet" href="./css/styles.css">
</head>

<body>


<nav id="menu">
    <ul>
        <li><a href="CidadeSP.jsp">Cidade de S�o Paulo </a></li>
        <li><a href="CidadeBH.jsp">Cidade de Belo Horizonte </a></li>
        <li><a href="CidadePT.jsp">Cidade de Porto Alegre</a></li>
    	<li><a href="CidadeCR.jsp">Cidade de Curitiba</a></li>
   
    </ul>
</nav>

<div class="container" align="center">
    <form action="CidadeCR" method="post">
        <p class="title"><b> CIDADE DE CURITIBA </b></p>
        <table>
            <tr>
                <td><input class="input_data" type="number" id="idade" name="idade" step="1" placeholder="idade" oninput="validarValor(this);"  required></td>
            </tr>
            <tr>
                <td><input class="input_data" type="number" id="areaTotal" name="areaTotal" step="1" placeholder="Area Total" oninput="validarValor(this);" required ></td>
            </tr>
            <script>
                function validarValor(input) {
                    if (input.value < 0) {
                        input.value = 0;
                    }
                }
            </script>
            <tr>
                <td>
                    <input type="hidden" name="cmd" id="cmd" value="">
                    <input type="submit" id="EnviarCalcular" name="EnviarCalcular" value="Enviar"	onclick="document.getElementById('cmd').value = 'Enviar';">
                </td>
            </tr>
        </table>
    </form>
</div>

<br/>
<br/>
<c:if test="${not empty imposto}">
    <div id="output" align="center">
        O valor total de imposto a pagar � ${imposto}.
    </div>
</c:if>




</body>
</html>
