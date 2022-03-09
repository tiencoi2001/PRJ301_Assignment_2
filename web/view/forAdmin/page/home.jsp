<%-- 
    Document   : home
    Created on : Mar 3, 2022, 5:45:46 PM
    Author     : Vu Duc Tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Queen hotel</title>
        <jsp:include page="../header_footer/linkcss.jsp"></jsp:include>
        </head>
        <body class="skin-black">
        <jsp:include page="../header_footer/header.jsp"></jsp:include>

            <div class="wrapper row-offcanvas row-offcanvas-left">
            <jsp:include page="../header_footer/leftmenu.jsp"></jsp:include>
                <aside class="right-side row">
                    <div class="col-lg-10">
                        <p style="font-size: 100px; padding: auto;">HAVE A GOOD DAY</p>
                    </div>
                </aside>
            </div>
        <jsp:include page="../header_footer/linkjavascript.jsp"></jsp:include>
    </body>
</html>
