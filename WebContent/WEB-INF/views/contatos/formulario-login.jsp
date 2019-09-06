<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="resources/css/contatos.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/util.js"></script>
</head>
<body>
<h1>Efetuar Login</h1>
<form action="efetuaLogin" method="post">
	<label>Nome:</label> 
	<input type="text" name="nome"/>
	<label>Senha:</label> 
	<input type="password" name="senha"/>
	<input type="submit" value="Logar"/>
</form>

</body>
</html>