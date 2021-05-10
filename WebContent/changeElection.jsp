<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>change election</title>
</head>
<body>
    <h1>Change election's properties</h1>

    <s:form action="login" method="post">
        <s:text name="Electio's title:" />
        <s:textfield name="title" /><br>
        <s:text name="Description" />
        <s:textfield name="description" /><br>
        <s:text name="Begging date:" /><br>
        <s:textfield name="beggdate" type="date" /><br> <!--What the fuck?-->
        <s:date name = "beggdate" format = "dd/MM/yyyy" /><br>
        <s:text name="Ending date:" /><br>
        <s:textfield name="endDate" type="date" /><br> <!--What the fuck?-->
        <s:date name = "endDate" format = "dd/MM/yyyy" /><br>
        <s:submit />
    </s:form>

</body>
</html>
