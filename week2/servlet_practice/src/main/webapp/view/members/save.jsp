<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=Long.parseLong(request.getParameter("id"))%></li>
    <li>username=<%=request.getParameter("username")%></li>
    <li>age=<%=Integer.parseInt(request.getParameter("age"))%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>