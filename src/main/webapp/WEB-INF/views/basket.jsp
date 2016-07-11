<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Basket</title>
    <link rel="stylesheet" href="<c:url value="/resources/form_style.css" />" type="text/css"/>
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
        }

    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
</head>
<body>
<div>
    <c:if test="${!empty basket.basket}">
        <table>
            <tr style="background-color: #ce153e">
                <th>Name</th>
                <th>Amount</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${basket.basket}" var="product">
                <tr>
                    <td>${product.key.name}</td>
                    <td>${product.value}</td>
                    <td>${product.key.price*product.value}$</td>
                    <td><a href="<c:url value='/basket/remove/${product.key.id}' />">Remove</a></td>
                </tr>
            </c:forEach>
            Total: ${basket.sum}$
        </table>
    </c:if>
    <a href="/buyer_info">BUY</a>
</div>
<a href="/">GO HOME</a>
</body>
</html>
