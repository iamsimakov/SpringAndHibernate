<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 24.11.2015
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
  <title>Find Page</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>

<h1>Results search</h1>

<c:if test="${!empty listUsers}">
  <table class="tg">
    <tr>
      <th width="80">User ID</th>
      <th width="120">User Name</th>
      <th width="120">User age</th>
      <th width="120">Is admin</th>
      <th width="120">Date</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.isAdmin}</td>
        <td>${user.createdDate}</td>
        <td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
        <td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<br>
<a href="<c:url value='/users' />" >Back</a>

</body>
</html>
