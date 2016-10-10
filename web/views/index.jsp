<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<head>
  <meta charset="utf-8">
  <title>Добавить запись</title>
</head>
<body>
<h1>ToDoList</h1>
<table style="border-collapse: collapse; width: 800px; text-align:center">
    <thead>
    <tr>
        <th>Задание</th>
        <th>Статус</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="persona">
            <c:url var="deleteUrl" value="/deletetask?id=${persona.id}" />
            <c:url var="editUrl" value="/edittask?id=${persona.id}" />
    <tr>
        <td style="border: 1px solid black"><c:out value="${persona.task}"/></td>
        <td style="border: 1px solid black"><c:out value="${persona.status}"/></td>
        <td style="border: 1px solid black"><a href="${editUrl}">Изменить</a>/<a href="${deleteUrl}" onclick ="return confirm('Удалить запись?');">Удалить</a></td>
    </tr>
        </c:forEach>
    </tbody>
</table>
<br>
<form action="${pageContext.servletContext.contextPath}/views/addTask.jsp">
    <button type="submit">Добавить запись</button>
</form>
</body>
</html>
