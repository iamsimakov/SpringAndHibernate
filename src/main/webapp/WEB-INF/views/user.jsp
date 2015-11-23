<%--<!doctype html>
<html ng-app>
<head>
	<title>Spring MVC + AngularJS Demo</title>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
	<script>
		function Hello($scope, $http) {
			$http.get('http://localhost:8080/SpringAndHibernate/testangular.json').
					success(function(data) {
						$scope.users = data;
						document.write(data);
					});
		}
	</script>
</head>
<body>
<div ng-controller="Hello">
	<h2>Spring MVC + AngularJS Demo</h2>
	<p>EMail Id : {{user.emailId}}</p>
	<p>User Name : {{user.userName}}</p>
	<ul>
		<li ng-repeat="user in users">
			{{ user.name }}
		</li>
	</ul>

</div>
</body>
</html>--%>





<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a User
</h1>

<c:url var="addAction" value="/user/add" ></c:url>

<form:form action="${addAction}" commandName="user">
<table>

	<c:if test="${!empty user.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td>
	</tr>
	</c:if>

	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="age">
				<spring:message text="Age"/>
			</form:label>
		</td>
		<td>
			<form:input path="age" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="isAdmin">
				<spring:message text="isAdmin"/>
			</form:label>
		</td>
		<td>
			<form:input path="isAdmin" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="createDate">
				<spring:message text="Date"/>
			</form:label>
		</td>
		<td>
			<form:input type="date" path="createDate" name="createDate" value=""/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.name}">
				<input type="submit"
					value="<spring:message text="Edit User"/>" />
			</c:if>
			<c:if test="${empty user.name}">
				<input type="submit"
					value="<spring:message text="Add User"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Users List</h3>
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
			<td>${user.createDate}</td>
			<td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
