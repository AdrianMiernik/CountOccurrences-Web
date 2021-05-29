<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Details</title>
</head>
<body>
<h2>Details:</h2>

<div class="navList" >
<tr>
    <td><b>Keyword:</b>  ${occurrence.keyword}</td><br>
    <td><b>Sentence:</b> ${occurrence.sentence}</td><br>
</tr>
    <br>
</div>

<div>
<table border="1" cellpadding="20px">
    <thead>
    <tr>
        <th>Character</th>
        <th>Occurrence</th>
        <th>Frequency</th>
        <th>Fraction</th>
    </thead>
    <tbody>
        <form:form method="get" modelAttribute="maps">

        <c:forEach items="${maps}" var="map" >
    <tr>
        <td>${map.key}</td>
        <td>${map.value}</td>
        <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${map.value/occurrenceLength}"/></td>
        <td>${map.value}/${occurrenceLength}</td>
    </tr>
    </c:forEach>
    </form:form>

    <tr>
        <td><b>TOTAL Frequency:</b> </td>
        <td></td>
       <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${occurrenceLength/totalLength}"/></td>
        <td>${occurrenceLength}/${totalLength}</td>
    </tr>
        </tbody>
    </table>
</div>

</body>
</html>