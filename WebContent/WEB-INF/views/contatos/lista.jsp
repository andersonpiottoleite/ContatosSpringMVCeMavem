<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<<!-- script type="text/javascript" src="../../util.js"></script>  -->
</head>
<body>

	<table border="solid 1px">
		<tr>
			<th>Nome</th>
			<th>Vivo ?</th>
			<th>Data de nascimento</th>
			<th>Remove</th>
		</tr>
		<c:forEach var="c" items="${lista}" varStatus="indice">
			<tr bgcolor="#${indice.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td> 
					<a href="/ContatosSpringMVCeMavem/carregaContato?id=${c.id}">${c.nome}</a>
				</td>
				<td>
					<c:if test="${c.vivo eq true}">
					  <td id="contato_${c.id}">
					    	<a href="#" onclick="mataAgora(${c.id})">Mata agora!</a>
					    </td>	
					</c:if>
					<c:if test="${c.vivo eq false}">
					   Morto!
					</c:if>
				</td>
				<td>
				 	<fmt:formatDate value="${c.dataNascimento.time}" pattern="dd/MM/yyyy"/>	
				</td>
				<td>
				 	<a href="/ContatosSpringMVCeMavem/remove?id=${c.id}">Remover</a>	
				</td>
		</c:forEach>
	</table>

</body>
</html>