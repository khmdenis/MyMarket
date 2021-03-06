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
    <form:form action="/mymarket/buyer_info" commandName="buyer">
        <c:if test="${!empty buyer.name}">
            <form:hidden path="id"/>
        </c:if>
        <legend><span class="number">1</span>Name</legend>
        <form:input path="name"/>
        <form:errors path="name"/><br/>
        <legend><span class="number">2</span>City</legend>
        <form:input path="city"/>
        <form:errors path="city"/><br/>
        <legend><span class="number">3</span>Phone number</legend>
        <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/><br/>
        <legend><span class="number">4</span>Email</legend>
        <form:input path="email"/>
        <form:errors path="email"/><br/>

        <input type="submit" value="Buy">
    </form:form>
</div>

</body>
</html>
