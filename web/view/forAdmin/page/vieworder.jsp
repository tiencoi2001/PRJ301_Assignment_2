<%-- 
    Document   : vieworder
    Created on : Mar 5, 2022, 2:42:52 AM
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
                                        <div style="margin-right: 70%;">List of order wait</div>
                                        <div>
                                            <a class="btn label-danger center-block col-sm-10" style="width: 100%;margin-left: 68%;" href="${pageContext.request.contextPath}/admin/addneworder">Add new order</a>
                                        </div>
                                    </div>
                                    <div class="box-tools m-b-15" style="float: right;">
                                        <div class="input-group">
                                            <form action="${pageContext.request.contextPath}/admin/vieworder" method="post">
                                                <input type="text" name="key" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search" value="" />
                                                <button class="btn btn-sm btn-default" type="submit"><i class="fa fa-search"></i> </button>                                             
                                            </form>
                                        </div>
                                    </div>
                                <c:if test="${requestScope.orders.isEmpty()}">
                                    <h3>Not Found Any Order</h3>
                                </c:if>
                                <c:if test="${!requestScope.orders.isEmpty()}">
                                    <div class="panel-body table-responsive">
                                        <table class="table table-hover">
                                            <tr>
                                                <td>ID</td>
                                                <td>Number of rooms</td>
                                                <td>Type</td>
                                                <td>Choose room(s)</td>
                                            </tr>
                                            <c:forEach items="${requestScope.orders}" var="o">
                                                <tr>
                                                    <td>${o.orderID}</td>
                                                    <td>${o.numberOfRooms}</td>
                                                    <td>${o.roomType.name}</td>
                                                    <td><a href="${pageContext.request.contextPath}/admin/chooseroom?orderID=${o.orderID}">Choose room(s)</a></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </section>
            </aside>
        </div>
        <jsp:include page="../header_footer/linkjavascript.jsp"></jsp:include>
    </body>
</html>
