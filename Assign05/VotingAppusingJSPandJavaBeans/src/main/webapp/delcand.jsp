<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>

<jsp:useBean id="dcb" class="com.sunbeam.DeleteCandidateBean"/>
<jsp:setProperty name="dcb" property="id" />

${ dcb.deleteCandidate()}

<jsp:forward page="result.jsp"/>

</body>
</html>