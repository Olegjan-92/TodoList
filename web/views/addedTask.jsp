<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выполнено</title>
</head>
<body>
Добавлено!
<br>
<form action="/">
    <br>
Задание: ${userJSP.task};
<br/>
Статус: ${userJSP.status};
<br/>
    <br>
    <input type="submit" value="Готово">
</form>
</body>
</html>
