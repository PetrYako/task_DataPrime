<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: peotr
  Date: 31.10.2019
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Чат</title>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/message.css">
<body>
<div>
    <div class="chat">
        <h3>Чат:</h3>
        <c:forEach items="${messages}" var="message">
            <jsp:useBean id="message" type="model.Message"/>
            <p><span
                    class="time-right"><%=message.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))%></span>${message.text}<span
                    class="name-left">${message.user.name}:</span></p>
        </c:forEach>
    </div>
    <div class="users">
        <h3>Пользователи онлайн:</h3>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" type="model.User"/>
            <p>${user.name}</p>
        </c:forEach>
    </div>
    <form method="post" action="chat?action=sendMessage&user=${userName}&dateTime=<%=LocalDateTime.now()%>">
        <div class="enter">
            <textarea name="mess" placeholder="Введите сообщение"></textarea>
            <button type="submit">Отправить</button>
        </div>
    </form>
</div>
</body>
</html>
