<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adiciona um contato</title>
</head>
<body>
	<form:errors path="contato.nome"/>
	<form action="adicionaContato" method="post">
		<label for="nome"></label>
		<input type="text" id="nome" name="nome">
	
		<input type="submit" value="Gravar"></input>
	</form>
	
</body>
</html>