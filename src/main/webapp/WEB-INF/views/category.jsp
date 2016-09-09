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
<div class="form-style-5">
    <form:form modelAttribute="category" action="/mymarket/category/add">
        <form:hidden path="id"/>
        <legend><span class="number">1</span>Name</legend>
        <form:input path="name"/><br/>
        <input type="submit" value="Add category">
    </form:form><br/>
</div>
<table>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name}</td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/'/>">GO HOME</a>
</body>
</html>
