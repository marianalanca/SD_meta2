<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Create Election</title>
</head>
<body>

    <h1>Create Election</h1>

    <s:form action = "createElection" method = "execute">
        <s:text name="Election's name:" />
        <s:textfield name="title" /><br>
        <s:text name="Role:" />
        <s:textfield name="role" /><br>
        <s:text name="Description:" />
        <s:textfield name="description" /><br>
        <s:text name="Begging date" />
        <s:date name = "beggDate" format = "dd/MM/yyyy hh:mm" /><br>
        <s:text name="Ending date:" />
        <s:textfield name="endDate" format = "dd/MM/yyyy hh:mm" /><br>
        <s:text name="Department:" />
        <s:textfield name="department" /><br>
        <s:submit name = "submit" label = "Submit" align="center" />
    </s:form>
</body>
</html>
