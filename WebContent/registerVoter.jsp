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
        <s:textfield name = "name" label = "Name" size = "20" />
        <s:textfield name = "role" label = "Age" size = "20" />
        <s:submit name = "submit" label = "Submit" align="center" />
    </s:form>


    <label for="name">Enter name:</label>
    <input type="text" id="name" name="name"><br><br>

    <label for="role">Chosse a role:</label>
    <select name="role" id="role">
        <option value="STUDENT">Student</option>
        <option value="DOCENTE">Docente</option>
        <option value="FUNCIONARIO">Funcionario</option>
    </select>
    <br><br>

    <label for="cc_number">Enter cc number:</label>
    <input type="text" id="cc_number" name="cc_number"><br><br>

    <label for="cc_expiration">Enter cc expiring date:</label>
    <input type="date" id="cc_expiration" name="cc_expiration"><br><br>

    <label for="department">Enter department:</label>
    <input type="text" id="department" name="department"><br><br>

    <label for="contact">Enter contact:</label>
    <input type="text" id="contact" name="contact"><br><br>

    <label for="address">Enter address:</label>
    <input type="text" id="address" name="address"><br><br>

    <label for="password">Enter password:</label>
    <input type="text" id="password" name="password"><br><br>

    <input type="submit" value="Submit">

</body>
</html>
