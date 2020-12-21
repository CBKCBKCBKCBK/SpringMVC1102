<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>本期的樂透號碼: </h1>
        <%=request.getAttribute("lotto") %><br>
        ${ requestScope.lotto }<br>
        ${ lotto }
    </body>
</html>
