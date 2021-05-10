<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="menu.css">
</head>
<body>
    <h1><%= "Menu" %></h1>

    <div class="vertical-menu">
        <a href="exit.jsp">0. Exit</a>
        <a href="registerVoter.jsp">1. Register voter </a>
        <a href="changeVoter.jsp">2. Change voter's data </a>
        <a href="createElection.jsp">3. Create election </a>
        <a href="changeElection.jsp">4. Change election's properties </a>
        <a href="manageLists.jsp">5. Manage candidate lists </a>
        <a href="manageTables.jsp">6. Manage polling stations </a>
        <a href="manageMembersTables.jsp">7. Manage members of polling stations </a>
        <a href="statusTables.jsp">8. Show polling stations status </a>
        <a href="localVote.jsp">9. Local voted each voter </a>
        <a href="votersRealTime.jsp">10. Show voters in real time </a>
        <a href="results.jsp">11.  See results from past elections </a>
        <a href="listElections.jsp">12. List all elections </a>
        <a href="listVoters.jsp">13. List all voters </a>
        <a href="earlyVote.jsp">14. Early vote </a>
    </div>

    <%--<p><a href="<s:url action="index" />">Start</a></p>--%>

</body>
</html>