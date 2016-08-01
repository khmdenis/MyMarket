<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Products</title>
    <link rel="stylesheet" href="<c:url value="/resources/styles.css" />" type="text/css"/>
    <style type="text/css">
        body {
            background-image: url(<c:url value="/resources/fon.jpg" />);
            background-size: 100%;

        }

        div {
            float: left;
        }

        TABLE {
            background: white; /* Цвет фона таблицы */
            color: white; /* Цвет текста */
            font-size: 18px;
            background-color: Transparent !important;
            margin: 10px;

        }

        TD, TR {
            background-color: #49d3ce; /* Цвет фона ячеек */
            padding: 5px; /* Поля вокруг текста */
            max-width: 400px;
        }

        a {
            color: white;
            display: block;
            height: 100%;
            text-decoration: none;
        }

    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
</head>
<body>
<div class="form-style-5">
    <form:form action="/mymarket/products/add" commandName="product">
        <c:if test="${!empty product.name}">
            <form:hidden path="id"/>
        </c:if>
        <legend><span class="number">1</span>Name</legend>
        <form:input path="name"/><br/>
        <legend><span class="number">2</span>Price</legend>
        <form:input path="price"/><br/>
        <legend><span class="number">3</span>Description</legend>
        <form:textarea path="description"/><br/>
        <input type="submit" value="Add product">
    </form:form>
</div>
<div>
    <c:if test="${!empty listProducts}">
        <table>
            <tr style="background-color: #ce153e">
                <th><a href="<c:url value="/products/sort=name"/>">Name</a></th>
                <th><a href="<c:url value="/products/sort=price"/>">Price</a></th>
                <th>Description</th>
            </tr>
            <c:forEach items="${listProducts}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}$</td>
                    <td>${product.description}</td>
                    <td><a href="<c:url value='/cart/put/${product.id}'/>">Put in basket</a></td>
                    <td><a href="<c:url value='/products/edit/${product.id}' />">Edit</a></td>
                    <td><a href="<c:url value='/products/remove/${product.id}' />">Remove</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>
<a class="go-to-cart" href="<c:url value='/cart'/>">
    <c:if test="${!empty cart}">
        <span class="indicator"> ${cart.getTotalQuantity()}</span>
    </c:if>
    <img src="<c:url value="/resources/cart.png" />"></a>
<a class="go-to-cart" href="<c:url value='/deals'/>">
    <img src="<c:url value="/resources/order.png" />"></a>

</body>
</html>
