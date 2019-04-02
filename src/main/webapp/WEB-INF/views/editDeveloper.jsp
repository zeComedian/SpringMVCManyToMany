<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maksf
  Date: 01.04.2019
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>${headerMessage}</h1>

    <form:form method="post" action="editDeveloper" modelAttribute = "developer">
        <form:hidden path="id"></form:hidden>
        <table>
            <tr>
                <td><form:label path="firstName">First Name</form:label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><form:label path="lastName">Last Name</form:label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><form:label path="specialty">Speciality</form:label></td>
                <td><form:input path="specialty"/></td>
            </tr>
            <tr>
                <td><form:label path="experience">Experience</form:label></td>
                <td><form:input path="experience"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>

    </form:form>
</body>
</html>
