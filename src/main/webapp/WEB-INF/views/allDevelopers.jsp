<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>All Developers</title>
</head>
<body>
<br>
<br>
<br>

    <a href="${pageContext.request.contextPath}/addDeveloper">Add Developer</a>
    <a href="${pageContext.request.contextPath}/addProject">Add Project</a>
    <br>
<h3>List of all Developers</h3>
${message}
<br>
<br>
<table border="1px" cellpadding="0" cellspacing="0">
    <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Speciality</th>
            <th>Experience</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
            <c:forEach var="developer" items="${developersList}">
                <tr>
                    <td>${developer.id}</td>
                    <td>${developer.firstName}</td>
                    <td>${developer.lastName}</td>
                    <td>${developer.specialty}</td>
                    <td>${developer.experience}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/editDeveloper/${developer.id}">Edit</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/deleteDeveloper/${developer.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
    </tbody>
</table>

<br>

<table border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th>Id</th>
        <th>Project Name</th>
        <th>Company Name</th>
        <%--<th>Developer Id</th>--%>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="project" items="${projectsList}">
        <tr>
            <td>${project.id}</td>
            <td>${project.projectName}</td>
            <td>${project.company}</td>
            <%--<td>${project.developer}</td>--%>
            <td>
                <a href="${pageContext.request.contextPath}/editDeveloper/${project.id}">Edit</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deleteDeveloper/${project.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
