<!-- обратите внимание на spring тэги -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <meta charset="utf-8">
  <title>Добавить запись</title>
</head>

<body>
Добавление записи:
<form action="/addedTask" method="post">
  <table>
    <tr><br></tr>
    <tr>
      <td>Задание</td>
      <td>Статус</td>
    </tr>
    <tr>
      <td><input type="text" name="task"></td>
      <td><input type="text" name="status"></td>
    </tr>
  </table>
  <br>
  <input type="submit" value="Добавить">
</form>
</body>
</html>
