<%--
  Created by IntelliJ IDEA.
  User: jinhu
  Date: 2022-09-25
  Time: 오후 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>404</title>
</head>
<body>
    <script>
        alert("요청하신 페이지를 찾을 수 없습니다.");
        location.href = "<c:url value="/main"/>";
    </script>

</body>
</html>
