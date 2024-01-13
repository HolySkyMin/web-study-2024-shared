<%@ page import="hello.servlet.domain.member.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Model model = (Model)request.getAttribute("model");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%="/"+model.getParameter("type")+"/members/save"%>" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
