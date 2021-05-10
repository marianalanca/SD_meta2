<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Change Voter</title>
</head>
<body>

    <h1>Change voter's </h1>


    <s:form action="login" method="post">
        <s:text name="Name:" />
        <s:textfield name="name" /><br>
        <s:text name="Role" />
        <s:textfield name="role" /><br>
        <s:text name="CC_expiring" /><br>
        <s:textfield name="cc_expiring" type="date" /><br>
        <s:text name="Department:" />
        <s:textfield name="department" /><br>
        <s:text name="Contact:" />
        <s:textfield name="contact" /><br>
        <s:text name="Address:" />
        <s:textfield name="address" /><br>
        <s:text name="Password:" />
        <s:textfield name="password" type="hidden"/><br>
        <s:submit />
    </s:form>

</body>
</html>
