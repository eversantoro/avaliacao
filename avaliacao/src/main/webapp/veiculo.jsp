<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Veículo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pikaday/css/pikaday.css">
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
            width: 50%;
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
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <div class="container">
        <center><h1>Cadastrar Veículo</h1></center>
		        
        <div class="btn-container">
            <button onclick="gravar()">Gravar</button>
            <button onclick="excluir()">Excluir</button>
            <button onclick="pesquisar()">Pesquisar</button>
        </div>
        <form method="POST" action='VeiculoController' name="formVeiculo">
         
            <table>
                <tr>
                    <th>Id</th>
                    <th>Placa*</th>
                    <th>Modelo*</th>                    
                    <th>Marca</th>
                    <th>Fabricação</th>
                </tr>
                <tr>
                    <td><input type="text" readonly name="veiculoId" value="<c:out value="${veiculo.id}"/>"/></td>
                    <td><input type="text" maxlength="12" name="placa" value="<c:out value="${veiculo.placa}"/>" required /></td>
                    <td><input type="text" maxlength="100" name="modelo" value="<c:out value="${veiculo.modelo}"/>" required /></td>
                    <td><input type="text" maxlength="100" name="marca" value="<c:out value="${veiculo.marca}" />" /></td>
                    <td><input type="date" name="fabricacao" value="<c:out value="${veiculo.fabricacao}" />"></td>
                </tr>
            </table>
        </form>
    </div>

<script>

    function excluir() {
    	var url = 'VeiculoController?action=apagar&veiculoId=<c:out value="${veiculo.id}"/>';
    	window.location.href = url;
    }

    function pesquisar() {
    	var url = 'VeiculoController?action=listarVeiculo';
    	window.location.href = url;
    }
    
    function gravar() {
    	  if ( document.formVeiculo.placa.value == '')
    	  {
    	   alert ('A Placa não pode ser nula!');
    	   return false;
    	  }
    	  if ( document.formVeiculo.modelo.value == '')
    	  {
    	   alert ('O Modelo não pode ser nulo!');
    	   return false;
    	  }    	
        var form = document.getElementsByName("formVeiculo")[0];
        form.submit();
    }
    
</script>

    
</body>
</html>

