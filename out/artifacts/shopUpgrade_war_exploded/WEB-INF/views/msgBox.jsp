<%--
  Created by IntelliJ IDEA.
  User: HANJAEWOOK
  Date: 2022-09-20
  Time: 오후 6:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
  <script>
      if('${msg}' != ""){
        alert('${msg}');
      }
      if('${url}' != ""){
        location.href = '<c:url value="${url}"/>'
      }

  </script>
</body>
</html>
