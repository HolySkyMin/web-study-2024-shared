<%@ page import="hello.servlet.domain.member.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Model model = (Model)request.getAttribute("model");
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=Long.parseLong(model.getParameter("id"))%></li>
    <li>username=<%=model.getParameter("username")%></li>
    <li>age=<%=Integer.parseInt(model.getParameter("age"))%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>