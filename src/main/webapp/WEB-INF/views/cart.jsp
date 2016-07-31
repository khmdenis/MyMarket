<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="<c:url value="/resources/styles.css" />" type="text/css"/>
    <style type="text/css">
        body {
            background-image: url(<c:url value="/resources/fon.jpg" />);
            background-size: 100%;

        }

        .product_table TABLE {

            font-size: 18px;
            background-color: Transparent !important;
            margin: 10px;
            empty-cells: hide;


        }

        .product_table TD, TR {
            color: white; /* Цвет текста */
            background-color: #49d3ce; /* Цвет фона ячеек */
            padding: 5px; /* Поля вокруг текста */
            max-width: 400px;
            text-align: center;
        }


        a {
            color: white;
        }

    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
</head>
<body>
<div style="display: inline-block">
    <c:choose>
        <c:when test="${!empty cart}">
            <table class="product_table">
            <tr style="background-color: #ce153e">
                <th>Name</th>
                <th>Amount</th>
                <th>Price</th>
            </tr>
                <c:forEach items="${cart}" var="product">
                <tr>
                    <td>${product.key.name}</td>
                    <td>${product.value}</td>
                    <td>${product.key.price*product.value}$</td>
                    <td><a href="<c:url value='/cart/remove/${product.key.id}' />">Remove</a></td>
                </tr>
            </c:forEach>
                <tr>
                    <td></td>
                    <td colspan="2">Total: ${cart.getTotalPrice()}$</td>
                    <td style="background-color:#ce153e "><a href="<c:url value='/cart/clean'/>">Clean cart</a></td>
                </tr>
            </table>
            <br/>
            <a class="cart_buy" href="<c:url value='/buyer_info'/>">Checkout</a>
        </c:when>
        <c:otherwise>
            <h1>Cart is empty</h1>
        </c:otherwise>
    </c:choose>
</div>
<br/>
<a href="<c:url value='/'/>">GO HOME</a>
</body>
</html>
