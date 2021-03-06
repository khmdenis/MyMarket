<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


    <c:forEach items="${deals}" var="deal">
        <div class="deals">
            <span>Buyer: ${deal.buyer.name} <span class="date"><fmt:formatDate value="${deal.date}"
                                                                               pattern="dd.MM.yyy HH:mm:ss"/></span></span>
            <br/> <c:forEach items="${deal.items}" var="product">
            - ${product.product.name} x${product.quantity}<br/>
        </c:forEach>
            <br/><span>Total: ${deal.total}$</span>
        </div>
        <br/>
    </c:forEach>

</body>
</html>
