<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar um contato</title>

<!-- 
<link rel="stylesheet" href="../../css/jquery-ui.css" />
<script src="../../js/jquery-ui.js"></script>
<script src="../../js/jquery-ui.min.js"></script>
 -->

<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

  
</head>
<body>
<script>
$(function() {
    $( "#calendario" ).datepicker();
    
});
</script>
		
			
	<form:errors path="contato.nome" />
	<form action="adicionaContato" method="post">
		<input type="hidden" id="id" name="id" value="${contato.id}">
		<input type="text" id="nome" name="nome" value="${contato.nome}">
		
		Vivo? <input type="checkbox" name="vivo" value="true"
			${contato.vivo? 'checked' : '' } /> 
			
			<input type="text" id ="calendario" 
			name="dataNascimento"
			value="<fmt:formatDate
			value="${contato.dataNascimento.time}"
			pattern="dd/MM/yyyy" />" >
			</input>
			
		<input type="submit" value="Gravar"></input>
	</form>

</body>
</html>