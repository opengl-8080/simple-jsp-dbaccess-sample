<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Hello</title>
  </head>
  <body>
    <ul>
      <c:forEach items="${requestScope.list}" var="item">
        <li>${item.id} : ${item.value}</li>
      </c:forEach>
    </ul>
  </body>
</html>
