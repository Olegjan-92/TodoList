<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 06.09.16
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Изменение записи</title>
</head>
<body>
<h1>Изменение записи</h1>
<form:form modelAttribute="personAttribute" method="POST" action="/edittask?id=${personAttribute.id}">
    <table>
        <tr>
            <td><form:label path="id">Id:</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="task">Задание:</form:label></td>
            <td><form:input path="task"/></td>
        </tr>

        <tr>
            <td><form:label path="status">Статус:</form:label></td>
            <td><form:input path="status"/></td>
        </tr>

    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>