<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisar Veículo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        h1 {
            font-weight: bold;
        }
        .container {
            margin-top: 50px;
            display: inline-block;
            text-align: left;
        }
        .btn-container {
            text-align: right;
            margin-bottom: 20px;
        }
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
            padding: 8px;
        }
        th {
            text-align: left;
        }
        input[type="text"], input[type="date"] {
            width: calc(100% - 16px);
            padding: 8px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <div class="container">
        <center><h1>Pesquisar Veículo</h1></center>
        <div class="btn-container">
            <button onclick="limparForm()">Limpar</button>
            <button onclick="window.location.href = 'veiculo.jsp'">Novo</button>
            <button onclick="pesquisar()">Pesquisar</button>
        </div>
        <form method="GET" action='VeiculoController' name="formVeiculoListagem">
        	<input type="hidden" name="action" value="pesquisar"/>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Placa</th>
                    <th>Modelo</th>
                    <th>Marca</th>
                    <th>Data Validade</th>
                </tr>
                <tr>
                    <td><input type="text" name="veiculoId"></td>
                    <td><input type="text" name="placa" maxlength="12"></td>
                    <td><input type="text" name="modelo" maxlength="100"></td>
                    <td><input type="text" name="marca" maxlength="100"></td>
                    <td><input type="date" name="fabricacao"></td>
                </tr>
		 		<tbody>
		            <c:forEach items="${listaVeiculos}" var="veiculo">
		                <tr>
		                    <td><a href="VeiculoController?action=editar&veiculoId=<c:out value="${veiculo.id}"/>"><c:out value="${veiculo.id}" /></a></td>
		                    <td><c:out value="${veiculo.placa}" /></td>
		                    <td><c:out value="${veiculo.modelo}" /></td>
		                    <td><c:out value="${veiculo.marca}" /></td>
		                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${veiculo.fabricacao}" /></td>
		                </tr>
		            </c:forEach>
		        </tbody>                
            </table>
        </form>
        <div id="lista-veiculos">
            <!-- Aqui será exibida a lista de veículos -->
        </div>
    </div>
    <script>
        function limparForm() {
            var inputs = document.querySelectorAll('input[type="text"], input[type="date"]');
            inputs.forEach(function(input) {
                input.value = '';
            });
        }
        
        function pesquisar() {
        	 var form = document.getElementsByName("formVeiculoListagem")[0];
             form.submit();
        }
    </script>
</body>
</html>
