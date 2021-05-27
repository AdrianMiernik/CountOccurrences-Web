<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Input</title>
</head>
<body>
<h2>Input:</h2>
<form:form method="post" modelAttribute="occurrence">
    <div>
        <label for="keyword">Keyword</label>
        <form:input type="text" id="keyword" path="keyword" />
    </div>
    <div>
        <label for="sentence">Sentence</label>
        <form:input type="text" id="sentence" path="sentence" />
    </div>
    <div>
        <input type="submit" lang="english" title="submit" name="submit"/>
    </div>
</form:form>
</body>
</html>
