<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login bean</title>
</head>
<body>
  <h2>Login
  </h2>
	<div>
		<%-- create bean object --%>
		<jsp:useBean id="cb2" class="com.sunbeam.LoginBean"/>
		<%-- set bean field values from req parameters --%>
		
		<jsp:setProperty name="cb2" property="email" param="email" />
		<jsp:setProperty name="cb2" property="passwd" param="passwd" />
		
		<%-- call business logic --%>
		
		<%-- call a method --%>
           ${cb2.Login() }
       
	<%-- choose-when statement to implement if-else ladder --%>
	<c:choose>
		<c:when test="${cb2.count == 1}">
			
			<c:redirect url="candlist.jsp"/>
		</c:when>
		<c:otherwise>
			Login Failed! : ${count}
		</c:otherwise>
	</c:choose>
		
		
	</div>
</body>
</html>