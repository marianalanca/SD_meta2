<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <s:form action="login" method="post">
        <s:text name="Username:" />
        <s:textfield name="username" /><br>
        <s:submit />
    </s:form>

</body>
</html>
