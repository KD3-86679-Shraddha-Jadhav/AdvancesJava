
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration bean</title>
</head>
<body>
  <h2>RegisterBean
  </h2>
	<div>
		<%-- create bean object --%>
		<jsp:useBean id="cb1" class="com.sunbeam.RegisterationBean"/>
		<%-- set bean field values from req parameters --%>
		<jsp:setProperty name="cb1" property="firstname" param="firstname" />
		<jsp:setProperty name="cb1" property="lastname" param="lastname" />
		<jsp:setProperty name="cb1" property="email" param="email" />
		<jsp:setProperty name="cb1" property="passwd" param="passwd" />
		<jsp:setProperty name="cb1" property="dob" param="dob" />
		<%-- call business logic --%>
		
		<%-- call a method --%>
           ${cb1.Register() }
       
	<%-- choose-when statement to implement if-else ladder --%>
	<c:choose>
		<c:when test="${cb1.count == 1}">
			Registered Successfully! : ${count}
		</c:when>
		<c:otherwise>
			Registeration Failed! : ${count}
		</c:otherwise>
	</c:choose>
		
		
	</div>

</body>
</html>