<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="/">Add New Products</a>

	<table border="1">
		<thead >
			<tr>
				<th>SL</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
		
		<c:forEach items="${products}" var="product" varStatus="index">

    <tr>
    <td>${index.count}</td>
    <td>${product.name}</td>
    <td>${product.price}</td>
    <td>${product.qty}</td>

    <td>
        <a href="edit?pid=${product.pid}">Edit</a>
        <a href="delete?pid=${product.pid}"
           onclick="return confirm('Are you sure?')">Delete</a>
    </td>
</tr>

</c:forEach>
		</tbody>
	</table>

</body>
</html>