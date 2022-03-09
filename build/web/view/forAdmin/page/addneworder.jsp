<%-- 
    Document   : addnewroom
    Created on : Mar 9, 2022, 12:35:50 AM
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
        <title>Add new order</title>
        <jsp:include page="../header_footer/linkcss.jsp"></jsp:include>
        </head>
        <body class="skin-black">
        <jsp:include page="../header_footer/header.jsp"></jsp:include>

            <div class="wrapper row-offcanvas row-offcanvas-left">
            <jsp:include page="../header_footer/leftmenu.jsp"></jsp:include>
                <aside class="right-side">
                    <section class="panel">
                        <header class="panel-heading">
                            CHOOSE ROOM
                        </header>
                        <div class="panel-body col-lg-8">
                            <form class="form-horizontal tasi-form add-form" id="bookingform" action="${pageContext.request.contextPath}/admin/addneworder" method="post">
                            <input type="hidden" name="accountID">            
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Name:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="name" class="form-control" value="${requestScope.order.name}" required placeholder="Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Email:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="email" class="form-control" value="${requestScope.order.email}" required placeholder="Email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Phone:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="phone" class="form-control" value="${requestScope.order.phone}" required placeholder="Phone">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Room type:</label>
                                <div class="col-sm-6">
                                    <select id="type" class="form-control" name="type">
                                        <option value="0">----------Type Room----------</option>
                                        <c:forEach items="${requestScope.typeList}" var="type">
                                            <option value="${type.id}">${type.name} (${type.price}/night)</option>
                                        </c:forEach>
                                    </select>
                                    <div id="type_alert" style="color: red"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">Number of rooms:</label>
                                <div class="col-sm-6">
                                    <input type="number" name="numberOfRooms" class="form-control" id="numberOfRooms" value="${requestScope.order.numberOfRooms}" required placeholder="Number of rooms">
                                    <div id="number_alert" style="color: red"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">CheckIN:</label>
                                <div class="col-sm-6">
                                    <input type="date" name="checkIN" class="form-control" value="${requestScope.order.checkIN}" required placeholder="Check in">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-2 control-label">CheckOUT:</label>
                                <div class="col-sm-6">
                                    <input type="date" name="checkOUT" class="form-control" value="${requestScope.order.checkOUT}" required placeholder="Check out">
                                </div>
                            </div>

                            <c:if test="${tag eq 'done'}">
                                <div class="col-sm-6" style="color: green; margin: 1% 38% 2% 38%;">
                                    Successful.
                                </div>
                            </c:if>
                            <div class="col-sm-12">
                                <div class="col-sm-4">
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="btn btn-danger center-block col-sm-10"
                                            onclick="location.href = '${pageContext.request.contextPath}/admin/vieworder'">
                                        Discard
                                    </button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" style="" onclick="checkNum()" class="btn btn-info center-block col-sm-10">Save</button>
                                </div>
                            </div>
                        </form>
                        <script>
                            function checkNum() {
                                var type = document.getElementById("type").value;
                                var numberOfRooms = document.getElementById("numberOfRooms").value;
                                if (type <= 0) {
                                    document.getElementById("type_alert").innerHTML = "<p>Please choose type</p>";
                                }
                                if (numberOfRooms <= 0) {
                                    document.getElementById("number_alert").innerHTML = "<p>Number of room must bigger than 0</p>";
                                }

                                if (type > 0 && numberOfRooms > 0) {
                                    document.getElementById("type_alert").innerHTML = "";
                                    document.getElementById("number_alert").innerHTML = "";
                                    document.getElementById("bookingform").submit();
                                }
                            }
                        </script>
                    </div>
                </section>
            </aside>
        </div>
        <jsp:include page="../header_footer/linkjavascript.jsp"></jsp:include>
    </body>
</html>
