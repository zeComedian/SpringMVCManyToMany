<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maksf
  Date: 02.04.2019
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Project</title>
</head>
<body>
<h1>${headerMessage}</h1>
<form:form method="post" action="addProject" modelAttribute = "project">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="projectName">Project Name</form:label></td>
            <td><form:input path="projectName"/></td>
        </tr>
        <tr>
            <td><form:label path="company">Company Name</form:label></td>
            <td><form:input path="company"/></td>
        </tr>
        <tr>
            <td><input name="developerId" type="text"> Developer ID</td>
            <td></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>


</body>
</html>
