<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Register voter</title>
</head>
<body>

    <h1>Register voter</h1>

    <s:form action = "register" method = "execute">
        <s:text name="Name:" />
        <s:textfield name="name" /><br>
        <s:radio label="Roles" name="type" list="roles"
                 listKey="key" listValue="value"/><br>
        <s:text name="Role:" />
        <s:textfield name="type" /><br>
        <s:text name="Cc_number:" />
        <s:textfield name="cc_number" /><br>
        <s:text name="CC_expiring:" />
        <s:date name = "cc_expiring" format = "dd/MM/yyyy" /><br>
        <s:text name="Department:" />
        <s:textfield name="department" /><br>
        <s:text name="Contact:" />
        <s:textfield name="contact" /><br>
        <s:text name="Address:" />
        <s:textfield name="address" /><br>
        <s:text name="Password:" />
        <s:textfield name="password" /><br>
        <s:submit name = "submit" label = "Submit" align="center" />
    </s:form>


</body>
</html>
