<%-- 
    Document   : paid
    Created on : Mar 7, 2022, 11:53:26 PM
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
        <title>Users List</title>
        <jsp:include page="../header_footer/linkcss.jsp"></jsp:include>
        </head>
        <body class="skin-black">
        <jsp:include page="../header_footer/header.jsp"></jsp:include>

            <div class="wrapper row-offcanvas row-offcanvas-left">
            <jsp:include page="../header_footer/leftmenu.jsp"></jsp:include>
                <aside class="right-side">
                    <section class="content">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="panel">
                                    <div class="panel-heading" style="display: flex;">
                                        <div style="margin-right: 70%;">List of order</div>
                                        <div>
                                            <a class="btn label-danger center-block col-sm-10" style="width: 100%;margin-left: 68%;" href="${pageContext.request.contextPath}/admin/addneworder">Add new order</a>
                                        </div>
                                    </div>
                                    <div class="box-tools m-b-15" style="float: right;">
                                        <div class="input-group">
                                            <form action="${pageContext.request.contextPath}/admin/viewaccess" method="post">
                                                <input type="text" name="key" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search" value="" />
                                                <button class="btn btn-sm btn-default" type="submit"><i class="fa fa-search"></i> </button>                                             
                                            </form>
                                        </div>
                                    </div>
                                    <form action="${pageContext.request.contextPath}/admin/viewaccess" method="post">
                                    <c:if test="${requestScope.orders.isEmpty()}">
                                        <h3>Not Found Any Order</h3>
                                    </c:if>
                                    <c:if test="${!requestScope.orders.isEmpty()}">
                                        <div class="panel-body table-responsive">
                                            <table class="table table-hover">
                                                <tr>
                                                    <td>ID</td>
                                                    <td>Full name</td>
                                                    <td>Number of rooms</td>
                                                    <td>Type</td>
                                                    <td>CheckIN
                                                        <input class="input-sm" type="date" name="checkIN" value="${requestScope.checkIN}">
                                                    </td>
                                                    <td>CheckOUT
                                                        <input class="input-sm" type="date" name="checkOUT" value="${requestScope.checkOUT}">
                                                    </td>
                                                    <td><button class="btn btn-info center-block" type="submit">Apply</button></td>
                                                </tr>
                                                <c:forEach items="${requestScope.orders}" var="o">
                                                    <tr>
                                                        <td>${o.orderID}</td>
                                                        <td>${o.name}</td>
                                                        <td>${o.numberOfRooms}</td>
                                                        <td>${o.roomType.name}</td>
                                                        <td>${o.checkIN}</td>
                                                        <td>${o.checkOUT}</td>
                                                        <td><a href="">View</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </c:if>
                                </form>
                                <div>
                                    <nav aria-label="Page navigation example">
                                        <ul id="paggingBottom" class="pagination page">
                                        </ul>
                                    </nav>
                                </div>
                                <script>
                                    generatePagger('paggingBottom',${requestScope.pageIndex},${requestScope.totalPages}, '${requestScope.url}', 1);
                                    function generatePagger(div, pageIndex, totalPages, url, gap) {
                                        var container = document.getElementById(div);
                                        container.innerHTML += '<li class="page-item"><a class="page-link" href="' + url + 1 + '">First</a></li>';
                                        if (pageIndex - gap > 0)
                                            container.innerHTML += '<li class="page-item"><a class="page-link" href="' + url + (pageIndex - 1) + '">Previous</a></li>';
                                        for (var i = (pageIndex) - gap; i < pageIndex; i++) {
                                            if (i > 0)
                                                container.innerHTML += '<li class="page-item"><a class="page-link" href="' + url + i + '">' + i + '</a></li>';
                                        }
                                        container.innerHTML += '<li class="page-item active"><span class="page-link">' + pageIndex + '</span></li>';
                                        for (var i = (pageIndex) + 1; i <= pageIndex + gap; i++) {
                                            if (i <= totalPages)
                                                container.innerHTML += '<li class="page-item"><a class="page-link" href="' + url + i + '">' + i + '</a></li>';
                                        }
                                        if (pageIndex + gap < totalPages)
                                            container.innerHTML += '<li class="page-item"><a class="page-link" href="' + url + (pageIndex + 1) + '">Next</a></li>';
                                        container.innerHTML += '<li class="page-item"><a class="page-link" href="' + url + totalPages + '">Last</a></li>';
                                    }
                                </script>
                            </div>
                        </div>
                    </div>
                </section>
            </aside>
        </div>
        <jsp:include page="../header_footer/linkjavascript.jsp"></jsp:include>
    </body>
</html>
